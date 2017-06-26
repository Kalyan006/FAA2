package com.phm.hec.PD.Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.phm.hec.CM.FormResourceAndEducationObjects.FormResourceAndEducationObjects;
import com.phm.hec.PD.AdminPageObjects.ProviderAdminPageObjects;
import com.phm.hec.PD.RolePageObjects.RolePageObjects;
import com.phm.hec.PEC.FormResourceAndEducationObjects.PecFormResourceAndEducationObjects;
import com.phm.hec.pageObjects.HeaderPageObjects;
import com.phm.hec.pageObjects.IntermediatePageObjects;
import com.phm.hec.testcases.Login;
import com.phm.hec.uploadFilePageObjects.UploadFileObjects;
import com.phm.hec.utility.GenericUtils;
import com.phm.hec.utility.GlobalVar;
import com.phm.hec.utility.ReadExcelFile;
import com.phm.hec.utility.ReportGenerator;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC398UploadFile {

	public static Logger addlog = Logger.getLogger(TC398UploadFile.class.getName());
	static ExtentTest TC_398_UploadFile;
	public static String ScreenShotPath;
	public static int CM_FAT;
	public static int CM_FAQ;
	public static int CM_RefGuides;
	public static int CM_EMREdu;
	public static int CM_Webinars;
	public static int CM_DecisionAids;
	public static int CM_Handouts;
	public static String PDCount;
	public static int PD_FAQ;
	public static int PD_FAT;
	public static int PD_RefGuides;
	public static int PD_EMREdu;
	public static int PD_Webinars;
	public static int PD_DecisionAids;
	public static int PD_Handouts;
	public static int PEC_FAT;
	public static int PEC_FAQ;
	public static int PEC_RefGuides;
	public static int PEC_EMREdu;
	public static int PEC_Webinars;
	public static int PEC_DecisionAids;
	public static int PEC_Handouts;
	public static String TestName = "";

	@SuppressWarnings({})

	@BeforeMethod
	public static void FileUploadPreCondition() throws Throwable {
		TC_398_UploadFile = GlobalVar.report.startTest("TC_398_UploadFile",
				"Validate the user able to upload the file");
		Logger logger = addlog;
		RolePageObjects RPO = PageFactory.initElements(GlobalVar.Driver, RolePageObjects.class);
		IntermediatePageObjects IntMedPage = PageFactory.initElements(GlobalVar.Driver, IntermediatePageObjects.class);
		ProviderAdminPageObjects PAP = PageFactory.initElements(GlobalVar.Driver, ProviderAdminPageObjects.class);
		HeaderPageObjects HPO = PageFactory.initElements(GlobalVar.Driver, HeaderPageObjects.class);

		if (GlobalVar.loggedin == false) {

			GlobalVar.Driver.get(GlobalVar.URL);
			ReadExcelFile readExcelFile = new ReadExcelFile();
			try {
				GlobalVar.Modules = "PD";
				readExcelFile.getUsernamePassword(GlobalVar.TestDataFilePath, GlobalVar.UserDetailsTestData,
						GlobalVar.SheetName, GlobalVar.Client, GlobalVar.Modules);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (Login.login1(GlobalVar.LoginUsername, GlobalVar.LoginPassword) == true) {
				logger.info("Login Success : Username :" + GlobalVar.LoginUsername + " Password : "
						+ GlobalVar.LoginPassword);

				Thread.sleep(GlobalVar.threadSleep);
				IntMedPage.ClickProviderAdmin();
				GlobalVar.loggedin = true;

			} else {
				GlobalVar.loggedin = false;
				logger.info("Login Failed : Username :" + GlobalVar.LoginUsername + " Password : "
						+ GlobalVar.LoginPassword);
			}
		} else {

			try {
				Boolean txtExists = GlobalVar.Driver.getPageSource().contains("Release Notes");
				if (txtExists == false) {
					logger.info("Clicking on PHM Icon");
					HPO.ClickPHM();
					Thread.sleep(GlobalVar.threadSleep);
					logger.info("Clicking on Provider Admin Icon");
					IntMedPage.ClickProviderAdmin();

				} else {
					Thread.sleep(GlobalVar.threadSleep);
					logger.info("Clicking on Provider Admin Home Tab...");
					IntMedPage.ClickProviderAdmin();

				}
			} catch (Exception e) {
				logger.info("Exception Message :" + e.getMessage());
			}
		}

		try {
			// Click on Implementation Menu
			Thread.sleep(GlobalVar.threadSleep);
			PAP.ClickLnkImplementation();
			logger.info("Implementation Menu Clicking...");

			// click on Click on Role SubMenu
			logger.info("Click Role SubMenu Under Implementation Menu");
			Thread.sleep(GlobalVar.threadSleep);
			PAP.ClickLnkRole();

			// Enter The Role Name
			RPO.EnterRoleName("Client Admin");

			// click on Search role button
			RPO.ClickSearchRole();

			// click on setup icon for the role
			logger.info("Click on RoleGrid List for Document Admin Feature");
			RPO.ClickGridRoleList();

			// select associate product name
			RPO.SelectAssociateProductNames("Provider Admin");

			// select the document Admin check box
			if (RPO.Clkcheckbox.isSelected() == true) {

				logger.info("The Document Admin Feature already enabled");
				TC_398_UploadFile.log(LogStatus.INFO, "The Document Admin Feature already enabled");
			} else {

				RPO.ClickCheckBox();
				logger.info("Enabling the Document Admin Feature..");
				TC_398_UploadFile.log(LogStatus.INFO, "Enabling the Document Admin Feature");
			}

			// click on save button
			RPO.ClickbtnSave();

			// Check PreCondition for care Manager
			Thread.sleep(GlobalVar.threadSleep);
			logger.info("Check Forms Resource And Education feature for care manager...");

			RPO.EnterRoleName("care manager");

			// click search role
			RPO.ClickSearchRole();

			// click on setup for care manager role
			logger.info("Click on RoleGrid List for Care Manager Role");
			RPO.ClickGridRoleList();

			// select associate product name

			RPO.SelectAssociateProductNames("Care Manager");

			// Click Care Management Check Box
			if (RPO.ClkCaremgtchkbox.isSelected()) {

				if (RPO.ClkformsEdusubmenu.isSelected()) {

					logger.info("The Forms Resource And Education Feature already enabled...");
					TC_398_UploadFile.log(LogStatus.INFO, "The Forms Resource And Education Feature already enabled");
				} else {

					logger.info("Enabling the Forms Resource And Education Feature...");
					TC_398_UploadFile.log(LogStatus.INFO, "Enabling the Forms Resource And Education Feature");
					for(int i=1;i<=2;i++)
					{
						RPO.ClickFormResourceEducationSubMenu();
					}
					
				}

			} else {
				logger.info("Enabling the Forms Resource And Education Feature...");
				TC_398_UploadFile.log(LogStatus.INFO, "Enabling the Forms Resource And Education Feature");
				RPO.ClickCareManagementcheckbox();

			}

			// Click on Save Button..
			RPO.ClickbtnSave();
		} 
			catch(NoSuchElementException nse){
				logger.info(nse.getMessage());
			}
			catch (Exception e) {
			
			logger.info("FileUploadPreCondition Exception :" + e.getMessage().toString());

		}
	}

	// Start the test case for File uploading..
	// @SuppressWarnings("resource")
	@SuppressWarnings("deprecation")
	@Test

	public static void UploadFile() throws Throwable {
		Logger logger = addlog;
		UploadFileObjects UFO = PageFactory.initElements(GlobalVar.Driver, UploadFileObjects.class);
		IntermediatePageObjects IntMedPage = PageFactory.initElements(GlobalVar.Driver, IntermediatePageObjects.class);
		FormResourceAndEducationObjects FRE = PageFactory.initElements(GlobalVar.Driver,
				FormResourceAndEducationObjects.class);
		ProviderAdminPageObjects PAP = PageFactory.initElements(GlobalVar.Driver, ProviderAdminPageObjects.class);
		HeaderPageObjects HPO = PageFactory.initElements(GlobalVar.Driver, HeaderPageObjects.class);
		PecFormResourceAndEducationObjects PFRE = PageFactory.initElements(GlobalVar.Driver,
				PecFormResourceAndEducationObjects.class);
		ReadExcelFile readExcelFile = new ReadExcelFile();
		GenericUtils genutil = PageFactory.initElements(GlobalVar.Driver, GenericUtils.class);

		boolean multitestdata = Boolean.parseBoolean(GlobalVar.multpletestdata);

		try {
			logger.info("FileUpload  test execution starts.");
			TC_398_UploadFile.log(LogStatus.INFO, "FileUpload test execution starts.");
	
			// click on Document Admin link
			Thread.sleep(GlobalVar.threadSleep);
			PAP.ClickDocumentadminMenu();

			// click on upload file link
			Thread.sleep(GlobalVar.threadSleep);
			PAP.ClickUploadFile();

			// Take The Data From Excel Sheet
			String filepath = GlobalVar.TestDataUploadFileTC398FilePath;
			logger.info("File Path : " + filepath);
			TC_398_UploadFile.log(LogStatus.INFO, "File Path : " + filepath);
			int rows;
			String Documentcategory;
			logger.info("Multiple Test Data : " + multitestdata);
			File file = new File(filepath);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("PD_UploadFile");
			logger.info("Test Type " + GlobalVar.TestType +     " multitestdata " + multitestdata);

			// && (!"FALSE".equals(GlobalVar.multpletestdata))
			if (!"BAT".equals(GlobalVar.TestType)) {
				rows = sheet.getLastRowNum() + 1;
			} else {
				rows = 2;
			}

			int cols = sheet.getRow(1).getLastCellNum();
			logger.info("Test Type : " + GlobalVar.TestType + " || Total Rows :" + rows + "|| Total Columns : " + cols);

			for (int rownum = 1; rownum < rows; rownum++) {
				TestName = "TC_398_UploadFile" + "_" + "row: " + rownum;
				sheet.getRow(rownum).getCell(cols - 1).setCellType(Cell.CELL_TYPE_STRING);
				String executeyn = sheet.getRow(rownum).getCell(cols - 1).getStringCellValue();
				String ExecuteYN = executeyn.toUpperCase().trim();
				Boolean Execute = ExecuteYN.equals("YES");
				logger.info("Test Data Execute Y/N : " + ExecuteYN + " Execute the Row " + rownum + " Execute = "
						+ Execute + "Test Type : " + GlobalVar.TestType);

				if (Execute == true || "BAT".equals(GlobalVar.TestType)) {
					try {
						// Pick the File Name
						sheet.getRow(rownum).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
						String Filename = sheet.getRow(rownum).getCell(0).getStringCellValue();
						logger.info(Filename);

						// Search the Document category
						sheet.getRow(rownum).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						Documentcategory = sheet.getRow(rownum).getCell(1).getStringCellValue();
						logger.info(Documentcategory);

						// browse the file & select the file from location and
						// Check the file is Physically present or not
						File filesrc = new File(GlobalVar.UploadFilesPath + File.separator + Filename);
						if (filesrc.exists() == true) {
							TC_398_UploadFile.log(LogStatus.INFO, "Uploading the file : " + Filename
									+ "|| Under the document category :" + Documentcategory);
							UFO.UploadFileDocument(GlobalVar.UploadFilesPath + File.separator + Filename);

							// select the Document Category from the Drop Down
							// List for uploading
							UFO.SelectDocCatagoryUpload(Documentcategory);

							// click on Upload button
							UFO.ClickUploadbtn();
							Thread.sleep(GlobalVar.threadSleep);
							logger.info("File has been uploaded");
						} else {
							logger.info("File Not exist in the location");
						}

						
					}

					catch (Exception e) {
						logger.info("Exception Message :" + e.getMessage());

					}
				}
				logger.info("Multi Test Data :" + multitestdata + " Execute : " + Execute);
				if ((Boolean.FALSE.equals(multitestdata)) && (Boolean.TRUE.equals(Execute))) {
					logger.info("Multi Test Data : " + (Boolean.FALSE.equals(multitestdata)) + " Execute Y/N : "
							+ (Boolean.TRUE.equals(Execute)));
					break;
				}
			}

			logger.info("All files has been Uploaded");
			TC_398_UploadFile.log(LogStatus.INFO, "All files has been Uploaded");

			// Search the document based on the category
			UFO.SelectDocumentCatagory("FREQUENTLY ASKED QUESTIONS");
			UFO.ClickbtnSearchDocument();
			try {
				if (UFO.verifyRecordPresentorNot() == false) {
					if (UFO.LblPresentOrNot() == true) {
						PD_FAQ = genutil.CountPdUploadRecord(UFO.uploaddoc);
						logger.info("Frequesntly asked Question Total records Count : " + PD_FAQ);
					}
				}

				else {
					PD_FAQ = 0;
				}
			} catch (Exception e) {
				logger.info("Exception Message :" + e.getMessage());

			}

			// Count the record based on the category
			UFO.SelectDocumentCatagory("FORMS AND TEMPLATES");
			UFO.ClickbtnSearchDocument();
			try {
				if (UFO.verifyRecordPresentorNot() == false) {
					if (UFO.LblPresentOrNot() == true) {
						PD_FAT = genutil.CountPdUploadRecord(UFO.uploaddoc);
						logger.info("Forms and template Total Records Count : " + PD_FAT);
					}
				}

				else {
					PD_FAT = 0;
				}
			} catch (Exception e) {
				logger.info("Exception Message :" + e.getMessage());
			}

			// Count the record based on the category
			UFO.SelectDocumentCatagory("REFERENCE GUIDES");
			UFO.ClickbtnSearchDocument();
			try {
				if (UFO.verifyRecordPresentorNot() == false) {
					if (UFO.LblPresentOrNot() == true) {
						PD_RefGuides = genutil.CountPdUploadRecord(UFO.uploaddoc);
						logger.info("Reference Guides Total Records Count : " + PD_RefGuides);
					}
				}

				else {
					PD_RefGuides = 0;
				}
			} catch (Exception e) {
				logger.info("Exception Message :" + e.getMessage());
			}

			// Count the record based on the category
			UFO.SelectDocumentCatagory("EMR EDUCATION");
			UFO.ClickbtnSearchDocument();
			try {
				if (UFO.verifyRecordPresentorNot() == false) {
					if (UFO.LblPresentOrNot() == true) {
						PD_EMREdu = genutil.CountPdUploadRecord(UFO.uploaddoc);
						logger.info("EMR Education Total Records Count : " + PD_EMREdu);
					}
				}

				else {
					PD_EMREdu = 0;
				}
			} catch (Exception e) {
				logger.info("Exception Message :" + e.getMessage());
			}

			// Count the record based on the category
			UFO.SelectDocumentCatagory("WEBINARS");
			UFO.ClickbtnSearchDocument();
			try {
				if (UFO.verifyRecordPresentorNot() == false) {
					if (UFO.LblPresentOrNot() == true) {
						PD_Webinars = genutil.CountPdUploadRecord(UFO.uploaddoc);
						logger.info(" Webinars Total Records Count : " + PD_Webinars);
					}
				}

				else {
					PD_Webinars = 0;
				}
			} catch (Exception e) {
				logger.info("Exception Message :" + e.getMessage());
			}

			// Count the record based on the category
			UFO.SelectDocumentCatagory("DECISION AIDS");
			UFO.ClickbtnSearchDocument();
			try {
				if (UFO.verifyRecordPresentorNot() == false) {
					if (UFO.LblPresentOrNot() == true) {
						PD_DecisionAids = genutil.CountPdUploadRecord(UFO.uploaddoc);
						logger.info("Decision Aids Total Records Count : " + PD_DecisionAids);
					}
				}

				else {
					PD_DecisionAids = 0;
				}
			} catch (Exception e) {
				logger.info("Exception Message :" + e.getMessage());
			}

			// Count the record based on the category
			UFO.SelectDocumentCatagory("HANDOUTS");
			UFO.ClickbtnSearchDocument();
			try {
				if (UFO.verifyRecordPresentorNot() == false) {
					if (UFO.LblPresentOrNot() == true) {
						PD_Handouts = genutil.CountPdUploadRecord(UFO.uploaddoc);
						logger.info("Handouts Total Records Count : " + PD_Handouts);
					}
				}

				else {
					PD_Handouts = 0;
				}
			} catch (Exception e) {
				logger.info("Exception Message :" + e.getMessage());
			}

			// Logout from the PD Application
			logger.info("Logout from the PD application..");
			TC_398_UploadFile.log(LogStatus.PASS, "Logout from the PD application.");
			Thread.sleep(GlobalVar.threadSleep);
			HPO.PDLogout();

			// Logged into the Care Manager Role in the Application
			Thread.sleep(GlobalVar.threadSleep);

			GlobalVar.Modules = "CM";
			readExcelFile.getUsernamePassword(GlobalVar.TestDataFilePath, GlobalVar.UserDetailsTestData,
					GlobalVar.SheetName, GlobalVar.Client, GlobalVar.Modules);
			Login.login1(GlobalVar.LoginUsername, GlobalVar.LoginPassword);
			TC_398_UploadFile.log(LogStatus.INFO,
					"Login to CM - Login name :" + GlobalVar.LoginUsername + " Password :" + GlobalVar.LoginPassword);
			logger.info("Logged in to the Care Manager Application");

			// Click on Care Manager Home Tab..
			logger.info("Click on Care Manager Home Tab");
			Thread.sleep(GlobalVar.threadSleep);
			IntMedPage.ClickOnCareManagerLink();

			// Click on Care Management Menu...
			logger.info("Click on Care Management Menu");
			Thread.sleep(GlobalVar.threadSleep);
			FRE.ClickCareManagementMenu();

			// click on form Resource And Education Sub Menu..
			logger.info("Click on Form Resourse and Education Sub Menu..");
			FRE.ClickFormResourceEducation();

			// ........Click on Frequently Asked Question Link.......
			FRE.ClickFAQ();
			logger.info("Click on Frequently asked question");
			try {
				if (FRE.LblFaqCount.isDisplayed()) {
					String Faqtxt = FRE.LblFaqRecordsCountText();
					CM_FAQ = genutil.CountRecords(Faqtxt);
					logger.info("CM Frequently Asked Question Total Count : " + CM_FAQ);
				}
			} catch (Exception e) {

				CM_FAQ = FRE.LstFaqRowCount();
				logger.info("CM Frequently Asked Question Total Count : " + CM_FAQ);
			}

			// .........Click on Form And Template Link.........
			logger.info("Click on Form And Template Tab");
			FRE.ClickFormAndTemplate();
			try {
				if (FRE.LblFaTCount.isDisplayed()) {

					String Fattxt = FRE.LblFormAndTempRecordsCountText();
					CM_FAT = genutil.CountRecords(Fattxt);
					logger.info("CM Form And Template Total Count : " + CM_FAT);
				}
			} catch (Exception e) {
				CM_FAT = FRE.LstFormAndTempRowCount();
				logger.info("CM Form And Template Total Count : " + CM_FAT);

			}

			// Click on Reference Guides Tab
			logger.info("Click on Reference Guides Tab");
			FRE.ClickRefernceGuides();

			try {
				if (FRE.LblRefGuideCount.isDisplayed()) {

					String RefGuidestxt = FRE.LblReferenceGuideRecordsCountText();
					CM_RefGuides = genutil.CountRecords(RefGuidestxt);
					logger.info("CM Reference Guides Total Count : " + CM_RefGuides);
				}
			} catch (Exception e) {
				CM_RefGuides = FRE.LstReferenceGuideRowCount();
				logger.info("CM Reference Guides Total Count : " + CM_RefGuides);

			}

			// Click On EMR Education Tab
			logger.info("Click on EMR Education Tab");
			FRE.ClickEMREducation();
			try {
				if (FRE.LblEMREducationCount.isDisplayed()) {
					String EMREdutxt = FRE.LblEMREducationRecordsCountText();
					CM_EMREdu = genutil.CountRecords(EMREdutxt);
					logger.info("CM EMR Education Total Count : " + CM_EMREdu);
				}
			} catch (Exception e) {

				CM_EMREdu = FRE.LstEMREducationRowCount();
				logger.info("CM EMR Education Total Count : " + CM_EMREdu);

			}

			// Click on Webinars Tab
			logger.info("Click on Webinars Tab");
			FRE.ClickWebinars();
			try {
				if (FRE.LblWebinarsCount.isDisplayed()) {
					String Webinarstxt = FRE.LblWebinarsRecordsCountText();
					CM_Webinars = genutil.CountRecords(Webinarstxt);
					logger.info("CM Webinars Total Count : " + CM_Webinars);
				}
			} catch (Exception e) {

				CM_Webinars = FRE.LstWebinarsRowCount();
				logger.info("CM Webinars Total Count : " + CM_Webinars);
			}

			// click on Decisions Aids
			logger.info("Click on Decision Aids Tab");
			Thread.sleep(GlobalVar.threadSleep);
			// FRE.ClickDecisionsAids();
			try {
				if (FRE.LblDecisionAidsCount.isDisplayed()) {
					String DecisionAidstxt = FRE.LblDecisionAidsRecordsCountText();
					CM_DecisionAids = genutil.CountRecords(DecisionAidstxt);
					logger.info("CM Decisions Aids Total Count : " + CM_DecisionAids);
				}
			} catch (Exception e) {
				CM_DecisionAids = FRE.LstDecisionsAidsRowCount();
				logger.info("CM Decisions Aids Total Count : " + CM_DecisionAids);
			}

			// Click on HandOuts Tab
			logger.info("Click on Handouts Tab");
			FRE.ClickHandouts();
			try {
				if (FRE.LblhandoutsCount.isDisplayed()) {
					String Handoutstxt = FRE.LblhandoutsRecordsCountText();
					CM_Handouts = genutil.CountRecords(Handoutstxt);
					logger.info("CM HandOuts Total Count : " + CM_Handouts);
				}
			} catch (Exception e) {
				CM_Handouts = FRE.LsthandoutsRowCount();
				logger.info("CM HandOuts Total Count : " + CM_Handouts);
			}

			// Logout from the CM Application
			logger.info("Logout from the CM application..");
			TC_398_UploadFile.log(LogStatus.PASS, "Logout from the CM application.");
			Thread.sleep(GlobalVar.threadSleep);
			HPO.FREPageLogout();

			// Logged into the Provider Role in the Application
			Thread.sleep(GlobalVar.threadSleep);
			GlobalVar.Modules = "PEC";
			readExcelFile.getUsernamePassword(GlobalVar.TestDataFilePath, GlobalVar.UserDetailsTestData,
					GlobalVar.SheetName, GlobalVar.Client, GlobalVar.Modules);
			Login.login1(GlobalVar.LoginUsername, GlobalVar.LoginPassword);
			TC_398_UploadFile.log(LogStatus.INFO,
					"Login to PEC - Login name :" + GlobalVar.LoginUsername + " Password :" + GlobalVar.LoginPassword);
			// Thread.sleep(GlobalVar.threadSleep);
			logger.info("Logged in to the Provider Application");

			// click on Provider eConnect home tab..
			Thread.sleep(GlobalVar.threadSleep);
			IntMedPage.ClickOnProvidereConnect();

			// click on form Resource And Education Sub Menu..
			logger.info("Click on Form Resourse and Education Sub Menu..");
			PFRE.ClickFormsResourceAndEducation();

			// ........Click on Frequently Asked Question Link.......
			logger.info("Click on Frequently Asked Question");
			PFRE.ClickFrequentlyAskedQuestion();

			try {
				if (PFRE.LblFaqCount.isDisplayed()) {
					String Faqtxt = PFRE.LblFaqRecordsCountText();
					PEC_FAQ = genutil.CountRecords(Faqtxt);
					logger.info("PEC Frequently Asked Question Total Count : " + PEC_FAQ);
				}
			} catch (Exception e) {

				PEC_FAQ = PFRE.LstFaqRowCount();
				logger.info("PEC Frequently Asked Question Total Count : " + PEC_FAQ);
			}

			// .........Click on Form And Template Link.........
			logger.info("Click on Form And Resource Tab");
			PFRE.ClickFormsAndTemplates();
			try {
				if (PFRE.LblFaTCount.isDisplayed()) {
					String FaTtxt = PFRE.LblFormAndTempRecordsCountText();
					PEC_FAT = genutil.CountRecords(FaTtxt);
					logger.info("PEC Form And Template Total Count : " + PEC_FAT);
				}
			} catch (Exception e) {
				PEC_FAT = PFRE.LstFormAndTempRowCount();
				logger.info("PEC Form And Template Total Count : " + PEC_FAT);
				
			}

			// ............Click on Reference Guides Tab............

			logger.info("Click on Reference Guides Tab");
			PFRE.ClickReferenceGuides();
			try {
				if (PFRE.LblRefGuideCount.isDisplayed()) {
					String RefGuidestxt = PFRE.LblReferenceGuideRecordsCountText();
					PEC_RefGuides = genutil.CountRecords(RefGuidestxt);
					logger.info("PEC Reference Guides Total Count : " + PEC_RefGuides);
				}
			} catch (Exception e) {
				PEC_RefGuides = PFRE.LstReferenceGuideRowCount();
				logger.info("PEC Reference Guides Total Count : " + PEC_RefGuides);

			}

			// ..............Click On EMR Education Tab....................
			logger.info("Click on EMR Education Tab");
			PFRE.ClickEMREduction();
			try {
				if (PFRE.LblEMREducationCount.isDisplayed()) {
					String EMREdutxt = PFRE.LblEMREducationRecordsCountText();
					PEC_EMREdu = genutil.CountRecords(EMREdutxt);
					logger.info("PEC EMR Education Total Count : " + PEC_EMREdu);
				}
			} catch (Exception e) {

				PEC_EMREdu = PFRE.LstEMREducationRowCount();
				logger.info("PEC EMR Education Total Count : " + PEC_EMREdu);

			}

			// ....................Click on Webinars Tab...................
			logger.info("Click on Webinars Tab");
			PFRE.ClickWebinars();
			try {
				if (PFRE.LblWebinarsCount.isDisplayed()) {
					String Webinarstxt = PFRE.LblWebinarsRecordsCountText();
					PEC_Webinars = genutil.CountRecords(Webinarstxt);
					logger.info("PEC  Webinars Total Count : " + PEC_Webinars);
				}
			} catch (Exception e) {

				PEC_Webinars = PFRE.LstWebinarsRowCount();
				logger.info("PEC  Webinars Total Count : " + PEC_Webinars);
			}

			// ............. click on Decisions Aids...................
			logger.info("Click on Decision Aids Tab");
			Thread.sleep(GlobalVar.threadSleep);
			PFRE.ClickDecisionAids();
			try {
				if (PFRE.LblDecisionAidsCount.isDisplayed()) {
					String DecisionAidstxt = PFRE.LblDecisionAidsRecordsCountText();
					PEC_DecisionAids = genutil.CountRecords(DecisionAidstxt);
					logger.info("PEC Decisions Aids Total Count : " + PEC_DecisionAids);
				}
			} catch (Exception e) {

				PEC_DecisionAids = PFRE.LstDecisionsAidsRowCount();
				logger.info("PEC Decisions Aids Total Count : " + PEC_DecisionAids);
			}

			// ................ Click on HandOuts Tab......................
			logger.info("Click on Handouts Tab");
			PFRE.ClickHandouts();
			try {
				if (PFRE.LblhandoutsCount.isDisplayed()) {
					String Handoutstxt = PFRE.LblhandoutsRecordsCountText();
					PEC_Handouts = genutil.CountRecords(Handoutstxt);
					logger.info("PEC HandOuts Total Count : " + PEC_Handouts);
				}
			} catch (Exception e) {
				PEC_Handouts = PFRE.LsthandoutsRowCount();
				logger.info("PEC HandOuts Total Count : " + PEC_Handouts);
			}

			// Match The Particular Record Count..

			logger.info("PD_Count = || FREQUENTLY ASKED QUESTIONS : " + PD_FAQ + "|| FORMS AND TEMPLATES : " + PD_FAT
					+ "|| REFERENCE GUIDES : " + PD_RefGuides + "|| EMR EDUCATION : " + PD_EMREdu + "|| WEBINARS : "
					+ PD_Webinars + "|| DECISION AIDS : " + PD_DecisionAids + "|| HANDOUTS : " + PD_Handouts);
			logger.info("CM_Count = || FREQUENTLY ASKED QUESTIONS : " + CM_FAQ + "|| FORMS AND TEMPLATES : " + CM_FAT
					+ "|| REFERENCE GUIDES : " + CM_RefGuides + "|| EMR EDUCATION : " + CM_EMREdu + "|| WEBINARS : "
					+ CM_Webinars + "|| DECISION AIDS : " + CM_DecisionAids + "|| HANDOUTS : " + CM_Handouts);
			logger.info("PEC_Count = || FREQUENTLY ASKED QUESTIONS : " + PEC_FAQ + "|| FORMS AND TEMPLATES : " + PEC_FAT
					+ "|| REFERENCE GUIDES : " + PEC_RefGuides + "|| EMR EDUCATION : " + PEC_EMREdu + "|| WEBINARS : "
					+ PEC_Webinars + "|| DECISION AIDS : " + PEC_DecisionAids + "|| HANDOUTS : " + PEC_Handouts);
			TC_398_UploadFile.log(LogStatus.INFO,
					"PD_Count = " + " FREQUENTLY ASKED QUESTIONS : " + PD_FAQ + "|| FORMS AND TEMPLATES : " + PD_FAT
							+ "|| REFERENCE GUIDES : " + PD_RefGuides + "|| EMR EDUCATION : " + PD_EMREdu
							+ "|| WEBINARS : " + PD_Webinars + "|| DECISION AIDS : " + PD_DecisionAids
							+ "|| HANDOUTS : " + PD_Handouts);
			TC_398_UploadFile.log(LogStatus.INFO,
					"CM_Count = " + " FREQUENTLY ASKED QUESTIONS : " + CM_FAQ + "|| FORMS AND TEMPLATES : " + CM_FAT
							+ "|| REFERENCE GUIDES : " + CM_RefGuides + "|| EMR EDUCATION : " + CM_EMREdu
							+ "|| WEBINARS : " + CM_Webinars + "|| DECISION AIDS : " + CM_DecisionAids
							+ "|| HANDOUTS : " + CM_Handouts);
			TC_398_UploadFile.log(LogStatus.INFO,
					"PEC_Count = " + " FREQUENTLY ASKED QUESTIONS : " + PEC_FAQ + "|| FORMS AND TEMPLATES : " + PEC_FAT
							+ "|| REFERENCE GUIDES : " + PEC_RefGuides + "|| EMR EDUCATION : " + PEC_EMREdu
							+ "|| WEBINARS : " + PEC_Webinars + "|| DECISION AIDS : " + PEC_DecisionAids
							+ "|| HANDOUTS : " + PEC_Handouts);

			boolean Result_FAQ = ((PD_FAQ == CM_FAQ) && (PD_FAQ == PEC_FAQ));
			boolean Result_FAT = ((PD_FAT == CM_FAT) && (PD_FAT == PEC_FAT));
			boolean Result_RefGuides = ((PD_RefGuides == CM_RefGuides) && (PD_RefGuides == PEC_RefGuides));
			boolean Result_EMREdu = ((PD_EMREdu == CM_EMREdu) && (PD_EMREdu == PEC_EMREdu));
			boolean Result_Webinars = ((PD_Webinars == CM_Webinars) && (PD_Webinars == PEC_Webinars));
			boolean Result_DecisionAids = ((PD_DecisionAids == CM_DecisionAids)
					&& (PD_DecisionAids == PEC_DecisionAids));
			boolean Result_Handouts = ((PD_Handouts == CM_Handouts) && (PD_Handouts == PEC_Handouts));

			if ((Boolean.TRUE.equals(Result_FAQ)) && (Boolean.TRUE.equals(Result_FAT))
					&& (Boolean.TRUE.equals(Result_RefGuides)) && (Boolean.TRUE.equals(Result_EMREdu))
					&& (Boolean.TRUE.equals(Result_Webinars)) && (Boolean.TRUE.equals(Result_DecisionAids))
					&& (Boolean.TRUE.equals(Result_Handouts))) {
				TC_398_UploadFile.log(LogStatus.PASS, "PASS");
				logger.info("Test Case Status :  PASS ");

			} else {

				TC_398_UploadFile.log(LogStatus.FAIL, "FAIL");
				logger.info("Test Case Status : FAIL ");
			}

			logger.info("Upload document Execution has been completed");
			// ReportGenerator.setLog("Upload document Execution has been
			// completed");
			TC_398_UploadFile.log(LogStatus.PASS, "Upload document Execution has been completed");
			GlobalVar.report.endTest(TC_398_UploadFile);

		} catch (Throwable t) {

			logger.info("UploadFile Exception :" + t.getMessage().toString());
			// ScreenShotPath = GenericUtils.CaptureScreenshot(GlobalVar.Driver,
			// "TC_398 _UploadFile" + LocalDateTime.now().getHour() +
			// LocalDateTime.now().getMinute() +
			// LocalDateTime.now().getSecond());
			ScreenShotPath = ReportGenerator.setLog("Uplod Document Failed", t.getMessage().toString(),
					"Upload Document_TC398_Fail");
			String image = TC_398_UploadFile.addScreenCapture(ScreenShotPath);
			TC_398_UploadFile.log(LogStatus.FAIL, image);
			GlobalVar.report.endTest(TC_398_UploadFile);

		}
	}

}