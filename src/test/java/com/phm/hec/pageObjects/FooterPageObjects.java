package com.phm.hec.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FooterPageObjects {

	// Leftfooter Image
	@FindBy(how = How.XPATH, using = "html/body/div[7]/footer/div[1]/div[1]/a/img")
	public WebElement imgLeftcornorFooter;

	// Login Page Version Number
	@FindBy(how = How.XPATH, using = ".//*[@id='IDVersion']")
	public WebElement lblPHMVersion;

	public void getPHMVersion() {
		lblPHMVersion.getText();
	}

}
