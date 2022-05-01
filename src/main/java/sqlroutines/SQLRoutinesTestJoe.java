package sqlroutines;

import java.sql.*;



//import org.junit.*;
import oracle.jdbc.*;
/**
 * Auto Generated Java Class.
 */
public class SQLRoutinesTestJoe{
  public static void main(String[] args) 
   {

        SQLRoutinesJoe s = new SQLRoutinesJoe();
		s.loginPlayer("mdave001@csbsju.edu","1234");
		
		SQLRoutinesJoe t = new SQLRoutinesJoe();
		boolean r = t.createAccount("09", "Sebenaler", "Joe", "jsebenale001@csbsju.edu","pass12345", "pass12345", "3","Absolute gamer",
				"twitter.com/JoeSebenaler", "SEBATRON");
		System.out.println(r);
		
		SQLRoutinesJoe p = new SQLRoutinesJoe();
		p.editProfile("05","pass1234312414", "BIG BALLER SEB", "snipstashower");
    }
  
  
  /* ADD YOUR CODE HERE */
  
}
