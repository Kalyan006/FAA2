package com.phm.hec.PD.Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;
import com.phm.hec.PD.AccountPageObjects.AccountPageObjects;
import com.phm.hec.PD.AccountPageObjects.AddAccountAssignFacilityPageObjects;
import com.phm.hec.PD.AccountPageObjects.AddAccountAssignProviderPageObjects;
import com.phm.hec.PD.AccountPageObjects.AddAccountAssignRegionPageObjects;
import com.phm.hec.PD.AccountPageObjects.AddAccountAssignUserPageObjects;
import com.phm.hec.PD.AccountPageObjects.AddAccountPageObjects;
import com.phm.hec.PD.AdminPageObjects.ProviderAdminPageObjects;
import com.phm.hec.pageObjects.HeaderPageObjects;
import com.phm.hec.pageObjects.IntermediatePageObjects;
import com.phm.hec.testcases.Login;
import com.phm.hec.utility.GenericUtils;
import com.phm.hec.utility.GlobalVar;
import com.phm.hec.utility.ReadExcelFile;
import com.phm.hec.utility.ReportGenerator;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC16AddAccount {

	static ExtentTest TC_16_Add_Account;
	public static String ScreenShotPath;
	public static String testdata;
	public static String RegionName = "";
	public static String FacilityName = "";
	public static String ProviderLastName = "";
	public static String ProviderFirstName = "";
	public static String UserLastName = "";
	public static String UserFirstName = "";
	public static Boolean Execute = false;
	public static String TestName = "";
	public static String ARRegionCode = "";
	public static String AFTaxId = "";
	public static String APNPI = "";
	public static String AUUserName = "";
	public static Logger addlog = Logger.getLogger(TC16AddAccount.class.getName());
	public  static GlobalVar WebDriver;

	@Test
	public static void AddAccount() throws Throwable {
		
	
		try {
			Logger logger = Logger.getLogger(TC16AddAccount.class.getName());
			TC_16_Add_Account = GlobalVar.report.startTest("TC_16_Add_Account",
					"Validate user able to create add account");

			// Intermediate page object
			IntermediatePageObjects INM = PageFactory.initElements(GlobalVar.Driver, IntermediatePageObjects.class);
			// Provider admin page object
			ProviderAdminPageObjects papo = PageFactory.initElements(GlobalVar.Driver, ProviderAdminPageObjects.class);
			// Header page object
			HeaderPageObjects hpo = PageFactory.initElements(GlobalVar.Driver, HeaderPageObjects.class);
			// Account page object
			AccountPageObjects apo = PageFactory.initElements(GlobalVar.Driver, AccountPageObjects.class);
			// Add account page object
			AddAccountPageObjects aapo = PageFactory.initElements(GlobalVar.Driver, AddAccountPageObjects.class);
			// Assign region page object
			AddAccountAssignRegionPageObjects aaarpo = PageFactory.initElements(GlobalVar.Driver,
					AddAccountAssignRegionPageObjects.class);
			// Assign faciity page object
			AddAccountAssignFacilityPageObjects aaafpo = PageFactory.initElements(GlobalVar.Driver,
					AddAccountAssignFacilityPageObjects.class);
			// Assign provider page object
			AddAccountAssignProviderPageObjects aaappo = PageFactory.initElements(GlobalVar.Driver,
					AddAccountAssignProviderPageObjects.class);
			// Assign user page object
			AddAccountAssignUserPageObjects aaaupo = PageFactory.initElements(GlobalVar.Driver,
					AddAccountAssignUserPageObjects.class);
			boolean multitestdata = Boolean.parseBoolean(GlobalVar.multpletestdata);

			if (GlobalVar.loggedin == false) {
				
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
					INM.ClickProviderAdmin();
					GlobalVar.loggedin = true;
				} else {
					GlobalVar.loggedin = false;
					logger.info("Login Failed : Username :" + GlobalVar.LoginUsername + " Password : "
							+ GlobalVar.LoginPassword);
				}
			} else {
				// Click on the PHM Icon in the Upper Right cornor of the page
				try {
					Boolean txtExists = GlobalVar.Driver.getPageSource().contains("Release Notes");
					if (txtExists == false) {
						logger.info("Clicking on PHM Icon");
						hpo.ClickPHM();
						Thread.sleep(GlobalVar.threadSleep);
						logger.info("Clicking on Provider Admin Icon");
						Thread.sleep(GlobalVar.threadSleep);
						INM.ClickProviderAdmin();
						
					} else {
						Thread.sleep(GlobalVar.threadSleep);
						logger.info("Clicking on Provider Admin Home Tab...");
						INM.ClickProviderAdmin();
					}
				} catch (Exception e) {
					logger.info("Exception Message :" + e.getMessage());
				}
			}

			Thread.sleep(GlobalVar.threadSleep);
			
			// Click on organization link
			papo.ClickLnkOrganization();

			// Click on account link
			papo.ClickLnkAccount();

			TC_16_Add_Account.log(LogStatus.INFO, "TC 16 Add Account - Test execution starts");
			// Click on add account button
			logger.info("Clicking on Add Account");
			apo.ClickBtnAddAccount();
			logger.info("Clicked on Add Account button in Account Page");
			
			String filepath = GlobalVar.TestDataAddAccountTC16FilePath;

			logger.info("File Path for Add Account : " + filepath);
						
			// Data driven starts here

			File AddAccount = new File(filepath);
			FileInputStream fis = new FileInputStream(AddAccount);
			int rows;
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			String AddAccSheetName = GlobalVar.TDSheetName.toString().trim();
			AddAccSheetName = AddAccSheetName.toUpperCase().trim();
			logger.info("Sheet Name : " + AddAccSheetName);
			XSSFSheet sheet = workbook.getSheet(AddAccSheetName);
			
			int cols = sheet.getRow(1).getLastCellNum();
			// logger.info("Rows :" + rows + "|| Columns : " + cols);

			if (!"BAT".equals(GlobalVar.TestType)) {
				rows = sheet.getLastRowNum() + 1;
			} else {
				rows = 2;
			}

			for (int rownum = 1; rownum < rows; rownum++) {
				TestName = "TC_16_Add_Account" + "_" + "rows: " + rownum;
				String Executeyn = GenericUtils.cellValue(sheet, rownum, cols - 1);
				String ExecuteYN = Executeyn.toUpperCase().trim();
				Boolean Execute = ExecuteYN.equals("YES");
				logger.info("Test Data Execute Y/N : " + Executeyn + " Execute the Row " + rownum + " Execute = "
						+ Execute + "Test Type : " + GlobalVar.TestType);
				// if (!"Yes".equalsIgnoreCase(Executeyn) ||
				// "BAT".equals(GlobalVar.TestType))
				if (Execute == true || "BAT".equals(GlobalVar.TestType)) {
					try {

						
						{
						
							// Add account page Account Information,enter account name
							String AccountName = "UATAddAccount" + LocalDateTime.now().getHour()
									+ LocalDateTime.now().getMinute() + LocalDateTime.now().getSecond();
							// String AccountName==GenericUtils.cellValue(sheet,
							// rownum, 0);
							logger.info("Row No. " + rownum + " Account Name : " + AccountName);
							aapo.EnterAddAccAccountName(AccountName);

							// Thread.sleep(GlobalVar.threadSleep);

							// Add account page Account Information,select
							// account type
							String AddAccAccountType = GenericUtils.cellValue(sheet, rownum, 1);
							logger.info(AddAccAccountType);
							if(AddAccAccountType==null){
								continue;
							}
							else{
								aapo.SctAddAccAccountType(AddAccAccountType);
							}
							
							// aapo.AccountDropdownSelect(AddAccAccountType,
							// AddAccAccountType);

							// Add account page Account Information,select
							// account category
							String AddAccAccountCategory = GenericUtils.cellValue(sheet, rownum, 2);
							logger.info(AddAccAccountCategory);
							if(AddAccAccountCategory==null){
								continue;
							}
							else{
								aapo.SctAddAccAccountCategory(AddAccAccountCategory);
							}
							// aapo.AccountDropdownSelect(AddAccAccountCategory,
							// AddAccAccountCategory);

							// Add account page Identifier Information,enter SSN
							String AddAccSsn = GenericUtils.cellValue(sheet, rownum, 3);
							logger.info(AddAccSsn);
							if(AddAccSsn==null){
								continue;
							}
							else{
								aapo.EnterAddAccSsn(AddAccSsn);
							}
														
							// Add account page Identifier Information,enter NPI
							String npi = GenericUtils.cellValue(sheet, rownum, 4);
							logger.info(npi);
							if(npi==null){
								continue;
							}
							else{
								aapo.EnterAddAccNpi(npi);
							}

							// Add account page Identifier Information,enter tax
							// id
							try{
							String taxid = GenericUtils.cellValue(sheet, rownum, 5);
							logger.info(taxid);
							if(taxid==null){
								continue;
							}
							else{
								aapo.EnterAddAccTaxId(taxid);
							}
							}
							catch(NullPointerException n)
							{
								n.printStackTrace();
								logger.info("Null");
							}
							//Thread.sleep(GlobalVar.threadSleep);
							// Add account page Identifier Information,select
							// state
							try{
							String state = GenericUtils.cellValue(sheet, rownum, 6);
							logger.info(state);
							if(state==null){
								continue;
							}
							else{
								aapo.SctAddAccDdlState(state);
							}
							}
							catch(NullPointerException n1)
							{
								n1.printStackTrace();
								logger.info("Null");
							}
							// Add account page Identifier Information,state
							// assigned id
							String StateAssignedId = GenericUtils.cellValue(sheet, rownum, 7);
							logger.info(StateAssignedId);
							if(StateAssignedId==null){
								continue;
							}
							else{
								aapo.EnterAddAccStateAssignedId(StateAssignedId);
							}

							// Add account page Identifier Information,enter
							// upin
							String upin = GenericUtils.cellValue(sheet, rownum, 8);
							logger.info(upin);
							if(upin==null){
								continue;
							}
							else{
								aapo.EnterAddAccUpin(upin);
							}

							//Thread.sleep(GlobalVar.threadSleep);

							// Add account page Taxonomy & Description,select
							// taxonomy code set
							String TaxonomyCodeSet = GenericUtils.cellValue(sheet, rownum, 9);
							logger.info(TaxonomyCodeSet);
							if(TaxonomyCodeSet==null){
								continue;
							}
							else{
								aapo.SctAddAccTaxonomyCodeSet(TaxonomyCodeSet);
							}

							/*
							 * Select sct=new
							 * Select(GlobalVar.Driver.findElement(By.id(
							 * "ContentPlaceHolder1_ddlTaxCodeSet")));
							 * List<WebElement> listofoptions=sct.getOptions();
							 * for(WebElement option :listofoptions) { String
							 * TaxonomyCodeSet=option.getText();
							 * logger.info(TaxonomyCodeSet);
							 * if(TaxonomyCodeSet.contains("Ambulatory")) {
							 * sct.selectByVisibleText(TaxonomyCodeSet); break;
							 * } }
							 */

							//Thread.sleep(GlobalVar.threadSleep);
							/*
							 * Select sct1=new
							 * Select(GlobalVar.Driver.findElement(By.id(
							 * "ContentPlaceHolder1_ddlTaxCode")));
							 * List<WebElement>
							 * listofoptions1=sct1.getOptions(); for(WebElement
							 * option1 :listofoptions1) { String
							 * TaxonomyCode=option1.getText();
							 * logger.info(TaxonomyCode);
							 * if(TaxonomyCode.contains("Clinic/Center")) {
							 * sct1.selectByVisibleText(TaxonomyCode); break; }
							 * }
							 */

							// Add account page Taxonomy & Description,select
							// taxonomy code
							String TaxonomyCode = GenericUtils.cellValue(sheet, rownum, 10);
							logger.info(TaxonomyCode);
							if(TaxonomyCode==null){
								continue;
							}
							else{
								aapo.SctAddAccDdlTaxonomyCode(TaxonomyCode);
							}
							
							// Add account page Address & Contact
							// Information,enter last name
							String LastName = GenericUtils.cellValue(sheet, rownum, 11);
							logger.info(LastName);
							if(LastName==null){
								continue;
							}
							else{
								aapo.EnterAddAccLastName(LastName);
							}
							
							// Add account page Address & Contact
							// Information,enter First Name
							String FirstName = GenericUtils.cellValue(sheet, rownum, 12);
							logger.info(FirstName);
							if(FirstName==null){
								continue;
							}
							else{	
								aapo.EnterAddAccFirstName(FirstName);
							}
							
							// Add account page Address & Contact
							// Information,enter email
							String Email = GenericUtils.cellValue(sheet, rownum, 13);
							logger.info(Email);
							if(Email==null){
								continue;
							}
							else{
								aapo.EnterAddAccEmail(Email);
							}
							
							// Add account page Address & Contact
							// Information,enter Address 1
							String Address1 = GenericUtils.cellValue(sheet, rownum, 14);
							logger.info(Address1);
							if(Address1==null){
								continue;
							}
							else{
								aapo.EnterAddAccTxtAddress1(Address1);
							}
							
							// Add account page Address & Contact
							// Information,enter Address 2
							String Address2 = GenericUtils.cellValue(sheet, rownum, 15);
							logger.info(Address2);
							if(Address2==null){
								continue;
							}
							else{
								aapo.EnterAddAccTxtAddress2(Address2);
							}
							
							// Add account page Address & Contact
							// Information,enter city
							String City = GenericUtils.cellValue(sheet, rownum, 16);
							logger.info(City);
							if(City==null){
								continue;
							}
							else{
								aapo.EnterAddAccCity(City);
							}
							
							// Add account page Address & Contact
							// Information,select state
							String ACIState = GenericUtils.cellValue(sheet, rownum, 17);
							logger.info(ACIState);
							if(ACIState==null){
								continue;
							}
							else{	
								aapo.SctAddAccDdlAcState(ACIState);
							}
							
							// Add account page Address & Contact
							// Information,enter zip
							String Zip = GenericUtils.cellValue(sheet, rownum, 18);
							logger.info(Zip);
							if(Zip==null){
								continue;
							}
							else{
								aapo.EnterAddAccZip(Zip);
							}
							
							// Add account page Address & Contact
							// Information,enter fax
							String Fax = GenericUtils.cellValue(sheet, rownum, 19);
							logger.info(Fax);
							if(Fax==null){
								continue;
							}
							else{
								aapo.EnterAddAccFax(Fax);
							}
							
							// Add account page Address & Contact
							// Information,enter phone 1
							String phone1 = GenericUtils.cellValue(sheet, rownum, 20);
							logger.info(phone1);
							if(phone1==null){
								continue;
							}
							else{
								aapo.EnterAddAccTelephone1(phone1);
							}
							
							// Add account page Address & Contact
							// Information,enter Extension1
							String Ext1 = GenericUtils.cellValue(sheet, rownum, 21);
							logger.info(Ext1);
							if(Ext1==null){
								continue;
							}
							else{
								aapo.EnterAddAccExtension1(Ext1);
							}
							
							// Add account page Address & Contact
							// Information,enter phone 2
							String phone2 = GenericUtils.cellValue(sheet, rownum, 22);
							logger.info(phone2);
							if(phone2==null){
								continue;
							}
							else{
								aapo.EnterAddAccTelephone2(phone2);
							}
							
							// Add account page Address & Contact
							// Information,enter Extension2
							String Ext2 = GenericUtils.cellValue(sheet, rownum, 23);
							logger.info(Ext2);
							if(Ext2==null){
								continue;
							}
							else{
								aapo.EnterAddAccExtension2(Ext2);
							}
							
							Thread.sleep(GlobalVar.threadSleep);
							// Add account page Additional Information,select
							// batch claims format
							aapo.ClickAddAccBatchClaims();

							// Add account page, select ANSI/X12 format
							aapo.ClickRdoAnsi();

							// Add account page select Propertiary format
							// aapo.ClickRdoPropertiary();

							// Add account page Credit / Debit Payment
							// Gateway,enter merchant id
							String MerchantID = GenericUtils.cellValue(sheet, rownum, 24);
							logger.info(MerchantID);
							if(MerchantID==null){
								continue;
							}
							else{
								aapo.EnterAddAccMerchantId(MerchantID);
							}
							
							// Add account page Credit / Debit Payment
							// Gateway,enter Operator / User ID
							String OperatorUserID = GenericUtils.cellValue(sheet, rownum, 25);
							logger.info(OperatorUserID);
							if(OperatorUserID==null){
								continue;
							}
							else{
								aapo.EnterAddAccOperatorOrUserId(OperatorUserID);
							}
							
							// Add account page Credit / Debit Payment
							// Gateway,enter Password
							String Password = GenericUtils.cellValue(sheet, rownum, 26);
							logger.info(Password);
							if(Password==null){
								continue;
							}
							else{
								aapo.EnterAddAccPassword(Password);
							}
							
							// Add account page Credit / Debit Payment
							// Gateway,enter Device ID
							String DeviceID = GenericUtils.cellValue(sheet, rownum, 27);
							logger.info(DeviceID);
							if(DeviceID==null){
								continue;
							}
							else{
								aapo.EnterAddAccDeviceId(DeviceID);
							}
							
							// Add account page Credit / Debit Payment
							// Gateway,enter Registration Key
							String RegistrationKey = GenericUtils.cellValue(sheet, rownum, 28);
							logger.info(RegistrationKey);
							if(RegistrationKey==null){
								continue;
							}
							else{
								aapo.EnterAddAccRegisKey(RegistrationKey);
							}
							
							// Add account page Check Payment Gateway,enter Site
							// ID
							String SiteID = GenericUtils.cellValue(sheet, rownum, 29);
							logger.info(SiteID);
							if(SiteID==null){
								continue;
							}
							else{	
								aapo.EnterAddAccSiteID(SiteID);
							}
							// Add account page Check Payment Gateway,enter
							// Location ID
							String LocationID = GenericUtils.cellValue(sheet, rownum, 30);
							logger.info(LocationID);
							if(LocationID==null){
								continue;
							}
							else{
								aapo.EnterAddAccLocationID(LocationID);
							}
							
							// Add account page Check Payment Gateway,enter
							// POSProgram ID
							String POSProgramID = GenericUtils.cellValue(sheet, rownum, 31);
							logger.info(POSProgramID);
							if(POSProgramID==null){
								continue;
							}
							else{
								aapo.EnterAddAccPOSProgramID(POSProgramID);
							}
							
							// Add account page Check Payment Gateway,enter Lane
							// ID
							String LaneID = GenericUtils.cellValue(sheet, rownum, 32);
							logger.info(LaneID);
							if(LaneID==null){
								continue;
							}
							else{
								aapo.EnterAddAccTxtLaneID(LaneID);
								TC_16_Add_Account.log(LogStatus.INFO,
									"Account Name : " + AccountName + " || Account Type : " + AddAccAccountType);
							}
							
							// Add account page,Click on assign region button
							String AssignRegionYN=GenericUtils.cellValue(sheet, rownum, 33).toString().toUpperCase();
							boolean ExecuteAssReg=AssignRegionYN.equals("YES");
							logger.info(ExecuteAssReg);
							if(ExecuteAssReg==true){
								aapo.ClickAddAccAssignRegion();
								logger.info("Clicked on Assign Region Button");
							}
				
							// TC_16_Add_Account.log(LogStatus.INFO, "To add
							// account click on assing region button");

							// Switch to the Child Window
							aapo.switchToWindowByIndex(1);

							// Assign region page,enter region code
							String ARRegionCode = GenericUtils.cellValue(sheet, rownum, 34);
							logger.info(ARRegionCode);
							if(ARRegionCode==null){
								continue;
							}
							else{
								aaarpo.EnterAddAccRegionCode(ARRegionCode);
							}
							
							// Add account page,click search region button
							aaarpo.ClickAddAccSearchRegion();

							// Add account page,select assign region check box
							aaarpo.ClickAddAccSelectRegionBox();

							// To get assign region, region name

							// To locate table
							WebElement eleregionname = GlobalVar.Driver
									.findElement(By.xpath(".//*[@id='content_inner']/div[6]/div[1]"));
							// To locate rows of table
							List<WebElement> rowsTable = eleregionname
									.findElements(By.xpath(".//*[@id='grdRegionList']/tbody/tr[3]/td[2]"));
							// To calculate no of rows in table
							int rowscount = rowsTable.size();
							// Loop will execute till the last row of table
							for (int row = 0; row < rowscount; row++) {
								// To locate columns(cells) of that specific row
								List<WebElement> columnsRow = rowsTable.get(row)
										.findElements(By.xpath(".//*[@id='grdRegionList_lblLastName_0']"));
								// To calculate no of columns(cells) in that
								// specific row
								int colscount = columnsRow.size();
								// System.out.println("No of cells in row "
								// +colscount);
								// Loop will execute till the last cell of that
								// specific row
								for (int col = 0; col < colscount; col++) {
									//To retrieve text from specific cell
									String celtext = columnsRow.get(col).getText();
									RegionName = celtext;
									logger.info("Region Name :" + celtext);

								}
							}
							// Add account page,click on assign region button
							aaarpo.ClickAddAccAssignUserRegion();

							//Switch to parent window
							aapo.switchToWindowByIndex(0);

							//Add account page,Click on assign facility button
							String AssignFacilityYN=GenericUtils.cellValue(sheet, rownum, 35).toString().toUpperCase();
							boolean ExecuteAssFac=AssignFacilityYN.equals("YES");
							logger.info(ExecuteAssFac);
							if(ExecuteAssFac==true){
								aapo.ClickAddAccAssignFacility();
								logger.info("Clicked on Assign Facility Button");
							}
																			
							// Switch to the Child Window
							aapo.switchToWindowByIndex(1);
							Thread.sleep(GlobalVar.threadSleep);

							// Switch to the parent Window
							aapo.switchToWindowByIndex(0);

							// Switch to the Child Window
							aapo.switchToWindowByIndex(1);

							// Assign facility page,enter facility name
							/*
							 * String AFFacilityName
							 * =GenericUtils.cellValue(sheet, rownum, 34);
							 * logger.info(AFFacilityName);
							 * aaafpo.EnterAddAccFacilityName(AFFacilityName);
							 */
							// TC_16_Add_Account.log(LogStatus.INFO, "Enter
							// facility name to assign facility");

							// Assign facility page ,enter taxid
							String AFTaxId = GenericUtils.cellValue(sheet, rownum, 36);
							logger.info(AFTaxId);
							if(AFTaxId==null){
								continue;
							}
							else{
								aaafpo.EnterAddAccTaxId(AFTaxId);
							}
							
							// Assign facility page,click on search facility
							// button
							aaafpo.ClickAddAccSearchFaciity();

							// Assign facility page,click facility name check
							// box
							aaafpo.ClickAddAccSctFacilityNameBox();

							// Assign facility, facility name

							// To locate table
							WebElement elefacilityname = GlobalVar.Driver
									.findElement(By.xpath(".//*[@id='content_inner_Lookups']/div[6]/div[1]"));
							// To locate rows of table
							List<WebElement> rowsTable1 = elefacilityname
									.findElements(By.xpath(".//*[@id='grdAccountList']/tbody/tr[3]/td[2]"));
							// To calculate no of rows in table
							int rowscount1 = rowsTable1.size();
							// Loop will execute till the last row of table
							for (int row = 0; row < rowscount1; row++) {
								// To locate columns(cells) of that specific row
								List<WebElement> columnsRow1 = rowsTable1.get(row)
										.findElements(By.xpath(".//*[@id='grdAccountList_lblAccountName_0']"));
								// To calculate no of columns(cells) in that
								// specific row
								int colscount1 = columnsRow1.size();
								// System.out.println("No of cells in row "
								// +colscount);
								// Loop will execute till the last cell of that
								// specific row
								for (int col = 0; col < colscount1; col++) {
									// To retrieve text from specific cell
									String celtext1 = columnsRow1.get(col).getText();
									FacilityName = celtext1;
									logger.info("Facility Name :" + celtext1);

								}
							}

							// Assign facility,click assign facility button check box
							aaafpo.ClickAddAccAssignFacilityChkBox();

							// Switch to parent window
							aapo.switchToWindowByIndex(0);

							// Assign provider page,Click on assign provider
							// button
							String AssignProviderYN=GenericUtils.cellValue(sheet, rownum, 37).toString().toUpperCase();
							boolean ExecuteAssProv=AssignProviderYN.equals("YES");
							logger.info(ExecuteAssProv);
							if(ExecuteAssProv==true){
								aapo.ClickAddAccAssignProvider();
								logger.info("Clicked on Assign Provider Button");
							}
							// TC_16_Add_Account.log(LogStatus.INFO, "To add
							// account click on assing provider button");

							// Switch to the Child Window
							aapo.switchToWindowByIndex(1);
							Thread.sleep(GlobalVar.threadSleep);

							// Switch to the parent Window
							aapo.switchToWindowByIndex(0);

							// Switch to the Child Window
							aapo.switchToWindowByIndex(1);

							// Assign Provider page,enter assign provider npi
							String APNPI = GenericUtils.cellValue(sheet, rownum, 38);
							logger.info(APNPI);
							if(APNPI==null){
								continue;
							}
							else{
								aaappo.EnterAddAccTxtNpi(APNPI);
							}
							
							// Assign provider page,click search provider button
							aaappo.ClickAddAccSearchProvider();

							// Assign provider page,click check box button
							aaappo.ClickAddAccChkBoxToSct();

							// Thread.sleep(GlobalVar.threadSleep);

							// Assign provider,provider last name

							// To locate table
							WebElement eleprlastname = GlobalVar.Driver
									.findElement(By.xpath(".//*[@id='content_inner']"));
							// To locate rows of table
							List<WebElement> rowsTable2 = eleprlastname
									.findElements(By.xpath(".//*[@id='grdProviderListERX']/tbody/tr[3]/td[2]"));
							// To calculate no of rows in table
							int rowscount2 = rowsTable2.size();
							// Loop will execute till the last row of table
							for (int row = 0; row < rowscount2; row++) {
								// To locate columns(cells) of that specific row
								List<WebElement> columnsRow2 = rowsTable2.get(row)
										.findElements(By.xpath(".//*[@id='grdProviderListERX_lblLastNameERX_0']"));
								// To calculate no of columns(cells) in that
								// specific row
								int colscount1 = columnsRow2.size();
								// System.out.println("No of cells in row "
								// +colscount);
								// Loop will execute till the last cell of that
								// specific row
								for (int col = 0; col < colscount1; col++) {
									// To retrieve text from specific cell
									String celtext2 = columnsRow2.get(col).getText();
									ProviderLastName = celtext2;
									logger.info("Provider Last Name :" + celtext2);

								}
							}

							// Thread.sleep(GlobalVar.threadSleep);
							// Assign provider, provider first name

							// To locate table
							WebElement eleprfirstname = GlobalVar.Driver
									.findElement(By.xpath(".//*[@id='content_inner']"));
							// To locate rows of table
							List<WebElement> rowsTable3 = eleprfirstname
									.findElements(By.xpath(".//*[@id='grdProviderListERX']/tbody/tr[3]/td[3]"));
							// To calculate no of rows in table
							int rowscount3 = rowsTable3.size();
							// Loop will execute till the last row of table
							for (int row = 0; row < rowscount3; row++) {
								// To locate columns(cells) of that specific row
								List<WebElement> columnsRow3 = rowsTable3.get(row)
										.findElements(By.xpath(".//*[@id='grdProviderListERX_lblFirstNameERX_0']"));
								// To calculate no of columns(cells) in that
								// specific row
								int colscount3 = columnsRow3.size();
								// System.out.println("No of cells in row "
								// +colscount);
								// Loop will execute till the last cell of that
								// specific row
								for (int col = 0; col < colscount3; col++) {
									// To retrieve text from specific cell
									String celtext3 = columnsRow3.get(col).getText();
									ProviderFirstName = celtext3;
									logger.info("Provider first name :" + celtext3);

								}
							}

							// Assign provider page,click assign provider button
							aaappo.ClickAddAccAssignProviderBtn();

							// Switch to parent window
							aapo.switchToWindowByIndex(0);

							// Assign user page,Click on assign user button
							String AssignUserYN=GenericUtils.cellValue(sheet, rownum, 39).toString().toUpperCase();
							boolean ExecuteAssUser=AssignUserYN.equals("YES");
							logger.info(ExecuteAssUser);
							if(ExecuteAssUser==true){
								aapo.ClickAddAccAssignUser();
								logger.info("Clicked on Assign User Button");
							}
														
							// String regionname;
							// TC_16_Add_Account.log(LogStatus.INFO, "To add
							// account click on assing user button");

							// Switch to the Child Window
							aapo.switchToWindowByIndex(1);
							Thread.sleep(GlobalVar.threadSleep);

							// Switch to the parent Window
							aapo.switchToWindowByIndex(0);

							// Switch to child window
							aapo.switchToWindowByIndex(1);

							// Assign user page,enter user name
							String AUUserName = GenericUtils.cellValue(sheet, rownum, 40);
							logger.info(AUUserName);
							if(AUUserName==null){
								continue;
							}
							else{
								aaaupo.EnterAddAccUserName(AUUserName);
							}
							
							// TC_16_Add_Account.log(LogStatus.INFO," Region
							// Code : " + ARRegionCode + " || Region Name : " +
							// RegionName + " || Facility : " + FacilityName +
							// "||TaxId : "+ AFTaxId + " || NPI : " + APNPI + "
							// || Last Name : " + ProviderLastName + " || First
							// Name : " + ProviderFirstName + " || User : " +
							// AUUserName +"|| Last Name : " + UserLastName + "
							// || First Name : " + UserFirstName );
							// TC_16_Add_Account.log(LogStatus.INFO, "Enter user
							// name to assign user");

							// Assign user page,click on search user button
							aaaupo.ClickAddAccSearchUser();

							// Assign user page,click on user check box
							aaaupo.ClickAddAccUserChkBox();

							// Assign user, user last name

							// To locate table
							WebElement eleuserlastname = GlobalVar.Driver
									.findElement(By.xpath(".//*[@id='gridHolder']/div"));
							// To locate rows of table
							List<WebElement> rowsTable4 = eleuserlastname
									.findElements(By.xpath(".//*[@id='gridCustomUserList']/tbody/tr[3]/td[2]"));
							// To calculate no of rows in table
							int rowscount4 = rowsTable4.size();
							// Loop will execute till the last row of table
							for (int row = 0; row < rowscount4; row++) {
								// To locate columns(cells) of that specific row
								List<WebElement> columnsRow4 = rowsTable4.get(row)
										.findElements(By.xpath(".//*[@id='gridCustomUserList_lblLastName_0']"));
								// To calculate no of columns(cells) in that
								// specific row
								int colscount4 = columnsRow4.size();
								// System.out.println("No of cells in row "
								// +colscount);
								// Loop will execute till the last cell of that
								// specific row
								for (int col = 0; col < colscount4; col++) {
									// To retrieve text from specific cell
									String celtext4 = columnsRow4.get(col).getText();
									UserLastName = celtext4;
									logger.info("User last name :" + celtext4);

								}
							}

							// Assign user, user first name

							// To locate table
							WebElement eleuserfirstname = GlobalVar.Driver
									.findElement(By.xpath(".//*[@id='gridHolder']/div"));
							// To locate rows of table
							List<WebElement> rowsTable5 = eleuserfirstname
									.findElements(By.xpath(".//*[@id='gridCustomUserList']/tbody/tr[3]/td[3]"));
							// To calculate no of rows in table
							int rowscount5 = rowsTable5.size();
							// Loop will execute till the last row of table
							for (int row = 0; row < rowscount5; row++) {
								// To locate columns(cells) of that specific row
								List<WebElement> columnsRow5 = rowsTable5.get(row)
										.findElements(By.xpath(".//*[@id='gridCustomUserList_lblFirstName_0']"));
								// To calculate no of columns(cells) in that
								// specific row
								int colscount5 = columnsRow5.size();
								// System.out.println("No of cells in row "
								// +colscount);
								// Loop will execute till the last cell of that
								// specific row
								for (int col = 0; col < colscount5; col++) {
									// To retrieve text from specific cell
									String celtext5 = columnsRow5.get(col).getText();
									UserFirstName = celtext5;
									logger.info("User first name :" + celtext5);

								}
							}

							// Assign user page,click on assign user button
							aaaupo.ClickAddAccUserAccountSave();
							
							// Switch to parent window
							aapo.switchToWindowByIndex(0);

							// Switch to parent window
							// aapo.switchToWindowByIndex(1);

							Thread.sleep(GlobalVar.threadSleep);

							// Add account page,click on save button
							aapo.ClickAddAccSave();
							logger.info("Save button");
							
							// Enter account name to search
							apo.EnterAccountName(AccountName);

							// Account page,click on search accoutn button
							apo.ClickAccSearchAccount();

							// Account name present or not
							apo.verifyAccountNamePresentorNot();

							// Thread.sleep(GlobalVar.threadSleep);
							apo.ClickBtnAddAccount();

						}
						

					} 
					/*catch(NullPointerException n)
					{
						n.printStackTrace();
						logger.info("Null");
					}*/
					
					
					
					catch (Exception e) {
												
						logger.info("Add Account Exception :" + e.getMessage().toString());
						ScreenShotPath = ReportGenerator.setLog("Add account failed", e.getMessage().toString(),
								"Add account TC_16_Fail");
						String image = TC_16_Add_Account.addScreenCapture(ScreenShotPath);
						TC_16_Add_Account.log(LogStatus.FAIL, image);
						GlobalVar.report.endTest(TC_16_Add_Account);
					}
				

				}

				logger.info("Multi Test Data :" + multitestdata);
				if ((Boolean.FALSE.equals(multitestdata)) && (Boolean.TRUE.equals(Execute))) {
					logger.info("Multi Test Data : " + (Boolean.FALSE.equals(multitestdata)) + " Execute Y/N : "
							+ (Boolean.TRUE.equals(Execute)));
					break;
				}

				/*TC_16_Add_Account.log(LogStatus.INFO,
						" Region Code : " + ARRegionCode + " || Region Name : " + RegionName + " || Facility : "
								+ FacilityName + "||TaxId : " + AFTaxId + " || NPI : " + APNPI + " || Last Name : "
								+ ProviderLastName + " || First Name : " + ProviderFirstName + " ||  User : " + AUUserName
								+ "|| Last Name : " + UserLastName + " || First Name : " + UserFirstName);
				logger.info("Account details have been updated successfully");
				TC_16_Add_Account.log(LogStatus.PASS, "Account details have been updated successfully");
*/


				TC_16_Add_Account.log(LogStatus.INFO,
						" Region Code : " + ARRegionCode + " || Region Name : " + RegionName + " || Facility : "
								+ FacilityName + "||TaxId : " + AFTaxId + " || NPI : " + APNPI + " || Last Name : "
								+ ProviderLastName + " || First Name : " + ProviderFirstName + " ||  User : " + AUUserName
								+ "|| Last Name : " + UserLastName + " || First Name : " + UserFirstName);
				logger.info("Account details have been updated successfully");
				TC_16_Add_Account.log(LogStatus.PASS, "Account details have been updated successfully");

			}
			/*TC_16_Add_Account.log(LogStatus.INFO,
					" Region Code : " + ARRegionCode + " || Region Name : " + RegionName + " || Facility : "
							+ FacilityName + "||TaxId : " + AFTaxId + " || NPI : " + APNPI + " || Last Name : "
							+ ProviderLastName + " || First Name : " + ProviderFirstName + " ||  User : " + AUUserName
							+ "|| Last Name : " + UserLastName + " || First Name : " + UserFirstName);
			logger.info("Account details have been updated successfully");
			TC_16_Add_Account.log(LogStatus.PASS, "Account details have been updated successfully");*/
			GlobalVar.report.endTest(TC_16_Add_Account);

		}

		catch (Exception e) {
			e.printStackTrace();
			ScreenShotPath = ReportGenerator.setLog("Add account failed", e.getMessage().toString(),
					"Add account TC_16_Fail");
			String image = TC_16_Add_Account.addScreencast(ScreenShotPath);
			TC_16_Add_Account.log(LogStatus.FAIL, image);
			GlobalVar.report.endTest(TC_16_Add_Account);
		}
	}
}
