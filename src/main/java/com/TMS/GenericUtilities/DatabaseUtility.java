package com.TMS.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
   Connection con = null;
	public void connectToDb() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
         con = DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DBUSERNAME,IpathConstants.DBPASSWORD);
         }
	
	public String executeQueryAndGetData(String query, String expData, int columnIndex) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		
        boolean flag = false;
        while(result.next())
        {
       	String data= result.getString(columnIndex);
       	if(data.equalsIgnoreCase(expData)) {
    		flag= true;
    		break;
    	}
     }
    if(flag) {
    	System.out.println("Data is Verified");
    	return expData;
    }
    else {
    	System.out.println("Data is not updated"); 
    	return "";
        }
	}
	public void closeDb() throws SQLException {
		con.close();
		System.out.println("Database connection closed");
	}
}
