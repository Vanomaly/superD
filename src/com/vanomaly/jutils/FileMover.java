package com.vanomaly.jutils;

import java.io.File;

public class FileMover {
	public boolean fileMover(String fileToBeMoved, String directoryToMoveTo) {
		File file = new File(fileToBeMoved);
		File dir = new File(directoryToMoveTo);
		boolean success = file.renameTo(new File(dir, file.getName()));
		return success;
		
	}
}