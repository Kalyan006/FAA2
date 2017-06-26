package com.phm.hec.initializer;

import com.phm.hec.utility.GlobalVar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import java.util.logging.Logger;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Initializer {

	public static Logger addlog = Logger.getLogger(Initializer.class);// (Logger)
																		// LoggerFactory.getLogger(Initializer.class);
	public static FileInputStream configfis = null;
	public static FileInputStream urlfis = null;
	public static Properties urlProp = null;
	public static Properties configProp = null;

	static final String driverPath = GlobalVar.BrowserDriverPath;

	public static void initialize() throws IOException {
		// Here we need to create logger instance so we need to pass Class name
		// for
		// which we want to create log file in my case Google is class name
		// System.out.println("User Directory " +
		// System.getProperty("user.dir"));
		Logger logger = addlog; // Logger.getLogger("Initializer");

		// configure log4j properties file
		// PropertyConfigurator.configure("D:\\Automation\\PHMSuite\\PHM\\log4j.properties");
		PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "log4j.properties");

		configfis = new FileInputStream(new File(System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "test" + File.separator + "config" + File.separator + "config.properties"));
		configProp = new Properties();
		configProp.load(configfis);

		urlfis = new FileInputStream(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "test" + File.separator + "config" + File.separator + "urls.properties"));
		urlProp = new Properties();
		urlProp.load(urlfis);

		PropertyConfigurator.configure(configProp);
		GlobalVar.Browser = configProp.getProperty("Browser").toUpperCase().trim();
		GlobalVar.Client = configProp.getProperty("Client").toUpperCase().trim();
		GlobalVar.Environment = configProp.getProperty("Environment").toUpperCase().trim();
		GlobalVar.SheetName = configProp.getProperty("Environment").toUpperCase().trim();
		GlobalVar.Modules = configProp.getProperty("Module").toUpperCase().trim();
		GlobalVar.TestType = configProp.getProperty("Type").toUpperCase().trim();
		GlobalVar.TestRequestor = configProp.getProperty("Requestor").toUpperCase().trim();
		GlobalVar.multpletestdata = configProp.getProperty("MultipleData").toUpperCase().trim();
		GlobalVar.loglevel = configProp.getProperty("Loglevel").toUpperCase().trim();
		GlobalVar.TDSheetName = configProp.getProperty("Client").toUpperCase().trim();
		GlobalVar.Client = configProp.getProperty("Client") + "_" + configProp.getProperty("Environment");
		GlobalVar.URL = urlProp.getProperty(GlobalVar.Client);

		PropertyConfigurator.configure("Log4j.properties");

		System.out.println("Client : " + GlobalVar.Client);
		logger.info("Client : " + GlobalVar.Client);
		System.out.println("Browser : " + GlobalVar.Browser);
		logger.info("Browser : " + GlobalVar.Browser);
		System.out.println("Module(s) : " + GlobalVar.Modules);
		logger.info("Module(s) : " + GlobalVar.Modules);
		System.out.println("TestType : " + GlobalVar.TestType);
		logger.info("TestType : " + GlobalVar.TestType);
		System.out.println("URL : " + GlobalVar.URL);
		// initializeTestBaseSetup(Constant.Browser,Constant.URL);
		logger.info("URL : " + GlobalVar.URL);

		String browser1 = GlobalVar.Browser;
		System.out.println(" Browser set = " + browser1);

		if (browser1.equalsIgnoreCase("firefox")) {
			System.out.println("Launching Firefox browser..");
			logger.info("Launching  " + GlobalVar.URL + "  firefox with new profile..");
			System.out.println(driverPath + File.separator + "geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", driverPath + File.separator + "geckodriver.exe");
			GlobalVar.Driver = new FirefoxDriver();
			GlobalVar.Driver.manage().window().maximize();
			GlobalVar.Driver.navigate().to(GlobalVar.URL);

		} else if (browser1.equalsIgnoreCase("chrome")) {

			System.out.println("Launching chrome with new profile..");
			logger.info("Launching  " + GlobalVar.URL + " chrome with new profile..");
			System.setProperty("webdriver.chrome.driver", driverPath + File.separator + "chromedriver.exe");
			GlobalVar.Driver = new ChromeDriver();
			GlobalVar.Driver.manage().window().maximize();
			GlobalVar.Driver.navigate().to(GlobalVar.URL);
		} else {
			System.out.println("Launching Firefox browser..");
			logger.info("Launching  " + GlobalVar.URL + " chrome with new profile..");
			System.out.println(driverPath + File.separator + "geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", driverPath + File.separator + "geckodriver.exe");
			GlobalVar.Driver = new FirefoxDriver();
			GlobalVar.Driver.manage().window().maximize();
			GlobalVar.Driver.navigate().to(GlobalVar.URL);
		}

	}

}
