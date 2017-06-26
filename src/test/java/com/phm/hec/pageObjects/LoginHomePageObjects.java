package com.phm.hec.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginHomePageObjects {

	// User name Text field in Login Screen
	@FindBy(how = How.XPATH, using = ".//*[@id='txtLogin']")
	public WebElement txtuserName;

	public void enterUserName(String userName) {
		this.txtuserName.sendKeys(userName);
	}

	// Password Field in Login Screen
	@FindBy(how = How.XPATH, using = ".//*[@id='txtPwd']")
	public WebElement txtPassword;

	public void enterPassword(String password) {
		this.txtPassword.sendKeys(password);
		System.out.println("Password Typed");
	}

	// Login button in Login screen
	@FindBy(how = How.XPATH, using = ".//*[@id='buttonlogin']")
	public WebElement btnLogin;

	public void clickLoginButton() {
		btnLogin.click();
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Forgot Password?']")
	public WebElement lnkforgotPassword;

	public void clickForgotPassword() {
		lnkforgotPassword.click();
	}

}
