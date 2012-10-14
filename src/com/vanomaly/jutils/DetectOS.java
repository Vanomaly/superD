package com.vanomaly.jutils;

public class DetectOS {
	public static String getOS(boolean direct) {
		String os = System.getProperty("os.name");
		if (isWindows(os.toLowerCase())) {
			if (direct) {
				return os;
			} else {
				return "Windows";
			}
		} else if (isUnix(os.toLowerCase())) {
			if (direct) {
				return os;
			} else {
				return "Unix/Linux";
			}
		} else if (isMac(os.toLowerCase())) {
			if (direct) {
				return os;
			} else {
				return "Mac";
			}
		} else if (isSolaris(os.toLowerCase())) {
			if (direct) {
				return os;
			} else {
				return "Solaris";
			}
		}
		return "Unsupported OS";
	}
	private static boolean isWindows(String os) {
		return (os.indexOf("win") > -1);
	}
	private static boolean isUnix(String os) {
		return ((os.indexOf("nux") > -1) || (os.indexOf("nix") > -1));
	}
	private static boolean isMac(String os) {
		return (os.indexOf("mac") > -1);
	}
	private static boolean isSolaris(String os) {
		return ((os.indexOf("sunos") > -1) || (os.indexOf("solaris") > -1));
	}
	public static String getOSArch() {
		return System.getProperty("sun.arch.data.model");
	}
}
