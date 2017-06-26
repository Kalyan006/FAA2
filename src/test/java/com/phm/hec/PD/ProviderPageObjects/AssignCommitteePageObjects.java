package com.phm.hec.PD.ProviderPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssignCommitteePageObjects {
	// Click on Assign Committee
	@FindBy(id = "ContentPlaceHolder1_btnAssignCommittee")
	public WebElement BtnAssignCommittee;

	public void ClickAssignCommitteeButton() {
		BtnAssignCommittee.click();
	}

	// Assign Committee Page,committee name text field
	@FindBy(xpath = "//input[@name='txtCommiteeName']")
	public WebElement TxtCommitteeName;

	public void EnterCommitteeName(String CommitteeName) {
		TxtCommitteeName.sendKeys(CommitteeName);
	}

	// Assign Committee Page,search user assign text field
	@FindBy(id = "btnSearchUserAssign")
	public WebElement BtnCommSearchUser;

	public void ClickSearchComm() {
		BtnCommSearchUser.click();
	}

	// Assign Committee Page,check box committee name
	@FindBy(id = "grdAccountList_chkBoxACOId_0")
	public WebElement LnkChkCommName;

	public void ClickLnkComm() {
		LnkChkCommName.click();
	}

	// Assign Committee Page,assign committee button
	@FindBy(id = "btnAssignUserAccount")
	public WebElement BtnSelAssignCommit;

	public void ClickAssignCommittee() {
		BtnSelAssignCommit.click();
	}

}
