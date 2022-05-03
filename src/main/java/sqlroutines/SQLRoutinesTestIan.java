package sqlroutines;

import java.sql.*;
//import org.junit.*;
import oracle.jdbc.*;
/**
 * Auto Generated Java Class.
 */
public class SQLRoutinesTestIan {
  public static void main(String[] args) throws SQLException {
        SQLRoutinesIan s = new SQLRoutinesIan();
        boolean result1 = s.addNewStoreItem("0009", "K23", 23.33, "cool thing", 19);
  //String r = s.viewTeamRoster("THE JETS");
        ResultSet rs = s.getImages();
        while(rs.next()) {
        System.out.println(rs.getString(2));
        }
  System.out.println(result1);
    }
  
  
  /* ADD YOUR CODE HERE */
  
}
