package com.phm.hec.PD.AccountPageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.phm.hec.utility.GenericUtils;
import com.phm.hec.utility.GlobalVar;

public class AccountPageObjects {
	// Account Page account name text
	@FindBy(id = "ContentPlaceHolder1_txtAccountName")
	public WebElement TxtAccountName;

	public void EnterAccountName(String AccountName) {
		TxtAccountName.sendKeys(AccountName);
	}

	// Account Page account type ddl
	@FindBy(id = "ContentPlaceHolder1_ddlAccountType")
	public WebElement DdlAccountType;

	public void SctDdlAccountType(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlAccountType, vtext);
	}

	// Account Page account type npi text
	@FindBy(id = "ContentPlaceHolder1_txtnpi")
	public WebElement TxtAcNpi;

	public void EnterAccNpi(String Npi) {
		TxtAcNpi.sendKeys(Npi);
	}

	// Account Page account UserName text
	@FindBy(id = "ContentPlaceHolder1_txtUserName")
	public WebElement TxtAccUserName;

	public void EnterAccUserName(String UserName) {
		TxtAccUserName.sendKeys(UserName);
	}

	// Account Page account State Assigned ID text field.
	@FindBy(id = "ContentPlaceHolder1_txtUmpi")
	public WebElement TxtAssignedID;

	public void EnterAccStateID(String AssignedID) {
		TxtAssignedID.sendKeys(AssignedID);
	}

	// Account Page account tax ID text field.
	@FindBy(id = "ContentPlaceHolder1_txtTaxID")
	public WebElement TxtAccTaxID;

	public void EnterAccTaxID(String TaxID) {
		TxtAccTaxID.sendKeys(TaxID);
	}

	// Account Page account from date
	@FindBy(id = "ContentPlaceHolder1_imgDtFrom")
	public WebElement ImgDtFrom;

	public void ClickAccImgDtFrom() {
		ImgDtFrom.click();
	}

	// Account Page account to date
	@FindBy(id = "ContentPlaceHolder1_imgDtTo")
	public WebElement TxtImgDtTo;

	public void ClickAccImgDtTo() {
		TxtImgDtTo.click();
	}

	// Account Page account status
	@FindBy(id = "ContentPlaceHolder1_ddlStatus")
	public WebElement DdlStatus;

	public void SctAccDdlStatus(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlStatus, vtext);
	}

	// Account Page account Phone text
	@FindBy(id = "ContentPlaceHolder1_txtPhone")
	public WebElement TxtPhone;

	public void EnterAccPhoneNo(String text) {
		TxtPhone.sendKeys(text);
	}

	// Account Page account Email text
	@FindBy(id = "ContentPlaceHolder1_txtEmail")
	public WebElement TxtAccEmail;

	public void EnterAccEmail(String email) {
		TxtAccEmail.sendKeys(email);
	}

	// Account Page account Search Account button
	@FindBy(id = "ContentPlaceHolder1_btnSearchAccount")
	public WebElement BtnSearchAccount;

	public void ClickAccSearchAccount() {
		BtnSearchAccount.click();
	}

	// Account Page account clear button
	@FindBy(id = "ContentPlaceHolder1_btnClearAddAccount")
	public WebElement BtnClear;

	public void ClickAccBtnClear() {
		BtnClear.click();
	}

	// Account Page, add account button
	// @FindBy(id="ContentPlaceHolder1_btnAddAccount")
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnAddAccount']")
	public WebElement BtnAddAccount;

	public void ClickBtnAddAccount() {
		/*
		 * try { JavascriptExecutor executor =
		 * (JavascriptExecutor)GlobalVar.Driver;
		 * executor.executeScript("arguments[0].click()", BtnAddAccount);
		 * //BtnAddAccount.click(); } catch(NoSuchElementException e) {
		 * e.printStackTrace(); }
		 */
		BtnAddAccount.click();

	}

	// Account name text box to search
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAccountName']")
	public WebElement TxtAccountNameSearch;

	public void EnterAccountNameToSearch(String accountname) {
		TxtAccountNameSearch.sendKeys(accountname);

	}

	// Account name has been created successfully
	@FindBy(id = "ContentPlaceHolder1_lblAccountstatus")
	public WebElement LblAccountStatusTxt;

	public void CheckAccCreatedSucc() {
		String createdtext = LblAccountStatusTxt.getText();
		Reporter.log("Display successfull message----" + createdtext, true);

	}

	// To verify account name present or not
	@FindBy(id = "ContentPlaceHolder1_grdAccountList_lblLastName_0")
	public WebElement verifyaccountname;

	public Boolean verifyAccountNamePresentorNot() {
		WebDriverWait wait = new WebDriverWait(GlobalVar.Driver, 5);
		try {
			wait.until(ExpectedConditions.visibilityOf(verifyaccountname));
			Reporter.log("Account name exist... ", true);
			return true;
		} catch (Exception e) {
			Reporter.log("Account name not exist... ", true);
			return false;

		}
	}

}
