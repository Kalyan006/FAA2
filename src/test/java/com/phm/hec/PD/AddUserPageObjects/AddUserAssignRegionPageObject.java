package com.phm.hec.PD.AddUserPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserAssignRegionPageObject {
	// Region code field text box
	@FindBy(xpath = ".//*[@id='txtRegionCode']")
	public WebElement txtRegionCode;

	public void EnterRegionCode(String RegionCode) {
		txtRegionCode.sendKeys(RegionCode);
	}

	// Search Region field text box
	@FindBy(xpath = ".//*[@id='btnSearchUserAssign']")
	public WebElement btnSearchUserAssign;

	public void ClickSearchRegion() {
		btnSearchUserAssign.click();
	}

	// Search Region field text box
	@FindBy(xpath = ".//*[@id='grdRegionList_chkBoxACOId_0']")
	public WebElement chkBox;

	public void SelectChkBox() {
		chkBox.click();
	}

	// Assign Account field text box
	@FindBy(xpath = ".//*[@id='btnAssignUserAccount']")
	public WebElement btnAssignUserAccount;

	public void ClickAssignRegion() {
		btnAssignUserAccount.click();
	}

}
