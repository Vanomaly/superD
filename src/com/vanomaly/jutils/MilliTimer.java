package com.vanomaly.jutils;

public class MilliTimer {
	
	private long startTime = 0L;
	private long stopTime = 0L;
	
	public void startTimer() {
		startTime = System.nanoTime();
	}
	public void stopTimer() {
		stopTime = System.nanoTime();
	}
	public String getTime() {
		String statement = "";
		float time = ((stopTime - startTime) / 1000000000F);
		if (time > 120.00f) {
			time = (time / 60.00f);
			statement += time + " (m)";
		} else {
			statement += time + " (s)";
		}
		return statement;//((stopTime - startTime) / 1000000000F);
	}
}
