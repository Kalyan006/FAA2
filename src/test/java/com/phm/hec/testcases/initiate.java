package com.phm.hec.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.phm.hec.initializer.Initializer;
import com.phm.hec.utility.ReadExcelFile;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.phm.hec.utility.GlobalVar;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class initiate {
	ExtentTest initiate;

	@Test

	public void loginn() throws Exception {
		GlobalVar.report = new ExtentReports(GlobalVar.ExtentReportPath, true);
		initiate = GlobalVar.report.startTest("initiate", "Automation Execution Initiated");
		System.out.println("Test Starting");
		initiate.log(LogStatus.INFO, "Initializing");
		Initializer.initialize();

		System.out.println("Reading XL file for Username / Password");
		initiate.log(LogStatus.INFO, "Reading XL file for Username / Password");
		ReadExcelFile readExcelFile = new ReadExcelFile();

		try {
			readExcelFile.getUsernamePassword(GlobalVar.TestDataFilePath, GlobalVar.UserDetailsTestData,
					GlobalVar.SheetName, GlobalVar.Client, GlobalVar.Modules);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GlobalVar.report.endTest(initiate);

		Login.login1(GlobalVar.LoginUsername, GlobalVar.LoginPassword);
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
		GlobalVar.report = new ExtentReports(GlobalVar.ExtentReportPath, true);
		// GlobalVar.report.lo.loadConfig(new File(
		// GlobalVar.ExtentReportConfigFilePath));
	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		GlobalVar.extLog = GlobalVar.report.startTest(this.getClass().getSimpleName() + ":: " + method.getName(),
				method.getName());
		// GlobalVar.test.assignAuthor(GlobalVar.Requester);
		GlobalVar.extLog.assignCategory(
				GlobalVar.TestType + "Client : " + GlobalVar.Client + "Environment : " + GlobalVar.Environment);
	}
}
