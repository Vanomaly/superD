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
