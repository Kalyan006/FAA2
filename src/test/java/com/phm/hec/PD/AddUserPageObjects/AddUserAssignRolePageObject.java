package com.phm.hec.PD.AddUserPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserAssignRolePageObject {
	// Role Name field text
	@FindBy(xpath = "//*[@id='TxtRoleName']")
	public WebElement TxtRoleName;

	public void EnterRoleName(String RoleName) {
		TxtRoleName.sendKeys(RoleName);
	}

	// Search role field text
	@FindBy(xpath = "//*[@id='btnSearchRole']")
	public WebElement btnSearchRole;

	public void ClickSearchRole() {
		btnSearchRole.click();
	}

	// Select role hand icon field text
	@FindBy(xpath = "//*[@id='grdRoleList']/tbody/tr[3]/td[1]/input")
	public WebElement SltHnd;

	public void SelectRoleHandIcon() {
		SltHnd.click();
	}

}
