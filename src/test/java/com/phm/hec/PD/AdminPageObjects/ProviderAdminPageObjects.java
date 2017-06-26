package com.phm.hec.PD.AdminPageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.phm.hec.utility.GlobalVar;

public class ProviderAdminPageObjects {
	// --------------------------Implementation and Sub
	// Menu-----------------------------
	// Implementation link
	@FindBy(xpath = "//a[text()='Implementation']")
	public WebElement LnkImplementation;

	public void ClickLnkImplementation() {
		LnkImplementation.click();
	}

	// Link for client
	@FindBy(xpath = "//h3[text()='Client']")
	public WebElement LnkClient;

	public void ClickLnkClient() {
		LnkClient.click();
	}

	// Link for Program
	@FindBy(xpath = "//h3[text()='Program']")
	public WebElement LnkProgram;

	public void ClickLnkProgram() {
		LnkProgram.click();
	}

	// Link for Region
	@FindBy(xpath = "//h3[text()='Region']")
	public WebElement LnkRegion;

	public void ClickLnkRegion() {
		LnkRegion.click();
	}

	// Link for Role
	@FindBy(xpath = "//h3[text()='Role']")
	public WebElement LnkRole;

	public void ClickLnkRole() {
		LnkRole.click();
	}

	// -----------------------Organization and Sub Menus-----------------------
	// Organization Link
	@FindBy(xpath = "//a[text()='Organization']")
	// @FindBy(xpath="//h2/a[text()='Organization']")
	public WebElement LnkOrganization;

	public void ClickLnkOrganization() {
		/*
		 * try { JavascriptExecutor executor =
		 * (JavascriptExecutor)GlobalVar.Driver;
		 * executor.executeScript("arguments[0].click()", LnkOrganization);
		 * //LnkOrganization.click(); } catch(NoSuchElementException e) {
		 * e.printStackTrace(); }
		 */
		LnkOrganization.click();
	}

	// Link for account
	@FindBy(xpath = "//h3[text()='Account']")
	public WebElement LnkAccount;

	public void ClickLnkAccount() {
		/*
		 * try { JavascriptExecutor executor =
		 * (JavascriptExecutor)GlobalVar.Driver;
		 * executor.executeScript("arguments[0].click()", LnkAccount);
		 * //LnkAccount.click(); } catch(NoSuchElementException e) {
		 * e.printStackTrace(); }
		 */
		LnkAccount.click();
	}

	// Link for facility
	@FindBy(xpath = "//h3[text()='Facility']")
	public WebElement LnkFacility;

	public void ClickLnkFacility() {
		LnkFacility.click();
	}

	// Link for provider
	@FindBy(xpath = "//h3[text()='Provider']")
	public WebElement LnkProvider;

	public void ClickLnkProvider() {
		LnkProvider.click();
	}

	// Link for User
	@FindBy(xpath = "//h3[text()='User']")
	public WebElement LnkUser;

	public void ClickLnkUser() {
		LnkUser.click();
	}

	// Link for add user
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_btnAddUser']")
	public WebElement LnkbtnAddUser;

	public void ClickAddUser() {
		LnkbtnAddUser.click();
	}

	// ----------------Social Media and Sub menus----------------
	// Link for social media
	@FindBy(xpath = "//a[text()='Social Media']")
	public WebElement LnkSocialMedia;

	public void ClickLnkSocialMedia() {
		LnkSocialMedia.click();
	}

	// Link for committee
	@FindBy(xpath = "//h3[text()='Committee']")
	public WebElement LnkCommittee;

	public void ClickLnkCommittee() {
		LnkCommittee.click();
	}

	// Link for Forum
	@FindBy(xpath = "//h3[text()='Forum']")
	public WebElement LnkForum;

	public void ClickLnkForum() {
		LnkForum.click();
	}

	// Link for Webinar
	@FindBy(xpath = "//h3[text()='Webinar']")
	public WebElement LnkWebinar;

	public void ClickLnkWebinar() {
		LnkWebinar.click();
	}

	// ---------------------------Reports and SubMenu-------------------
	// Link for reports
	@FindBy(xpath = "//h3[text()='Reports']")
	public WebElement LnkReports;

	public void ClickLnkReports() {
		LnkReports.click();
	}

	// --------------------------Codes Maintenance And SubMenu---------------
	// Link for codes maintenance
	@FindBy(xpath = "//a[text()='Codes Maintenance']")
	public WebElement LnkCodesMain;

	public void ClickLnkCodesMain() {
		LnkCodesMain.click();
	}

	// -------------------------Document Admin and
	// SubMenu-----------------------
	// click on Document Admin Menu
	@FindBy(xpath = "//a[text()='Document Admin']")
	public WebElement ClkDocumentAdmin;

	public void ClickDocumentadminMenu() {
		ClkDocumentAdmin.click();
	}

	// Upload File
	@FindBy(xpath = "//h3[text()='Upload File']")
	public WebElement ClkUploadFile;

	public void ClickUploadFile() {
		ClkUploadFile.click();
	}

}
