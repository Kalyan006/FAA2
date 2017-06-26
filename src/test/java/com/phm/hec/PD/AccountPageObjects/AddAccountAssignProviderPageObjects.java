package com.phm.hec.PD.AccountPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAccountAssignProviderPageObjects {
	// Assign provider page,enter npi
	@FindBy(xpath = "//input[@id='txtNPI']")
	public WebElement TxtAddAccNPI;

	public void EnterAddAccTxtNpi(String txtnpi) {
		TxtAddAccNPI.sendKeys(txtnpi);
	}

	// Assing provider page after chech box last name
	@FindBy(xpath = "//span[@id='grdProviderListERX_lblLastNameERX_0']")
	public WebElement LblAddAccPrLastName;

	public String ClickAddAccPrLblLastName() {
		return LblAddAccPrLastName.getText();
	}

	// Assing provider page after check box first name
	@FindBy(xpath = "//span[@id='grdProviderListERX_lblFirstNameERX_0']")
	public WebElement LblAddAccPrFirstName;

	public String ClickAddAccPrLblFirstName() {
		return LblAddAccPrFirstName.getText();
	}

	// Assign provider page,click on search provider button
	@FindBy(id = "btnSearchProvider")
	public WebElement BtnSearchProvider;

	public void ClickAddAccSearchProvider() {
		BtnSearchProvider.click();
	}

	// Assign provider page,select check box
	@FindBy(id = "grdProviderListERX_CBSelect_0")
	public WebElement ChkBoxSelect;

	public void ClickAddAccChkBoxToSct() {
		ChkBoxSelect.click();
	}

	// Assign provider page,click on assign provider button
	@FindBy(id = "btnAssignUserAccount")
	public WebElement BtnAssignUserAccount;

	public void ClickAddAccAssignProviderBtn() {
		BtnAssignUserAccount.click();
	}
}
