package com.phm.hec.PD.AccountPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.phm.hec.utility.GlobalVar;

public class AddAccountAssignRegionPageObjects {
	// Enter assign region code
	@FindBy(id = "txtRegionCode")
	public WebElement TxtRegionCode;

	public void EnterAddAccRegionCode(String regioncode) {
		TxtRegionCode.sendKeys(regioncode);
	}

	// Enter assign region name
	@FindBy(id = "txtRegionName")
	public WebElement TxtRegionName;

	public String EnterAddAccRegionName(String regionname) {
		TxtRegionName.sendKeys(regionname);
		return regionname;
	}

	// Click search region
	@FindBy(id = "btnSearchUserAssign")
	public WebElement BtnSearchRegion;

	public void ClickAddAccSearchRegion() {
		BtnSearchRegion.click();
	}

	// Select assign region name check box
	@FindBy(id = "grdRegionList_chkBoxACOId_0")
	public WebElement ChkBoxRegionName;

	public void ClickAddAccSelectRegionBox() {
		ChkBoxRegionName.click();
	}

	// Select assign after check box region name
	@FindBy(xpath = ".//*[@id='grdRegionList_lblLastName_0']")
	public WebElement LblAddAccRegionName;

	public String AddAccLblRegionNameText() {
		String ARLblRegionName = LblAddAccRegionName.getText();
		return ARLblRegionName;

	}

	// Click on assign region button
	@FindBy(id = "btnAssignUserAccount")
	public WebElement BtnAssignAccount;

	public void ClickAddAccAssignUserRegion() {
		BtnAssignAccount.click();
	}

}
