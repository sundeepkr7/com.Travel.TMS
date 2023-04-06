package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class PracticeInsert {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		int result=0;
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc://mysql://localhost:3306/sdet47","root","root");
		Statement state = con.createStatement();
        String query = "INSERT INTO STUDENTS VALUES('SHYAM',1006,'BANASHANKARI','SANDEEP',9,'CHENNAI);";
        result = state.executeUpdate(query);
	     }
	catch(Exception e) {
	}
		finally {
			
			if(result==1) {
				System.out.println("Data updated");
			}
		else {
			System.out.println("Data not updated");
		}
			con.close();
	}
}
}
	
