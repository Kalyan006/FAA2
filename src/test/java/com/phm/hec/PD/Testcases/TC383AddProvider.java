package com.phm.hec.PD.Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.phm.hec.PD.AdminPageObjects.ProviderAdminPageObjects;
import com.phm.hec.PD.ProviderPageObjects.AddCallLogPageObjects;
import com.phm.hec.PD.ProviderPageObjects.AddProviderPageObjects;
import com.phm.hec.PD.ProviderPageObjects.AssignCommitteePageObjects;
import com.phm.hec.PD.ProviderPageObjects.AssignPrimaryAccountPageObjects;
import com.phm.hec.PD.ProviderPageObjects.AssignPrimaryFacilityPageObjects;
import com.phm.hec.PD.ProviderPageObjects.AssignRegionPageObjects;
import com.phm.hec.PD.ProviderPageObjects.AssignSecondaryAccountPageObjects;
import com.phm.hec.PD.ProviderPageObjects.AssignSecondaryFacilityPageObjects;
import com.phm.hec.PD.ProviderPageObjects.ProviderPageObjects;
import com.phm.hec.pageObjects.IntermediatePageObjects;
import com.phm.hec.testcases.Login;
import com.phm.hec.utility.GlobalVar;
import com.phm.hec.utility.ReadExcelFile;

public class TC383AddProvider {

	public static Logger addlog = Logger.getLogger(TC383AddProvider.class);

