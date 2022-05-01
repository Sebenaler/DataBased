package sqlroutines;

//Load JDBC API functions
import java.io.*;
import java.sql.*;
import oracle.jdbc.*;

public class SQLRoutinesBen
{
public SQLRoutinesBen()
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

public void addPlayerToTeam(String playerID, String teamName) {
  //if (this.loggedIn == false) {
  //  throw new IllegalStateException();
  //}
  
  try {
  Connection con = openDBConnection();
  CallableStatement callStmt = con.prepareCall("{call addPlayerToTeam_Proc(?,?)}");
  callStmt.setString(1, playerID);
  callStmt.setString(2, teamName);
  callStmt.execute();
  
  System.out.println("Player "+playerID+" has been added to "+teamName+".");
  
  callStmt.close();
  }
  catch (SQLException e) {
    System.out.println(e);
  }
}

public void removePlayerFromTeam(String playerID, String teamName) {
  //if (this.loggedIn == false) {
  //  throw new IllegalStateException();
  //}
  
  try {
  Connection con = openDBConnection();
  CallableStatement callStmt = con.prepareCall("{call removePlayerFromTeam_Proc(?,?)}");
  callStmt.setString(1, playerID);
  callStmt.setString(2, teamName);
  callStmt.execute();
  
  System.out.println("Player "+playerID+" has been removed from "+teamName+".");
  
  callStmt.close();
  }
  catch (SQLException e) {
    System.out.println(e);
  }
}

public void addMatch(String matchID, String matchDate, String mediaLink, String game, String opponent, String teamName) {
  //if (this.loggedIn == false) {
  //  throw new IllegalStateException();
  //}
  
  try {
  Connection con = openDBConnection();
  CallableStatement callStmt = con.prepareCall("{call addMatch_Proc(?,?,?,?,?,?)}");
  callStmt.setString(1, matchID);
  callStmt.setString(2, matchDate);
  callStmt.setString(3, mediaLink);
  callStmt.setString(4, game);
  callStmt.setString(5, opponent);
  callStmt.setString(6, teamName);
  callStmt.execute();
  
  System.out.println("Match "+matchID+" has been added for "+teamName+".");
  
  callStmt.close();
  }
  catch (SQLException e) {
    System.out.println(e);
  }
}

public void removeMatch(String matchID) {
  //if (this.loggedIn == false) {
  //  throw new IllegalStateException();
  //}
  
  try {
  Connection con = openDBConnection();
  CallableStatement callStmt = con.prepareCall("{call removeMatch_Proc(?)}");
  callStmt.setString(1, matchID);
  callStmt.execute();
  
  System.out.println("Match "+matchID+" has been removed.");
  
  callStmt.close();
  }
  catch (SQLException e) {
    System.out.println(e);
  }
}

public void addTeam(String teamName, String game, String league) {
  //if (this.loggedIn == false) {
  //  throw new IllegalStateException();
  //}
  
  try {
  Connection con = openDBConnection();
  CallableStatement callStmt = con.prepareCall("{call addTeam_Proc(?,?,?,?)}");
  callStmt.setString(1, teamName);
  callStmt.setString(2, game);
  callStmt.setString(3, league);
  callStmt.setString(4, "0");
  callStmt.execute();
  
  System.out.println("Team "+teamName+" has been added.");
  
  callStmt.close();
  }
  catch (SQLException e) {
    System.out.println(e);
  }
}

public void removeTeam(String teamName) {
  //if (this.loggedIn == false) {
  //  throw new IllegalStateException();
  //}
  
  try {
  Connection con = openDBConnection();
  CallableStatement callStmt = con.prepareCall("{call removeTeam_Proc(?)}");
  callStmt.setString(1, teamName);
  callStmt.execute();
  
  System.out.println("Team "+teamName+" has been removed.");
  
  callStmt.close();
  }
  catch (SQLException e) {
    System.out.println(e);
  }
}

public ResultSet viewAllTeams() {
  //if (this.loggedIn == false) {
  //  throw new IllegalStateException();
  //}
  
  try {
  Connection con = openDBConnection();
  Statement stmt = con.createStatement();
  String queryString = "SELECT * FROM TEAMS";
  ResultSet result = stmt.executeQuery(queryString);
  
  System.out.println("TEAMS");
  while(result.next())
  {
    System.out.println(result.getString(1)+", " +result.getString(2)+", "+result.getString(3)+", "+result.getInt(4));
  }  
  
  return result;
  //result.close();
  //stmt.close();
  }
  catch (SQLException e) {
    System.out.println(e);
  }  
  return null;
}

public ResultSet viewTeamSchedule(String teamName) {
  //if (this.loggedIn == false) {
  //  throw new IllegalStateException();
  //}
  
  try {
  Connection con = openDBConnection();
  Statement stmt = con.createStatement();
  String queryString = "SELECT * FROM MATCHES WHERE TEAM_NAME = '"+teamName+"'";
  ResultSet result = stmt.executeQuery(queryString);
  
  //System.out.println(teamName+" SCHEDULE");
  //while(result.next())
  //{
  //  System.out.println(result.getString(1)+", " +result.getString(2)+", "+result.getDate(3)+", "+result.getString(4)+", "+result.getString(5)+", "+result.getString(6));
  //}  
  
  return result;
  //result.close();
  //stmt.close();
  }
  catch (SQLException e) {
    System.out.println(e);
  }  
  return null;
}

public static void main (String args [])
{
  SQLRoutinesBen ben = new SQLRoutinesBen();
  //ben.addPlayerToTeam("05","BENNY");
  //ben.removePlayerFromTeam("05","BENNY");
  //NOT WORKING to_date()???
  //ben.addMatch("0002","2022-10-01","twitch.tv/thejets","League of Legends","TCU","THE JETS");
  //ben.removeMatch("0002");
  //ben.addTeam("R6 Team 1","Rainbow Six Siege","NECC");
  //ben.removeTeam("R6 Team 1");
  //ben.viewAllTeams();
  //ben.viewTeamSchedule("THE JETS");
} 
}