package com.phm.hec.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import com.phm.hec.initializer.Initializer;
import com.phm.hec.utility.GlobalVar;

public class ScreenshotGenerator extends Initializer {

	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	public static Object[][] data;
	public static int report = 0;
	SoftAssert Sassert = new SoftAssert();
	public static int check = 0;

	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
	public static Date dat = new Date();

	// *************Folder moving and screenshot history maintains****//
	public static void copyfile(File Scr, File Dst) throws IOException {
		if (Scr.isDirectory()) {
			if (!Dst.exists()) {
				Dst.mkdir();
			}
			String[] FilePaths = Scr.list();
			for (String Filepath : FilePaths) {
				File ScrFile = new File(Scr, Filepath);
				File DstFile = new File(Dst, Filepath);
				copyfile(ScrFile, DstFile);
			}
		} else {
			FileInputStream from = null;
			FileOutputStream to = null;
			from = new FileInputStream(Scr);
			to = new FileOutputStream(Dst);

			byte[] buffer = new byte[4096];
			int bytereads = 0;
			while ((bytereads - from.read(buffer)) != 1) {
				to.write(buffer, 0, bytereads);
			}
			from.close();
			to.close();

		}
	}

	// ***deleting folder****//

	public static void delete(File file) throws IOException {

		if (file.isDirectory()) {

			// directory is empty, then delete it
			if (file.list().length == 0) {

				file.delete();
				System.out.println("Directory is deleted : " + file.getAbsolutePath());

			} else {

				// list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);

					// recursive delete
					delete(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
					System.out.println("Directory is deleted : " + file.getAbsolutePath());
				}
			}

		} else {
			// if file, then delete it
			file.delete();
			System.out.println("File is deleted : " + file.getAbsolutePath());
		}
	}

	public static void ScreenShot_AddToXSLT(String TestNameAndTcid, String Reason_for_fail) throws IOException {

		String Scrfilepath = System.getProperty("user.dir") + "\\Screenshot";
		String Dstfilepath = System.getProperty("user.dir") + "\\OldScreenShots\\PreviousScreenshots "
				+ dateFormat.format(dat);
		File dscreate = new File(Dstfilepath);
		File file = new File(Scrfilepath);
		if (report == 0) {
			if (!dscreate.exists()) {
				dscreate.mkdir();
			}
			if (file.exists()) {
				copyfile(new File(Scrfilepath), new File(Dstfilepath));
				delete(file);
			}
			if (!file.exists()) {
				file.mkdir();
			}
		}
		System.setProperty(ESCAPE_PROPERTY, "false");
		if (report == 0) {
			Reporter.log(
					"<h>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Reporter.log("Note: Below Screen shot name is fomated as TestCaseName & TestStatus & TestID");
			Reporter.log("Example: TestCaseName_TestStatus_TestID");
			Reporter.log("Please Click Screen shot name to view screen shot in full page");
			Reporter.log(
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h>");
			Reporter.log("</br>");
			Reporter.log("</br>");
			Reporter.log("</br>");
			report++;
		}
		String string = TestNameAndTcid;
		String[] parts = string.split("_");
		String TestID = parts[0];
		System.out.println(parts[0]);
		String TestName = parts[1];
		System.out.println(parts[1]);
		String Pass_or_Fail = parts[2];
		System.out.println(parts[2]);
		File srcFile = ((TakesScreenshot) GlobalVar.Driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/Screenshot/" + TestName + "_"
					+ Pass_or_Fail + "_" + TestID + ".png"));
			if (Pass_or_Fail.equals("Pass")) {
				Reporter.log("<tr><td><a href='" + "file:///" + System.getProperty("user.dir") + "/Screenshot/"
						+ TestName + "_" + Pass_or_Fail + "_" + TestID + ".png'> <img src='" + "file:///"
						+ System.getProperty("user.dir") + "/Screenshot/" + TestName + "_" + Pass_or_Fail + "_" + TestID
						+ ".png' height='100' width='100'/>" + "<b><strong><font size='" + "3" + "' color='"
						+ "OrangeRed" + "'></font></strong></b>" + "<b><font size='" + "3" + "' color='" + "Indigo"
						+ "'>" + TestName + "_" + "<font size='" + "3" + "' color='" + "green" + "'>" + Pass_or_Fail
						+ "</font>" + "_" + TestID + "</font></b></a></td></tr>");
			} else if (!Pass_or_Fail.equals("Fail") && !Pass_or_Fail.equals("Pass")) {
				Reporter.log("<tr><td><a href='" + "file:///" + System.getProperty("user.dir") + "/Screenshot/"
						+ TestName + "_" + Pass_or_Fail + "_" + TestID + ".png'> <img src='" + "file:///"
						+ System.getProperty("user.dir") + "/Screenshot/" + TestName + "_" + Pass_or_Fail + "_" + TestID
						+ ".png' height='100' width='100'/>" + "<b><strong><font size='" + "3" + "' color='" + "Orange"
						+ "'></font></strong></b>" + "<b><font size='" + "3" + "' color='" + "Indigo" + "'>" + TestName
						+ "_" + "<font size='" + "3" + "' color='" + "Orange" + "'>" + Pass_or_Fail + "</font>" + "_"
						+ TestID + "</font></b></a></td></tr>");
			}

			else {
				Reporter.log("<tr><td><a href='" + "file:///" + System.getProperty("user.dir") + "/Screenshot/"
						+ TestName + "_" + Pass_or_Fail + "_" + TestID + ".png'> <img src='" + "file:///"
						+ System.getProperty("user.dir") + "/Screenshot/" + TestName + "_" + Pass_or_Fail + "_" + TestID
						+ ".png' height='100' width='100'/>" + "<b><strong><font size='" + "3" + "' color='"
						+ "OrangeRed" + "'></font></strong></b>" + "<b><font size='" + "3" + "' color='" + "Indigo"
						+ "'>" + TestName + "_" + "<font size='" + "3" + "' color='" + "red" + "'>" + Pass_or_Fail
						+ "</font>" + "_" + TestID + "</font></b></a></td></tr>");
				Reporter.log("<font size='" + "3" + "' color='" + "Tomato" + "'>Reason for Failuer   :  </font>"
						+ "<font size='" + "3" + "' color='" + "DarkSlateGray" + "'>" + Reason_for_fail + "</font>");
			}
		} catch (IOException e)

		{
			e.printStackTrace();
		}
		Reporter.setCurrentTestResult(null);
	}

}