	@SuppressWarnings({ "resource", "deprecation" })
	@Test
	public static void AddProvider() throws Throwable {

		if (GlobalVar.loggedin == false) {
			ReadExcelFile readExcelFile = new ReadExcelFile();
			try {
				readExcelFile.getUsernamePassword(GlobalVar.TestDataFilePath, GlobalVar.UserDetailsTestData,
						GlobalVar.SheetName, GlobalVar.Client, GlobalVar.Modules);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Login.login1(GlobalVar.LoginUsername, GlobalVar.LoginPassword);
		}
		GlobalVar.report.startTest("TC383 - AddProvider", "Validate the user able to add the Provider");

		Logger logger = addlog;
		logger.info("TC_-383:Validate the user able to add provider");
		// System.out.println("TC383");

		// Intermediate page object
		IntermediatePageObjects INM = PageFactory.initElements(GlobalVar.Driver, IntermediatePageObjects.class);
		// Provider page object
		ProviderPageObjects ppo = PageFactory.initElements(GlobalVar.Driver, ProviderPageObjects.class);
		// Add provider page object
		AddProviderPageObjects appo = PageFactory.initElements(GlobalVar.Driver, AddProviderPageObjects.class);
		// Assign region page object
		AssignRegionPageObjects arpo = PageFactory.initElements(GlobalVar.Driver, AssignRegionPageObjects.class);
		// Assign primary account page object
		AssignPrimaryAccountPageObjects apapo = PageFactory.initElements(GlobalVar.Driver,
				AssignPrimaryAccountPageObjects.class);
		// Assign secondary account page object
		AssignSecondaryAccountPageObjects asapo = PageFactory.initElements(GlobalVar.Driver,
				AssignSecondaryAccountPageObjects.class);
		// Assign primary facility page object
		AssignPrimaryFacilityPageObjects apfpo = PageFactory.initElements(GlobalVar.Driver,
				AssignPrimaryFacilityPageObjects.class);
		// Assign secondary facility page object
		AssignSecondaryFacilityPageObjects asfpo = PageFactory.initElements(GlobalVar.Driver,
				AssignSecondaryFacilityPageObjects.class);
		// Assign committee page object
		AssignCommitteePageObjects acpo = PageFactory.initElements(GlobalVar.Driver, AssignCommitteePageObjects.class);
		// Add call log page object
		AddCallLogPageObjects aclpo = PageFactory.initElements(GlobalVar.Driver, AddCallLogPageObjects.class);

		// Provider Admin page objects
		ProviderAdminPageObjects PAP = PageFactory.initElements(GlobalVar.Driver, ProviderAdminPageObjects.class);
		// Click on the Intermediate Page --> Provider Admin

		Thread.sleep(GlobalVar.threadSleep);
		/*
		 * WebDriverWait wait=new WebDriverWait(GlobalVar.Driver, 10);
		 * wait.until(ExpectedConditions.elementToBeClickable(By.id(
		 * "divproviderAdmin")));
		 */

		// Click provider admin
		INM.ClickProviderAdmin();
		logger.info("Clicked on Provider Admin in Intermediate Page");

		// Click on the Provider link in the left Menu Pane
		PAP.ClickLnkProvider();
		logger.info("Clicked on Provider Link in Account Page");

		// Add provider page before count records
		// appo.CountBefore();

		// Click on the Add Provider Button
		ppo.ClickAddProvider();
		logger.info("Clicked on Add Provider button in Provider Page");

		String filepath = GlobalVar.TestDataAddProviderTC383FilePath;
		logger.info("File Path : " + filepath);
		// Data Driver starting
		int rows;
		File AddProvidersrc = new File(filepath);
		FileInputStream fis = new FileInputStream(AddProvidersrc);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("PD_AddProvider");
		rows = sheet.getLastRowNum() + 1;
		int cols = sheet.getRow(1).getLastCellNum();
		logger.info("Rows :" + rows + "|| Columns : " + cols);
		for (int rownum = 1; rownum < rows; rownum++) {

			/*
			 * for (int columnnum=0;columnnum < cols; columnnum++){ }
			 */
			// 69 Execute Yes/No
			sheet.getRow(rownum).getCell(cols - 1).setCellType(Cell.CELL_TYPE_STRING);
			String executeyn = sheet.getRow(rownum).getCell(cols - 1).getStringCellValue();
			String ExecuteYN = executeyn.toUpperCase().trim();
			logger.info("Execute the Row " + rownum + " = " + ExecuteYN);
			Boolean Execute = ExecuteYN.equals("YES");
			logger.info(Execute);
			if (Execute == true) {

				sheet.getRow(rownum).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				String ChkboxOrg = sheet.getRow(rownum).getCell(0).getStringCellValue();
				String OrgChkBox = ChkboxOrg.toUpperCase().trim();
				logger.info("Org Checkbox value : " + ChkboxOrg);
				Boolean ORGCHK = OrgChkBox.equals("YES");
				logger.info(ORGCHK);
				if (ORGCHK == true) {
					appo.ClickOnOrganizationChkBox();
				}
				// Select Provider Category
				sheet.getRow(rownum).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				String ProviderCat = sheet.getRow(rownum).getCell(1).getStringCellValue();
				appo.SelectProviderCategory(ProviderCat);

				// appo.EnterLastName("");
				sheet.getRow(rownum).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				String LastName = sheet.getRow(rownum).getCell(2).getStringCellValue();
				appo.EnterLastName(LastName);

				// Enter Provider middle Name
				sheet.getRow(rownum).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				String MiddleName = sheet.getRow(rownum).getCell(3).getStringCellValue();
				appo.EnterMiddleName(MiddleName);

				// Enter Provider first name
				sheet.getRow(rownum).getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				String FirstName = sheet.getRow(rownum).getCell(4).getStringCellValue();
				appo.EnterFirstName(FirstName);

				// Enter Provider Title
				sheet.getRow(rownum).getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				String PRTitle = sheet.getRow(rownum).getCell(5).getStringCellValue();
				appo.EnterTitle(PRTitle);

				// Enter Provider Degree
				sheet.getRow(rownum).getCell(6).setCellType(Cell.CELL_TYPE_STRING);
				String PRDegree = sheet.getRow(rownum).getCell(6).getStringCellValue();
				appo.EnterDegree(PRDegree);

				// Enter Provider Name Suffix
				sheet.getRow(rownum).getCell(7).setCellType(Cell.CELL_TYPE_STRING);
				String PRSufix = sheet.getRow(rownum).getCell(7).getStringCellValue();
				appo.EnterSuffix(PRSufix);

				// Enter Provider Identification NPI
				sheet.getRow(rownum).getCell(8).setCellType(Cell.CELL_TYPE_STRING);
				String PRNPI = sheet.getRow(rownum).getCell(8).getStringCellValue();
				appo.EnterNpi(PRNPI);

				// Enter Provider Identification Tax ID
				sheet.getRow(rownum).getCell(9).setCellType(Cell.CELL_TYPE_STRING);
				String PRTAXID = sheet.getRow(rownum).getCell(9).getStringCellValue();
				appo.EnterTaxId(PRTAXID);

				// Enter Provider Identification State-Assigned ID
				sheet.getRow(rownum).getCell(10).setCellType(Cell.CELL_TYPE_STRING);
				String PRStateAssignedID = sheet.getRow(rownum).getCell(10).getStringCellValue();
				appo.EnterStateAssignedId(PRStateAssignedID);

				// Enter Provider Identification Internal ID
				sheet.getRow(rownum).getCell(11).setCellType(Cell.CELL_TYPE_STRING);
				String PRINTERNALID = sheet.getRow(rownum).getCell(11).getStringCellValue();
				appo.EnterinternalId(PRINTERNALID);

				// Enter Provider Identification Organisation Assigned ID
				sheet.getRow(rownum).getCell(12).setCellType(Cell.CELL_TYPE_STRING);
				String PROrganizationAssignedID = sheet.getRow(rownum).getCell(12).getStringCellValue();
				appo.EnterOrganizationAssignedId(PROrganizationAssignedID);

				// Enter Provider Identification State License ID
				sheet.getRow(rownum).getCell(13).setCellType(Cell.CELL_TYPE_STRING);
				String PRStateLicenseID = sheet.getRow(rownum).getCell(13).getStringCellValue();
				appo.EnterStateLicenseId(PRStateLicenseID);

				// Enter Provider Identification SSN
				sheet.getRow(rownum).getCell(14).setCellType(Cell.CELL_TYPE_STRING);
				String PRSSN = sheet.getRow(rownum).getCell(14).getStringCellValue();
				appo.EnterSSN(PRSSN);

				// Enter Provider Identification Sub ID/Site ID
				sheet.getRow(rownum).getCell(15).setCellType(Cell.CELL_TYPE_STRING);
				String PRSubIDSiteID = sheet.getRow(rownum).getCell(15).getStringCellValue();
				appo.EnterSubIdSiteId(PRSubIDSiteID);

				// Select Provider Identification Status/DdlProStatus
				sheet.getRow(rownum).getCell(16).setCellType(Cell.CELL_TYPE_STRING);
				String PRStatus = sheet.getRow(rownum).getCell(16).getStringCellValue();
				appo.SctDdlProStatus(PRStatus);

				// Enter Taxonomy & Description Taxonomy Code Set
				sheet.getRow(rownum).getCell(17).setCellType(Cell.CELL_TYPE_STRING);
				String PRTaxonomyCodeSet = sheet.getRow(rownum).getCell(17).getStringCellValue();
				appo.SctDdlTaxonomyCodeSet(PRTaxonomyCodeSet);

				// Enter Taxonomy & Description Taxonomy Code
				sheet.getRow(rownum).getCell(18).setCellType(Cell.CELL_TYPE_STRING);
				String PRTaxonomyCode = sheet.getRow(rownum).getCell(18).getStringCellValue();
				appo.SctDdlTaxonomyCode(PRTaxonomyCode);

				// Enter Taxonomy & Description Provider Type
				sheet.getRow(rownum).getCell(19).setCellType(Cell.CELL_TYPE_STRING);
				String PRProviderType = sheet.getRow(rownum).getCell(19).getStringCellValue();
				appo.SctDdlProviderType(PRProviderType);

				// Enter Provider Contact Information Last Name
				sheet.getRow(rownum).getCell(20).setCellType(Cell.CELL_TYPE_STRING);
				String PCILastName = sheet.getRow(rownum).getCell(20).getStringCellValue();
				appo.EnterProviderLastName(PCILastName);

				// Enter Provider Contact Information First Name
				sheet.getRow(rownum).getCell(21).setCellType(Cell.CELL_TYPE_STRING);
				String PCIFirstName = sheet.getRow(rownum).getCell(21).getStringCellValue();
				appo.EnterProviderFirstName(PCIFirstName);

				// Enter Provider Contact Information Email
				sheet.getRow(rownum).getCell(22).setCellType(Cell.CELL_TYPE_STRING);
				String PCIEmail = sheet.getRow(rownum).getCell(22).getStringCellValue();
				appo.EnterProviderEmail(PCIEmail);

				// Enter Provider Contact Information Address 1
				sheet.getRow(rownum).getCell(23).setCellType(Cell.CELL_TYPE_STRING);
				String PCIAddress1 = sheet.getRow(rownum).getCell(23).getStringCellValue();
				appo.EnterProviderAddress1(PCIAddress1);

				// Enter Provider Contact Information Address 2
				sheet.getRow(rownum).getCell(24).setCellType(Cell.CELL_TYPE_STRING);
				String PCIAddress2 = sheet.getRow(rownum).getCell(23).getStringCellValue();
				appo.EnterProviderAddress2(PCIAddress2);

				// Enter Provider Contact Information City
				sheet.getRow(rownum).getCell(25).setCellType(Cell.CELL_TYPE_STRING);
				String PCICity = sheet.getRow(rownum).getCell(25).getStringCellValue();
				appo.EnterProviderCity(PCICity);

				// Enter Provider Contact Information State
				sheet.getRow(rownum).getCell(26).setCellType(Cell.CELL_TYPE_STRING);
				String PCIState = sheet.getRow(rownum).getCell(26).getStringCellValue();
				appo.SctDdlProviderState(PCIState);

				// Enter Provider Contact Information Zip
				sheet.getRow(rownum).getCell(27).setCellType(Cell.CELL_TYPE_STRING);
				String PCIZip = sheet.getRow(rownum).getCell(27).getStringCellValue();
				appo.EnterProviderZip(PCIZip);

				// Enter Provider Contact Information Fax
				sheet.getRow(rownum).getCell(28).setCellType(Cell.CELL_TYPE_STRING);
				String PCIFAX = sheet.getRow(rownum).getCell(28).getStringCellValue();
				appo.EnterProviderFax(PCIFAX);

				// Enter Provider Contact Information Phone
				sheet.getRow(rownum).getCell(29).setCellType(Cell.CELL_TYPE_STRING);
				String PCIPHONE = sheet.getRow(rownum).getCell(29).getStringCellValue();
				appo.EnterProviderPhone(PCIPHONE);

				// Enter Provider Other Information Employed
				sheet.getRow(rownum).getCell(30).setCellType(Cell.CELL_TYPE_STRING);
				String POIEmployed = sheet.getRow(rownum).getCell(30).getStringCellValue();
				appo.SctDdlProviderEmployed(POIEmployed);

				// Enter Provider Other Information Preferred communication
				sheet.getRow(rownum).getCell(31).setCellType(Cell.CELL_TYPE_STRING);
				String POIPreferredcommunication = sheet.getRow(rownum).getCell(31).getStringCellValue();
				appo.SctDdlcommunication(POIPreferredcommunication);

				// Enter Provider Other Information Hospital affiliation1
				sheet.getRow(rownum).getCell(32).setCellType(Cell.CELL_TYPE_STRING);
				String POIHospitalAffiliation1 = sheet.getRow(rownum).getCell(32).getStringCellValue();
				appo.EnterProviderhospaff1(POIHospitalAffiliation1);

				// Enter Provider Other Information Hospital affiliation2
				sheet.getRow(rownum).getCell(33).setCellType(Cell.CELL_TYPE_STRING);
				String POIHospitalAffiliation2 = sheet.getRow(rownum).getCell(33).getStringCellValue();
				appo.EnterProviderhospaff2(POIHospitalAffiliation2);

				// Enter Provider Other Information Hospital affiliation3
				sheet.getRow(rownum).getCell(34).setCellType(Cell.CELL_TYPE_STRING);
				String POIHospitalAffiliation3 = sheet.getRow(rownum).getCell(34).getStringCellValue();
				appo.EnterProviderhospaff3(POIHospitalAffiliation3);

				// Enter Provider Other Information Hospital affiliation4
				sheet.getRow(rownum).getCell(35).setCellType(Cell.CELL_TYPE_STRING);
				String POIHospitalAffiliation4 = sheet.getRow(rownum).getCell(35).getStringCellValue();
				appo.EnterProviderhospaff4(POIHospitalAffiliation4);

				// Credit / Debit Payment Gateway Merchant ID
				sheet.getRow(rownum).getCell(36).setCellType(Cell.CELL_TYPE_STRING);
				String CDPMerchantID = sheet.getRow(rownum).getCell(36).getStringCellValue();
				appo.EnterMerchantId(CDPMerchantID);

				// Credit / Debit Payment Gateway Operation User ID
				sheet.getRow(rownum).getCell(37).setCellType(Cell.CELL_TYPE_STRING);
				String CDPOperatorUserID = sheet.getRow(rownum).getCell(37).getStringCellValue();
				appo.EnterOperatorOrUserId(CDPOperatorUserID);

				// Credit / Debit Payment Gateway Password
				sheet.getRow(rownum).getCell(38).setCellType(Cell.CELL_TYPE_STRING);
				String CDPPassword = sheet.getRow(rownum).getCell(38).getStringCellValue();
				appo.EnterPaymentPassword(CDPPassword);

				// Credit / Debit Payment Gateway Device ID
				sheet.getRow(rownum).getCell(39).setCellType(Cell.CELL_TYPE_STRING);
				String CDPDeviceID = sheet.getRow(rownum).getCell(39).getStringCellValue();
				appo.EnterPaymentDeviceID(CDPDeviceID);

				// Credit / Debit Payment Gateway Registration Key
				sheet.getRow(rownum).getCell(40).setCellType(Cell.CELL_TYPE_STRING);
				String CDPRegistrationKey = sheet.getRow(rownum).getCell(40).getStringCellValue();
				appo.EnterRegistrationKey(CDPRegistrationKey);

				// Check Payment Gateway - Gateway
				sheet.getRow(rownum).getCell(41).setCellType(Cell.CELL_TYPE_STRING);
				String CPGGateway = sheet.getRow(rownum).getCell(41).getStringCellValue();
				appo.SctDdlGateway(CPGGateway);

				// Check Payment Gateway - Site ID
				sheet.getRow(rownum).getCell(42).setCellType(Cell.CELL_TYPE_STRING);
				String CPGSiteID = sheet.getRow(rownum).getCell(42).getStringCellValue();
				appo.EnterMerchantId(CPGSiteID);

				// Check Payment Gateway - Location ID
				sheet.getRow(rownum).getCell(43).setCellType(Cell.CELL_TYPE_STRING);
				String CPGLocationID = sheet.getRow(rownum).getCell(43).getStringCellValue();
				appo.EnterOperatorOrUserId(CPGLocationID);

				// Check Payment Gateway - POS Program ID
				sheet.getRow(rownum).getCell(44).setCellType(Cell.CELL_TYPE_STRING);
				String CPGPOSProgramID = sheet.getRow(rownum).getCell(44).getStringCellValue();
				appo.EnterPaymentPassword(CPGPOSProgramID);

				// Check Payment Gateway - Lane ID
				sheet.getRow(rownum).getCell(45).setCellType(Cell.CELL_TYPE_STRING);
				String CPGLaneID = sheet.getRow(rownum).getCell(45).getStringCellValue();
				appo.EnterPaymentDeviceID(CPGLaneID);

				// Click on assign region button
				arpo.ClickAssignRegion();

				logger.info("Clicked on Assign Region Button");

				// Switch to the Child Window
				appo.switchToWindowByIndex(1);

				// Enter Region code to search
				sheet.getRow(rownum).getCell(46).setCellType(Cell.CELL_TYPE_STRING);
				String ARRegionCode = sheet.getRow(rownum).getCell(46).getStringCellValue();
				arpo.EnterRegionCode(ARRegionCode);

				// Click on the Search Region Button
				arpo.ClickSearchRegion();

				// Click select region box
				arpo.ClickSelectRegionBox();

				// select region start date
				// arpo.ClickOnFromDateCalendar();
				// GlobalVar.Driver.findElement(By.id("grdAccountList_imgDtFrom_0")).click();
				arpo.ClickOnFromDateCalendar();

				// Select the From date
				GlobalVar.Driver.findElement(By.xpath("//td[text()='11']")).click();

				// select region termed date
				arpo.ClickOnTermDateCalendar();

				// GlobalVar.Driver.findElement(By.id("grdAccountList_imgDtTo_0")).click();

				GlobalVar.Driver.findElement(By.xpath("//td[text()='11']")).click();

				// select region status
				arpo.SctRegionstatus("");

				// Click on singed contract
				arpo.SctSignedContract("");

				// click assign region button
				arpo.ClickAssignUserRegion();

				// Switch to parent window
				appo.switchToWindowByIndex(0);

				// Delete assign region(Plz don't delete)
				// appo.ClickDeleteRegion();

				// Click on assign primary account button
				apapo.ClickPrimaryAssignAccount();

				logger.info("Clicked on Primary Assign Account Button");

				// Switch to child window
				appo.switchToWindowByIndex(1);

				// Enter accont name
				sheet.getRow(rownum).getCell(47).setCellType(Cell.CELL_TYPE_STRING);
				String APAAccountName = sheet.getRow(rownum).getCell(47).getStringCellValue();
				apapo.EnterPryAccountName(APAAccountName);

				// Enter text id(Plz don't delete)
				/*
				 * sheet.getRow(rownum).getCell(48).setCellType(Cell.
				 * CELL_TYPE_STRING); String APATaxID =
				 * sheet.getRow(rownum).getCell(48).getStringCellValue();
				 * apapo.EnterPryTaxId(APATaxID);
				 */

				// apapo.EnterTaxId("");

				// Click on search user region
				apapo.ClickSearchUserRegion();

				// Click on link
				apapo.ClickAccountName();

				// Switch to parent window
				appo.switchToWindowByIndex(0);

				// Click on Assign Secondary Account
				appo.ClickSecondaryAccountButton();

				logger.info("Clicked on Secondary Assign Account Button");

				// Switch to child window
				appo.switchToWindowByIndex(1);

				// Enter secondary accont name
				sheet.getRow(rownum).getCell(50).setCellType(Cell.CELL_TYPE_STRING);
				String ASAAccountName = sheet.getRow(rownum).getCell(50).getStringCellValue();
				asapo.EnterSecondaryAccountName(ASAAccountName);

				// Enter secondary tax id(Plz don't delete)
				/*
				 * sheet.getRow(rownum).getCell(51).setCellType(Cell.
				 * CELL_TYPE_STRING); String ASATaxID =
				 * sheet.getRow(rownum).getCell(51).getStringCellValue();
				 * asapo.EnterSecondaryTaxId(ASATaxID);
				 */

				// Click on secondary search account button
				asapo.ClickSeconSearchUser();

				// Select one secondary account name
				asapo.ClickSeconAccountName();

				// Click on secondary assign account
				asapo.ClickSeconAssignAccount();

				// Switch to parent window
				appo.switchToWindowByIndex(0);

				// Click on Assign Primary Facility
				appo.ClickPrimaryFacilityButton();

				logger.info("Clicked on Primary facility Button");

				// Switch to parent window
				// appo.switchToWindowByIndex(0);

				// Switch to child window
				appo.switchToWindowByIndex(1);
				Thread.sleep(GlobalVar.threadSleep);

				// Switch to parent window
				appo.switchToWindowByIndex(0);

				// Switch to child window
				appo.switchToWindowByIndex(1);
				// Enter primary facility name
				sheet.getRow(rownum).getCell(53).setCellType(Cell.CELL_TYPE_STRING);
				String APFFacilityName = sheet.getRow(rownum).getCell(53).getStringCellValue();
				apfpo.EnterPryFacilityName(APFFacilityName);

				// Enter Primary facility tax id(Plz don't delete)
				/*
				 * sheet.getRow(rownum).getCell(54).setCellType(Cell.
				 * CELL_TYPE_STRING); String APFTaxID =
				 * sheet.getRow(rownum).getCell(54).getStringCellValue();
				 * apfpo.EnterPryFacilityTaxId(APFTaxID);
				 */

				// Click search facility
				apfpo.ClickPrySearchFacility();

				// Click link facility name
				apfpo.ClickPryFacilityName();

				// Switch to parent window
				appo.switchToWindowByIndex(0);

				// Click on Secondary Facility button
				appo.ClickSecondaryFacilityButton();

				logger.info("Clicked on Secondary facility Button");

				// Switch to child window
				appo.switchToWindowByIndex(1);

				// Enter secondary facility name
				sheet.getRow(rownum).getCell(56).setCellType(Cell.CELL_TYPE_STRING);
				String ASFFacilityName = sheet.getRow(rownum).getCell(56).getStringCellValue();
				asfpo.EnterSecFacilityName(ASFFacilityName);

				// Enter secondary facility tax id(Plz don't delete)
				/*
				 * sheet.getRow(rownum).getCell(57).setCellType(Cell.
				 * CELL_TYPE_STRING); String ASFTaxID =
				 * sheet.getRow(rownum).getCell(57).getStringCellValue();
				 * asfpo.EnterSecFacilityTaxId(ASFTaxID);
				 */

				// Click on search facility button
				asfpo.ClickSecSearchFacility();

				// Click on secondary facility link faicility name
				asfpo.ClickSecLnkFacilityName();

				// Switch to parent window
				appo.switchToWindowByIndex(0);

				// Click on Assign Committee
				appo.ClickAssignCommitteeButton();

				logger.info("Clicked on assign committee Button");

				// Switch to child window
				appo.switchToWindowByIndex(1);

				// Enter committee name
				sheet.getRow(rownum).getCell(59).setCellType(Cell.CELL_TYPE_STRING);
				String ACCommitteeName = sheet.getRow(rownum).getCell(59).getStringCellValue();
				acpo.EnterCommitteeName(ACCommitteeName);

				// Click on search committee button
				acpo.ClickSearchComm();

				// Click select check box committee name
				acpo.ClickLnkComm();

				// Click assign committee
				acpo.ClickAssignCommittee();

				// Switch to parent window
				appo.switchToWindowByIndex(0);

				// Click on add call log button
				appo.ClickAddCallLogButton();

				logger.info("Clicked on Add call log Button");

				// Switch to child window
				appo.switchToWindowByIndex(1);
				Thread.sleep(GlobalVar.threadSleep);

				appo.switchToWindowByIndex(0);

				appo.switchToWindowByIndex(1);
				// Add call log page,select Call log tracker reason type
				sheet.getRow(rownum).getCell(61).setCellType(Cell.CELL_TYPE_STRING);
				String ACLReasonType = sheet.getRow(rownum).getCell(61).getStringCellValue();
				aclpo.SctReasonType(ACLReasonType);

				// Add call log page,contact mode
				sheet.getRow(rownum).getCell(63).setCellType(Cell.CELL_TYPE_STRING);
				String ACLContactMode = sheet.getRow(rownum).getCell(63).getStringCellValue();
				aclpo.SctContactMode(ACLContactMode);

				// Enter communication date
				aclpo.ClickCommDate();

				GlobalVar.Driver.findElement(By.xpath("//td[text()='17']")).click();

				// Enter created date
				aclpo.ClickCreatedDate();
				GlobalVar.Driver.findElement(By.xpath("//td[text()='17']")).click();

				// Enter call log tracker note
				sheet.getRow(rownum).getCell(63).setCellType(Cell.CELL_TYPE_STRING);
				String ACLNotes = sheet.getRow(rownum).getCell(63).getStringCellValue();
				aclpo.EnterNotes(ACLNotes);

				// Add call log page, select contact type
				sheet.getRow(rownum).getCell(64).setCellType(Cell.CELL_TYPE_STRING);
				String ACLContactType = sheet.getRow(rownum).getCell(64).getStringCellValue();
				aclpo.SctContactType(ACLContactType);

				// Call log tracker click check box
				aclpo.ClickFollowUp();

				// Enter follow up date
				aclpo.ClickFollowupdate();
				GlobalVar.Driver.findElement(By.xpath("//td[text()='17']")).click();

				// Enter follow up note
				sheet.getRow(rownum).getCell(66).setCellType(Cell.CELL_TYPE_STRING);
				String ACLFollowUpNotes = sheet.getRow(rownum).getCell(66).getStringCellValue();
				aclpo.EnterFollowupNotes(ACLFollowUpNotes);

				// Call log tracker,click on submit button
				aclpo.ClickCallLogSubmit();

				// Switch to parent window
				appo.switchToWindowByIndex(0);

				// Enter healthec health plan(Plz don't delete)
				/*
				 * sheet.getRow(rownum).getCell(67).setCellType(Cell.
				 * CELL_TYPE_STRING); String PRHealthECHealthPlanName =
				 * sheet.getRow(rownum).getCell(67).getStringCellValue();
				 * appo.EnterHealthPlanName(PRHealthECHealthPlanName);
				 */

				// Select healthec health plan
				// appo.ClickHealthPlan();

				// click on transaction type(Plz don't delete)
				/*
				 * sheet.getRow(rownum).getCell(68).setCellType(Cell.
				 * CELL_TYPE_STRING); String PRTransactionType =
				 * sheet.getRow(rownum).getCell(68).getStringCellValue();
				 * appo.SctDdlTransactionType(PRTransactionType);
				 */

				// Enter lagacy id(Plz don't delete)
				/*
				 * sheet.getRow(rownum).getCell(69).setCellType(Cell.
				 * CELL_TYPE_STRING); String PRLegacyID =
				 * sheet.getRow(rownum).getCell(69).getStringCellValue();
				 * appo.EnterLegacyID(PRLegacyID);
				 */

				// Click on add button
				// appo.ClickAddButton();

				// Click on save provider
				appo.ClickSaveButton();

				// logger.info("Records 1 to 10 of 1897");

				// Add provider page successfully message
				appo.CheckValidMsg();

				// logger.info("Provider has been created successfully.");

				// Add provider page after count records
				appo.CountAfter();

				// logger.info("Records 1 to 10 of 1898");

				// Click clear button
				// appo.ClickClearButton();
			}
		}
	}
}
