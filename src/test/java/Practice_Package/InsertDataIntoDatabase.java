package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataIntoDatabase {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet47","root","root");
			Statement state = con.createStatement();
			String query = "INSERT INTO STUDENTS VALUES('SANTOSH',1005,'KORMANGLA','SANDEEP',9,'CHENNAI');";
			int result = state.executeUpdate(query);
			//while(result.)
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}

	}

}
