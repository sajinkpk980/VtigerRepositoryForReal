package vtigerFrameworkReal.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * this class contain all the generic methods related to java
 * @author Sajin kp
 *
 */
public class JavaUtility {
	/**
	 * this method will generate random number
	 * @return
	 */
   public int getRandomNumber() {
	   Random r = new Random();
	  int ran = r.nextInt(1000);
	  return ran;
   }
   
   public String getSystemDate() {
	   Date d = new Date();
	  String date = d.toString();
	  return date;
   }
   public String getSystemDateFormat() {
	   Date d = new Date();
	 String[] darr = d.toString().split(" ");
	 String date = darr[2];
	 String month = darr[1];
	 String year = darr[5];
	 String time = darr[3];
	 String currentdate = date+" "+month+" "+year+" "+time;
	 return currentdate;
   }
}
