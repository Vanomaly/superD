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

package com.vanomaly.dedupe;

import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;
import com.vanomaly.jutils.SQLiteUtils;

public class DeDupeSQL extends SQLiteUtils {
//	public void sqlDB(DeDupeObj[] deDupeObj) {
	public void sqlDB(SQLiteStatement st, String file, String hash) {
//		System.out.println("DeDupeSQL CLASS");
//		SQLiteStatement st;
		try {
			//st = db.prepare("INSERT INTO files VALUES (? , ?);");
//			for (int j = 0; j < DedupeR.count; j++) {
//				st = db.prepare("INSERT INTO files VALUES (? , ?);");
				st.bind(1, file);
				st.bind(2, hash);
//				st.bind(1, deDupeObj[j].filepath);
//				st.bind(2, deDupeObj[j].filehash);
				System.out.println("Writing record " + file + " to db!");
				st.step();
//				st.dispose();
//			}
		} catch (SQLiteException e) {
			e.printStackTrace();
		}
	}
}
