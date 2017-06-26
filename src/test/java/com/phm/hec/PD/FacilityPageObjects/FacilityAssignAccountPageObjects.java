package com.phm.hec.PD.FacilityPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacilityAssignAccountPageObjects {

	@FindBy(id = "ContentPlaceHolder1_txtAccountName")
	public WebElement TxtAccountName;
	@FindBy(id = "ContentPlaceHolder1_ddlAccountType")
	public WebElement DdlAccountType;
	@FindBy(id = "ContentPlaceHolder1_txtTaxID")
	public WebElement TxtTaxId;
	@FindBy(id = "txtInternalID")
	public WebElement TxtInternalId;
	@FindBy(id = "txtPhone")
	public WebElement TxtPhone;
	@FindBy(id = "txtEmail")
	public WebElement TxtEmail;
	@FindBy(id = "ddlTimePeriod")
	public WebElement DdlTimePeriod;
	@FindBy(id = "txtDtFrom")
	public WebElement TxtDtFrom;
	@FindBy(id = "imgDtFrom")
	public WebElement ImgDtFrom;
	@FindBy(id = "txtDtTo")
	public WebElement TxtDtTo;
	@FindBy(id = "imgDtTo")
	public WebElement ImgDtTo;
	@FindBy(id = "ddlStatus")
	public WebElement DdlStatus;
	@FindBy(id = "btnSearchUserAssign")
	public WebElement BtnSearchUserAssign;
	@FindBy(id = "btnCancelUserAssign")
	public WebElement BtnCancelUserAssign;

}
