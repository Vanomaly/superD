package com.vanomaly.jutils;

import java.io.File;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;

public class SQLiteUtils {
	protected static SQLiteConnection db = null;
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
