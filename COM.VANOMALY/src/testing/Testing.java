package testing;

import java.io.File;

import com.vanomaly.jutils.*;

public class Testing {
	public static void main (String[] args) {
		System.out.println("OS Direct: " + DetectOS.getOS(true));
		System.out.println("OS Indirect: " + DetectOS.getOS(false));
		System.out.println("OS Arch: " + DetectOS.getOSArch());
		System.out.println("CPU Cores: " + DetectMachineInfo.getCores());
		System.out.println("CPU Arch: " + DetectCPU.getCPUArch());
		File[] file = DetectMachineInfo.getRoot();
		for (int i = 0; i < file.length; i++) {
			System.out.println("Filesystem Root: " + file[i]);
		}
		for (int j = 0; j < 999999999L; j++) {
			double count = Math.sqrt(j);
		}
		System.out.println("Max Memory: " + DetectMachineInfo.getMaxMem() + " Bytes");
		System.out.println("Total Memory: " + DetectMachineInfo.getTotalMem() + " Bytes");
		System.out.println("Free Memory: " + DetectMachineInfo.getFreeMem() + " Bytes");
		System.out.println("Available Memory: " +
				((DetectMachineInfo.getTotalMem() - DetectMachineInfo.getFreeMem())
				/ 1024 ) + " KB");
	}
}
