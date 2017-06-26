package com.phm.hec.PEC.FormResourceAndEducationObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PecFormResourceAndEducationObjects {

		// Forms Resource And Education Image
		//@FindBy(xpath = "(//img[@id='img1'])[3]")
		@FindBy(xpath="//div[2]/div[3]/div/div[4]/span[3]")
		public WebElement LnkformsResourceEducation;

		public void ClickFormsResourceAndEducation() {
			LnkformsResourceEducation.click();

		}

		// .......... Frequently Asked Question....................
		//Click on FAQ Tab
		@FindBy(xpath = ".//*[@id='data1']/a")
		public WebElement LnkFrequentlyAskedQuestion;

		public void ClickFrequentlyAskedQuestion() {
			LnkFrequentlyAskedQuestion.click();
		}

		// count the number of Row of FAQ
		@FindBy(xpath = ".//*[@id='content_inner']/div[4]/table/tbody/tr")
		public List<WebElement> LstFaqCount;

		public int LstFaqRowCount() {
			int LstFaqcounts = LstFaqCount.size() - 1;
			return LstFaqcounts;
		}

		// Count the number of Records in FAQ...
		@FindBy(xpath = ".//*[@id='content_inner']/div[4]/div")
		public WebElement LblFaqCount;

		public String LblFaqRecordsCountText() {
			String LblFaqCounttxt = LblFaqCount.getText();
			return LblFaqCounttxt;
		}
		
		// ............. Forms And Templates.....................
		//Click on FAT Tab
		@FindBy(xpath = ".//*[@id='data2']/a")
		public WebElement LnkformsAndTemplates;

		public void ClickFormsAndTemplates() {
			LnkformsAndTemplates.click();
		}

		// Count The Number Of Row Of Form And Template
		@FindBy(xpath = ".//*[@id='content_inner']/div[5]/table/tbody/tr")
		public List<WebElement> LstFaTCount;

		public int LstFormAndTempRowCount() {
			int LstFatrecords = LstFaTCount.size() - 1;
			return LstFatrecords;

		}

		// Count the Records of Forms And Template
		@FindBy(xpath = ".//*[@id='content_inner']/div[5]/div")
		public WebElement LblFaTCount;

		public String LblFormAndTempRecordsCountText() {
			String LblFaTCounttxt = LblFaTCount.getText();
			return LblFaTCounttxt;
		}

		// .................... Reference Guides.....................
		//Click on Reference Guides Tab
		@FindBy(xpath = ".//*[@id='data3']/a")
		public WebElement LnkReferenceGuides;

		public void ClickReferenceGuides() {
			LnkReferenceGuides.click();
		}

		// Count The number of Row Of Reference Guide
		@FindBy(xpath = ".//*[@id='content_inner']/div[6]/table/tbody/tr")
		public List<WebElement> LstRefGuideCount;

		public int LstReferenceGuideRowCount() {
			int LstRefGuiderecords = LstRefGuideCount.size() - 1;
			return LstRefGuiderecords;
		}

		// Count The Number Of Records in Reference Guides
		@FindBy(xpath = ".//*[@id='content_inner']/div[6]/div")
		public WebElement LblRefGuideCount;

		public String LblReferenceGuideRecordsCountText() {
			String LblRefGuideCounttxt = LblRefGuideCount.getText();
			return LblRefGuideCounttxt;
		}

		// .............. EMR Education......................
		//Click on EMR Education Tab
		@FindBy(xpath = ".//*[@id='data4']/a")
		public WebElement LnkEMREducation;

		public void ClickEMREduction() {
			LnkEMREducation.click();
		}

		// Count The Number Of Row of EMR Education
		@FindBy(xpath = ".//*[@id='content_inner']/div[7]/table/tbody/tr")
		public List<WebElement> LstEMREducationCount;

		public int LstEMREducationRowCount() {
			int LstEMREducationrecords = LstEMREducationCount.size() - 1;
			return LstEMREducationrecords;
		}

		// Count the Number Of Records of EMR Education......
		@FindBy(xpath = ".//*[@id='content_inner']/div[7]/div")
		public WebElement LblEMREducationCount;

		public String LblEMREducationRecordsCountText() {
			String LblEMREducationtxt = LblEMREducationCount.getText();
			return LblEMREducationtxt;
		}

		//............... Webinars....................
		//Click on Webinars Tab
		@FindBy(xpath = ".//*[@id='data5']/a")
		public WebElement LnkWebinars;

		public void ClickWebinars() {
			LnkWebinars.click();
		}

		// Count the Number Of row Of Webinars
		@FindBy(xpath = ".//*[@id='content_inner']/div[8]/table/tbody/tr")
		public List<WebElement> LstWebinarsCount;

		public int LstWebinarsRowCount() {
			int LstWebinarsrecords = LstWebinarsCount.size() - 1;
			return LstWebinarsrecords;

		}

		// Count the Number of Records of Webinars...
		@FindBy(xpath = ".//*[@id='content_inner']/div[8]/div")
		public WebElement LblWebinarsCount;

		public String LblWebinarsRecordsCountText() {
			String LblWebinarsCounttxt = LblWebinarsCount.getText();
			return LblWebinarsCounttxt;
		}

		//.............. Decision Aids..............
		//Click on Decision Aids Tab
		@FindBy(xpath = ".//*[@id='data6']/a")
		public WebElement LnkDecisionAids;

		public void ClickDecisionAids() {
			LnkDecisionAids.click();
		}

		// Count The Number Of row In Decisions Aids
		@FindBy(xpath = ".//*[@id='content_inner']/div[9]/table/tbody/tr")
		public List<WebElement> LstDecisionAidsCount;

		public int LstDecisionsAidsRowCount() {
			int LstDecisionAidsrecords = LstDecisionAidsCount.size() - 1;
			return LstDecisionAidsrecords;
		}

		// Count the Number of Records in Decisions Aids...
		@FindBy(xpath = ".//*[@id='content_inner']/div[9]/div")
		public WebElement LblDecisionAidsCount;

		public String LblDecisionAidsRecordsCountText() {
			String LblDecisionAidsCounttxt = LblDecisionAidsCount.getText();
			return LblDecisionAidsCounttxt;
		}

		//............... Handouts............

		@FindBy(xpath = ".//*[@id='data7']/a")
		public WebElement LnkHandouts;

		public void ClickHandouts() {
			LnkHandouts.click();
		}

		// Count the number of Row in handouts
		@FindBy(xpath = ".//*[@id='content_inner']/div[10]/table/tbody/tr")
		public List<WebElement> LsthandoutsCount;

		public int LsthandoutsRowCount() {
			int LsthandoutsCountrecords = LsthandoutsCount.size() - 1;
			return LsthandoutsCountrecords;
		}

		// Count the number of Records in Handouts
		@FindBy(xpath = ".//*[@id='content_inner']/div[10]/div")
		public WebElement LblhandoutsCount;

		public String LblhandoutsRecordsCountText() {
			String LblhandoutsCounttxt = LblhandoutsCount.getText();
			return LblhandoutsCounttxt;
		}

	}
