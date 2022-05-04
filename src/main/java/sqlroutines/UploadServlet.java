package sqlroutines;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
		SQLRoutinesIan i = new SQLRoutinesIan();
		
		// gets values of text fields
		String item_number = request.getParameter("item_number");
		String item_name = request.getParameter("item_name");
		double item_price = Double.parseDouble(request.getParameter("item_price"));
		String item_desc = request.getParameter("item_desc");
		int item_quantity = Integer.parseInt(request.getParameter("item_quantity"));
        String image_name = request.getParameter("image_name");
         
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        Connection conn = i.openDBConnection(); // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
            String sql = "INSERT INTO store_item (item_number, item_name, price, item_description, quantity, image, image_name) values (?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, item_number);
            statement.setString(2, item_name);
            statement.setDouble(3, item_price);
            statement.setString(4, item_desc);
            statement.setInt(5, item_quantity);
            statement.setString(7, image_name);
             
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(6, inputStream);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);
             
            // forwards to the message page
            getServletContext().getRequestDispatcher("/add_new_store_item.jsp").forward(request, response);
        }
    }
}
