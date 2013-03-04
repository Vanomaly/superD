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
