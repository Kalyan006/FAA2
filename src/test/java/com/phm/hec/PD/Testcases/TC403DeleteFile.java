package com.phm.hec.PD.Testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.phm.hec.CM.FormResourceAndEducationObjects.FormResourceAndEducationObjects;
import com.phm.hec.PD.AdminPageObjects.ProviderAdminPageObjects;

import com.phm.hec.pageObjects.IntermediatePageObjects;
import com.phm.hec.uploadFilePageObjects.UploadFileObjects;
import com.phm.hec.utility.GenericUtils;
import com.phm.hec.utility.GlobalVar;

public class TC403DeleteFile {

	public static Logger addlog = Logger.getLogger(TC403DeleteFile.class.getName());
	public static String FILE_PATH = "D:/PHM Automation/hec/src/test/Data/userdetails.xlsx";

	@Test
	public static void Deletefile() throws Throwable

	{
		Logger logger = addlog;
		UploadFileObjects UFO = PageFactory.initElements(GlobalVar.Driver, UploadFileObjects.class);
		IntermediatePageObjects INM = PageFactory.initElements(GlobalVar.Driver, IntermediatePageObjects.class);
		FormResourceAndEducationObjects FRE = PageFactory.initElements(GlobalVar.Driver,
				FormResourceAndEducationObjects.class);
		ProviderAdminPageObjects PAP = PageFactory.initElements(GlobalVar.Driver, ProviderAdminPageObjects.class);

		Thread.sleep(GlobalVar.threadSleep);

		// click on provider Admin
		INM.ClickProviderAdmin();
		logger.info("Clicking on Provider Admin Home Tab...");

		// click on Document Admin link

		PAP.ClickDocumentadminMenu();

		Thread.sleep(GlobalVar.threadSleep);
		// click on upload file link
		PAP.ClickUploadFile();

		// take the file name from the excel sheet & enter file name
		int rc = GenericUtils.getRowCount(FILE_PATH, "TC403UploadFile");
		logger.info(rc);
		for (int i = 1; i <= rc; i++) {
			String flnm = GenericUtils.getData(FILE_PATH, "TC403UploadFile", i, 0);
			String value = GenericUtils.getData(FILE_PATH, "TC403UploadFile", i, 1);

			{
				UFO.Enterfilename(flnm);
				UFO.Cleartextdata();
			}

			// click on search document button
			UFO.ClickbtnSearchDocument();

			// count the record before Deleting
			String text1 = GlobalVar.Driver.findElement(By.id("ContentPlaceHolder1_lblRecordInfo1")).getText();
			logger.info("Total Number of Records After Searching---- " + text1);

			// count the record after deletion
			String text2 = GlobalVar.Driver.findElement(By.id("ContentPlaceHolder1_lblRecordInfo1")).getText();
			logger.info("Total Number of Records After Deleting-----" + text2);
		}

	}

}
