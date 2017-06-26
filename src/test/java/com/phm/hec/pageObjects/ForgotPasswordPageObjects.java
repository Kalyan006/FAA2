package com.phm.hec.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPageObjects {

	// Forgot Password landing page heading
	@FindBy(xpath = ".//*[@id='login_container']/h2")
	public WebElement lblForgotpasswordheader;

	public boolean lblForgotPasswordPresent() {
		boolean lblexist = lblForgotpasswordheader.isDisplayed();
		return lblexist;
	}

	// Forgot password Username
	@FindBy(id = "ContentPlaceHolder1_txtUserName")
	public WebElement txtFPUsername;

	public void EnterFPUsername(String Username) {
		txtFPUsername.sendKeys(Username);
		;
	}

	// Forgot password email
	@FindBy(id = "ContentPlaceHolder1_txtEmail")
	public WebElement txtFPemail;

	public void EnterFPEmail(String Email) {
		txtFPemail.sendKeys(Email);
	}

	// ---------Forgot Password Page Objects------------
	// Button Next in Forgot Password Page
	@FindBy(id = "ContentPlaceHolder1_btnNextfrgtPswd")
	public WebElement btnNextInFogotPassword;

	public void ClickNextbtnInForgotPassword() {
		btnNextInFogotPassword.click();
	}

	// Button Cancel in Forgot Password page
	@FindBy(id = "ContentPlaceHolder1_btnCancelfrgtPswd")
	public WebElement btnCancelInForgotPassword;

	public void ClickCancelInForgotpassword() {
		btnCancelInForgotPassword.click();
	}

	// Error message for the invalid user name
	@FindBy(id = "ContentPlaceHolder1_ValUserName")
	public WebElement lblFPValUserName;

	public String getFPValUserName() {
		return lblFPValUserName.getText();
	}

	// Error message for the Invalid Email ID
	@FindBy(id = "ContentPlaceHolder1_ValEmail")
	public WebElement lblFPValEmail;

	public String getFPValEmail() {
		return lblFPValEmail.getText();
	}

	// Error message for the Invalid User Name / Email ID
	@FindBy(id = "ContentPlaceHolder1_LblError")
	public WebElement lblFPValError;

	public String getFPValErroeMsg() {
		return lblFPValError.getText();
	}

	// -------------Forgot Password OTP Page Objects------------

	// Error label field for OTP Page
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_LblError']")
	public WebElement lblFPOTPErrorMsg;

	public String GetFPOTPErrMsg() {
		String FPOTPErrorMessage = lblFPOTPErrorMsg.getText();
		return FPOTPErrorMessage;
	}

	// OTP Field
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtOTP']")
	public WebElement txtOTP;

	public void EnterOTP(String OTP) {
		txtOTP.sendKeys(OTP);
	}

	// Check OTP field is available after pressing the next button in Forgot
	// Password Page
	public boolean TxtOTPPresent() {
		boolean txtOPTPresent = txtOTP.isDisplayed();
		return txtOPTPresent;
	}

	// Cancel button on Forgot Password OTP Page
	@FindBy(id = "ContentPlaceHolder1_btnCancelfrgtPswd")
	public WebElement btnCancelInFPOTP;

	public void ClickCancelBtnInFPOTP() {
		btnCancelInFPOTP.click();
	}

	// Next button on Forgot password OTP Page
	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_btnNextfrgtPswd']")
	public WebElement btnNextInForgotPasswordOTPPage;

	public void ClickNextbtnInForgotPasswordOTPPage() {
		btnNextInForgotPasswordOTPPage.click();
	}

	// Validation Text OTP - Error message for the OTP field Empty
	@FindBy(id = "ContentPlaceHolder1_ValtxtOTP")
	public WebElement lblFPOTPErrorMessage;

	public String getForgotPasswordOTPErrMsg() {
		return lblFPOTPErrorMessage.getText();
	}

	// Validation error message Forgot Password OTP

	@FindBy(id = "ContentPlaceHolder1_LblError")
	public WebElement lblFPOTPErrMsg;

	public String getFPRegenateErrMsg() {
		return lblFPOTPErrMsg.getText();
	}

	// Re-Generate OTP Button
	@FindBy(id = "ContentPlaceHolder1_btnRegenreateOTP")
	public WebElement btnFPGenerateOTP;

	public void ClickRegenerateOTP() {
		btnFPGenerateOTP.click();
	}

	// -----------Security Question Page objects---------------

	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_txtSecurityAnswer']")
	public WebElement txtSecurityQuestionAnswer;

	public void EnterSecurityQuestionAnswer(String SecurityAnswer) {
		txtSecurityQuestionAnswer.sendKeys(SecurityAnswer);
	}

	// Button Next in Security Question
	@FindBy(id = "ContentPlaceHolder1_btnSecurityNext")
	public WebElement btnNextInSecurityQuestion;

	public void ClickSecurityQuestionNext() {
		btnNextInSecurityQuestion.click();
	}

	@FindBy(xpath = "//h3[text()='Provider']")
	public WebElement btnFPNext;

	public void ClickNextbutton() {
		btnFPNext.click();
	}

	@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_btnCancelfrgtPswd']")
	public WebElement btnFPCancel;

	public void ClickCancelbutton() {
		btnFPCancel.click();
	}

	// ---------------------Change Password Page Objects ----------------------

	// Caption Change Password
	@FindBy(xpath = ".//*[@id='login_container']/h2")
	public WebElement lblChangePassword;

	public boolean islblChangePassword() {
		boolean lblChangePasswordPreent = lblChangePassword.isDisplayed();
		return lblChangePasswordPreent;
	}

	// New Password Field
	@FindBy(id = "ContentPlaceHolder1_txtNewPswd")
	public WebElement txtNewPassword;

	public void EnterNewPassword(String newpassword) {
		txtNewPassword.sendKeys(newpassword);
	}

	// Confirm Password Field
	@FindBy(id = "ContentPlaceHolder1_txtConfirmPswd")
	public WebElement txtConfirmPassword;

	public void EnterConfirmPassword(String confirmpwd) {
		txtConfirmPassword.sendKeys(confirmpwd);
	}

	// Text Verification Code
	@FindBy(id = "ContentPlaceHolder1_txtVerificationCode")
	public WebElement txtVerificationCode;

	public void EnterVerificationCode(String VerificationCode) {
		txtVerificationCode.sendKeys(VerificationCode);
	}

	// Reset Password Button
	@FindBy(id = "ContentPlaceHolder1_btnNextresetPswd")
	public WebElement btnResetPassword;

	public void ClickOnResetPassword() {
		btnResetPassword.click();
	}

	// Cancel Button in Change password reset page
	@FindBy(id = "ContentPlaceHolder1_btnCancelresetPswd")
	public WebElement btnCancelChangePWDReset;

	public void ClickonCancelChangePWDReset() {
		btnCancelChangePWDReset.click();
	}

	// -----------Password Reset Confirmation Page---------

	// Forgot password confirmation Message
	@FindBy(xpath = "//span[contains(text(),'Your password has been changed. ')")
	public WebElement lblForgotPasswordResetConfMsg;

	public String getForgotPWDConfirmationMsg() {
		String ForgotPWDcnfMsg = lblForgotPasswordResetConfMsg.getText();
		return ForgotPWDcnfMsg;
	}

	// Confirmation Page click here to login

	@FindBy(id = "LinkButton1")
	public WebElement lnkClickHere;

	public void ClickClickHere() {

		lnkClickHere.click();
	}

}
