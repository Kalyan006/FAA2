package com.phm.hec.PD.ProviderPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Assert;
import org.testng.Reporter;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import com.phm.hec.utility.GenericUtils;
import com.phm.hec.utility.GlobalVar;

public class AddProviderPageObjects {
	// Provider page Add provider button field.
	@FindBy(id = "ContentPlaceHolder1_btnAddProvider")
	public WebElement BtnAddProvider;

	public void ClickOnAddProvider() {
		BtnAddProvider.click();
	}

	// Provider page select check box to enter organization details
	@FindBy(id = "ContentPlaceHolder1_chkBoxOrganization")
	public WebElement ChkBoxOrganization;

	public void ClickOnOrganizationChkBox() {
		ChkBoxOrganization.click();
	}

	// Add Provider page provider category ddl field.
	// ContentPlaceHolder1_ddlProviderTypeId
	@FindBy(id = "ContentPlaceHolder1_ddlProviderTypeId")
	public WebElement DdlProviderCategory;

	public void SelectProviderCategory(String prcategory) {
		GenericUtils.selectDdlByVisibleText(DdlProviderCategory, prcategory);
	}

	// Add Provider page provider last name text field.
	@FindBy(id = "ContentPlaceHolder1_txtLastName")
	public WebElement TxtLastName;

	public void EnterLastName(String lastname) {
		TxtLastName.sendKeys(lastname);
	}

	// Add Provider page provider middle name text field.
	@FindBy(id = "ContentPlaceHolder1_txtMiddleName")
	public WebElement TxtMiddleName;

	public void EnterMiddleName(String middlename) {
		TxtMiddleName.sendKeys(middlename);
	}

	// Add Provider page provider first name text field.
	@FindBy(id = "ContentPlaceHolder1_txtFirstName")
	public WebElement TxtFirstName;

	public void EnterFirstName(String FirstName) {
		TxtFirstName.sendKeys(FirstName);
	}

	// Add Provider page provider title text field.
	@FindBy(id = "ContentPlaceHolder1_txtTitle")
	public WebElement TxtTitle;

	public void EnterTitle(String title) {
		TxtTitle.sendKeys(title);
	}

	// Add Provider page provider Degree text field.
	@FindBy(id = "ContentPlaceHolder1_txtDegree")
	public WebElement TxtDegree;

	public void EnterDegree(String degree) {
		TxtDegree.sendKeys(degree);
	}

	// Add Provider page provider Suffix text field.
	@FindBy(id = "ContentPlaceHolder1_txtSuffix")
	public WebElement TxtSuffix;

	public void EnterSuffix(String suffix) {
		TxtSuffix.sendKeys(suffix);
	}

	// Add Provider page Provider Identification npi text field.
	@FindBy(id = "ContentPlaceHolder1_txtNPI")
	public WebElement TxtNPI;

	public void EnterNpi(String npi) {
		TxtNPI.sendKeys(npi);
	}

	// Add Provider page Provider Identification TaxId text field.
	@FindBy(id = "ContentPlaceHolder1_txtTaxId")
	public WebElement TxtTaxId;

	public void EnterTaxId(String taxid) {
		TxtTaxId.sendKeys(taxid);
	}

	// Add Provider page Provider Identification State-Assigned ID text field.
	@FindBy(id = "ContentPlaceHolder1_txtUMPI")
	public WebElement TxtStateAssignedID;

	public void EnterStateAssignedId(String assignedid) {
		TxtStateAssignedID.sendKeys(assignedid);
	}

	// Add Provider page Provider Identification Internal ID text field.
	@FindBy(id = "ContentPlaceHolder1_txtInternalId")
	public WebElement TxtInternalId;

	public void EnterinternalId(String internalid) {
		TxtInternalId.sendKeys(internalid);
	}

	// Add Provider page Provider Identification Organization Assigned ID text
	// field.
	@FindBy(id = "ContentPlaceHolder1_txtOrganizationId")
	public WebElement TxtOrganizationAssignedId;

	public void EnterOrganizationAssignedId(String AssignedId) {
		TxtOrganizationAssignedId.sendKeys(AssignedId);
	}

