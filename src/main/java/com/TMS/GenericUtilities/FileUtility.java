package com.TMS.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String readDataFromPropertyFile(String key){
		String value="";
		try {
		FileInputStream fis = new FileInputStream(IpathConstants.FilePath);
        Properties p = new Properties();
        p.load(fis);
		value = p.getProperty(key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

}
