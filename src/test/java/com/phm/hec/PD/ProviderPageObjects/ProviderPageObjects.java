package com.phm.hec.PD.ProviderPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.phm.hec.utility.GenericUtils;

public class ProviderPageObjects {

	// Provider page provider last name text field.
	@FindBy(id = "ContentPlaceHolder1_txtLastName")
	public WebElement TxtLastName;

	public void EnterProviderLastName(String lastname) {
		TxtLastName.sendKeys(lastname);
	}

	// Provider page provider first name text field.
	@FindBy(id = "ContentPlaceHolder1_txtFirstName")
	public WebElement TxtFirstName;

	public void EnterProviderFirstName(String firstname) {
		TxtFirstName.sendKeys(firstname);
	}

	// Provider page provider ddl status field.
	@FindBy(id = "ContentPlaceHolder1_ddlStatus")
	public WebElement DdlProviderStatus;

	public void ClickProviderStatus(int index) {
		GenericUtils.selectDdlByIndex(DdlProviderStatus, index);
	}

	// Provider page provider NPI text field.
	@FindBy(id = "ContentPlaceHolder1_txtNPI")
	public WebElement TxtProviderNpi;

	public void EnterProviderNpi(String npi) {
		TxtProviderNpi.sendKeys(npi);
	}

	// Provider page provider tax id text field.
	@FindBy(id = "ContentPlaceHolder1_txtFederalTaxId")
	public WebElement TxtProviderTaxId;

	public void EnterProviderTaxId(String taxid) {
		TxtProviderTaxId.sendKeys(taxid);
	}

	// Provider page provider State Assigned id text field.
	@FindBy(id = "ContentPlaceHolder1_txtUMPI")
	public WebElement TxtPdrStateAssignedId;

	public void EnterPdrStateAssignedId(String StateAssignedId) {
		TxtPdrStateAssignedId.sendKeys(StateAssignedId);
	}

	// Provider page provider Region Code ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlACOList")
	public WebElement DdlRegionCode;

	public void ClickPdrRegionCode(int index) {
		GenericUtils.selectDdlByIndex(DdlRegionCode, index);
	}

	// Provider page Region Provider Status ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlRegionProviderStatus")
	public WebElement DdlRegionStatus;

	public void ClickRegionStatus(int index) {
		GenericUtils.selectDdlByIndex(DdlRegionStatus, index);
	}

	// Provider page Provider source ddl field.
	@FindBy(id = "ContentPlaceHolder1_ddlProviderSource")
	public WebElement DdlProviderSource;

	public void ClickProviderSource(int index) {
		GenericUtils.selectDdlByIndex(DdlProviderSource, index);
	}

	// Provider page Provider user name text field.
	@FindBy(id = "ContentPlaceHolder1_txtUserName")
	public WebElement TxtUserName;

	public void EnterUserName(String UserName) {
		TxtUserName.sendKeys(UserName);
	}

	// Provider page Provider Account name text field.
	@FindBy(id = "ContentPlaceHolder1_txtAssignAccount")
	public WebElement TxtAccountName;

	public void EnterAccountName(String AccountName) {
		TxtAccountName.sendKeys(AccountName);
	}

	// Provider page Provider img Account name text field.
	@FindBy(id = "ContentPlaceHolder1_imgbtnAccount")
	public WebElement BtnImgAccountName;

	public void ClickImgAccountName() {
		BtnImgAccountName.click();
	}

	// Provider page search provider button field.
	@FindBy(id = "ContentPlaceHolder1_btnSearchProvider")
	public WebElement BtnSearchProvider;

	public void ClickSearchProvider() {
		BtnSearchProvider.click();
	}

	// Provider page clear provider button field.
	@FindBy(id = "ContentPlaceHolder1_btnClearProvider")
	public WebElement BtnClearProvider;

	public void ClickClearProvider() {
		BtnClearProvider.click();
	}

	// Provider page Add provider button field.
	@FindBy(id = "ContentPlaceHolder1_btnAddProvider")
	public WebElement BtnAddProvider;

	public void ClickAddProvider() {
		BtnAddProvider.click();
	}

}
