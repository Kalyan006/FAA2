package com.phm.hec.PD.RolePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.phm.hec.utility.GenericUtils;
import com.phm.hec.utility.GlobalVar;

public class RolePageObjects {

		GenericUtils GenUtil = new GenericUtils();
		// Enter the Role Name
		@FindBy(id = "ContentPlaceHolder1_TxtRoleName")
		public WebElement TxtRolename;
		
		public void EnterRoleName(String rolename) {
			TxtRolename.sendKeys(rolename);
		}

		// Click On Role Search Button
		@FindBy(xpath = ".//*[@id='ContentPlaceHolder1_btnSearchRole']")
		public WebElement ClksearchRole;
		public void ClickSearchRole() {
			ClksearchRole.click();
		}

		// click on Grid Role List
		@FindBy(id = "ContentPlaceHolder1_gridRoleList_imgSetup_0")
		public WebElement Clkgridrole;
		
		public void ClickGridRoleList() {
			Boolean elePresent = GenUtil.isElementPresent(By.id("ContentPlaceHolder1_gridRoleList_imgSetup_0"));
			if ((Boolean.TRUE.equals(elePresent))){
				
				Clkgridrole.click();
				Reporter.log("Grid Role list option exist",true);
			}
			else
			{
				Reporter.log("Grid Role list option not exist",true);
			}

		}

		// Select Associate Product Name From The Drop Down
		@FindBy(id = "ContentPlaceHolder1_drAssProductNames")
		public WebElement SelectAssProduct;
		
		public void SelectAssociateProductNames(String txt) {
			GenericUtils.selectDdlByVisibleText(SelectAssProduct, txt);
		}

		// Select the Particular Checked Box
		@FindBy(xpath = ".//*[@id='content_inner']/table/tbody/tr[7]/td[1]/input")
		public WebElement Clkcheckbox;
		
		public void ClickCheckBox() {
			Clkcheckbox.click();
		}

		// Select the check box for Care management menu in role setup
		// @FindBy(xpath=".//*[@id='content_inner']/table/tbody/tr[3]/td[1]/input")
		@FindBy(xpath = "//label[contains(text(),'Care Management')]/..//input[@type='checkbox']")
		public WebElement ClkCaremgtchkbox;
		
		public void ClickCareManagementcheckbox() {
			ClkCaremgtchkbox.click();

		}

		// select the check box for forms,resources and education sub menu in role setup
		// @FindBy(xpath=".//*[@id='content_inner']/table/tbody/tr[3]/td[2]/input[9]")
		//@FindBy(xpath = "//label[contains(text(),'Forms, Resources and Education')]/..//input[@type='checkbox']")
		//@FindBy(xpath="((//label[.='Care Management']/../../td[2])//input[@type='checkbox'])[position()=1 or position()=last()]")
		public WebElement ClkformsEdusubmenu;
		
		public void ClickFormResourceEducationSubMenu() {
			ClkformsEdusubmenu.click();
		}

		// click on save button
		@FindBy(id = "ContentPlaceHolder1_btnSave")
		public WebElement btnSave;
		
		public void ClickbtnSave() {
			btnSave.click();
		}

	}
