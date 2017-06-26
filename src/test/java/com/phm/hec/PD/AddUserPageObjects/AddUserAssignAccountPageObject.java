package com.phm.hec.PD.AddUserPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserAssignAccountPageObject {
	// Tax Id field text
	@FindBy(xpath = ".//*[@id='txtTaxID']")
	public WebElement txtTaxID;

	public void EnterTaxID(String TaxID) {
		txtTaxID.sendKeys(TaxID);
	}

	// Search account field text
	@FindBy(xpath = ".//*[@id='btnSearchUserAssign']")
	public WebElement btnSearchUserAssign;

	public void ClickSearchAccount() {
		btnSearchUserAssign.click();
	}

	// Checkbox field text
	@FindBy(xpath = ".//*[@id='grdAccountList_chkBoxAccountId_0']")
	public WebElement chkBoxAccountId_0;

	public void ClickCheckBox() {
		chkBoxAccountId_0.click();
	}

	// Assign account field text
	@FindBy(xpath = ".//*[@id='btnAssignUserAccount']")
	public WebElement btnAssignUserAccount;

	public void ClickAssignAccount() {
		btnAssignUserAccount.click();
	}

}
