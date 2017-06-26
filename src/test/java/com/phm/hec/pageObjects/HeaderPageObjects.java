package com.phm.hec.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPageObjects {

	// InterMediate Page Link for Logout
	@FindBy(xpath = ".//*[@id='lnkBtnLogout']/img")
	public WebElement INMLogoutLink;

	public void InmPageLogout() {
		INMLogoutLink.click();
	}

	// Forms Resource and Education page logout
	// *[@id="top_links"]/a[7]/img
	// <img src="images/logout.png" alt="Logout" title="Logout">
	// @FindBy(xpath="//*[@id="top_links"]/a[7]/img")
	@FindBy(xpath = "//img[@title='Logout']")
	public WebElement FREPageLogout;

	public void FREPageLogout() {
		FREPageLogout.click();
	}

	// Link for PHM icon
	@FindBy(xpath = "//img[@title='Take me to PHM']")
	public WebElement PhmLnk;

	public void ClickPHM() {
		PhmLnk.click();
	}

	// Link for home
	@FindBy(xpath = "//img[@title='Home']")
	public WebElement HomeLnk;

	public void ClickHome() {
		HomeLnk.click();
	}

	@FindBy(how = How.XPATH, using = ".//*[@id='txtLogin']")
	public WebElement txtuserName;

	// PD Page Link for Logout
	@FindBy(xpath = ".//*[@id='top_links']/a[3]/img")
	public WebElement pdlogout;

	public void PDLogout() {
		pdlogout.click();
	}

}
