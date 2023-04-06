package com.TMS.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

		public int random() {
			Random ran = new Random();
			int random = ran.nextInt();
			return random;
		}
		public String getSystemDate() {
			Date dt = new Date();
			String date = dt.toString();
			//String date = dt.toString().replace(":","-");
			return date;
	    }
		
		public String formatSystemDate() {
			SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			Date dt = new Date();
			String getDateAndTime = dateformat.format(dt);
			getDateAndTime.replace(":", "-");
			return getDateAndTime;
		}

}
