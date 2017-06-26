package com.phm.hec.utility;

import java.io.File;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class GlobalVar {

	public static String TestRequestor = "";
	public static String URL = "";
	public static String Username = "";
	public static String Password = "";
	public static String Client = "";
	public static String Environment = "";
	public static String Requester = "";
	public static String Driverpath = "";
	public static String Browser = "";
	public static String Modules = "";
	public static String TestType = "";
	public static String SheetName = "";
	public static String multpletestdata = "";
	public static String loglevel = "";

	public static String TestDataPath = "";
	public static String TDSheetName = "";
	public static WebDriver Driver = null;

	public static String LoginUsername = null;
	public static String LoginPassword = null;

	public static Boolean loggedin = false;

	// Reports public variables

	public static ExtentTest extLog;
	public static ExtentReports report;

	public static final String ExtentReportPath = System.getProperty("user.dir") + File.separator + "Reports"
			+ File.separator + "automationreport.html";
	public static final String ExtentReportConfigFilePath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "config" + File.separator + "extent-reports.xml";

	//
	public static final int purgeInterval = 2000;
	public static final int threadSleep = 2000;
	public static boolean keepAlive = true;

	// Screenshot folder path

	public static final String executionScreenshotFilePath = System.getProperty("user.dir") + File.separator
			+ "executionScreenshots";

	// Test Data / Config file path
	public static final String UserDetailsTestData = "userdetails.xlsx";
	public static final String TestDataFilePath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "Data";

	public static final String TestDataAddProviderTC383FilePath = System.getProperty("user.dir") + File.separator
			+ "src" + File.separator + "test" + File.separator + "Data" + File.separator + "PD" + File.separator
			+ "PD_AddProvider.xlsx";
	public static final String TestDataUploadFileTC398FilePath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "Data" + File.separator + "PD" + File.separator
			+ "PD_UploadFile.xlsx";
	public static final String TestDataAddAccountTC16FilePath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "Data" + File.separator + "PD" + File.separator
			+ "PD_AddAccount.xlsx";
	public static final String TestDataChangeAccountTC767FilePath = System.getProperty("user.dir") + File.separator
			+ "src" + File.separator + "test" + File.separator + "Data" + File.separator + "PD" + File.separator
			+ "ChangeAccount.xlsx";
	public static final String TestDataForgotPasswordTC399FilePath = System.getProperty("user.dir") + File.separator
			+ "src" + File.separator + "test" + File.separator + "Data" + File.separator + "forgotpassword.xlsx";
	public static final String UploadFilesPath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "uploadFiles";
	public static final String TestDataAddUserTC444FilePath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "Data" + File.separator + "PD" + File.separator
			+ "PD_AddUser.xlsx";
	// Configuration file paths

	public static final String configPropFilePath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "config" + File.separator + "config.properties";
	public static final String urlsPropFilePath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "config" + File.separator + "urls.properties";

	public static final String BrowserDriverPath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "browserdrivers";

	// Log4j Variables
	// public static final String executionLogFilePath =
	// System.getProperty("user.dir")+ File.separator + "executionLogs" +
	// File.separator + "executionLog.log";

}
