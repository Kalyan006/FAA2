package com.phm.hec.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

	List<String> fileList;
	private static final String OUTPUT_ZIP_FILE = "E:\\Personal\\Interview Test Manager\\Automation\\Selenium\\Besant Training\\frameworkfile\\reports\\test.zip";
	private static final String SOURCE_FOLDER = "E:\\GitHub\\Selenium1\\framework001\\test-output";
	// SourceFolder path

	Zip() {
		fileList = new ArrayList<String>();
		System.out.println(SOURCE_FOLDER);
	}

	public static void main(String[] args) {
		Zip appZip = new Zip();
		appZip.generateFileList(new File(SOURCE_FOLDER));
		appZip.zipIt(OUTPUT_ZIP_FILE);
	}

	public void zipIt(String zipFile) {
		byte[] buffer = new byte[1024];
		String source = "";
		try {
			try {
				source = SOURCE_FOLDER.substring(SOURCE_FOLDER.lastIndexOf("\\") + 1, SOURCE_FOLDER.length());
			} catch (Exception e) {
				source = SOURCE_FOLDER;
			}
			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);

			System.out.println("Output to Zip : " + zipFile);

			for (String file : this.fileList) {
				System.out.println("File Added : " + file);
				ZipEntry ze = new ZipEntry(source + File.separator + file);
				zos.putNextEntry(ze);

				FileInputStream in = new FileInputStream(SOURCE_FOLDER + File.separator + file);

				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}

				in.close();
			}

			zos.closeEntry();
			// remember close it
			zos.close();

			System.out.println("Folder successfully compressed");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void generateFileList(File node) {
		// add file only
		if (node.isFile()) {
			fileList.add(generateZipEntry(node.toString()));

		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateFileList(new File(node, filename));
			}
		}

	}

	private String generateZipEntry(String file) {
		return file.substring(SOURCE_FOLDER.length() + 1, file.length());
	}

}
