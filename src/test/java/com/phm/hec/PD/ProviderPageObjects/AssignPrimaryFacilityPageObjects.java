package com.phm.hec.PD.ProviderPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignPrimaryFacilityPageObjects {
	// Click on assign primary facility button
	@FindBy(id = "ContentPlaceHolder1_btnAssignFacility")
	public WebElement BtnPrimaryFacility;

	public void ClickPrimaryFacilityButton() {
		BtnPrimaryFacility.click();
	}

	// Primary Facility Page,facility name text field
	@FindBy(xpath = "//input[@name='txtFacilityName']")
	public WebElement TxtPryFacilityName;

	public void EnterPryFacilityName(String FacilityName) {
		TxtPryFacilityName.sendKeys(FacilityName);
	}

	// Primary Facility Page,tax id text field
	@FindBy(xpath = "//input[@name='txtTaxID']")
	public WebElement TxtPryFacilityTaxId;

	public void EnterPryFacilityTaxId(String TaxId) {
		TxtPryFacilityTaxId.sendKeys(TaxId);
	}

	// Primary Facility Page,search facility button
	@FindBy(xpath = "//input[@id='btnSearchUserAssign']")
	public WebElement BtnPrySearchFacility;

	public void ClickPrySearchFacility() {
		BtnPrySearchFacility.click();
	}

	// Primary Facility Page,search facility link
	@FindBy(xpath = "//input[@type='image']")
	public WebElement LnkPryFacilityName;

	public void ClickPryFacilityName() {
		LnkPryFacilityName.click();
	}
}
