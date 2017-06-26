package com.phm.hec.PD.AccountPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAccountAssignFacilityPageObjects {
	// Assign facility page,Enter facility name
	@FindBy(xpath = "//input[@id='txtFacilityName']")
	public WebElement TxtAddAaccFacilityName;

	public void EnterAddAccFacilityName(String facilityname) {
		TxtAddAaccFacilityName.sendKeys(facilityname);
	}

	// Assign facility page,Enter taxid
	@FindBy(id = "txtTaxID")
	public WebElement TxtAddAccTaxID;

	public void EnterAddAccTaxId(String taxid) {
		TxtAddAccTaxID.sendKeys(taxid);
	}

	// Assign facility page,click on search facility button
	@FindBy(id = "btnSearchUserAssign")
	public WebElement BtnSearchUserAssign;

	public void ClickAddAccSearchFaciity() {
		BtnSearchUserAssign.click();
	}

	// Assign facility page,Select facility name check box
	@FindBy(id = "grdAccountList_chkBoxACOId_0")
	public WebElement ChkBoxFacilityName;

	public void ClickAddAccSctFacilityNameBox() {
		ChkBoxFacilityName.click();
	}

	// Assign facility page,after check box facility name
	@FindBy(xpath = "//span[@id='grdAccountList_lblAccountName_0']")
	public WebElement LblAddAccFacilityName;

	public String AddAccLblFacilityNameText() {
		String xyz = LblAddAccFacilityName.getText();
		return xyz;

	}

	// Assign facility page,click on assign facility box
	@FindBy(id = "btnAssignUserAccount")
	public WebElement BtnAssignUserAccountChkBox;

	public void ClickAddAccAssignFacilityChkBox() {
		BtnAssignUserAccountChkBox.click();
	}

}
