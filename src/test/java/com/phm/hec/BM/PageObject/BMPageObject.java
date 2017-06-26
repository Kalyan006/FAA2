package com.phm.hec.BM.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.phm.hec.utility.GenericUtils;

public class BMPageObject {

	// click on Beneficiary Management Home Button
	@FindBy(xpath = ".//*[@id='top_links']/p/a[2]/img']")
	public WebElement LnkHomeBM;

	public void ClickOnHomeButtonBM() {
		LnkHomeBM.click();
	}

	// Click on Beneficiary Attribution Menu

	@FindBy(xpath = ".//*[@id='lnkParent']//a[normalize-space(text())='Beneficiary Attribution']")
	public WebElement LnkBeneficiaryAttributionM;

	public void ClickBeneficiaryAttributionMenu() {
		LnkBeneficiaryAttributionM.click();

	}

	// click on Beneficiary Attribution Sub Menu under Beneficiary Management

	@FindBy(xpath = ".//*[@id='lnk']//h3[normalize-space(text())='Beneficiary Attribution']")
	public WebElement LnkBeneficiaryAttributionSM;

	public void ClickBeneficiaryAttributionSubMenu() {
		LnkBeneficiaryAttributionSM.click();
	}

	@FindBy(xpath = ".//*[@id='mcont']/table[1]/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/div/button")
	public WebElement dropdownWidgetBM;

	public void ClickDropDown() {
		dropdownWidgetBM.click();
	}

	@FindBy(name = "selectAll")
	public WebElement DropDownCheckBoxBM;

	public void ClickDropDownCheckBoxBM() {
		DropDownCheckBoxBM.click();
	}

	@FindBy(id = "txtAttrMemberId")
	public WebElement MemberIDBM;

	public void ClickMemberIDBoxBM(String MID) {
		MemberIDBM.sendKeys(MID);
	}

	@FindBy(id = "btnAttrSearch")
	public WebElement SearchButtonBM;

	public void ClickSearchButtonBM() {
		SearchButtonBM.click();
	}

}
