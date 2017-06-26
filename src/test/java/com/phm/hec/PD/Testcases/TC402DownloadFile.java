package com.phm.hec.PD.Testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.phm.hec.PD.AdminPageObjects.ProviderAdminPageObjects;

import com.phm.hec.pageObjects.IntermediatePageObjects;
import com.phm.hec.uploadFilePageObjects.UploadFileObjects;
import com.phm.hec.utility.GenericUtils;
import com.phm.hec.utility.GlobalVar;

public class TC402DownloadFile {
	public static Logger addlog = Logger.getLogger(TC402DownloadFile.class.getName());
	public static String FILE_PATH = "D:/PHM Automation/hec/src/test/Data/userdetails.xlsx";

	@Test
	public static void downloadfile() throws Throwable

	{
		Logger logger = addlog;
		UploadFileObjects UFO = PageFactory.initElements(GlobalVar.Driver, UploadFileObjects.class);
		IntermediatePageObjects INM = PageFactory.initElements(GlobalVar.Driver, IntermediatePageObjects.class);
		ProviderAdminPageObjects PAP = PageFactory.initElements(GlobalVar.Driver, ProviderAdminPageObjects.class);

		Thread.sleep(2000);

		// click on provider admin
		INM.ClickProviderAdmin();
		logger.info("Click on Provider Admin Home Tab...");

		// click on Document Admin links
		PAP.ClickDocumentadminMenu();

		Thread.sleep(GlobalVar.threadSleep);
		// click on upload file link

		PAP.ClickUploadFile();
		logger.info("Click on Upload file link...");

		// enter user name
		// UFO.Enterusername("test_admin");

		// take the file name from the excel sheet & enter file name
		int rc = GenericUtils.getRowCount(FILE_PATH, "TC403UploadFile");

		for (int i = 1; i <= rc; i++) {
			UFO.Cleartextdata();
			String flnm = GenericUtils.getData(FILE_PATH, "TC403UploadFile", i, 0);
			UFO.Cleartextdata();
			UFO.Enterfilename(flnm);

			// Click on search document button
			UFO.ClickbtnSearchDocument();
			logger.info("Doucment search Button is Clicking..");

			// click on download button

			// UFO.clickDownload();
			UFO.Selectdownloadlink(flnm);
			logger.info("Download succesfully.........");

		}

	}
}
