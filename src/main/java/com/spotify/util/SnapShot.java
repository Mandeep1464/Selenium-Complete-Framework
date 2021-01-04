package com.spotify.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SnapShot {

	private WebDriver driver = null;
	private XWPFDocument document = null;
	private XWPFParagraph p = null;
	private TakesScreenshot scrShot = null;
	private XWPFRun r = null;
	private FileOutputStream out = null;

	public SnapShot(WebDriver driver) {
		this.driver = driver;
	}

	public boolean openWordFile(String filepath, String filename) {
		try {
			document = new XWPFDocument();
			p = document.createParagraph();
			scrShot = (TakesScreenshot) driver;
			r = p.createRun();
			System.out.println(document + "ds");
			DateFormat df = new SimpleDateFormat("[HH-mm-ss][dd-MMM-yyyy]");
			Date dateobj = new Date();
			String date = df.format(dateobj);
			File file = new File(filepath);
			if (!file.exists()) {
				// String username = System.getProperty("user.name");
				// System.out.println("username"+ username);
				filepath = System.getProperty("user.dir") + "\\TestSnapShot";
				file = new File(filepath);
				if (!file.exists())
					file.mkdir();
				String newfile = filepath + "\\" + ((filename != null) ? filename : "TestSnapShot " + date) + ".docx";
				out = new FileOutputStream(newfile);
			}
			System.out.println("Document file is Opening....");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void takeScreenShort(String info) {
		try {
			File screenShort = scrShot.getScreenshotAs(OutputType.FILE);
			// System.out.println("Screen Short taken");
			addImagesToWordDocument(screenShort, info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveFile() {
		try {
			document.write(out);
			out.close();
			document.close();
			System.out.println("Document file saved.\nDocument Created Successfully");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			System.out.println("Document file is not saved");
		}
	}

	private void addImagesToWordDocument(File imageFile, String textToDisplay) {
		try {
			BufferedImage bimg1 = ImageIO.read(imageFile);
			float reducesizeby = 4.3f;
			float width = bimg1.getWidth() / reducesizeby;
			float height = bimg1.getHeight() / reducesizeby;
			String imgFile = imageFile.getName();
			int imgFormat = XWPFDocument.PICTURE_TYPE_JPEG;
			String p1 = textToDisplay;
			r.setText(p1);
			r.addBreak();
			r.addPicture(new FileInputStream(imageFile), imgFormat, imgFile, Units.toEMU(width), Units.toEMU(height));
			// System.out.println("Image Added");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
