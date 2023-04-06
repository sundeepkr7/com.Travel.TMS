package Practice_Package;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws SQLException
	{
		Connection con = null;
		try {
		//step1: create object for driver
          Driver driver = new Driver();
          
		//step2: Register the database
          DriverManager.registerDriver(driver);
  
		//step3: Get connection for the database
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet47", "root", "root");
         
		//step4: create statement for writing queries
         Statement state = con.createStatement();
        
         String query = "select * from students;";
        
		//step5: Execute Query
         ResultSet result = state.executeQuery(query);
         
         while(result.next())
         {
        	 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" ");
        	 
         }
       //String q = "DELETE From STUDENTS WHERE SID=1005;";
         String q = "INSERT INTO STUDENTS VALUES('SANTOSH',1005,'KORMANGLA','SANDEEP',9,'CHENNAI');";
         state.executeUpdate(q);
         q = "select * from students;";
         ResultSet res = state.executeQuery(q);
         
         //for writing the data in the excel sheet
         while(result.next()) {
        	 System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" ");
         }
        	 
	   }
	catch(Exception e) {
		
	}
	
		finally {
			//step6: close database connection
			con.close();
		}
	}
}