	// Add Provider page Provider Identification State License ID text field.
	@FindBy(id = "ContentPlaceHolder1_txtStateLicense")
	public WebElement TxtStateLicenseId;

	public void EnterStateLicenseId(String StateLicenseId) {
		TxtStateLicenseId.sendKeys(StateLicenseId);
	}

	// Add Provider page Provider Identification SSN text field.
	@FindBy(id = "ContentPlaceHolder1_txtSSN")
	public WebElement TxtSSN;

	public void EnterSSN(String SSN) {
		TxtSSN.sendKeys(SSN);
	}

	// Add Provider page Provider Identification Sub ID/Site ID text field.
	@FindBy(id = "ContentPlaceHolder1_txtSiteId")
	public WebElement TxtSubIdSiteId;

	public void EnterSubIdSiteId(String SubIdSiteId) {
		TxtSubIdSiteId.sendKeys(SubIdSiteId);
	}

	// Add Provider page Provider Identification status ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlProStatus")
	public WebElement DdlProStatus;

	public void SctDdlProStatus(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlProStatus, vtext);
	}

	// Add Provider page Taxonomy & Description Taxonomy Code Set ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlTaxonomyCodeSet")
	public WebElement DdlTaxonomyCodeSet;

	public void SctDdlTaxonomyCodeSet(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlTaxonomyCodeSet, vtext);
	}

	// Add Provider page Taxonomy & Description Taxonomy Code ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlTaxonomyCodeSub")
	public WebElement DdlTaxonomyCode;

	public void SctDdlTaxonomyCode(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlTaxonomyCode, vtext);
	}

	// Add Provider page Taxonomy & Description ProviderType ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlProviderType")
	public WebElement DdlProviderType;

	public void SctDdlProviderType(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlProviderType, vtext);
	}

	// Add Provider page Provider Contact Information last name text field.
	@FindBy(id = "ContentPlaceHolder1_txtContactLastName")
	public WebElement TxtProviderLastName;

	public void EnterProviderLastName(String LastName) {
		TxtProviderLastName.sendKeys(LastName);
	}

	// Add Provider page Provider Contact Information First name text field.
	@FindBy(id = "ContentPlaceHolder1_txtContactFirstName")
	public WebElement TxtProviderFirstName;

	public void EnterProviderFirstName(String FirstName) {
		TxtProviderFirstName.sendKeys(FirstName);
	}

	// Add Provider page Provider Contact Information Email text field.
	@FindBy(id = "ContentPlaceHolder1_txtEmail")
	public WebElement TxtProviderEmail;

	public void EnterProviderEmail(String EmailName) {
		TxtProviderEmail.sendKeys(EmailName);
	}

	// Add Provider page Provider Contact Information Address1 text field.
	@FindBy(id = "ContentPlaceHolder1_txtAddress1")
	public WebElement TxtProviderAddress1;

	public void EnterProviderAddress1(String ProviderAddress1) {
		TxtProviderAddress1.sendKeys(ProviderAddress1);
	}

	// Add Provider page Provider Contact Information Address2 text field.
	@FindBy(id = "ContentPlaceHolder1_txtAddress2")
	public WebElement TxtProviderAddress2;

	public void EnterProviderAddress2(String ProviderAddress2) {
		TxtProviderAddress2.sendKeys(ProviderAddress2);
	}

	// Add Provider page Provider Contact Information City text field.
	@FindBy(id = "ContentPlaceHolder1_txtCity")
	public WebElement TxtProviderCity;

	public void EnterProviderCity(String ProviderCity) {
		TxtProviderCity.sendKeys(ProviderCity);
	}

	// Add Provider page Provider Contact Information State ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlState")
	public WebElement DdlProviderState;

	public void SctDdlProviderState(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlProviderState, vtext);
	}

	// Add Provider page Provider Contact Information zip text field.
	@FindBy(id = "ContentPlaceHolder1_txtZip")
	public WebElement TxtProviderZip;

	public void EnterProviderZip(String ProviderZip) {
		TxtProviderZip.sendKeys(ProviderZip);
	}

	// Add Provider page Provider Contact Information Fax text field.
	@FindBy(id = "ContentPlaceHolder1_txtFax")
	public WebElement TxtProviderFax;

	public void EnterProviderFax(String ProviderFax) {
		TxtProviderFax.sendKeys(ProviderFax);
	}

	// Add Provider page Provider Contact Information Phone text field.
	@FindBy(id = "ContentPlaceHolder1_txtPhone")
	public WebElement TxtProviderPhone;

	public void EnterProviderPhone(String ProviderPhone) {
		TxtProviderPhone.sendKeys(ProviderPhone);
	}

	// Add Provider page Provider Other Information employed ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlEmployed")
	public WebElement DdlProviderEmployed;

	public void SctDdlProviderEmployed(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlProviderEmployed, vtext);
	}

	// Add Provider page Provider Other Information Prefered communication ddl
	// field.
	@FindBy(id = "ContentPlaceHolder1_ddlPreferedcommunication")
	public WebElement DdlPreferedcommunication;

	public void SctDdlcommunication(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlPreferedcommunication, vtext);
	}

	// Add Provider page Provider Other Information Hospital affiliation1 text
	// field.
	@FindBy(id = "ContentPlaceHolder1_txthospaff1")
	public WebElement TxtProviderhospaff1;

	public void EnterProviderhospaff1(String Providerhospaff1) {
		TxtProviderhospaff1.sendKeys(Providerhospaff1);
	}

	// Add Provider page Provider Other Information Hospital affiliation2 text
	// field.
	@FindBy(id = "ContentPlaceHolder1_txthospaff2")
	public WebElement TxtProviderhospaff2;

	public void EnterProviderhospaff2(String Providerhospaff2) {
		TxtProviderhospaff2.sendKeys(Providerhospaff2);
	}

	// Add Provider page Provider Other Information Hospital affiliation3 text
	// field.
	@FindBy(id = "ContentPlaceHolder1_txthospaff3")
	public WebElement TxtProviderhospaff3;

	public void EnterProviderhospaff3(String Providerhospaff3) {
		TxtProviderhospaff3.sendKeys(Providerhospaff3);
	}

	// Add Provider page Provider Other Information Hospital affiliation4 text
	// field.
	@FindBy(id = "ContentPlaceHolder1_txthospaff4")
	public WebElement TxtProviderhospaff4;

	public void EnterProviderhospaff4(String Providerhospaff4) {
		TxtProviderhospaff4.sendKeys(Providerhospaff4);
	}

	// Add Provider page Payment Information Merchant Number text field.
	@FindBy(id = "ContentPlaceHolder1_txtMerchantID")
	public WebElement TxtMerchantId;

	public void EnterMerchantId(String MerchantID) {
		TxtMerchantId.sendKeys(MerchantID);
	}

	// Add Provider page Credit / Debit Payment Gateway Operator/user id text
	// field.
	@FindBy(id = "ContentPlaceHolder1_txtOperatorORUserID")
	public WebElement TxtOperatorOrUserId;

	public void EnterOperatorOrUserId(String OperatorId) {
		TxtOperatorOrUserId.sendKeys(OperatorId);
	}

	// Add Provider page Credit / Debit Payment Gateway Password text field.
	@FindBy(id = "ContentPlaceHolder1_txtPassword")
	public WebElement TxtPaymentPassword;

	public void EnterPaymentPassword(String Password) {
		TxtPaymentPassword.sendKeys(Password);
	}

	// Add Provider page Credit / Debit Payment Gateway DeviceID text field.
	@FindBy(id = "ContentPlaceHolder1_txtDeviceID")
	public WebElement TxtPaymentDeviceID;

	public void EnterPaymentDeviceID(String PaymentDeviceID) {
		TxtPaymentDeviceID.sendKeys(PaymentDeviceID);
	}

	// Add Provider page Credit / Debit Payment Gateway Registration Key text
	// field.
	@FindBy(id = "ContentPlaceHolder1_txtRegistrationKey")
	public WebElement TxtRegistrationKey;

	public void EnterRegistrationKey(String RegisKey) {
		TxtRegistrationKey.sendKeys(RegisKey);
	}

	// Add Provider page Check Payment Gateway, Gateway ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlGateWay")
	public WebElement DdlGateway;

	public void SctDdlGateway(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlGateway, vtext);
	}

	// Add Provider page Check Payment Gateway, Site id text field.
	@FindBy(id = "ContentPlaceHolder1_txtSite")
	public WebElement TxtPaymentSiteId;

	public void EnterPaymentSiteId(String SiteId) {
		TxtPaymentSiteId.sendKeys(SiteId);
	}

	// Add Provider page Check Payment Gateway, Location ID text field.
	@FindBy(id = "ContentPlaceHolder1_txtLocationID")
	public WebElement TxtLocationID;

	public void EnterLocationId(String LocId) {
		TxtLocationID.sendKeys(LocId);
	}

	// Add Provider page Check Payment Gateway, POS program ID text field.
	@FindBy(id = "ContentPlaceHolder1_txtPOSProgramID")
	public WebElement TxtPOSProgramID;

	public void EnterPOSProgramId(String ProgramID) {
		TxtPOSProgramID.sendKeys(ProgramID);
	}

	// Add Provider page Check Payment Gateway, Lane ID text field.
	@FindBy(id = "ContentPlaceHolder1_txtLaneID")
	public WebElement TxtLaneId;

	public void EnterLaneId(String LaneId) {
		TxtLaneId.sendKeys(LaneId);
	}

	// Add Provider page Assign Region button field.
	@FindBy(id = "ContentPlaceHolder1_btnAssignRegion")
	public WebElement BtnAssignRegion;

	public void ClickAssignRegion() {
		BtnAssignRegion.click();
	}

	public void switchToWindowByIndex(int index) {
		int count = 0;
		Set<String> windows = GlobalVar.Driver.getWindowHandles();
		for (String window : windows) {
			GlobalVar.Driver.switchTo().window(window);
			if (count == index) {
				System.out.println("Switched into window :: " + index);
				break;

			}
			count++;
		}
	}

	// Add provider page select assign region then click on delete button
	@FindBy(id = "ContentPlaceHolder1_grdACOList_ButtonDelete_0")
	public WebElement BtnDeleteRegion;

	public void ClickDeleteRegion() {
		BtnDeleteRegion.click();
	}

	public String rowNo(String value) {
		WebElement table = GlobalVar.Driver.findElement(By.id("tableId"));
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		// ArrayList<String> ListOdIds=new ArrayList<>();
		String rowNo = "";
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = tbody.findElement(By.xpath("//table[@id='tableId']/tbody/tr[" + (i + 1) + "]"));
			if (row.getText().trim().contains(value)) {
				rowNo = Integer.toString(i + 1);
				break;
			}

		}

		return rowNo;
	}

	/*
	 * public void GetRegionRowNo(String tablename,String regioncode,int
	 * recordstartrow) { //Grab the table WebElement
	 * table=GlobalVar.Driver.findElement(By.id(tablename)); //Now get all the
	 * tr elements from the table List<WebElement>
	 * allrows=table.findElements(By.tagName(regioncode)); //And iterate over
	 * them,getting the cells for(WebElement row: allrows) { String td = null;
	 * List<WebElement> cells=row.findElements(By.tagName(td)); //Print the
	 * contents of all cell for(WebElement cell:cells) {
	 * System.out.println(cell.getText()); }
	 * 
	 * }
	 */

	// Add Provider page Primary Assign Account button field.
	@FindBy(id = "ContentPlaceHolder1_btnPrimaryAssignAccount")
	public WebElement BtnPrimaryAccount;

	public void ClickPrimaryAccountButton() {
		BtnPrimaryAccount.click();
	}

	// Add Provider page Secondary Assign Account button field.
	@FindBy(id = "ContentPlaceHolder1_btnSecondaryAssignAccount")
	public WebElement BtnSecondaryAccount;

	public void ClickSecondaryAccountButton() {
		BtnSecondaryAccount.click();
	}

	// Add Provider page Assign Primary Facility button field.
	@FindBy(id = "ContentPlaceHolder1_btnAssignFacility")
	public WebElement BtnPrimaryFacility;

	public void ClickPrimaryFacilityButton() {
		BtnPrimaryFacility.click();
	}

	// Add Provider page Assign Secondary Facility button field.
	@FindBy(id = "ContentPlaceHolder1_btnAssignSecFacility")
	public WebElement BtnSecondaryFacility;

	public void ClickSecondaryFacilityButton() {
		BtnSecondaryFacility.click();
	}

	// Add Provider page Assign Committee button field.
	@FindBy(id = "ContentPlaceHolder1_btnAssignCommittee")
	public WebElement BtnAssignCommittee;

	public void ClickAssignCommitteeButton() {
		BtnAssignCommittee.click();
	}

	// Add Provider page AddCallLog button field.
	@FindBy(id = "ContentPlaceHolder1_btnAddCallLog")
	public WebElement BtnAddCallLog;

	public void ClickAddCallLogButton() {
		BtnAddCallLog.click();
	}

	// Add Provider page HealthEC Health Plan Name text field.
	@FindBy(id = "ContentPlaceHolder1_txtNewOrbitPayerName")
	public WebElement TxtHealthPlanName;

	public void EnterHealthPlanName(String HealthPlanName) {
		TxtHealthPlanName.sendKeys(HealthPlanName);
	}

	// Add Provider page HealthEC Health Plan link.
	@FindBy(id = "ContentPlaceHolder1_hlSearchPayerName")
	public WebElement LnkHealthPlan;

	public void ClickHealthPlan() {
		LnkHealthPlan.click();
	}

	// Add Provider page Transaction Type ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlTransactionType")
	public WebElement DdlTransactionType;

	public void SctDdlTransactionType(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlTransactionType, vtext);
	}

	// Add Provider page LegacyID text field.
	@FindBy(id = "ContentPlaceHolder1_txtLegacyID")
	public WebElement TxtLegacyID;

	public void EnterLegacyID(String LegacyID) {
		TxtLegacyID.sendKeys(LegacyID);
	}

	// Add Provider page add button field.
	@FindBy(id = "ContentPlaceHolder1_btnAdd")
	public WebElement BtnAdd;

	public void ClickAddButton() {
		BtnAdd.click();
	}

	// Add Provider page Save Provider button field.
	@FindBy(id = "ContentPlaceHolder1_btnSaveProvider")
	public WebElement BtnSave;

	public void ClickSaveButton() {
		BtnSave.click();
		;
	}

	// Add provider page, after save successfull message display
	@FindBy(id = "ContentPlaceHolder1_lblProviderStatus")
	public WebElement msg;

	public void CheckValidMsg() {
		String text = msg.getText();
		Reporter.log("Display successfull message----" + text, true);
	}

	// Add provider page,count records before
	@FindBy(id = "ContentPlaceHolder1_lblRecordInfo1")
	public WebElement LblRecordBefore;

	public void CountBefore() {
		String text1 = LblRecordBefore.getText();
		Reporter.log("count the number of provider before adding----" + text1, true);
	}

	// Add provider page,count records after
	@FindBy(id = "ContentPlaceHolder1_lblRecordInfo1")
	public WebElement LblRecordAfter;

	public void CountAfter() {
		String text2 = LblRecordAfter.getText();
		Reporter.log("count the number of provider after adding----" + text2, true);
	}

	public void JavaScriptClick(WebElement element) {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using javascript click");
				((JavascriptExecutor) GlobalVar.Driver).executeScript("arguments[0].click;", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Eelement is not attached to the page document" + e.getStackTrace());
		}
	}

	// Add Provider page clear Provider button field.
	@FindBy(id = "ContentPlaceHolder1_btnClearProvider")
	public WebElement BtnClear;

	public void ClickClearButton() {
		BtnClear.click();
	}

	// Add Provider page back Provider button field.
	@FindBy(id = "ContentPlaceHolder1_btnBackProvider")
	public WebElement BtnBack;

	public void ClickBackButton() {
		BtnBack.click();
	}

}