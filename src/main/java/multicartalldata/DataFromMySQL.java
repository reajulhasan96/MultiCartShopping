package multicartalldata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataFromMySQL {

	public static Statement getDataFromDB() throws SQLException {
		
		String host="localhost";

		String port= "3306";

		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/SeleniumTest", "root", "Reajul1996");

		Statement s=con.createStatement();
			
		return s;
	}
	
	public String userName(int userID)throws SQLException {
		ResultSet rs=getDataFromDB().executeQuery("select * from users where userid ="+userID+";");
		
		rs.next();
		String userName=rs.getString("UserName");	
		return userName;
		
		}

	public String password(int userID)throws SQLException {
		ResultSet rs=getDataFromDB().executeQuery("select * from users where userid ="+userID+";");
		
		rs.next();
		String passcode=rs.getString("Password");	
		return passcode;
		
		}
		
	}
	
	
	
	
	
	
	
	
	

