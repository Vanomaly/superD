package com.vanomaly.jutils;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class ReadFileToString {
	public String readFromFile(String strFile) {
       File file = new File(strFile);
       URI uri = file.toURI();
       byte[] bytes = null;
       try {
          bytes = java.nio.file.Files.readAllBytes(
        		  java.nio.file.Paths.get(uri));
       } catch(IOException e) {
    	   e.printStackTrace(); 
    	   return "ERROR loading file " + strFile;
       }
       return new String(bytes);
    }
}
