package com.vanomaly.jutils;

import java.io.BufferedWriter;
import java.io.FileWriter;



public class WriteFile {
	public static boolean writeFile(String writeMe, String saveDirectory, String fileName) {
		boolean success;
			String saveFile = null;
			saveFile = saveDirectory + fileName;
		try{
			FileWriter fStream = new FileWriter(saveFile);
			BufferedWriter out = new BufferedWriter(fStream);
			out.write(writeMe);
			out.close();
			success = true;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			success = false;
			return success;
		}
		return success;
	}
}
