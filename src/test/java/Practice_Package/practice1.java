package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class practice1 {

	public static void main(String[] args) {
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc://mysql://localhost:3306/sdet47","root","root");
		Statement state = con.createStatement();
		String query ="select * from students;";
		ResultSet result = state.executeQuery(query);
		
		while(result.next()) {
		
				System.out.println(result.getString(1)+" ");
			
		  }
		}
	    catch(Exception e){
	    	
	    }
	}
}
