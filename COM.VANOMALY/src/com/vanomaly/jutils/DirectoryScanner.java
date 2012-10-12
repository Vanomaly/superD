package com.vanomaly.jutils;

import java.io.File;

public class DirectoryScanner {
	public static File[] getList(String dir) {
		File[] files = new File(dir).listFiles();
		return files;
		//return new File(dir).listFiles();
	}
}
