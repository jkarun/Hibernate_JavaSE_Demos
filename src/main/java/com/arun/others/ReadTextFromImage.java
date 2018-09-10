package com.arun.others;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadTextFromImage {
	public String getImgText(String imageLocation) throws Exception {
		
		File file = new File(imageLocation);
		
		if (!file.exists())
			throw new Exception("File not found...");

		ITesseract instance = new Tesseract();
		try {
			String imgText = instance.doOCR(new File(imageLocation));
			return imgText;
		} catch (TesseractException e) {
			e.getMessage();
			return "Error while reading image";
		}
	}

	public static void main(String[] args) throws Exception{
		File file = new File("D://1.jpg");
		if(file.exists())
			System.out.println("found");
		else 
			System.out.println("Not found");
		
		
		ReadTextFromImage app = new ReadTextFromImage();
		System.out.println(app.getImgText("D://1.jpg"));
	}

}
