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

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;

public class SQLiteUtils {
	public static SQLiteConnection db = null;
	public static void main (String[] args) {
		String dbString = "db/superDduperdb.sqlite3";
		db = new SQLiteConnection(new File(dbString));
		try {
			db.open(true);
			SQLiteStatement st;
//			st = db.prepare("SELECT * FROM files");
			
			st = db.prepare("INSERT INTO files VALUES (? , ?);");
			st.bind(1, "/var/temp");
			st.bind(2, "666JE4fjflkjd443kjlkf43344jjJDJEjlkjd");
			st.step();
//			System.out.println(st.columnString(0));
//			System.out.println(st.columnString(1));
			st.dispose();
		} catch (SQLiteException e) {
			e.printStackTrace();
		}
		db.dispose();
	}
	public void connectDB() {
		String dbString = "";
		if (DetectOS.getOS(false).toUpperCase().indexOf("WIN") > -1) {
			dbString = "db\\superDduperdb.sqlite3";
		} else {
			dbString = "db/superDduperdb.sqlite3";
		}
		 db = new SQLiteConnection(new File(dbString));
		    try {
				db.open(true);
			} catch (SQLiteException e) {
				e.printStackTrace();
			}
	}
	public void sqlDB() { //String filepath, String filehash) {	
		// Override this method
/*		SQLiteStatement st;
		try {
			st = db.prepare("INSERT INTO files VALUES (? , ?);");
			st.bind(1, filepath);
			st.bind(2, filehash);
			st.step();
//		    } finally {
			st.dispose();
	//	    }
		} catch (SQLiteException e) {
			e.printStackTrace();
		}
*/
	}

	public void closeDB() {
		    db.dispose();
	}
}
