package com.vanomaly.jutils;

import java.io.File;
import java.io.IOException;

import com.vanomaly.dedupe.DeDupeSQL;

public class DirectoryScanner {
	public static File[] getList(String dir, DeDupeSQL sql) {
		Hasher hasher = new Hasher();
		File[] files = new File(dir).listFiles();
		for (int q = 0; q < files.length; q++) {
			try {
				if (files[q].getAbsolutePath().equalsIgnoreCase(files[q].getCanonicalPath())) {
					String hash = hasher.getSHA256(files[q].toString());
					String filepath = files[q].toString();
					System.out.println(filepath + " | " + hash);
					sql.sqlDB(filepath, hash);
				}
			} catch (IOException e1) {
				continue;
			}
		}
//		for (int i = 0; i < files.length; i++) {
			//System.out.println(files[i]);
//		}
		return files;
		//return new File(dir).listFiles();
	}
}
