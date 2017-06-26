package com.phm.hec.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public String getUsernamePassword(String filePath, String fileName, String sheetName, String environment,
			String module) throws Exception {

		System.out.println("Started reading xl file for user name");
		File file = new File(filePath + File.separator + fileName);
		System.out.println("File = " + filePath + File.separator + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook myWorkbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			myWorkbook = new XSSFWorkbook(inputStream);
			System.out.println("File extension is XLSX");
		} else if (fileExtensionName.equals(".xls")) {
			myWorkbook = new HSSFWorkbook(inputStream);
			System.out.println("File extension is XLS");
		}

		Sheet mySheet = myWorkbook.getSheet(sheetName);
		int rowCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
		System.out.println(rowCount);

		for (int i = 0; i < rowCount + 1; i++) {

			Row row = mySheet.getRow(i);
			String xlsEnvironment = row.getCell(2).getStringCellValue();
			String xlsModule = row.getCell(3).getStringCellValue();
			// System.out.println("Before Compare Environment value :" +
			// environment + " Module Value = " + module);
			// if (row.getCell(2).getStringCellValue().equals(environment) &&
			// row.getCell(3).getStringCellValue().equals(module)){
			if (xlsEnvironment.equalsIgnoreCase(environment) && xlsModule.equalsIgnoreCase(module)) {
				String xlsUsername = row.getCell(0).getStringCellValue();

				String xlsPassword = row.getCell(1).getStringCellValue();

				GlobalVar.LoginUsername = xlsUsername;
				GlobalVar.LoginPassword = xlsPassword;
				System.out.println("xlsUsername===" + GlobalVar.LoginUsername);
				System.out.println("xlsPassword===" + GlobalVar.LoginPassword);
				break;
			} else {

				// System.out.println("Environment = " + xlsEnvironment + "
				// Module = " + xlsModule);
			}

		}
		return GlobalVar.LoginUsername + "|" + GlobalVar.LoginPassword;
		// return module;
	}
}
