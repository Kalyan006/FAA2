package com.phm.hec.PD.Testcases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.phm.hec.BM.PageObject.BMPageObject;
import com.phm.hec.pageObjects.IntermediatePageObjects;
import com.phm.hec.utility.GenericUtils;
import com.phm.hec.utility.GlobalVar;

public class TC767ChangeAccount {
	public static Logger addlog = Logger.getLogger(TC767ChangeAccount.class.getName());

	@Test
	public static void ChangeAccount() throws Throwable {
		Logger logger = addlog;
		try {
			IntermediatePageObjects INM = PageFactory.initElements(GlobalVar.Driver, IntermediatePageObjects.class);
			BMPageObject BMP = PageFactory.initElements(GlobalVar.Driver, BMPageObject.class);

			Thread.sleep(GlobalVar.threadSleep);

			INM.ClickOnBeneficiaryManagmentLink();
			BMP.ClickBeneficiaryAttributionMenu();

			Thread.sleep(GlobalVar.threadSleep);

			BMP.ClickBeneficiaryAttributionSubMenu();

			BMP.ClickDropDown();

			BMP.ClickDropDownCheckBoxBM();

			String filepath = GlobalVar.TestDataChangeAccountTC767FilePath;
			logger.info("File Path : " + filepath);
			// Data Driver starting

			File ChangeProvidersrc = new File(filepath);
			FileInputStream fis = new FileInputStream(ChangeProvidersrc);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("ChangeAccount");
			logger.info(sheet);
			int rows = sheet.getLastRowNum() + 1;
			int cols = sheet.getRow(1).getLastCellNum();
			logger.info("Rows :" + rows + "|| Columns : " + cols);
			for (int rownum = 1; rownum < rows; rownum++)

			{
				sheet.getRow(rownum).getCell(cols - 1).setCellType(Cell.CELL_TYPE_STRING);
				String executeyn = sheet.getRow(rownum).getCell(cols - 1).getStringCellValue();
				String ExecuteYN = executeyn.toUpperCase().trim();
				logger.info("Execute the Row " + rownum + " = " + ExecuteYN);
				Boolean Execute = ExecuteYN.equals("YES");
				logger.info(Execute);
				if (Execute == true) {

					sheet.getRow(rownum).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					String MemberID = sheet.getRow(rownum).getCell(0).getStringCellValue();
					logger.info(MemberID);

					BMP.ClickMemberIDBoxBM(MemberID);

					BMP.ClickSearchButtonBM();

				}

			}
		} catch (Exception e) {

		}
	}
}
