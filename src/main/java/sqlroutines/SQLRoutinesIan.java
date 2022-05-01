package sqlroutines;

import java.io.*;
import java.sql.*;
import oracle.jdbc.*;

public class SQLRoutinesIan implements Serializable {
  

	
  public SQLRoutinesIan(){
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
  
//    public void viewTeamAndNumPlayers() {
//      
//    try{
//    //A string to hold the SQL statement....
//
//    String queryString = "select u.first, u.last from player_table u, plays_on p where u.player_id = p.player_id and p.team_name = '" + tn + "'";
//    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
//    PreparedStatement preparedStmt;
//    Connection con = openDBConnection();
//    preparedStmt = con.prepareStatement(queryString);
//    ResultSet result;
//    result = preparedStmt.executeQuery();
//    System.out.println(queryString);
//    if (result.next()){    
//      System.out.println(result.getString(1));
//    }
//    
//    result.close();
//    preparedStmt.close();
//                   }
//    catch(SQLException e){
//       System.out.println(e); 
//    }
//  }
//    
  public ResultSet viewTeamRoster(String tn) {
    try{
    String queryString = "select u.first, u.last from player_table u, plays_on p where u.player_id = p.player_id and p.team_name = '" + tn + "'";
    Connection con = openDBConnection();
    Statement stmt;
    String result1 = "";
    if (con != null) {
    stmt = con.createStatement();
    ResultSet result = stmt.executeQuery(queryString);
    
//    while (result.next()){    
//    	result1 += result.getString(1);
//      System.out.println(result.getString(1));
//    }
    return result;
    }

    }
    catch(SQLException e){
       System.out.println(e); 
       
    }
    return null;
  }
  
  public boolean addNewStoreItem(String i_num, String i_name, double p, String i_desc, int q) {
	  try{
		  	CallableStatement callStmt;
		  	Connection con = openDBConnection();
		  	callStmt = con.prepareCall(" {call insert_new_item(?,?,?,?,?)}");
		    callStmt.setString(1,i_num);
		    callStmt.setString(2,i_name);
		    callStmt.setDouble(3,p);
		    callStmt.setString(4,i_desc);
		    callStmt.setInt(5,q);
		    callStmt.execute();
		  
		  /*
		    String queryString = "execute DataBased.insert_new_item('"+ i_num +"','"+i_name+"',"+p+", '"+i_desc+"', "+q+")";
		    Connection con = openDBConnection();
		    Statement stmt;
		    if (con != null) {
		    stmt = con.createStatement();
		    stmt.executeQuery(queryString);
		    }*/
		    return true;
		    }
		    catch(SQLException e){
		       System.out.println(e); 
		       return false;
		   }
  }
  public String viewPlayerProfile(String p_id) {
	  try{
		    String queryString = "select u.first, u.last, u.email, u.player_year, u.player_description,u.social_media, u.ign,u.player_id from player_table u where u.player_id = '" + p_id + "'";
		    Connection con = openDBConnection();
		    Statement stmt;
		    String result1 = "";
		    if (con != null) {
		    stmt = con.createStatement();
		    ResultSet result = stmt.executeQuery(queryString);
		    
		    while (result.next()){    
		    	result1 = result.getString(1)+result.getString(2)+result.getString(3)+result.getString(4)+result.getString(5)+result.getString(6)+result.getString(7);
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
  public String viewStoreItems() {
	  try{
		    String queryString = "select * from store_item where quantity <> 0";
		    Connection con = openDBConnection();
		    Statement stmt;
		    String result1 = "";
		    if (con != null) {
		    stmt = con.createStatement();
		    ResultSet result = stmt.executeQuery(queryString);
		    
		    while (result.next()){    
		    	result1 = result.getString(1)+result.getString(2)+result.getString(3)+result.getString(4)+result.getString(5);
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
  public ResultSet viewTeams() {
	  try{
		    String queryString = "select * from teams";
		    Connection con = openDBConnection();
		    Statement stmt;
		    //String result1 = "";
		    if (con != null) {
		    stmt = con.createStatement();
		    ResultSet result = stmt.executeQuery(queryString);
		    
//		    while (result.next()){    
//		    	result1 = result.getString(1)+result.getString(2)+result.getString(3)+result.getString(4)+result.getString(5);
//		      System.out.println(result.getString(1));
//		    }
		    return result;
		    }
		
		    }
		    catch(SQLException e){
		       System.out.println(e); 
		       
		    }
	  return null;
	  }

}