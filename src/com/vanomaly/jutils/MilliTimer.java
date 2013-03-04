/*******************************************************************************
 *  Copyright 2012 Vanomaly.com and Jason Sipula                               *
 *                                                                             *
 *  Licensed under the Apache License, Version 2.0 (the "License");            *
 *  you may not use this file except in compliance with the License.           *
 *  You may obtain a copy of the License at                                    *
 *                                                                             *
 *      http://www.apache.org/licenses/LICENSE-2.0                             *
 *                                                                             *
 *  Unless required by applicable law or agreed to in writing, software        *
 *  distributed under the License is distributed on an "AS IS" BASIS,          *
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 *  See the License for the specific language governing permissions and        *
 *  limitations under the License.                                             *
 *******************************************************************************/

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
