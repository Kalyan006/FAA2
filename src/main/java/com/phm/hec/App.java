package com.phm.hec;

import java.util.regex.Pattern;

import org.testng.Reporter;

import java.util.regex.Matcher;

/**
 * Hello world!
 *
 */
public class App 
{

	 public static int CountRecords(String txt)
		{
		 try{
				Pattern pattern = Pattern.compile("(?<=of).*.(?=records)");
				Matcher matcher = pattern.matcher(txt);
				//boolean found = false;
				int retval = 0;
				while (matcher.find()) {
				    System.out.println("The Total Number of Records: " + matcher.group().toString());
				    String mycount = matcher.group();
					retval = Integer.parseInt(mycount.trim());
					System.out.println(retval);
					Reporter.log("String Value : " + txt + "Total Records : " + retval);
				    //Reporter.log("The Total Number of Records Based on Selected Category : " + matcher.group().toString(),true);
				    //found = true;
				}
				
				/*if (!found) {
				    //System.out.println("Records not founds..");
				   // Reporter.log("Records not founds..",true);
				}*/
				return retval;
		 }
		 catch (Exception ex){
			 
			 System.out.println("Exception : " + ex.getMessage());
			 return 0;
		 }
		
	}
		
		 
	
    public static void main( String[] args )
    {
    
        System.out.println( "Hello World!" );
       String txt="Showing 1 to 10 of 13 records 1 2 [Next]";
            int a = CountRecords(txt);
            System.out.println(a);
    }
}
