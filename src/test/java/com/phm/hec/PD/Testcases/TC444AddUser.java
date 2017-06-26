package com.phm.hec.PD.Testcases;

import java.io.File;
import java.io.FileInputStream;

import javax.print.attribute.standard.PagesPerMinute;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.phm.hec.PD.AddUserPageObjects.AddUserAssignAccountPageObject;
import com.phm.hec.PD.AddUserPageObjects.AddUserAssignProviderPageObject;
import com.phm.hec.PD.AddUserPageObjects.AddUserAssignRegionPageObject;
import com.phm.hec.PD.AddUserPageObjects.AddUserAssignRolePageObject;
import com.phm.hec.PD.AddUserPageObjects.AddUserPageObject;
import com.phm.hec.PD.AdminPageObjects.ProviderAdminPageObjects;
import com.phm.hec.PD.ProviderPageObjects.AddProviderPageObjects;
import com.phm.hec.PD.ProviderPageObjects.AssignRegionPageObjects;
import com.phm.hec.pageObjects.IntermediatePageObjects;
import com.phm.hec.utility.GlobalVar;

public class TC444AddUser {
	@Test
	public static void AddUser() throws Throwable {
		IntermediatePageObjects IntMedPage = PageFactory.initElements(GlobalVar.Driver, IntermediatePageObjects.class);
		ProviderAdminPageObjects PAP = PageFactory.initElements(GlobalVar.Driver, ProviderAdminPageObjects.class);
		AddUserPageObject APO = PageFactory.initElements(GlobalVar.Driver, AddUserPageObject.class);
		AddProviderPageObjects appo = PageFactory.initElements(GlobalVar.Driver, AddProviderPageObjects.class);
		AddUserAssignRolePageObject arpo = PageFactory.initElements(GlobalVar.Driver,
				AddUserAssignRolePageObject.class);
		AddUserAssignAccountPageObject aapo = PageFactory.initElements(GlobalVar.Driver,
				AddUserAssignAccountPageObject.class);
		AddUserAssignProviderPageObject uapo = PageFactory.initElements(GlobalVar.Driver,
				AddUserAssignProviderPageObject.class);
		AddUserAssignRolePageObject uarpo = PageFactory.initElements(GlobalVar.Driver,
				AddUserAssignRolePageObject.class);
		AddUserAssignRegionPageObject auarpo = PageFactory.initElements(GlobalVar.Driver,
				AddUserAssignRegionPageObject.class);
		Thread.sleep(GlobalVar.threadSleep);
		IntMedPage.ClickProviderAdmin();
		PAP.ClickLnkUser();
		PAP.ClickAddUser();
		String filepath = GlobalVar.TestDataAddUserTC444FilePath;
		File AddUsersrc = new File(filepath);
		FileInputStream fis = new FileInputStream(AddUsersrc);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("PD_AddUser");
		int rows = sheet.getLastRowNum() + 1;
		int cols = sheet.getRow(1).getLastCellNum();
		for (int rownum = 1; rownum < rows; rownum++) {

			sheet.getRow(rownum).getCell(cols - 1).setCellType(Cell.CELL_TYPE_STRING);
			String executeyn = sheet.getRow(rownum).getCell(cols - 1).getStringCellValue();
			String ExecuteYN = executeyn.toUpperCase().trim();
			Boolean Execute = ExecuteYN.equals("YES");
			if (Execute == true) {
				sheet.getRow(rownum).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				String LastName = sheet.getRow(rownum).getCell(0).getStringCellValue();
				APO.EnterLastName(LastName);
				sheet.getRow(rownum).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				String FirstName = sheet.getRow(rownum).getCell(1).getStringCellValue();
				APO.EnterFirstName(FirstName);
				sheet.getRow(rownum).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				String EmailID = sheet.getRow(rownum).getCell(2).getStringCellValue();
				APO.EnterEmailAddress(EmailID);
				sheet.getRow(rownum).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				String PhoneNumber = sheet.getRow(rownum).getCell(3).getStringCellValue();
				APO.EnterPhoneNum(PhoneNumber);
				sheet.getRow(rownum).getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				String UserName = sheet.getRow(rownum).getCell(4).getStringCellValue();
				APO.EnterUserName(UserName);
				sheet.getRow(rownum).getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				String Password = sheet.getRow(rownum).getCell(5).getStringCellValue();
				APO.EnterPassword(Password);
				sheet.getRow(rownum).getCell(6).setCellType(Cell.CELL_TYPE_STRING);
				String Address1 = sheet.getRow(rownum).getCell(6).getStringCellValue();
				APO.EnterAddress1(Address1);
				sheet.getRow(rownum).getCell(7).setCellType(Cell.CELL_TYPE_STRING);
				String Address2 = sheet.getRow(rownum).getCell(7).getStringCellValue();
				APO.EnterAddress2(Address2);
				sheet.getRow(rownum).getCell(8).setCellType(Cell.CELL_TYPE_STRING);
				String CityName = sheet.getRow(rownum).getCell(8).getStringCellValue();
				APO.EnterCityName(CityName);
				/*
				 * sheet.getRow(rownum).getCell(9).setCellType(Cell.
				 * CELL_TYPE_STRING); String
				 * StateName=sheet.getRow(rownum).getCell(9).getStringCellValue(
				 * ); APO.SelectState(StateName);
				 */
				sheet.getRow(rownum).getCell(10).setCellType(Cell.CELL_TYPE_STRING);
				String ZipCode = sheet.getRow(rownum).getCell(10).getStringCellValue();
				APO.EnterZipCode(ZipCode);
				sheet.getRow(rownum).getCell(11).setCellType(Cell.CELL_TYPE_STRING);
				String TitalName = sheet.getRow(rownum).getCell(11).getStringCellValue();
				APO.EnterTitle(TitalName);
				sheet.getRow(rownum).getCell(12).setCellType(Cell.CELL_TYPE_STRING);
				String PhoneNumber1 = sheet.getRow(rownum).getCell(12).getStringCellValue();
				APO.EnterPhoneNumber1(PhoneNumber1);
				sheet.getRow(rownum).getCell(13).setCellType(Cell.CELL_TYPE_STRING);
				String PhoneNumber2 = sheet.getRow(rownum).getCell(13).getStringCellValue();
				APO.EnterPhoneNumber2(PhoneNumber2);
				sheet.getRow(rownum).getCell(14).setCellType(Cell.CELL_TYPE_STRING);
				String FaxNumber = sheet.getRow(rownum).getCell(14).getStringCellValue();
				APO.EnterFaxNumber(FaxNumber);
				sheet.getRow(rownum).getCell(15).setCellType(Cell.CELL_TYPE_STRING);
				String Responsibility = sheet.getRow(rownum).getCell(15).getStringCellValue();
				APO.EnterResponsibility(Responsibility);
				APO.ClickAssignRegion();
				appo.switchToWindowByIndex(1);
				sheet.getRow(rownum).getCell(16).setCellType(Cell.CELL_TYPE_STRING);
				String RegionCode = sheet.getRow(rownum).getCell(16).getStringCellValue();
				auarpo.EnterRegionCode(RegionCode);
				auarpo.ClickSearchRegion();
				auarpo.SelectChkBox();
				auarpo.ClickAssignRegion();
				Thread.sleep(GlobalVar.threadSleep);
				appo.switchToWindowByIndex(0);
				APO.ClickAssignAccount();
				appo.switchToWindowByIndex(1);
				sheet.getRow(rownum).getCell(17).setCellType(Cell.CELL_TYPE_STRING);
				String TaxID = sheet.getRow(rownum).getCell(17).getStringCellValue();
				appo.EnterTaxId(TaxID);
				aapo.ClickSearchAccount();
				aapo.ClickCheckBox();
				aapo.ClickAssignAccount();

				/*
				 * APO.EnterLastName("Test"); APO.EnterFirstName("Test");
				 * APO.EnterEmailAddress("Himanshu.srivastava@healthec.com");
				 * APO.EnterPhoneNum("1234567891");
				 * APO.EnterUserName("User1234");
				 * APO.EnterPassword("Password@1"); APO.EnterAddress1("TEst");
				 * APO.EnterAddress2("Test"); APO.EnterCityName("Test");
				 * //APO.SelectState("ALASKA"); APO.EnterZipCode("12345");
				 * APO.EnterTitle("Mr"); APO.EnterPhoneNumber1("1234567891");
				 * APO.EnterPhoneNumber2("1234567891");
				 * APO.EnterAddress2("1234567891");
				 * APO.EnterFaxNumber("1234567891");
				 * APO.EnterResponsibility("TEst"); APO.ClickAssignRegion();
				 * appo.switchToWindowByIndex(1);
				 * auarpo.EnterRegionCode("A2105S"); auarpo.ClickSearchRegion();
				 * auarpo.SelectChkBox(); auarpo.ClickAssignRegion();
				 * Thread.sleep(GlobalVar.threadSleep);
				 * appo.switchToWindowByIndex(0); APO.ClickAssignAccount();
				 * appo.switchToWindowByIndex(1); aapo.EnterTaxID("223762143");
				 * aapo.ClickSearchAccount(); aapo.ClickCheckBox();
				 * aapo.ClickAssignAccount();
				 * Thread.sleep(GlobalVar.threadSleep);
				 * appo.switchToWindowByIndex(0); APO.ClickAssinProvidert();
				 * appo.switchToWindowByIndex(1); uapo.EnterNPI("1922008812");
				 * uapo.ClickSearchProvider(); uapo.SelectCheckBox();
				 * uapo.ClickAssignProvider();
				 * Thread.sleep(GlobalVar.threadSleep);
				 * appo.switchToWindowByIndex(0); APO.ClickAssinRole();
				 * appo.switchToWindowByIndex(1);
				 * uarpo.EnterRoleName("Beneficiary Admin");
				 * uarpo.ClickSearchRole(); uarpo.SelectRoleHandIcon();
				 * appo.switchToWindowByIndex(0);
				 * Thread.sleep(GlobalVar.threadSleep); APO.SelectWlcmChkBox();
				 * APO.SelectResetPwdChkBox(); APO.SelectWlcmChkBox();
				 * APO.SelectDisableButton(); // APO.ClickSaveUser();
				 */

			}
		}
	}
}