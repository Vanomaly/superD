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
 // test
package com.vanomaly.dedupe;

import java.io.File;
import java.io.IOException;

import com.vanomaly.jutils.*;

public class DedupeR {
	static int count = 0;
	static int batchSize = 500;
	public static void main (String[] args) throws IOException {
		MilliTimer timer = new MilliTimer();
		timer.startTimer();
		DeDupeSQL sql = new DeDupeSQL();
		sql.connectDB();
		setup(sql);
		sql.closeDB();
		timer.stopTimer();
		System.out.println("Total Runtime: " + timer.getTime());
	}
	public static void setup(DeDupeSQL sql) {
		File[] rootDirs = DetectMachineInfo.getRoot();
		DeDupeObj[] deDupeObj = new DeDupeObj[DedupeR.batchSize];
		walk(rootDirs, deDupeObj, sql);
	}
	public static void walk(File[] files, DeDupeObj[] deDupeObj, DeDupeSQL sql) {
		for (int i = 0; i < files.length; i++) {
			try {
//				if (files[i].getAbsolutePath().equalsIgnoreCase(files[i].getCanonicalPath())) {
					//walk(DirectoryScanner.getList(files[i].toString()), deDupeObj, sql);
				//	walk(ScanFiles.scanFiles(files[i].toString(), deDupeObj), 
					// 		deDupeObj, sql);
//					DedupeR.count++;
//					System.out.println("Count: " + DedupeR.count);
//					if (DedupeR.count == (batchSize -1)) {
//						System.out.println("");
//						System.out.println("\t~~~~ Syncing Database ~~~~");
//						System.out.println("\t  ~~~~ Please Wait ~~~~");
//						System.out.println("");
//						sql.sqlDB(deDupeObj);
//						DedupeR.count = 0;
//					}
//				}
			} catch (NullPointerException e) {
		//		continue;
//				e.printStackTrace();
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException en) {
//					en.printStackTrace();
//				}
				continue;
			} //catch (IOException e) {
//				continue;
//			}
		}
	}
}
