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
	    		System.out.println(result.getInt(1));
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
  public boolean loginAdmin(String email, String pass){
	  try {
		  	loggedIn = false;
		  	PreparedStatement preparedStmt;
		  	Connection con = openDBConnection();
	    	String queryString = "select loggedInAdmin(?,?) as Num from dual";
	    	preparedStmt = con.prepareStatement(queryString);
	    	preparedStmt.clearParameters();
	    	preparedStmt.setString(1,email);
	    	preparedStmt.setString(2,pass);
	    	result = preparedStmt.executeQuery();
	    	if(result.next())
	    	{
	    		System.out.println(result.getInt(1) + "HERE HERE");
	    		if(result.getInt(1)==1) 
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
	  
	  public boolean createAccount(String uID, String lastN, String firstN, String email,String password1,String password2, String playerYear, String playerDesc,String socialMedia,String IGN ) {
		  try{
			  if(password1.equals(password2)) {
			  	CallableStatement callStmt;
			  	Connection con = openDBConnection();
			  	callStmt = con.prepareCall("{call create_player(?,?,?,?,?,?,?,?,?,?)}");	
			  	callStmt.setString(1,uID);
			  	callStmt.setString(2,lastN);
			  	callStmt.setString(3,firstN);
			  	callStmt.setString(4,email);
			  	callStmt.setString(5,password1);
			  	callStmt.setString(6,password2);
			  	callStmt.setString(7,playerYear);
			  	callStmt.setString(8,playerDesc);
			  	callStmt.setString(9,socialMedia);
			  	callStmt.setString(10,IGN);
			    callStmt.execute();
			    
			    System.out.println("New player created");
			    return true;
		  }
			  else
			  {
				  return false;
			  }
			  }
			  
			    catch(SQLException e){
			       System.out.println(e); 
			       return false;
			   }
			  
	  }
	  public void editProfile(String email,String password, String desc, String IGN)
	  {
		  try{
			    String queryString = "UPDATE player_table SET player_table.player_password = '"+password+"',player_table.player_description = '"+desc+"', player_table.IGN='"+IGN+"' where player_table.email = '" + email+ "'";
			    Connection con = openDBConnection();
			    Statement stmt;

			    if (con != null) {
			    stmt = con.createStatement();
			    stmt.executeQuery(queryString);
			    }

			    }
			    catch(SQLException e){
			       System.out.println(e); 

			    }
		  }
	  public String viewProfile(String p_id)
	  {
	  try{
		    String queryString = "select u.first, u.last, u.email,u.player_password, u.player_year, u.player_description,u.social_media, u.ign from player_table u where u.player_id = '" + p_id + "'";
		    Connection con = openDBConnection();
		    Statement stmt;
		    String result1 = "";
		    if (con != null) {
		    stmt = con.createStatement();
		    ResultSet result = stmt.executeQuery(queryString);
		    
		    while (result.next()){    
		    	result1 = result.getString(1)+result.getString(2)+result.getString(3)+result.getString(4)+result.getString(5)+result.getString(6)+result.getString(7)+result.getString(8);
		      System.out.println(result.getString(1));
		    }
		    }
		return result1;
		    }
		    catch(SQLException e){
		       System.out.println(e); 
		       return null;
		    }
	  }
	 }


  
  