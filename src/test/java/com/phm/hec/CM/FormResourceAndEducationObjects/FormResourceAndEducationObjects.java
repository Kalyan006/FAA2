package com.phm.hec.CM.FormResourceAndEducationObjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormResourceAndEducationObjects {

		// click on care Manager Home Tab
		@FindBy(xpath = "//a[@id='lnkCareManager']")
		public WebElement LnkFREcaremgr;
		
		public void ClickOnCareManager() {
			LnkFREcaremgr.click();
		}

		// Click on Care Management Menu
		@FindBy(xpath = "//a[text()='Care Management']")
		public WebElement LnkFREcaremgt;
		
		public void ClickCareManagementMenu() {
			LnkFREcaremgt.click();

		}

		// click on Form Resource And Education Sub Menu under care management.
		@FindBy(xpath = "//h3[text()='Forms, Resources and Education']")
		public WebElement LnkFREformEdu;
		
		public void ClickFormResourceEducation() {
			LnkFREformEdu.click();
		}

		// ..........Click on frequently asked question tab............

		@FindBy(xpath = ".//*[@id='data1']/a")
		public WebElement LnkFAQ;
		
		public void ClickFAQ() {
			LnkFAQ.click();
		}
		
		// Count the Number of Row of FAQ
		@FindBy(xpath = ".//*[@id='content_inner']/div[3]/table/tbody/tr")
		public List<WebElement> LstFaqCount;
		
		public int LstFaqRowCount() {
			int LstFaqcounts = LstFaqCount.size() - 1;
			return LstFaqcounts;
		}

		// Count the number of Records in FAQ...
		@FindBy(xpath = ".//*[@id='content_inner']/div[3]/div")
		public WebElement LblFaqCount;
		
		public String LblFaqRecordsCountText() {
			String LblFaqCounttxt = LblFaqCount.getText();
			return LblFaqCounttxt;
		}
		
		// .......... Click on Forms and Templates tab..........
		
		@FindBy(xpath = ".//*[@id='data2']/a")
		public WebElement LnkFAT;
		
		public void ClickFormAndTemplate() {
			LnkFAT.click();
		}

		// Count The Number Of Row Of Form And Template
		@FindBy(xpath = ".//*[@id='content_inner']/div[4]/table/tbody/tr")
		public List<WebElement> LstFaTCount;
		
		public int LstFormAndTempRowCount() {
			int LstFatrecords = LstFaTCount.size() - 1;
			return LstFatrecords;

		}
		// Count the Records of Forms And Template.........
		@FindBy(xpath = ".//*[@id='content_inner']/div[4]/div")
		public WebElement LblFaTCount;
		
		public String LblFormAndTempRecordsCountText() {
			String LblFaTCounttxt = LblFaTCount.getText();
			return LblFaTCounttxt;
		}
		
		// ..........Click on Reference Guide Tab............
		
		@FindBy(xpath = ".//*[@id='data3']/a")
		public WebElement LnkRefGuide;
		
		public void ClickRefernceGuides() {
			LnkRefGuide.click();
		}

		// Count The number of Row Of Reference Guide
		@FindBy(xpath = ".//*[@id='content_inner']/div[5]/table/tbody/tr")
		public List<WebElement> LstRefGuideCount;
		
		public int LstReferenceGuideRowCount() {
			int LstRefGuiderecords = LstRefGuideCount.size() - 1;
			return LstRefGuiderecords;
		}

		// Count The Number Of Records in Reference Guides
		@FindBy(xpath = ".//*[@id='content_inner']/div[5]/div")
		public WebElement LblRefGuideCount;
		
		public String LblReferenceGuideRecordsCountText() {
			String LblRefGuideCounttxt = LblRefGuideCount.getText();
			return LblRefGuideCounttxt;
		}
		
		// ..........Click on EMR Education..........
		
		@FindBy(xpath = ".//*[@id='data4']/a")
		public WebElement LnkEMREducation;
		
		public void ClickEMREducation() {
			LnkEMREducation.click();
		}

		// Count The Number Of Row of EMR Education
		@FindBy(xpath = ".//*[@id='content_inner']/div[6]/table/tbody/tr")
		public List<WebElement> LstEMREducationCount;
		
		public int LstEMREducationRowCount() {
			int LstEMREducationrecords = LstEMREducationCount.size() - 1;
			return LstEMREducationrecords;
		}

		// Count the Number Of Records of EMR Education
		@FindBy(xpath = ".//*[@id='content_inner']/div[6]/div")
		public WebElement LblEMREducationCount;
		
		public String LblEMREducationRecordsCountText() {
			String LblEMREducationtxt = LblEMREducationCount.getText();
			return LblEMREducationtxt;
		}
		
		// ..........Click on Webinars tab..........
		
		@FindBy(xpath = ".//*[@id='data5']/a")
		public WebElement LnkWebnrs;
		
		public void ClickWebinars() {
			LnkWebnrs.click();
		}
		
		// Count the Number Of row Of Webinars
		@FindBy(xpath = ".//*[@id='content_inner']/div[7]/table/tbody/tr")
		public List<WebElement> LstWebinarsCount;
		
		public int LstWebinarsRowCount() {
			int LstWebinarsrecords = LstWebinarsCount.size() - 1;
			return LstWebinarsrecords;
		}

		// Count the Number of Records of Webinars
		@FindBy(xpath = ".//*[@id='content_inner']/div[7]/div")
		public WebElement LblWebinarsCount;
		
		public String LblWebinarsRecordsCountText() {
			String LblWebinarsCounttxt = LblWebinarsCount.getText();
			return LblWebinarsCounttxt;
		}
		
		// ...............Click on Decisions Aids................
		
		@FindBy(xpath = ".//*[@id='data6']/a")
		public WebElement LnkDecisionAids;
		
		public void ClickDecisionsAids() {
			LnkDecisionAids.click();
		}

		// Count The Number Of row In Decisions Aids
		@FindBy(xpath = ".//*[@id='content_inner']/div[8]/table/tbody/tr")
		public List<WebElement> LstDecisionAidsCount;
		
		public int LstDecisionsAidsRowCount() {
			int LstDecisionAidsrecords = LstDecisionAidsCount.size() - 1;
			return LstDecisionAidsrecords;
		}

		// Count the Number of Records in Decisions Aids
		@FindBy(xpath = ".//*[@id='content_inner']/div[8]/div")
		public WebElement LblDecisionAidsCount;
		
		public String LblDecisionAidsRecordsCountText() {
			String LblDecisionAidsCounttxt = LblDecisionAidsCount.getText();
			return LblDecisionAidsCounttxt;
		}
		
		//............ Click on Handouts Tab...............
		
		@FindBy(xpath = ".//*[@id='data7']/a")
		public WebElement ftLnkhandouts;
		
		public void ClickHandouts() {
			ftLnkhandouts.click();
		}

		// Count the number of Row in handouts
		@FindBy(xpath = ".//*[@id='content_inner']/div[9]/table/tbody/tr")
		public List<WebElement> LsthandoutsCount;
		
		public int LsthandoutsRowCount() {
			int LsthandoutsCountrecords = LsthandoutsCount.size() - 1;
			return LsthandoutsCountrecords;
		}

		// Count the number of Records in Handouts
		@FindBy(xpath = ".//*[@id='content_inner']/div[9]/div")
		public WebElement LblhandoutsCount;
		
		public String LblhandoutsRecordsCountText() {
			String LblhandoutsCounttxt = LblhandoutsCount.getText();
			return LblhandoutsCounttxt;
		}

		// Check the Level in CM App Based on Next Tab..
		@FindBy(xpath = "//div[@class='paging']")
		public List<WebElement> LblPresent;
    }
