package com.phm.hec.PD.AddUserPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserAssignProviderPageObject {
	// Provider NPI field text
	@FindBy(xpath = "//*[@id='txtNPI']")
	public WebElement txtNPI;

	public void EnterNPI(String NPI) {
		txtNPI.sendKeys(NPI);
	}

	// Search provider field text
	@FindBy(xpath = "//*[@id='btnSearchProvider']")
	public WebElement btnSearchProvider;

	public void ClickSearchProvider() {
		btnSearchProvider.click();
	}

	// select provider check box field text
	@FindBy(xpath = "//*[@id='grdProviderListERX_CBSelect_0']")
	public WebElement CBSelect_0;

	public void SelectCheckBox() {
		CBSelect_0.click();
	}

	// Assign provider field text
	@FindBy(xpath = "//*[@id='btnAssignUserAccount']")
	public WebElement btnAssignUserAccount;

	public void ClickAssignProvider() {
		btnAssignUserAccount.click();
	}

}
