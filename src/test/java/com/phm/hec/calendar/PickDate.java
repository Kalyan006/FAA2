package com.phm.hec.calendar;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.phm.hec.utility.GlobalVar;

import edu.emory.mathcs.backport.java.util.Arrays;

public class PickDate {
	// WebDriver driver;
	WebElement datePicker;
	List<WebElement> noOfColumns;
	String[] array = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
			"November", "December" };
	@SuppressWarnings("unchecked")
	List<String> monthList = Arrays.asList(array);
	// Expected Date, Month and Year
	int expMonth;
	int expYear;
	String expDate = null;
	// Calendar Month and Year
	String calMonth = null;
	String calYear = null;
	boolean dateNotFound;

	public void pickExpDate() {
		// Click on date text box to open date picker popup.
		GlobalVar.Driver.findElement(By.id("grdAccountList_imgDtFrom_0")).click();
		dateNotFound = true;

		// Set your expected date, month and year.
		expDate = "09";
		expMonth = 5;
		expYear = 2017;

		// This loop will be executed continuously till dateNotFound Is true.
		while (dateNotFound) {
			// Retrieve current selected month name from date picker popup.
			calMonth = GlobalVar.Driver.findElement(By.xpath("//span[text()='May']")).getText();
			// Retrieve current selected year name from date picker popup.
			calYear = GlobalVar.Driver.findElement(By.xpath("//span[text()='2017']")).getText();

			// If current selected month and year are same as expected month and
			// year then go Inside this condition.
			if (monthList.indexOf(calMonth) + 1 == expMonth && (expYear == Integer.parseInt(calYear))) {
				// Call selectDate function with date to select and set
				// dateNotFound flag to false.
				selectDate(expDate);
				dateNotFound = false;
			}
			// If current selected month and year are less than expected month
			// and year then go Inside this condition.
			else if (monthList.indexOf(calMonth) + 1 < expMonth && (expYear == Integer.parseInt(calYear))
					|| expYear > Integer.parseInt(calYear)) {
				// Click on next button of date picker.
				GlobalVar.Driver.findElement(By.xpath("//html/body/div[1]/div[4]/div[2]/img")).click();
			}
			// If current selected month and year are greater than expected
			// month and year then go Inside this condition.
			else if (monthList.indexOf(calMonth) + 1 > expMonth && (expYear == Integer.parseInt(calYear))
					|| expYear < Integer.parseInt(calYear)) {
				// Click on previous button of date picker.
				GlobalVar.Driver.findElement(By.xpath("//html/body/div[1]/div[4]/div[1]/img")).click();
			}
		}

	}

	public void selectDate(String date) {
		datePicker = GlobalVar.Driver.findElement(By.xpath("//td[text()='9']"));
		noOfColumns = datePicker.findElements(By.tagName("td"));

		// Loop will rotate till expected date not found.
		for (WebElement cell : noOfColumns) {
			// Select the date from date picker when condition match.
			if (cell.getText().equals(date)) {
				cell.findElement(By.linkText(date)).click();
				break;
			}
		}
	}
}
