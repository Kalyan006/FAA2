package com.phm.hec.PD.ProviderPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignSecondaryAccountPageObjects {
	// Click on assign secondary account button
	@FindBy(id = "ContentPlaceHolder1_btnSecondaryAssignAccount")
	public WebElement BtnSecondaryAccount;

	public void ClickSecondaryAccountButton() {
		BtnSecondaryAccount.click();
	}

	// Secondary account page account name text field
	@FindBy(id = "txtAccountName")
	public WebElement TxtSecondaryAccountName;

	public void EnterSecondaryAccountName(String AccountName) {
		TxtSecondaryAccountName.sendKeys(AccountName);
	}

	// Secondary account page secondary tax id text field
	@FindBy(id = "txtTaxID")
	public WebElement TxtSecondaryTaxId;

	public void EnterSecondaryTaxId(String TaxId) {
		TxtSecondaryTaxId.sendKeys(TaxId);
	}

	// Secondary account page account name text field
	@FindBy(id = "btnSearchUserAssign")
	public WebElement BtnSeconSearchUser;

	public void ClickSeconSearchUser() {
		BtnSeconSearchUser.click();
	}

	// Secondary account page,select any one account name
	@FindBy(id = "grdAccountList_chkBoxAccountId_0")
	public WebElement ChkSeconAccountName;

	public void ClickSeconAccountName() {
		ChkSeconAccountName.click();
	}

	// Secondary account page,Click on secondary assign account
	@FindBy(id = "btnAssignUserAccount")
	public WebElement BtnSeconAssignAccount;

	public void ClickSeconAssignAccount() {
		BtnSeconAssignAccount.click();
	}

}
