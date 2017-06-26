package com.phm.hec.PD.AccountPageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.html.Option;
import com.phm.hec.utility.GenericUtils;
import com.phm.hec.utility.GlobalVar;

public class AddAccountPageObjects {
	// Add account page account information,enter account name
	@FindBy(id = "ContentPlaceHolder1_txtAccountName")
	public WebElement TxtAccountName;

	public void EnterAddAccAccountName(String AccountName) {
		TxtAccountName.sendKeys(AccountName);
	}
	
	//Add account page to verify account name is present of not
	@FindBy(id = "ContentPlaceHolder1_RqdAccountName")
	public WebElement accountnamerequired;

	public Boolean VerifyAddAccountNamePresentorNot() {
		WebDriverWait wait = new WebDriverWait(GlobalVar.Driver, 5);
		try {
			wait.until(ExpectedConditions.visibilityOf(accountnamerequired));
			Reporter.log("Account name exist... ", true);
			return true;
		} catch (Exception e) {
			Reporter.log("Account name not exist... ", true);
			return false;

		}
	}	

	// Add account page account information account type
	@FindBy(id = "ContentPlaceHolder1_ddlAccountType")
	public WebElement DdlAccountType;

	public void SctAddAccAccountType(String vtext) {
		Select sct = new Select(DdlAccountType);
		List<WebElement> listofoptions = sct.getOptions();
		for (WebElement option : listofoptions) {
			String AddAccAccountType = option.getText().trim();
			if (AddAccAccountType.contains(vtext)) {
				sct.selectByVisibleText(vtext);
				break;
			}
		}

		// GenericUtils.selectDdlByVisibleText(DdlAccountType, vtext);

	}

	// Add account page account information account category
	@FindBy(id = "ContentPlaceHolder1_ddlAccountTypeId")
	public WebElement DdlAccountCategory;

	public void SctAddAccAccountCategory(String vtext) {
		Select sct = new Select(DdlAccountCategory);
		List<WebElement> listofoptions = sct.getOptions();
		for (WebElement option : listofoptions) {
			String AddAccAccountCategory = option.getText().trim();
			if (AddAccAccountCategory.contains(vtext)) {
				sct.selectByVisibleText(vtext);
				break;
			}
		}
		// GenericUtils.selectDdlByVisibleText(DdlAccountCategory, vtext);

	}

	// Add account page identifier information text field ssn.
	@FindBy(id = "ContentPlaceHolder1_txtSSN")
	public WebElement TxtSsn;

	public void EnterAddAccSsn(String ssn) {
		TxtSsn.sendKeys(ssn);
		
	}

	// Add account page identifier information text field groupnpi.
	@FindBy(id = "ContentPlaceHolder1_txtGroupNPI")
	public WebElement TxtNpi;

	public void EnterAddAccNpi(String npi) {
		TxtNpi.sendKeys(npi);
	}

	// Add account page identifier information text field txtid.
	@FindBy(id = "ContentPlaceHolder1_txtTaxID")
	public WebElement TxtTaxId;

	public void EnterAddAccTaxId(String taxid) {
		TxtTaxId.sendKeys(taxid);
	}

	// Add account page identifier information state ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlIIState")
	public WebElement DdlIIState;

