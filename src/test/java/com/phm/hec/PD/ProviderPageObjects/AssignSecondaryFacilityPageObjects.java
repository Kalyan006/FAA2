package com.phm.hec.PD.ProviderPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignSecondaryFacilityPageObjects {
	// Click on Assign Secondary Facility button
	@FindBy(id = "ContentPlaceHolder1_btnAssignSecFacility")
	public WebElement BtnSecondaryFacility;

	public void ClickSecondaryFacilityButton() {
		BtnSecondaryFacility.click();
	}

	// Secondary Facility Page,facility name text field
	@FindBy(id = "txtFacilityName")
	public WebElement TxtSecFacilityName;

	public void EnterSecFacilityName(String FacilityName) {
		TxtSecFacilityName.sendKeys(FacilityName);
	}

	// Secondary Facility Page,tax id text field
	@FindBy(xpath = "//input[@id='txtTaxID']")
	public WebElement TxtSecFacilityTaxId;

	public void EnterSecFacilityTaxId(String TaxId) {
		TxtSecFacilityTaxId.sendKeys(TaxId);
	}

	// Secondary Facility Page,search facility button
	@FindBy(id = "btnSearchUserAssign")
	public WebElement BtnSecSearchFacility;

	public void ClickSecSearchFacility() {
		BtnSecSearchFacility.click();
	}

	// Secondary Facility Page,search facility link
	@FindBy(xpath = "//table/tbody/tr[3]/td/input[@type='image']")
	public WebElement LnkSecFacilityName;

	public void ClickSecLnkFacilityName() {
		LnkSecFacilityName.click();
	}

}
