package com.phm.hec.PD.ProviderPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.phm.hec.utility.GenericUtils;

public class AddCallLogPageObjects {
	// Click on Add Call Log button
	@FindBy(id = "ContentPlaceHolder1_btnAddCallLog")
	public WebElement BtnAddCallLog;

	public void ClickAddCallLogButton() {
		BtnAddCallLog.click();
	}

	// Add call log page,call log tracker,reason type ddl field
	@FindBy(id = "ddlReasonType")
	public WebElement DdlReasonType;

	public void SctReasonType(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlReasonType, vtext);
	}

	// Add call log page,call log tracker,click browse to upload
	@FindBy(id = "FileUploadCtrl1")
	public WebElement LnkFileUpload;

	public void ClickToFileUpload() {
		LnkFileUpload.click();
	}

	// Add call log page,call log tracker,contact mode ddl field
	@FindBy(id = "ddlContactMode")
	public WebElement DdlContactMode;

	public void SctContactMode(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlContactMode, vtext);
	}

	// Add call log page,call log tracker,communication date
	@FindBy(id = "imgCommunicationDate")
	public WebElement ImgCommDate;

	public void ClickCommDate() {
		ImgCommDate.click();
	}

	// Add call log page,call log tracker,created date
	@FindBy(id = "imgCreatedDate")
	public WebElement ImgCreatedDate;

	public void ClickCreatedDate() {
		ImgCreatedDate.click();
	}

	// Add call log page,call log tracker,note text field
	@FindBy(id = "txtNotes")
	public WebElement TxtNotes;

	public void EnterNotes(String notes) {
		TxtNotes.sendKeys(notes);
	}

	// Add call log page,call log tracker,contact type ddl field
	@FindBy(id = "ddlContactType")
	public WebElement DdlContactType;

	public void SctContactType(String vtext) {
		GenericUtils.selectDdlByVisibleText(DdlContactType, vtext);
	}

	// Add call log page,call log tracker,click follow up
	@FindBy(id = "checkFollowup")
	public WebElement ChkFollowup;

	public void ClickFollowUp() {
		ChkFollowup.click();
	}

	// Add call log page,follow up date
	@FindBy(id = "imgFollowupdate")
	public WebElement ImgFollowupdate;

	public void ClickFollowupdate() {
		ImgFollowupdate.click();
	}

	// Add call log page,call log tracker,follow up text field
	@FindBy(id = "txtFollowupNotes")
	public WebElement TxtFollowupNotes;

	public void EnterFollowupNotes(String flwupnote) {
		TxtFollowupNotes.sendKeys(flwupnote);
	}

	// Add call log page,call log tracker,click on submit button
	@FindBy(id = "btnAddCallLog")
	public WebElement BtnAddCallLog1;

	public void ClickCallLogSubmit() {
		BtnAddCallLog1.click();
	}

	// Add call log page,call log tracker,click on back button
	@FindBy(id = "btnBackToFacility")
	public WebElement BtnBackToFacility;

	public void ClickToBack() {
		BtnBackToFacility.click();
	}

}
