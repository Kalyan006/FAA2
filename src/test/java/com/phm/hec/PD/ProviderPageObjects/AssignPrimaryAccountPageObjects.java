package com.phm.hec.PD.ProviderPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignPrimaryAccountPageObjects {
	// Click on assign primary account button
	@FindBy(id = "ContentPlaceHolder1_btnPrimaryAssignAccount")
	public WebElement BtnPrimaryAssignAccount;

	public void ClickPrimaryAssignAccount() {
		BtnPrimaryAssignAccount.click();
	}

	// Assign Primary Account Page, account name text field
	@FindBy(id = "txtAccountName")
	public WebElement TxtAccountName;

	public void EnterPryAccountName(String AccountName) {
		TxtAccountName.sendKeys(AccountName);
	}

	// Assign primary account page taxid text field
	@FindBy(id = "txtTaxID")
	public WebElement TxtTaxId;

	public void EnterPryTaxId(String TaxId) {
		TxtTaxId.sendKeys(TaxId);
	}

	// Assign primary account page, search account
	@FindBy(id = "btnSearchUserAssign")
	public WebElement BtnSearchUserRegion;

	public void ClickSearchUserRegion() {
		BtnSearchUserRegion.click();
	}
	// Assign primary account page, search account

	// Primary account page,select any one account name
	@FindBy(xpath = "//table/tbody/tr[3]/td/input[@type='image']")
	public WebElement BtnAccountName;

	public void ClickAccountName() {
		BtnAccountName.click();
	}

}
