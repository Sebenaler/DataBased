package sqlroutines;
import java.util.*;
import java.io.*;
import java.sql.*;
import oracle.jdbc.*;

//Load JDBC API functions

public class SQLRoutinesJoe
{
	private String email;
	private String pass;
	
	
	public String getEmail()
	{
		return email;
	}
	public String getPass()
	{
		return pass;
	}

  //Variable of type database connection
  private Connection myConnection;
  //Variable of type ResultSet which will contain query output
  private ResultSet result;

  
  public SQLRoutinesJoe()
  { 
  
  }


  public Connection openDBConnection() {
	    try {
	      // Load driver and link to driver manager
	      Class.forName("oracle.jdbc.OracleDriver");
	      // Create a connection to the specified database
	      Connection myConnection = DriverManager.getConnection("jdbc:oracle:thin:@//cscioraclerh7srv.ad.csbsju.edu:1521/" +
	                                                            "csci.cscioraclerh7srv.ad.csbsju.edu","TEAM01", "team01");
	      return myConnection;
	    } catch (Exception E) {
	      E.printStackTrace();
	    }
	    return null;
	  }

  private boolean loggedIn = false;
  public Boolean isLoggedIn() {
	    return this.loggedIn;
	  }

  private PreparedStatement preparedStmt;
  public boolean loginPlayer(String email, String pass){
	  try {
		  	loggedIn = false;
		  	PreparedStatement preparedStmt;
		  	Connection con = openDBConnection();
	    	String queryString = "select loggedIn(?,?) as Num from dual";
	    	preparedStmt = con.prepareStatement(queryString);
	    	preparedStmt.clearParameters();
	    	preparedStmt.setString(1,email);
	    	preparedStmt.setString(2,pass);
	    	result = preparedStmt.executeQuery();
	    	if(result.next())
	    	{
	    		if(result.getInt(1)==-1) 
	    		{
	    			loggedIn = true;
	    		}
	    	}
	    	
	    	System.out.println(loggedIn);
	    	result.close();
	    	preparedStmt.close();
	    	
	  }
	  catch(SQLException e)
	  {
		  System.out.println(e);
	  }
	  return loggedIn;
  }
	  /**
	   * sets loggedIn instance field to false
	   * @throws IllegalStateException if then method is called when loggedIn = false
	   */
	  public void logout(){
	    if(! isLoggedIn())
	      throw new IllegalStateException("MUST BE LOGGED IN FIRST!");
	    
	    this.loggedIn = false;
	  }

}

  
  