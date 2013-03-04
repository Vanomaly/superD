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
import java.io.IOException;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.vanomaly.dedupe.DeDupeSQL;

public class DirectoryScanner {
	public static File[] getList(String dir, SQLiteStatement st) {
		DeDupeSQL sql = new DeDupeSQL();
		Hasher hasher = new Hasher();
		File[] files = new File(dir).listFiles();
		for (int q = 0; q < files.length; q++) {
			try {
				if (files[q].getAbsolutePath().equalsIgnoreCase(files[q].getCanonicalPath())) {
					String hash = hasher.getSHA256(files[q].toString());
					String filepath = files[q].toString();
					System.out.println(filepath + " | " + hash);
					st.bind(1, filepath);
					st.bind(2, hash);
					st.step();
					st.reset();
				//	sql.sqlDB(st, filepath, hash);
				}
			} catch (IOException e1) {
				continue;
			} catch (SQLiteException e) {
				e.printStackTrace();
			}
		}
		return files;
	}
}
