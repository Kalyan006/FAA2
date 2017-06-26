package com.phm.hec.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;

import com.phm.hec.pageObjects.ForgotPasswordPageObjects;
import com.phm.hec.pageObjects.HeaderPageObjects;
import com.phm.hec.pageObjects.LoginHomePageObjects;
import com.phm.hec.utility.GlobalVar;
import com.phm.hec.utility.ReportGenerator;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.phm.hec.utility.EmailUtil;

public class TC399ForgotPassword {

	static ExtentTest TC_399_Forgot_Password;

	public static String Reason = null;
	public static String Username;
	public static String EmailID;
	public static String GMailPssword;

	public static String ScreenShotPath;
	public static String testdata;

	public static String TestName = "";
	public static boolean Execute;

	@SuppressWarnings({ "resource", "deprecation" })
	public static void forgotpassword() throws Exception {

		Logger logger = Logger.getLogger(TC399ForgotPassword.class.getName());
		TestName = "TC_399_Forgot_Password";
		TC_399_Forgot_Password = GlobalVar.report.startTest(TestName, "Validate the user able to reset the Password");

		LoginHomePageObjects LoginPage = PageFactory.initElements(GlobalVar.Driver, LoginHomePageObjects.class);
		HeaderPageObjects HeaderPage = PageFactory.initElements(GlobalVar.Driver, HeaderPageObjects.class);
		ForgotPasswordPageObjects FPPO = PageFactory.initElements(GlobalVar.Driver, ForgotPasswordPageObjects.class);
		EmailUtil emailUtil = PageFactory.initElements(GlobalVar.Driver, EmailUtil.class);

		String filepath = GlobalVar.TestDataForgotPasswordTC399FilePath;
		logger.info("File Path : " + filepath);

		int rows;
		String ExecuteYN = "";
		String SecurityAnswer1 = "";
		boolean multitestdata = Boolean.parseBoolean(GlobalVar.multpletestdata);

		logger.info("Multiple Test Data : " + multitestdata);
		File ForgotPasswordsrc = new File(filepath);
		FileInputStream fis = new FileInputStream(ForgotPasswordsrc);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("forgotpassword");

		// || (!"FALSE".equals(GlobalVar.multpletestdata))
		if (!"BAT".equals(GlobalVar.TestType)) {
			rows = sheet.getLastRowNum() + 1;
		} else {
			rows = 2;
		}

		int cols = sheet.getRow(1).getLastCellNum();
		logger.info("Test Type : " + GlobalVar.TestType + " || TesRows :" + rows + "|| Columns : " + cols);

		logger.info("Forgot password test execution starts - " + GlobalVar.loggedin);
		ReportGenerator.setLog("Forgot password test execution starts - " + GlobalVar.loggedin);
		TC_399_Forgot_Password.log(LogStatus.INFO, "Forgot password test execution starts - " + GlobalVar.loggedin);

		for (int rownum = 1; rownum < rows; rownum++) {
			TestName = "TC_399_Forgot_Password" + "_" + "row: " + rownum;
			ExecuteYN = "";
			Username = "";
			EmailID = "";
			GMailPssword = "";
			SecurityAnswer1 = "";

			try {
				logger.info("Execute the Row " + rownum);
				sheet.getRow(rownum).getCell(cols - 1).setCellType(Cell.CELL_TYPE_STRING);
				ExecuteYN = sheet.getRow(rownum).getCell(cols - 1).getStringCellValue().toUpperCase().trim();
				logger.info("Execute the Row " + rownum + " = " + ExecuteYN);
				Execute = ExecuteYN.equals("YES");
				logger.info(Execute);

				if (Execute == true || "BAT".equals(GlobalVar.TestType)) {
					TC_399_Forgot_Password = GlobalVar.report.startTest(TestName,
							"Validate the user able to reset the Password");
					// Click on the Forgot Password
					logger.info("Logged in : " + GlobalVar.loggedin);
					if (GlobalVar.loggedin == true) {
						TC_399_Forgot_Password.log(LogStatus.INFO,
								"Application already logged in. Logging out for Forgot password validation");
						logger.info("Application already logged in. Logging out for Forgot password validation : ");
						ReportGenerator
								.setLog("Application already logged in. Logging out for Forgot password validation");
						Thread.sleep(GlobalVar.threadSleep);
						if (HeaderPage.INMLogoutLink.isDisplayed() == true) {
							HeaderPage.InmPageLogout();
							GlobalVar.loggedin = false;
						} else if (HeaderPage.FREPageLogout.isDisplayed() == true) {
							HeaderPage.FREPageLogout();
							GlobalVar.loggedin = false;
						} else {
							GlobalVar.Driver.get(GlobalVar.URL);
						}
					} else {
						GlobalVar.Driver.get(GlobalVar.URL);
					}
					Thread.sleep(GlobalVar.threadSleep);
					if (LoginPage.lnkforgotPassword.isDisplayed() == true) {
						LoginPage.lnkforgotPassword.click();
						logger.info("Clicked on Forgot Password Link");
						TC_399_Forgot_Password.log(LogStatus.INFO, "Clicked on Forgot Password Link");
						ReportGenerator.setLog("Clicked on Forgot Password Link");
					}
					// Check you are landed correctly in Forgot password page
					// after clicking the Forgot password link
					boolean lblforgotpassword = FPPO.lblForgotPasswordPresent();

					if (lblforgotpassword != false) {

						// Enter User Name and Email in the Forgot Password Page
						sheet.getRow(rownum).getCell(0).setCellType(Cell.CELL_TYPE_STRING);
						Username = sheet.getRow(rownum).getCell(0).getStringCellValue();
						FPPO.EnterFPUsername(Username);

						// Email ID
						sheet.getRow(rownum).getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						EmailID = sheet.getRow(rownum).getCell(1).getStringCellValue();
						FPPO.EnterFPEmail(EmailID);

						// Click Next button on Forgot password
						FPPO.ClickNextbtnInForgotPassword();

						logger.info("Forgot Password User Name : " + Username + "|| Email ID : " + EmailID);
						TC_399_Forgot_Password.log(LogStatus.INFO,
								"Forgot Password User Name : " + Username + "|| Email ID : " + EmailID);
						ReportGenerator.setLog("Forgot Password User Name : " + Username + "|| Email ID : " + EmailID);

						boolean txtOTPField = FPPO.TxtOTPPresent();
						if (txtOTPField != false) {
							// Getting the OTP from email
							sheet.getRow(rownum).getCell(2).setCellType(Cell.CELL_TYPE_STRING);
							GMailPssword = sheet.getRow(rownum).getCell(2).getStringCellValue();
							// GMailPssword= "igi$12345";
							emailUtil.openEmailAccountOf(EmailID, GMailPssword);
							// emailUtil.searchEmailBySubject(subject)
							String OTP = emailUtil.getEmailContent("OTP");
							if (OTP != null) {
								logger.info("OTP For the User " + Username + " is : " + OTP);
								TC_399_Forgot_Password.log(LogStatus.INFO,
										"OTP For the User " + Username + " is : " + OTP);
								ReportGenerator.setLog("OTP For the User " + Username + " is : " + OTP,
										"OTP Page didn't shown up",
										"Row : " + rownum + " || " + "Forgot Password_TC399_Fail");
								FPPO.EnterOTP(OTP);
								emailUtil.deleteEmail("OTP");
								emailUtil.deleteEntireInbox();
							} else {
								Boolean EmailReceived = emailUtil.waitforMailToBeReceived("OTP");
								if (EmailReceived == true) {
									String OTP1 = emailUtil.getEmailContent("OTP");
									FPPO.EnterOTP(OTP1);
									logger.info("OTP For the User " + Username + " is : " + OTP);
									TC_399_Forgot_Password.log(LogStatus.INFO,
											"OTP For the User " + Username + " is : " + OTP1);
									ReportGenerator.setLog("OTP For the User " + Username + " is : " + OTP);

									emailUtil.deleteEmail("OTP");
									emailUtil.deleteEntireInbox();
								}
							}
							// Click on the Next button in Forgot Password OTP
							// Page
							FPPO.ClickNextbtnInForgotPasswordOTPPage();
							logger.info("Clicked on next button in OTP Page");
							TC_399_Forgot_Password.log(LogStatus.INFO, "Clicked on next button in OTP Page");
							ReportGenerator.setLog("Clicked on next button in OTP Page");

							Thread.sleep(GlobalVar.threadSleep);
							sheet.getRow(rownum).getCell(3).setCellType(Cell.CELL_TYPE_STRING);
							SecurityAnswer1 = sheet.getRow(rownum).getCell(3).getStringCellValue();
							// String SecurityAnswer1 = "test";
							FPPO.EnterSecurityQuestionAnswer(SecurityAnswer1);

							// Click on the Next button in Security Question
							// Page
							FPPO.ClickSecurityQuestionNext();
							Thread.sleep(GlobalVar.threadSleep);
							logger.info("Clicked on the next button in Security Question Page");
							TC_399_Forgot_Password.log(LogStatus.INFO,
									"Clicked on the next button in Security Question Page");
							ReportGenerator.setLog("Clicked on the next button in Security Question Page");

							boolean newpasswordfield = FPPO.txtNewPassword.isDisplayed();

							if (newpasswordfield != false) {
								// Enter the New Password
								String NewPWD = "Password!" + LocalDateTime.now().getHour()
										+ LocalDateTime.now().getMinute() + LocalDateTime.now().getSecond();
								logger.info("New password : " + NewPWD);
								TC_399_Forgot_Password.log(LogStatus.INFO, "New password : " + NewPWD);
								ReportGenerator.setLog("New password : " + NewPWD);

								FPPO.EnterNewPassword(NewPWD);
								FPPO.EnterConfirmPassword(NewPWD);
								Thread.sleep(20000);

								/*
								 * String capcha = USRINPUT.askForCapcha(null);
								 * FPPO.EnterVerificationCode(capcha);
								 */
								FPPO.ClickOnResetPassword();
								Thread.sleep(GlobalVar.threadSleep);
								Boolean txtExists = GlobalVar.Driver.getPageSource()
										.contains("Your password has been changed. ");
								// String CnfMsg =
								// FPPO.getForgotPWDConfirmationMsg();
								logger.info("Confirmation Message : " + txtExists.toString());
								TC_399_Forgot_Password.log(LogStatus.INFO,
										"Confirmation Message : " + txtExists.toString());
								// ReportGenerator.setLog("Confirmation Message
								// : " + txtExists.toString());

								if (txtExists == true) {
									Reason = "Password Changed Successfully. New Password is : " + NewPWD;
									// ReportGenerator.setLog(Reason, "Passed",
									// "Forgot Password User Name : " + Username
									// + "|| Email ID : " + EmailID + " || New
									// Password : " + NewPWD);
									// ScreenShotPath =
									// GenericUtils.CaptureScreenshot("TC399_ForgotPassword",
									// Reason);
									// ScreenShotPath =
									// GenericUtils.CaptureScreenshot(GlobalVar.Driver,
									// "TC399ForgotPassword" +
									// LocalDateTime.now().getHour() +
									// LocalDateTime.now().getMinute() +
									// LocalDateTime.now().getSecond());
									// ScreenShotPath =
									// ReportGenerator.setLog("Password Changed
									// Successfully. New Password is : " +
									// NewPWD, " ", "Row" + rownum+ "Forgot
									// Password_TC399_Pass");
									// String image =
									// TC_399_Forgot_Password.addScreenCapture(ScreenShotPath);
									TC_399_Forgot_Password.log(LogStatus.PASS, Reason);
									GlobalVar.report.endTest(TC_399_Forgot_Password);
								} else {
									Reason = "Password Not Changed Successfully.";
									// ScreenShotPath =
									// GenericUtils.CaptureScreenshot("TC399_ForgotPassword",
									// Reason);
									// ScreenShotPath =
									// GenericUtils.CaptureScreenshot(GlobalVar.Driver,
									// "TC399ForgotPassword" +
									// LocalDateTime.now().getHour() +
									// LocalDateTime.now().getMinute() +
									// LocalDateTime.now().getSecond());
									ScreenShotPath = ReportGenerator.setLog("Password Not Changed Successfully", " ",
											"Row" + rownum + "Forgot Password_TC399_Fail");
									String image = TC_399_Forgot_Password.addScreenCapture(ScreenShotPath);
									TC_399_Forgot_Password.log(LogStatus.FAIL, Reason, image);
									GlobalVar.report.endTest(TC_399_Forgot_Password);
								}

							} else {
								Reason = "Security Question Answer is Wrong";
								// ScreenShotPath =
								// GenericUtils.CaptureScreenshot("TC399_ForgotPassword",
								// Reason);
								// ScreenShotPath =
								// GenericUtils.CaptureScreenshot(GlobalVar.Driver,
								// "TC399ForgotPassword" +
								// LocalDateTime.now().getHour() +
								// LocalDateTime.now().getMinute() +
								// LocalDateTime.now().getSecond());
								ScreenShotPath = ReportGenerator.setLog("Password Not Changed Successfully", Reason,
										"Row" + rownum + "Forgot Password_TC399_Fail");
								testdata = Username + " || " + EmailID + " || " + GMailPssword;
								String image = TC_399_Forgot_Password.addScreenCapture(ScreenShotPath);
								TC_399_Forgot_Password.log(LogStatus.FAIL, Reason, image);
								GlobalVar.report.endTest(TC_399_Forgot_Password);
							}

						} else {
							Reason = FPPO.getForgotPasswordOTPErrMsg();
							// ScreenShotPath =
							// GenericUtils.CaptureScreenshot("TC399_ForgotPassword",
							// Reason);
							// ScreenShotPath =
							// GenericUtils.CaptureScreenshot(GlobalVar.Driver,
							// "TC399ForgotPassword" +
							// LocalDateTime.now().getHour() +
							// LocalDateTime.now().getMinute() +
							// LocalDateTime.now().getSecond());
							ScreenShotPath = ReportGenerator.setLog("Password Not Changed Successfully", Reason,
									"Row" + rownum + "Forgot Password_TC399_Fail");
							testdata = Username + " || " + EmailID + " || " + GMailPssword;
							String image = TC_399_Forgot_Password.addScreenCapture(ScreenShotPath);
							TC_399_Forgot_Password.log(LogStatus.FAIL, Reason, image);
							GlobalVar.report.endTest(TC_399_Forgot_Password);
						}
					} else {
						Reason = "Link forgot password does not exists";
						// ScreenShotPath =
						// GenericUtils.CaptureScreenshot("TC399_ForgotPassword",
						// Reason);
						// ScreenShotPath =
						// GenericUtils.CaptureScreenshot(GlobalVar.Driver,
						// "TC399ForgotPassword" + LocalDateTime.now().getHour()
						// + LocalDateTime.now().getMinute() +
						// LocalDateTime.now().getSecond());
						ScreenShotPath = ReportGenerator.setLog("Password Not Changed Successfully", Reason,
								"Row" + rownum + "Forgot Password_TC399_Fail");
						testdata = Username + " || " + EmailID + " || " + GMailPssword;
						String image = TC_399_Forgot_Password.addScreenCapture(ScreenShotPath);
						TC_399_Forgot_Password.log(LogStatus.FAIL, Reason, image);
						GlobalVar.report.endTest(TC_399_Forgot_Password);
					}
				} else {
					logger.info("Row Number :" + rownum + "User Name : " + Username + "Email ID : " + EmailID
							+ "Execute Y/N : " + ExecuteYN);
					ReportGenerator.setLog("Row Number :" + rownum + "User Name : " + Username + "Email ID : " + EmailID
							+ "Execute Y/N : " + ExecuteYN);
					TC_399_Forgot_Password.log(LogStatus.SKIP, "Row Number :" + rownum + "User Name : " + Username
							+ "Email ID : " + EmailID + "Execute Y/N : " + ExecuteYN);
				}
				// GlobalVar.report.endTest(TC_399_Forgot_Password);
				if ((Boolean.FALSE.equals(GlobalVar.multpletestdata)) && (Boolean.TRUE.equals(Execute))) {
					break;
				}
			}

			catch (Throwable t) {

				logger.info("Forgot Password Exception :" + t.getMessage().toString());
				// TC_399_Forgot_Password.log(LogStatus.INFO, "Forgot Password
				// Exception :" + t.getMessage().toString() + Username + " || "
				// + EmailID + " || " + GMailPssword);
				Reason = t.getMessage().toString();
				// ScreenShotPath =
				// GenericUtils.CaptureScreenshot("TC399_ForgotPassword",
				// Reason);
				// ScreenShotPath =
				// GenericUtils.CaptureScreenshot(GlobalVar.Driver,
				// "TC399ForgotPassword" + LocalDateTime.now().getHour() +
				// LocalDateTime.now().getMinute() +
				// LocalDateTime.now().getSecond());
				ScreenShotPath = ReportGenerator.setLog("Forgot Password Exception :", t.getMessage(),
						"Row" + rownum + "Forgot Password_TC399_Fail");
				String image = TC_399_Forgot_Password.addScreenCapture(ScreenShotPath);
				TC_399_Forgot_Password.log(LogStatus.FAIL, Reason, image);
				GlobalVar.report.endTest(TC_399_Forgot_Password);
			}

			if ((Boolean.FALSE.equals(multitestdata)) && (Boolean.TRUE.equals(Execute))) {
				logger.info("Multi Test Data : " + (Boolean.FALSE.equals(multitestdata)) + " Execute Y/N : "
						+ (Boolean.TRUE.equals(Execute)));
				break;
			}
		}
		// GlobalVar.report.endTest(TC_399_Forgot_Password);
	}
}
