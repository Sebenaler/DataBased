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
	
	private boolean loggedIn = false;
	
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

  
  public Boolean isLoggedIn() {
	    return this.loggedIn;
	  }
  
  public boolean loginPlayer(String email, String pass){
	    try{
	    ResultSet result;
	    Statement stmt;
	    Connection con = openDBConnection();
	    stmt = con.createStatement();
	    String queryString = "execute login_func('"+this.getEmail()+"','"+this.getPass()+"')";
	    result = stmt.executeQuery(queryString);
	    while (result.next()){
	      this.loggedIn = true;
	      System.out.print(result);
//	      
	    }
	    result.close();
	    stmt.close();
	    }
	    catch(SQLException e){
	     System.out.println(e); 
	    }
	    return this.loggedIn;
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

  
  