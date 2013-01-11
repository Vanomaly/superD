package com.vanomaly.jutils;

import java.io.IOException;

public class NativeCmd {
	public boolean execCmd(String cmd) {
		try {
			Process process = Runtime.getRuntime().exec(cmd);
		} catch (IOException re) {
			re.printStackTrace();
		}
		return true;
	}
}
