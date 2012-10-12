package com.vanomaly.jutils;

public class DetectCPU {
	public static int getCores() {
		return Runtime.getRuntime().availableProcessors();
	}
	public static String getCPUArch() {
		return System.getProperty("os.arch");
	}
}
