package com.phm.hec.uploadFilePageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.phm.hec.utility.GlobalVar;
import com.phm.hec.utility.GenericUtils;

public class UploadFileObjects {

		public static boolean value = false;
		GenericUtils genutil = new GenericUtils();
		
		// Enter User Name
		@FindBy(id = "ContentPlaceHolder1_txtUserName")
		public WebElement txtusername;
		
		public void Enterusername(String username) {
			txtusername.sendKeys(username);
		}

		// Enter File Name
		@FindBy(id = "ContentPlaceHolder1_txtFileName")
		public WebElement txtfilename;
		
		public void Enterfilename(String filename) {
			txtfilename.sendKeys(filename);
		}
		
		//clear text data
		public void Cleartextdata() {
			txtfilename.clear();
		}

		// Pick Data From Document Category
		@FindBy(id = "ContentPlaceHolder1_ddlDocCategory")
		public WebElement ddlDocCategory;
		
		public void SelectDocumentCatagory(String txt) {
			GenericUtils.selectDdlByVisibleText(ddlDocCategory, txt);
		}

		// Click on Search Document Button
		@FindBy(id = "ContentPlaceHolder1_btnSearchDocument")
		public WebElement btnSearchDocument;
		
		public void ClickbtnSearchDocument() {
			btnSearchDocument.click();
		}

		// Browse the File And Select the File From Location
		@FindBy(id = "FileUpload")
		public WebElement LnkUploadDoc;

		public void UploadFileDocument(String absolutefilepath) throws Exception {
			LnkUploadDoc.sendKeys(absolutefilepath);
		}

		// search the document category from drop down list for uploading
		@FindBy(id = "ContentPlaceHolder1_ddlCategory")
		public WebElement selectddlCategory;

		public void SelectDocCatagoryUpload(String txt) {
			GenericUtils.selectDdlByVisibleText(selectddlCategory, txt);
		}

		// click on upload button
		@FindBy(id = "ContentPlaceHolder1_btnUpload")
		public WebElement LnkUploadbtn;

		public void ClickUploadbtn() {
			LnkUploadbtn.click();
		}

		// delete the particular record from the list
		@FindBy(xpath = "//input[@value='Delete']")
		public WebElement btnDelete;

		public void deleterecordfromlist() {
			btnDelete.click();
			GenericUtils.acceptAlert(GlobalVar.Driver);
		}
		
		public void Clickdeletebutton(String filename) {
			String xp = "(//td[text()='" + filename + "'])[1]/../td[6]";
			GlobalVar.Driver.findElement(By.xpath(xp)).click();
			GenericUtils.acceptAlert(GlobalVar.Driver);
		}

		// Download the particular records
		@FindBy(xpath = "//input[@type='image']")
		public List<WebElement> btndownload;

		public void Selectdownloadlink(String filename) {
			String xp = "(//td[text()='" + filename + "'])[1]/../td[5]";
			GlobalVar.Driver.findElement(By.xpath(xp)).click();

		}
		
		// Verify Msg
		@FindBy(id = "ContentPlaceHolder1_lblMessage")
		public WebElement Errmsg;

		public Boolean verifyRecordPresentorNot() {
			WebDriverWait wait = new WebDriverWait(GlobalVar.Driver, 5);
			try {
				wait.until(ExpectedConditions.visibilityOf(Errmsg));
				Reporter.log("No matching records found for your selection ", true);
				return true;
			} catch (Exception e) {
					return false;
				}
		}

		// Define The Element For Records Count
		@FindBy(xpath = "//span[@id='ContentPlaceHolder1_lblRecordInfo1']")
		public WebElement uploaddoc;
		
		// Check Record Count Lable Present Or Not..
		@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_divgridRecordInfoTopLeft1']")
		public WebElement LblPresent;

		public boolean LblPresentOrNot() {
			try {
				LblPresent.isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
			

		}

	}
