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
  public String viewTeamRoster(String tn) {
      
    try{
    //A string to hold the SQL statement....

    String queryString = "select u.first, u.last from player_table u, plays_on p where u.player_id = p.player_id and p.team_name = '" + tn + "'";
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    /*PreparedStatement preparedStmt;
    Connection con = openDBConnection();
    preparedStmt = con.prepareStatement(queryString);
    ResultSet result;
    result = preparedStmt.executeQuery();*/
    Connection con = openDBConnection();
    Statement stmt;
    String result1 = "";
    if (con != null) {
    stmt = con.createStatement();
    ResultSet result = stmt.executeQuery(queryString);
    
    while (result.next()){    
    	result1 = result.getString(1);
      System.out.println(result.getString(1));
    }
    
    //result.close();
    //preparedStmt.close();
    //con.close();
    }
return result1;
    }
    catch(SQLException e){
       System.out.println(e); 
       return null;
    }
  }

}