package sqlroutines;

import java.io.*;
import java.sql.*;
import oracle.jdbc.*;

public class SQLRoutinesIan implements Serializable {
  

	
  public SQLRoutinesIan(){
  }
  
  public Connection openDBConnection() {
    try {
      Class.forName("oracle.jdbc.OracleDriver");
      Connection myConnection = DriverManager.getConnection("jdbc:oracle:thin:@//cscioraclerh7srv.ad.csbsju.edu:1521/" +
                                                            "csci.cscioraclerh7srv.ad.csbsju.edu","TEAM01", "team01");
      return myConnection;
    } catch (Exception E) {
      E.printStackTrace();
    }
    return null;
  }
   
  public ResultSet viewTeamRoster(String tn) {
    try{
    String queryString = "select u.first, u.last, u.player_id from player_table u, plays_on p where u.player_id = p.player_id and p.team_name = '" + tn + "'";
    Connection con = openDBConnection();
    Statement stmt;
    String result1 = "";
    if (con != null) {
    stmt = con.createStatement();
    ResultSet result = stmt.executeQuery(queryString);
    
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
		  
		    return true;
		    }
		    catch(SQLException e){
		       System.out.println(e); 
		       return false;
		   }
  }
  public ResultSet viewPlayerProfile(String p_id) {
	  try{
		    String queryString = "select u.first, u.last, u.email, u.player_year, u.player_description,u.social_media, u.ign,u.player_id from player_table u where u.player_id = '" + p_id + "'";
		    Connection con = openDBConnection();
		    Statement stmt;
		    String result1 = "";
		    if (con != null) {
		    stmt = con.createStatement();
		    ResultSet result = stmt.executeQuery(queryString);
		    
		    return result;
		    }
		
		    }
		    catch(SQLException e){
		       System.out.println(e); 
		       
		    }
	  return null;
	  }
  public ResultSet viewStoreItems() {
	  try{
		    String queryString = "select * from store_item where quantity <> 0";
		    Connection con = openDBConnection();
		    Statement stmt;
		    String result1 = "";
		    if (con != null) {
		    stmt = con.createStatement();
		    ResultSet result = stmt.executeQuery(queryString);
		    
return result;
		    }
		
		    }
		    catch(SQLException e){
		       System.out.println(e); 
		       
		    }
	  return null;
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
		    return result;
		    }
		
		    }
		    catch(SQLException e){
		       System.out.println(e); 
		       
		    }
	  return null;
	  }
  public ResultSet getImage(String i_id) {
	  try{
		    String queryString = "select image, image_name from store_item where'" + i_id + "'= item_number";
		    Connection con = openDBConnection();
		    Statement stmt;
		    //String result1 = "";
		    if (con != null) {
		    stmt = con.createStatement();
		    ResultSet result = stmt.executeQuery(queryString);
		    return result;
		    }
		
		    }
		    catch(SQLException e){
		       System.out.println(e); 
		       
		    }
	  return null;
	  }
  public ResultSet getImages() {
	  try{
		    String queryString = "select image, image_name from store_item";
		    Connection con = openDBConnection();
		    Statement stmt;
		    //String result1 = "";
		    if (con != null) {
		    stmt = con.createStatement();
		    ResultSet result = stmt.executeQuery(queryString);
		    return result;
		    }
		
		    }
		    catch(SQLException e){
		       System.out.println(e); 
		       
		    }
	  return null;
	  }

}