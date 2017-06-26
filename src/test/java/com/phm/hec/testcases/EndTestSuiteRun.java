package com.phm.hec.testcases;

import java.io.File;
import java.util.logging.Logger;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.phm.hec.pageObjects.HeaderPageObjects;
import com.phm.hec.utility.GlobalVar;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EndTestSuiteRun {
	static Logger logger = Logger.getLogger(EndTestSuiteRun.class.getName());
	static ExtentTest EndingTestSuite;

	@Test
	public static void EndTestSuite() {

		try {
			EndingTestSuite = GlobalVar.report.startTest("Ending Test Suite", "Ending Test In progress...!!!");
			HeaderPageObjects HeaderPage = PageFactory.initElements(GlobalVar.Driver, HeaderPageObjects.class);
			// GenericUtils GenUtils =
			// PageFactory.initElements(GlobalVar.Driver, GenericUtils.class);
			if (GlobalVar.loggedin == true) {
				EndingTestSuite.log(LogStatus.INFO, "Logging out");
				if (GlobalVar.Modules == "PD") {
					EndingTestSuite.log(LogStatus.INFO, "INM - Press the log out button");
					HeaderPage.InmPageLogout();

				} else if (GlobalVar.Modules == "CM") {
					EndingTestSuite.log(LogStatus.INFO, "FRE - Press the log out button");
					HeaderPage.FREPageLogout();
				}
			}
			GlobalVar.loggedin = false;
			logger.info("Ending the Automated Test case Execution");
			EndingTestSuite.log(LogStatus.PASS, "Ended the Automated Test case execution");
			GlobalVar.report.endTest(EndingTestSuite);
			GlobalVar.report.flush();
			// GlobalVar.Driver.close();

			// ********* Show the Report********//
			String ReportStr = System.getProperty("user.dir") + File.separator + "Reports" + File.separator
					+ "automationreport.html";
			GlobalVar.Driver.get(ReportStr);
		} catch (Exception e) {
			logger.info("End Test Suite Exception : " + e.getMessage().toString());
			EndingTestSuite.log(LogStatus.FATAL, e.getMessage().toString());
			EndingTestSuite.log(LogStatus.FAIL, e.getMessage().toString());
			GlobalVar.report.endTest(EndingTestSuite);
			GlobalVar.report.flush();
			// ********* Show the Report********//
			String ReportStr = System.getProperty("user.dir") + File.separator + "Reports" + File.separator
					+ "automationreport.html";
			GlobalVar.Driver.get(ReportStr);
		}

	}

}
