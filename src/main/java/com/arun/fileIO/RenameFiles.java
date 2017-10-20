package com.arun.fileIO;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RenameFiles {

	private final static String path="/media/arun/4A745D3D745D2D47/drive/cartoon shows/db super";
	private final static String absolutePath = "/media/arun/4A745D3D745D2D47/drive/cartoon shows/db super/";
	public static void main(String[] args) {
		RenameFiles rename = new RenameFiles();
		rename.renameFile();
	}
	
	private void renameFile(){
		File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        
        for(File f : listOfFiles){
        	String nameSubstring = f.getName().replace(".mp4", "").replaceAll("[720]", "");
        	String fileName = nameSubstring+f.getName().trim().substring(f.getName().lastIndexOf("."));
        	f.renameTo(new File(absolutePath + fileName));
        }
        System.out.println("Completed...");
	}

}
