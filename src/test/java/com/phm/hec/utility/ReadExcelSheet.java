package com.phm.hec.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet {
	public static HSSFWorkbook WBook = null;
	public static HSSFSheet WSheet = null;
	public static Object[][] data;

	public static HSSFSheet DataSheet(String FilePath, String SheetName) {
		File file = new File(FilePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			WBook = new HSSFWorkbook(fis);
			WSheet = WBook.getSheet(SheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return WSheet;
	}

	// RunModeVerification
	public static boolean RunModeVerification(String xlSheetName, String xlFilePath) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(
				new File("E:\\GitHub\\Selenium1\\framework001\\src\\test\\resources\\input\\inputcontroller.xlsx")));
		XSSFSheet TcSheetHome = workbook.getSheet(xlSheetName);
		int TcrowHome = TcSheetHome.getLastRowNum();
		for (int k = 1; k <= TcrowHome; k++) {
			String RunMode = TcSheetHome.getRow(k).getCell(2).getStringCellValue();
			String TCNameHome = TcSheetHome.getRow(k).getCell(0).getStringCellValue();
			if (RunMode.equals("Y") & TCNameHome.equals(xlSheetName)) {
				return true;
			}
		}
		return false;

	}

	// ***searching data sing run
	public static Object[][] collectSingleData(String xlSheetName, String xlFilePath) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(
				new File("E:\\GitHub\\Selenium1\\framework001\\src\\test\\resources\\input\\inputcontroller.xlsx")));
		XSSFSheet TcSheet = workbook.getSheet(xlSheetName);
		int TcRow = TcSheet.getLastRowNum();
		data = new Object[1][TcRow + 1];
		for (int i = 0; i <= TcRow; i++) {
			Cell Cell = TcSheet.getRow(i).getCell(5);
			TcSheet.getRow(i).getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			data[0][i] = TcSheet.getRow(i).getCell(5).getStringCellValue();
		}
		return data;
	}

}
