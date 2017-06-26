package com.phm.hec.PD.ProviderPageObjects;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.phm.hec.calendar.PickDate;
import com.phm.hec.utility.GenericUtils;
import com.phm.hec.utility.GlobalVar;

public class AssignRegionPageObjects {
	// Click on assign region
	@FindBy(id = "ContentPlaceHolder1_btnAssignRegion")
	public WebElement BtnAssignRegion;

	public void ClickAssignRegion() {
		BtnAssignRegion.click();
	}

	// Assign region page,region code text field
	@FindBy(id = "txtACOOrgID")
	public WebElement TxtRegionCode;

	public void EnterRegionCode(String regionCode) {
		TxtRegionCode.sendKeys(regionCode);
	}

	// Assign region page,region name
	@FindBy(id = "txtACOOrgName")
	public WebElement TxtRegionName;

	public void EnterRegionName(String regionname) {
		TxtRegionName.sendKeys(regionname);
	}

	// Assign region page,search region
	@FindBy(id = "btnSearchUserAssign")
	public WebElement BtnSearchUserAssign;

	public void ClickSearchRegion() {
		BtnSearchUserAssign.click();
	}

	// Assign region,Select assign region code
	@FindBy(id = "grdAccountList_chkBoxACOId_0")
	public WebElement ChkBoxSelectRegion;

	public void ClickSelectRegionBox() {
		ChkBoxSelectRegion.click();
	}

	// Assign region,select month
	// String dpmonth = "//span[text()='" + "MAY" + "']";
	@FindBy(id = "monthSelect")
	public WebElement TxtProviderMonth;

	public void EnterProviderMonth(int index) {
		GenericUtils.selectDdlByIndex(TxtProviderMonth, index);
	}

	// Assign region,select year
	@FindBy(id = "calendar_year_txt")
	public WebElement TxtProviderYear;

	public void EnterProviderYear(String year) {
		GenericUtils.selectDdlByVisibleText(TxtProviderYear, year);
	}

	// Assign region,Region Provider start date
	@FindBy(id = "grdAccountList_imgDtFrom_0")
	public WebElement ImgProviderStdate;

	public void ClickOnFromDateCalendar() {
		ImgProviderStdate.click();
	}

	// Assign region,Region Provider term date
	@FindBy(id = "grdAccountList_imgDtTo_0")
	public WebElement ImgProviderTrdate;

	public void ClickOnTermDateCalendar() {
		ImgProviderTrdate.click();
	}

	// Assign region,Region Provider status
	@FindBy(id = "grdAccountList_ddlACOStatus_0")
	public WebElement DdlRegionStatus;

	public void SctRegionstatus(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlRegionStatus, vtext);

	}

	// Assign region,signed contract
	@FindBy(id = "grdAccountList_ddlSignedContract_0")
	public WebElement DdlSignedContract;

	public void SctSignedContract(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlSignedContract, vtext);
	}

	/*
	 * //Assign region page,clear selection
	 * 
	 * @FindBy(id="btnCancelUserAssign") public WebElement BtnCancelAssign;
	 * public void ClickCancelRegion() { BtnCancelAssign.click(); }
	 */
	// Assign region page,click on assign region button
	@FindBy(id = "btnAssignUserAccount")
	public WebElement BtnAssignUserAccount;

	public void ClickAssignUserRegion() {
		BtnAssignUserAccount.click();
	}
	// Assign region page,click on clear data
	/*
	 * public void switchToWindowByIndex(int index) {
	 * 
	 * int count = 0; Set<String> windows = GlobalVar.Driver.getWindowHandles();
	 * for (String window : windows) {
	 * GlobalVar.Driver.switchTo().window(window); if (count == index) {
	 * System.out.println("Switched into window :: " + index); break;
	 * 
	 * } count++; }
	 * 
	 * }
	 */

}
