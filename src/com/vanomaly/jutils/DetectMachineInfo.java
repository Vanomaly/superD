package com.vanomaly.jutils;

import java.io.File;

public class DetectMachineInfo {
	public static int getCores() {
		return Runtime.getRuntime().availableProcessors();
	}
	public static String getCPUArch() {
		return System.getProperty("os.arch");
	}
	public static long getTotalMem() {
		return (Runtime.getRuntime().totalMemory() );/// 1048576);
	}
	public static long getMaxMem() {
		return (Runtime.getRuntime().maxMemory() );/// 1048576);
	}
	public static long getFreeMem() {
		return (Runtime.getRuntime().freeMemory() );/// 1048576);
	}
	public static File[] getRoot() {
		return File.listRoots();
	}
}
