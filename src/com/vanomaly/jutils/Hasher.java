package com.vanomaly.jutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
	public String getSHA256(String file) throws IOException {
		StringBuffer hexString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			FileInputStream fis = new FileInputStream(file);
		
			byte[] dataBytes = new byte[1024];
		
			int nread = 0;
			while ((nread = fis.read(dataBytes)) != -1) {
				md.update(dataBytes, 0, nread);
			}
			fis.close();
			byte[] mdbytes = md.digest();
		
			hexString = new StringBuffer();
			for (int i = 0; i < mdbytes.length; i++) {
				hexString.append(Integer.toHexString((0xFF & mdbytes[i])));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return hexString.toString();
	}
}
