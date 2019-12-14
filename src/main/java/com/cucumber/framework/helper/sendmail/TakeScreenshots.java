package com.cucumber.framework.helper.sendmail;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class TakeScreenshots {

	public static void attachScreen() {
		try {

			XWPFDocument docx = new XWPFDocument();
			XWPFRun run = docx.createParagraph().createRun();
			
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "\\target\\Evidance\\Test..docx";
			
			File file = new File(reportDirectory);
			
			FileOutputStream out = new FileOutputStream(file);

			for (int counter = 1; counter <= 5; counter++) {
				captureScreenShot(docx, run, out);
				TimeUnit.SECONDS.sleep(1);
			}

			docx.write(out);
			out.flush();
			out.close();
			docx.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void captureScreenShot(XWPFDocument docx, XWPFRun run, FileOutputStream out) throws Exception {

		String screenshot_name = System.currentTimeMillis() + ".png";
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		String reportDirectory1 = new File(System.getProperty("user.dir")).getAbsolutePath()
				+ "\\target\\Evidance\\";
		
		File file = new File(reportDirectory1 + screenshot_name);
		ImageIO.write(image, "png", file);
		InputStream pic = new FileInputStream(reportDirectory1 + screenshot_name);
		run.addBreak();
		run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(350), Units.toEMU(350));
		//pic.close();
		
	}

}
