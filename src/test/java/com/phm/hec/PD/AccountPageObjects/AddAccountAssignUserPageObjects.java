package com.phm.hec.PD.AccountPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAccountAssignUserPageObjects {
	// Assign user page,enter user name
	@FindBy(id = "txtUserName")
	public WebElement TxtUserName;

	public void EnterAddAccUserName(String username) {
		TxtUserName.sendKeys(username);
	}

	// Assign user page,click on search user button
	@FindBy(id = "btnSearchUser")
	public WebElement BtnSearchUser;

	public void ClickAddAccSearchUser() {
		BtnSearchUser.click();
	}

	// Assign user page,click on check box
	@FindBy(id = "gridCustomUserList_CBSelect_0")
	public WebElement ChkBoxUser;

	public void ClickAddAccUserChkBox() {
		ChkBoxUser.click();
	}

	// Assing user page after chech box last name
	@FindBy(xpath = "//span[@id='gridCustomUserList_lblLastName_0']")
	public WebElement LblAddAccUserLastName;

	public String ClickAddAccUserLblLastName() {
		return LblAddAccUserLastName.getText();
	}

	// Assing user page after check box first name
	@FindBy(xpath = "//span[@id='gridCustomUserList_lblFirstName_0']")
	public WebElement LblAddAccUserFirstName;

	public String ClickAddAccUserLblFirstName() {
		return LblAddAccUserFirstName.getText();
	}

	// Assign user page,click on assign user
	@FindBy(id = "btnAssignUserAccount")
	public WebElement BtnAssignUserAccount;

	public void ClickAddAccUserAccountSave() {
		BtnAssignUserAccount.click();
	}

}
