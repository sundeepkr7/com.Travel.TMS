package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Practice {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet47","root","root");
        if(con.isClosed()) {
        	System.out.println("we are not connected to database");
        }
        else {
        	System.out.println("we are connected to database");
        }
	}

}
