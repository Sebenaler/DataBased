package sqlroutines;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/image" })
public class DisplayImageServlet extends HttpServlet{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DisplayImageServlet() {
	      super();
	  }
	 
	private ResultSet getImageInTable(String i_id) throws SQLException {
		SQLRoutinesIan i = new SQLRoutinesIan();
		  ResultSet rs = i.getImage(i_id);
	      if (rs.next()) {
	          //String name = rs.getString("Name");
	          //byte[] imageData = rs.getBytes("Image_Data");
	          //String imageFileName = rs.getString("Image_File_Name");
	          return rs;
	      }
	      return null;
	  }
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
		  
		  String id = "";
		  try {
              id = (String)(request.getParameter("id"));
          } catch (Exception e) {

          }
		 try {
			 ResultSet r = getImageInTable(id);
	          String imageFileName = r.getString(2);
	          System.out.println("File Name: "+ imageFileName);
	      
	          String contentType = request.getServletContext().getMimeType(imageFileName);
	          System.out.println("Content Type: "+ contentType);
	       
	          response.setHeader("Content-Type", contentType);
	       
	          response.setHeader("Content-Length", String.valueOf(r.getBytes(1).length));
	       
	          response.setHeader("Content-Disposition", "inline; filename=\"" + r.getString(2) + "\"");

	          // Write image data to Response.
	          response.getOutputStream().write(r.getBytes(1));
			 
		 
	 } catch (Exception e) {
         throw new ServletException(e);
     }
	 
}
	 

}