	public void SctAddAccDdlState(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlIIState, vtext);
	}

	// Add account page identifier information text field state assigned id.
	@FindBy(id = "ContentPlaceHolder1_txtStateLicense")
	public WebElement TxtStateAssignedId;

	public void EnterAddAccStateAssignedId(String AssignedId) {
		TxtStateAssignedId.sendKeys(AssignedId);
	}

	// Add account page identifier information text field upin.
	@FindBy(id = "ContentPlaceHolder1_txtUPIN")
	public WebElement TxtUpin;

	public void EnterAddAccUpin(String Upin) {
		TxtUpin.sendKeys(Upin);
	}

	// Add account page Taxonomy & Description taxonomy code set ddl.
	@FindBy(id = "ContentPlaceHolder1_ddlTaxCodeSet")
	public WebElement DdltaxonomyCodeSet;

	public void SctAddAccTaxonomyCodeSet(String vtext) throws InterruptedException {
		Select sct = new Select(DdltaxonomyCodeSet);
		List<WebElement> listofoptions = sct.getOptions();
		for (WebElement option : listofoptions) {
			String TaxonomyCodeSet = option.getText();
			String filename = vtext;
			String subString = null;
			int iend = filename.indexOf("-");
			if (iend != -1)
				subString = filename.substring(0, iend);
			String truncated = subString.replaceAll("[^\\p{Print}]", "");
			String str = truncated.trim();
			if (TaxonomyCodeSet.contains(str)) {
				sct.selectByValue(str);
				break;
			}
		}

	}

	// Add account page Taxonomy & Description taxonomy code ddl.
	@FindBy(id = "ContentPlaceHolder1_ddlTaxCode")
	public WebElement DdltaxonomyCode;

	public void SctAddAccDdlTaxonomyCode(String vtext) throws InterruptedException {
		Select sct = new Select(DdltaxonomyCode);
		List<WebElement> listofoptions = sct.getOptions();
		for (WebElement option : listofoptions) {
			String TaxonomyCode = option.getText();
			String filename = vtext;
			String subString = null;
			int iend = filename.indexOf("-");
			if (iend != -1)
				subString = filename.substring(0, iend);
			String truncated = subString.replaceAll("[^\\p{Print}]", "");
			String str = truncated.trim();
			if (TaxonomyCode.contains(str)) {
				sct.selectByValue(str);
				break;
			}
		}

	}

	// Add account page Address & Contact Information text field last name.
	@FindBy(id = "ContentPlaceHolder1_txtLastName")
	public WebElement TxtLastName;

	public void EnterAddAccLastName(String lastname) {
		TxtLastName.sendKeys(lastname);
	}

	//Add account page to verify last name is present of not
	@FindBy(id = "ContentPlaceHolder1_RqdLastName")
	public WebElement lastnamerequired;

	public Boolean VerifyAddAccountLastNamePresentorNot() {
		WebDriverWait wait = new WebDriverWait(GlobalVar.Driver, 5);
		try {
			wait.until(ExpectedConditions.visibilityOf(lastnamerequired));
			Reporter.log("Last name exist... ", true);
			return true;
		} catch (Exception e) {
			Reporter.log("Last name not exist... ", true);
			return false;

		}
	}	
	
	
	// Add account page Address & Contact Information text field first name.
	@FindBy(id = "ContentPlaceHolder1_txtFirstName")
	public WebElement TxtFirstName;

	public void EnterAddAccFirstName(String FirstName) {
		TxtFirstName.sendKeys(FirstName);
	}

	//Add account page to verify first name is present of not
	@FindBy(id = "ContentPlaceHolder1_RqdFirstName")
	public WebElement firstnamerequired;

	public Boolean VerifyAddAccountLFirstNamePresentorNot() {
		WebDriverWait wait = new WebDriverWait(GlobalVar.Driver, 5);
		try {
			wait.until(ExpectedConditions.visibilityOf(firstnamerequired));
			Reporter.log("First name exist... ", true);
			return true;
		} catch (Exception e) {
			Reporter.log("First name not exist... ", true);
			return false;

		}
	}	
	
	
	// Add account page Address & Contact Information text field email.
	@FindBy(id = "ContentPlaceHolder1_txtEmail")
	public WebElement TxtEmail;

	public void EnterAddAccEmail(String Email) {
		TxtEmail.sendKeys(Email);
	}

	// Add account page Address & Contact Information text field address1.
	@FindBy(id = "ContentPlaceHolder1_txtAddress1")
	public WebElement TxtAddress1;

	public void EnterAddAccTxtAddress1(String Address1) {
		TxtAddress1.sendKeys(Address1);
	}

	// Add account page Address & Contact Information text field address1.
	@FindBy(id = "ContentPlaceHolder1_txtAddress2")
	public WebElement TxtAddress2;

	public void EnterAddAccTxtAddress2(String Address2) {
		TxtAddress2.sendKeys(Address2);
	}

	// Add account page Address & Contact Information text field city1.
	@FindBy(id = "ContentPlaceHolder1_txtCity")
	public WebElement TxtCity;

	public void EnterAddAccCity(String City) {
		TxtCity.sendKeys(City);
	}

	// Add account page Address & Contact Information state ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlACState")
	public WebElement DdlAccState;

	public void SctAddAccDdlAcState(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlAccState, vtext);
	}

	// Add account page Address & Contact Information text zip.
	@FindBy(id = "ContentPlaceHolder1_txtZip")
	public WebElement TxtZip;

	public void EnterAddAccZip(String zip) {
		TxtZip.sendKeys(zip);
	}

	// Add account page Address & Contact Information text field fax.
	@FindBy(id = "ContentPlaceHolder1_txtFax")
	public WebElement TxtFax;

	public void EnterAddAccFax(String fax) {
		TxtFax.sendKeys(fax);
	}

	// Add account page Address & Contact Information text field telephone1.
	@FindBy(id = "ContentPlaceHolder1_txtTelephone1")
	public WebElement TxtTelephone1;

	public void EnterAddAccTelephone1(String telephone1) {
		TxtTelephone1.sendKeys(telephone1);
	}

	// Add account page Address & Contact Information text field extension1.
	@FindBy(id = "ContentPlaceHolder1_txtExtension1")
	public WebElement TxtExtension1;

	public void EnterAddAccExtension1(String extension1) {
		TxtExtension1.sendKeys(extension1);
	}

	// Add account page Address & Contact Information text field telephone2.
	@FindBy(id = "ContentPlaceHolder1_txtTelephone2")
	public WebElement TxtTelephone2;

	public void EnterAddAccTelephone2(String telephone2) {
		TxtTelephone2.sendKeys(telephone2);
	}

	// Add account page Address & Contact Information text field extension2.
	@FindBy(id = "ContentPlaceHolder1_txtExtension2")
	public WebElement TxtExtension2;

	public void EnterAddAccExtension2(String extension2) {
		TxtExtension2.sendKeys(extension2);
	}

	// Add account page Additional Information click check box batch claims
	// format
	@FindBy(xpath = "//input[@id='CheckBatchClaims']")
	public WebElement ChkBatchClaims;

	public void ClickAddAccBatchClaims() {
		ChkBatchClaims.click();
	}

	// Add account page additional information,select ANSI/X12 format
	@FindBy(id = "ContentPlaceHolder1_rdoAnsi")
	public WebElement SctRdoAnsi;

	public void ClickRdoAnsi() {
		SctRdoAnsi.click();
	}

	// Add account page additional information,select Proprietary format
	@FindBy(id = "ContentPlaceHolder1_rdoPropertiary")
	public WebElement SctRdoPropertiary;

	public void ClickRdoPropertiary() {
		SctRdoPropertiary.click();
	}

	// Add account page Credit / Debit Payment Gateway merchant id
	@FindBy(id = "ContentPlaceHolder1_txtMerchantID")
	public WebElement TxtOperatorId;

	public void EnterAddAccMerchantId(String merchantid) {
		TxtOperatorId.sendKeys(merchantid);
	}

	// Add account page Credit / Debit Payment Gateway Operator / User ID
	@FindBy(id = "ContentPlaceHolder1_txtOperatorORUserID")
	public WebElement TxtOperatorOrUserId;

	public void EnterAddAccOperatorOrUserId(String OperatorOrUserId) {
		TxtOperatorOrUserId.sendKeys(OperatorOrUserId);
	}

	// Add account page Credit / Debit Payment Gateway Password
	@FindBy(id = "ContentPlaceHolder1_txtPassword")
	public WebElement TxtPassword;

	public void EnterAddAccPassword(String txtPassword) {
		TxtPassword.sendKeys(txtPassword);
	}

	// Add account page Credit / Debit Payment Gateway device id.
	@FindBy(id = "ContentPlaceHolder1_txtDeviceID")
	public WebElement TxtDeviceId;

	public void EnterAddAccDeviceId(String deviceid) {
		TxtDeviceId.sendKeys(deviceid);
	}

	// Add account page Credit / Debit Payment Gateway registration key.
	@FindBy(id = "ContentPlaceHolder1_txtRegistrationKey")
	public WebElement TxtRegisKey;

	public void EnterAddAccRegisKey(String regiskey) {
		TxtRegisKey.sendKeys(regiskey);
	}

	// Add account page Check Payment Gateway Site ID
	@FindBy(id = "ContentPlaceHolder1_txtSiteID")
	public WebElement TxtSiteID;

	public void EnterAddAccSiteID(String siteid) {
		TxtSiteID.sendKeys(siteid);
	}

	// Add account page Check Payment Gateway Location ID
	@FindBy(id = "ContentPlaceHolder1_txtLocationID")
	public WebElement TxtLocationID;

	public void EnterAddAccLocationID(String locationid) {
		TxtLocationID.sendKeys(locationid);
	}

	// Add account page Check Payment Gateway POSProgram ID
	@FindBy(id = "ContentPlaceHolder1_txtPOSProgramID")
	public WebElement TxtPOSProgramID;

	public void EnterAddAccPOSProgramID(String POSProgramID) {
		TxtPOSProgramID.sendKeys(POSProgramID);
	}

	// Add account page Check Payment Gateway TxtLaneID
	@FindBy(id = "ContentPlaceHolder1_txtLaneID")
	public WebElement TxtLaneID;

	public void EnterAddAccTxtLaneID(String txtLaneID) {
		TxtLaneID.sendKeys(txtLaneID);
	}

	// Add account page assign region button field.
	@FindBy(id = "ContentPlaceHolder1_btnAssignRegion")
	public WebElement BtnAssignRegion;

	public void ClickAddAccAssignRegion() {
		BtnAssignRegion.click();
	}

	// Add account page select assign region then click on delete button
	@FindBy(id = "ContentPlaceHolder1_grdACOList_ButtonDelete_0")
	public WebElement BtnDeleteRegion;

	public void ClickAddAccDeleteRegion() {
		BtnDeleteRegion.click();
	}

	// Add account page assign facility button field.
	@FindBy(id = "ContentPlaceHolder1_btnAssignFacility")
	public WebElement BtnAssignFacility;

	public void ClickAddAccAssignFacility() {
		BtnAssignFacility.click();
	}

	// Add account page assign provider button field.
	@FindBy(id = "ContentPlaceHolder1_btnAssignProvider")
	public WebElement BtnAssignProvider;

	public void ClickAddAccAssignProvider() {
		BtnAssignProvider.click();
	}

	// Add account page assign user button field.
	@FindBy(id = "ContentPlaceHolder1_btnAssignUser")
	public WebElement BtnAssignUser;

	public void ClickAddAccAssignUser() {
		BtnAssignUser.click();
	}

	// Add account page save account button filed.
	@FindBy(id = "ContentPlaceHolder1_btnSaveAccount")
	public WebElement BtnSaveAccount;

	public void ClickAddAccSave() {
		BtnSaveAccount.click();
	}

	// Add account page save account button filed.
	@FindBy(id = "ContentPlaceHolder1_btnClearAddAccount")
	public WebElement BtnClearAddAccount;

	public void ClickAddAccClear() {
		BtnClearAddAccount.click();
	}

	// Add account page save account button filed.
	@FindBy(id = "ContentPlaceHolder1_btnBackAccount")
	public WebElement BtnBackAccount;

	public void ClickAddAccBack() {
		BtnBackAccount.click();
	}

	public void switchToWindowByIndex(int index) {
		int count = 0;
		Set<String> windows = GlobalVar.Driver.getWindowHandles();
		for (String window : windows) {
			GlobalVar.Driver.switchTo().window(window);
			if (count == index) {
				System.out.println("Switched into window: " + index);
				break;
			}
			count++;
		}

	}

	public void AccountDropdownSelect(String dropdownidSelector, String dropdownlistData) {
		Select select = new Select(GlobalVar.Driver.findElement(By.id(dropdownidSelector)));
		List<WebElement> listOfOptions = select.getOptions();
		for (WebElement option : listOfOptions) {
			String storeAndAcctNum = option.getText().trim();
			if (storeAndAcctNum.contains(dropdownlistData)) {
				select.selectByVisibleText(dropdownlistData);
				break;
			}
		}

	}

}
