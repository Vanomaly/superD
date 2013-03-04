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

import java.io.BufferedWriter;
import java.io.FileWriter;



public class WriteFile {
	public static boolean writeFile(String writeMe, String saveDirectory, String fileName) {
		boolean success;
			String saveFile = null;
			saveFile = saveDirectory + fileName;
		try{
			FileWriter fStream = new FileWriter(saveFile);
			BufferedWriter out = new BufferedWriter(fStream);
			out.write(writeMe);
			out.close();
			success = true;
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			success = false;
			return success;
		}
		return success;
	}
}
