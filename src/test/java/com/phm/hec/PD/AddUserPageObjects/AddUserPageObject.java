package com.phm.hec.PD.AddUserPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.phm.hec.utility.GenericUtils;

public class AddUserPageObject {
	// User name last name text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_TxtLastName']")
	public WebElement TxtLastName;

	public void EnterLastName(String LastName) {
		TxtLastName.sendKeys(LastName);
	}

	// User first name text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_TxtFirstName']")
	public WebElement TxtFirstName;

	public void EnterFirstName(String FirstName) {
		TxtFirstName.sendKeys(FirstName);
	}

	// User email address text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_TxtEmail']")
	public WebElement TxtEmail;

	public void EnterEmailAddress(String EmailID) {
		TxtEmail.sendKeys(EmailID);
	}

	// User Phone Number text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_TxtPhone']")
	public WebElement TxtPhone;

	public void EnterPhoneNum(String PhoneNumber) {
		TxtPhone.sendKeys(PhoneNumber);
	}

	// User name text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_TxtUserName']")
	public WebElement TxtUserName;

	public void EnterUserName(String UserName) {
		TxtUserName.sendKeys(UserName);
	}

	// Password text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_TxtPassword']")
	public WebElement TxtPassword;

	public void EnterPassword(String Password) {
		TxtPassword.sendKeys(Password);
	}

	// Add User Address1 field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtAddress1']")
	public WebElement txtAddress1;

	public void EnterAddress1(String Address1) {
		txtAddress1.sendKeys(Address1);
	}

	// Add user Address2 field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtAddress2']")
	public WebElement txtAddress2;

	public void EnterAddress2(String Address2) {
		txtAddress2.sendKeys(Address2);
	}

	// Add user City field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtCity']")
	public WebElement txtCity;

	public void EnterCityName(String CityName) {
		txtCity.sendKeys(CityName);
	}

	// Add User State drop down
	@FindBy(id = ".//*[@id='ContentPlaceHolder1_ddlState']")
	public WebElement ddlState;

	public void SelectState(String StateName) {
		GenericUtils.selectDdlByVisibleText(ddlState, StateName);
	}

	// Add user Zip field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtZip']")
	public WebElement txtZip;

	public void EnterZipCode(String ZipCode) {
		txtZip.sendKeys(ZipCode);
	}

	// Add user title field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtTitle']")
	public WebElement txtTitle;

	public void EnterTitle(String TitalName) {
		txtTitle.sendKeys(TitalName);
	}

	// Add user Phone1 field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtTelephone1']")
	public WebElement txtTelephone1;

	public void EnterPhoneNumber1(String PhoneNumber1) {
		txtTelephone1.sendKeys(PhoneNumber1);
	}

	// Add user Phone1 field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtTelephone2']")
	public WebElement txtTelephone2;

	public void EnterPhoneNumber2(String PhoneNumber2) {
		txtTelephone2.sendKeys(PhoneNumber2);
	}

	// Add user Fax field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtFax']")
	public WebElement txtFax;

	public void EnterFaxNumber(String FaxNumber) {
		txtFax.sendKeys(FaxNumber);
	}

	// Add user Responsibility field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtResponsibility']")
	public WebElement txtResponsibility;

	public void EnterResponsibility(String Responsibility) {
		txtResponsibility.sendKeys(Responsibility);
	}

	// Click on assign region
	@FindBy(id = "ContentPlaceHolder1_btnAssignRegion")
	public WebElement BtnAssignRegion;

	public void ClickAssignRegion() {
		BtnAssignRegion.click();
	}

	// Click on assign Account
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnAssignAccount']")
	public WebElement btnAssignAccount;

	public void ClickAssignAccount() {
		btnAssignAccount.click();
	}

	// Click on assign Provider
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnAssignProvider']")
	public WebElement btnAssignProvider;

	public void ClickAssinProvidert() {
		btnAssignProvider.click();
	}

	// Click on assign Role
	@FindBy(xpath = "//*[@id='ContentPlaceHolder1_btnAssignRole']")
	public WebElement btnAssignRole;

	public void ClickAssinRole() {
		btnAssignRole.click();
	}

	// Welcome email check box field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_chkWelComeEmail']")
	public WebElement chkWelComeEmail;

	public void SelectWlcmChkBox() {
		chkWelComeEmail.click();
	}

	// Password reset check box field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_chkResetEmail']")
	public WebElement chkResetEmail;

	public void SelectResetPwdChkBox() {
		chkResetEmail.click();
	}

	// Disable field text
	@FindBy(xpath = ".//*[@id='disable_dv']")
	public WebElement disable;

	public void SelectDisableButton() {
		disable.click();
	}

	// Disable field text
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_btnSaveUserAdd']")
	public WebElement btnSaveUserAdd;

	public void ClickSaveUser() {
		btnSaveUserAdd.click();
	}

}