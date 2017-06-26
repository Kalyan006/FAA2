package com.phm.hec.utility;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GenericUtils {

	private boolean acceptNextAlert = true;

	// private StringBuffer verificationErrors = new StringBuffer();
	// Select class select by index
	public static void selectDdlByIndex(WebElement ddl, int index) {
		Select sct = new Select(ddl);
		sct.selectByIndex(index);
	}

	// select class select by value
	public static void selectDdlByValue(WebElement ddl, String value) {
		Select sct = new Select(ddl);
		sct.selectByValue(value);
	}

	// select class select by visible text
	public static void selectDdlByVisibleText(WebElement ddl, String visibleText) {
		Select sct = new Select(ddl);
		sct.selectByVisibleText(visibleText);
	}

	// Select class deselect by index
	public static void deselectByIndex(WebElement ddl, int index) {
		Select sct = new Select(ddl);
		sct.deselectByIndex(index);
	}

	// Select class deselect by value
	public static void deselectByValue(WebElement ddl, String value) {
		Select sct = new Select(ddl);
		sct.deselectByValue(value);
	}

	// Select class deselect by visible text
	public static void deselectByVisibleText(WebElement ddl, String visibleText) {
		Select sct = new Select(ddl);
		sct.deselectByVisibleText(visibleText);
	}

	// Select class deselect by all
	public static void deselectAll(WebElement ddl) {
		Select sct = new Select(ddl);
		sct.deselectAll();
	}

	// Pop up accept
	public static void acceptAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}

	// Pop up dismiss
	public static void dismiss(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}

	// Pop up enter text
	public static void enterText(WebDriver driver, String text) {
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(text);
	}

	// Pop up get alert text
	public static String getAlertText(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		String data = alt.getText();
		return data;
	}

	// Switch to parent window to child window
	public void switchToWindowByIndex(int index) {
		int count = 0;
		Set<String> windows = GlobalVar.Driver.getWindowHandles();
		for (String window : windows) {
			GlobalVar.Driver.switchTo().window(window);
			if (count == index) {
				System.out.println("Switched into window : " + index);
				break;
			}
			count++;
		}
	}

	// From excel sheet read the data
	public static String getData(String filePath, String sheetName, int rowIndex, int cellIndex) throws Exception {
		String data = null;
		try {
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
		} catch (Exception e) {

		}
		return data;
	}

	// From excel sheet write the data
	public static void setData(String filepath, String sheetName, int rowIndex, int cellIndex, String data)
			throws Exception {
		try {
			File f = new File(filepath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.createCell(cellIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		} catch (Exception e) {

		}
	}

	// Action class click method
	public void click(WebElement element) {
		Actions act = new Actions(GlobalVar.Driver);
		act.click(element).perform();
	}

	// Action class right click method
	public void contextClick(WebElement element) {
		Actions act = new Actions(GlobalVar.Driver);
		act.contextClick(element).perform();
	}

	// Action class double click method
	public void doubleClick(WebElement element) {
		Actions act = new Actions(GlobalVar.Driver);
		act.doubleClick(element).perform();
	}

	// Action class move to element method
	public void moveToElment(WebElement element) {
		Actions act = new Actions(GlobalVar.Driver);
		act.moveToElement(element).perform();
	}

	// Is element present method
	public boolean isElementPresent(By by) {
		try {
			GlobalVar.Driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// Is alert present method
	public boolean isAlertPresent() {
		try {
			GlobalVar.Driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	// Pop up accept and dismiss method
	public String closeAlertAndGetItsText() {
		try {
			Alert alert = GlobalVar.Driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	// Select date from date picker
	public String getDate(int period, String format) {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		currentDate.add(Calendar.DAY_OF_MONTH, period);
		String date = formatter.format(currentDate.getTime());
		return date;
	}

	public static int getRowCount(String filepath, String sheetName) {
		int r = 0;
		try {
			r = WorkbookFactory.create(new FileInputStream(filepath)).getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {

		}
		return r;
	}

	// Method to remove alerts from the web page
	public void purgeAllAlerts() {
		try {
			Thread.sleep(GlobalVar.purgeInterval);
			Alert alert = GlobalVar.Driver.switchTo().alert();
			if (alert != null)
				alert.dismiss();
		} catch (Exception ex) {
			// Intentionally left blank.
		}
	}

	// Method to start background thread for removing alerts
	public void startMonitor() {
		System.out.println("enter into AlertMonitor().");
		GlobalVar.keepAlive = true;
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (;;) {
					purgeAllAlerts();
					if (!GlobalVar.keepAlive)
						break;
				}
				System.out.println("exit from AlertMonitor() thread.");
			}
		});

		t.start();
		System.out.println("exit from AlertMonitor().");
	}

	// Method to stop alert monitor thread
	public void stopMonitor() {
		GlobalVar.keepAlive = false;
	}

	public static void HighLightMyElement(WebElement element) throws IOException {

		for (int i = 0; i < 7; i++)
		{
			JavascriptExecutor js = (JavascriptExecutor) GlobalVar.Driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 5px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");

		}

	}

	// To capture screenshot
	public static String CaptureScreenshot(WebDriver driver, String Screenshotname) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir") + File.separator + "Screenshot" + File.separator
					+ Screenshotname + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screen Shot Taken");
			return dest;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot" + e.getMessage());
			return e.getMessage();
		}
	}

	// To fetch the data from excelsheet particular cell value
	@SuppressWarnings("deprecation")
	public static String cellValue(XSSFSheet sheet, int rownum, int cellnum) {
		XSSFRow row = sheet.getRow(rownum);
		if (row != null) {
			XSSFCell cell = row.getCell(cellnum);
			if (cell != null) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				return cell.getStringCellValue();
			}
		}

		return "";
	}

	// Count The Records in PD For All Category...
	public int CountPdUploadRecord(WebElement we)

	{// ("dont delete")
		// try{
		String text = we.getText();
		String PdCount = text.substring(text.lastIndexOf("of") + 3);
		int result = Integer.parseInt(PdCount);
		return result;
		// }
		// catch(NoSuchElementException e) { 
		//e.printStackTrace();
		// }	
	}

	// Count The Record Based On the Text..
	public int CountRecords(String txt) {
		try {
			Pattern pattern = Pattern.compile("(?<=of).*.(?=records)");
			Matcher matcher = pattern.matcher(txt);
			// boolean found = false;
			int retval = 0;
			while (matcher.find()) {
				String mycount = matcher.group();
				retval = Integer.parseInt(mycount.trim());
				// found = true;
			}
			/*
			 * if (!found) { //System.out.println("Records not founds.."); //
			 * Reporter.log("Records not founds..",true); }
			 */
			return retval;
		} catch (Exception ex) {

			System.out.println("Exception : " + ex.getMessage());
			return 0;
		}
	}
}
