package sqlroutines;

import java.io.*;
import java.sql.*;
import oracle.jdbc.*;

public class SQLRoutinesPeyton implements Serializable {
  
	
	
  public SQLRoutinesPeyton(){
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
  
  public Boolean adminDeleteAccount(String PlayerID) {
	  try {
		  Connection con = openDBConnection();
		  
		  CallableStatement callStmt = con.prepareCall(" {call delete_Player(?) }");
		  callStmt.setString(1,  PlayerID);

		  callStmt.execute();

		  callStmt.close();
		  return true;
		   
	  }
	  catch (Exception E) {
		  E.printStackTrace();
		  return false;
	  }

  }
  
  public Boolean AdminCreateMatch(String matchID, String matchDate, String mediaLink, String game, String opponent, String teamName) {
	  try {
		  Connection con = openDBConnection();
		  
		  CallableStatement callStmt = con.prepareCall(" {call ADDMATCH_PROC(?,?,?,?,?,?) }");
		  callStmt.setString(1,  matchID);
		  callStmt.setString(2,  matchDate);
		  callStmt.setString(3,  mediaLink);
		  callStmt.setString(4,  game);
		  callStmt.setString(5,  opponent);
		  callStmt.setString(6,  teamName);
		  callStmt.execute();
		  callStmt.close();
		  return true;
		   
	  }
	  catch (Exception E) {
		  E.printStackTrace();
		  return false;
	  }

  }
  
  public Boolean AdminDeleteMatch(String matchId) {
	  try {
		  Connection con = openDBConnection();
		  
		  CallableStatement callStmt = con.prepareCall(" {call REMOVEMATCH_PROC(?) }");
		  callStmt.setString(1, matchId);
		  callStmt.execute();
		  callStmt.close();
		  return true;
	  }
	  catch (Exception E) {
		  E.printStackTrace();
		  return false;
	  }
  }
  
  public Boolean AdminUpdateMatchResult(String matchID, String score) {
	  try {
		  /*String tempMatchId = "";
		  String tempScore = "";
		  String tempMatchDate = "";
		  String tempMedialink = "";
		  String tempgame = "";
		  String tempOpponent = "";
		  String tempTeamname = "";
		  
		  String QueryString = "Select m.MATCH_ID, m.SCORE, m.MATCH_DATE, m.MEDIA_LINK, m.GAME, m.OPPONENT, m.TEAM_NAME From MATCHES m where MATCH_ID = '" + matchID+ "'";
		  Statement stmt = con.createStatement();
		  ResultSet result = stmt.executeQuery(QueryString);
		  while(result.next()) {
			  tempMatchId = result.getString(1);
			  tempScore = result.getString(2);
			  tempMatchDate = result.getDate(3).toString();
			  tempMedialink = result.getString(4);
			  tempgame = result.getString(5);
			  tempOpponent= result.getString(6);
			  tempTeamname = result.getString(7); 
		  }
		  if (matchID == "") {
			  matchID = tempMatchId;
		  }
		  if (score == "") {
			  score = tempScore;
		  }
		  if (matchDate == "") {
			  matchDate = tempMatchDate;
		  }
		  if (mediaLink == "") {
			  mediaLink = tempMedialink;
		  }
		  if (game == "") {
			  game = tempgame;
		  }
		  if (opponent == "") {
			  opponent = tempOpponent;
		  }
		  if (teamName == "") {
			  teamName = tempTeamname;
		  }
		  */
		  Connection con = openDBConnection();
		  /*CallableStatement callStmt1 = con.prepareCall(" {call REMOVEMATCH_PROC(?) }");
		  callStmt1.setString(1, matchID);
		  callStmt1.execute();
		  callStmt1.close();
		  
		  if (matchID != "") {
		  CallableStatement callStmt2 = con.prepareCall(" {call ADDMATCH_PROC(?,?,?,?,?,?,?) }");
		  callStmt2.setString(1,  matchID);
		  callStmt2.setString(2,  score);
		  callStmt2.setString(3,  matchDate);
		  callStmt2.setString(4,  mediaLink);
		  callStmt2.setString(5,  game);
		  callStmt2.setString(6,  opponent);
		  callStmt2.setString(7,  teamName);
		  callStmt2.execute();
		  callStmt2.close();
		  */
		  CallableStatement callStmt1 = con.prepareCall(" {call updateMatchScore_Proc(?,?) }");
		  callStmt1.setString(1, matchID);
		  callStmt1.setString(2, score);
		  callStmt1.execute();
		  callStmt1.close();
		  return true;
		  
	  }
	  catch (Exception E) {
		  E.printStackTrace();
		  return false;
	  }
	  
	  
  }
 /* public Boolean AdminRemoveGame(String game) {
	   try { 
		   Connection con = openDBConnection();
		   String QueryString = "Delete From TEAMS Where GAME = '" + game + "'";
		   Statement stmt = con.createStatement();
		   ResultSet result = stmt.executeQuery(QueryString);
		   return true;
	   }
	   catch (Exception E) {
			  E.printStackTrace();
			  return false;
		  }
	 */
		  
	   
  
  
  public ResultSet AdminSearchProfiles(String Player_ID, String last, String first, String year, String ign) {
	  try {
		  Connection con = openDBConnection();
		  String QueryString = "";
		  if (Player_ID == "" && last == "" && first == "" && year == ""  && ign == ""  ) {
			  QueryString = "Select p.PLAYER_ID, p.LAST, p.FIRST from PLAYER_TABLE p";
		  }
		  else {
			  QueryString = "Select p.PLAYER_ID, p.LAST, p.FIRST from PLAYER_TABLE p Where '1' = '1'";
		  }
		  if (Player_ID != "") {
			  QueryString = QueryString + " AND PLAYER_ID = '" + Player_ID+ "'";
		  }
		  if (last != "") {
			  QueryString = QueryString + " AND  LAST = '" + last+ "'";
		  }
		  if (first != "") {
			  QueryString = QueryString + " AND FIRST = '" + first+ "'";
		  }
		  if (year != "") {
			  QueryString = QueryString + " AND PLAYER_YEAR = '" + year+ "'";
		  }
		  if (ign != "") {
			  QueryString = QueryString + " AND IGN = '" + ign+ "'";
		  }
		  //System.out.println(QueryString);
		  Statement stmt = con.createStatement();
		  ResultSet result = stmt.executeQuery(QueryString);
		  /*while (result.next()){    
		    	result1 = result1.concat(result.getString(1));
		    	result1 = result1.concat(result.getString(2));
		    	result1 = result1.concat(result.getString(3));
		    	result1 = result1.concat(result.getString(4));
		    	result1 = result1.concat(result.getString(5));
		    	result1 = result1.concat(result.getString(6));
		      System.out.println(result.getString(1));
		    }*/
		  
		  return result;
	  }
	  catch (Exception E) {
		  E.printStackTrace();
		  return null;
	  }
				  
	  }
	  
	  
  }

  
  
 