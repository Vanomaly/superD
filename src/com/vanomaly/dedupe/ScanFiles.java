package com.vanomaly.dedupe;

import java.io.File;
import java.io.IOException;

import com.vanomaly.jutils.DirectoryScanner;
import com.vanomaly.jutils.Hasher;

public class ScanFiles extends DirectoryScanner {
	public static File[] scanFiles(String dir, DeDupeObj[] deDupeObj) throws IOException {
		//DedupeR.count++;
		System.out.println("SCANFILES CLASS");
		DeDupeSQL sql = new DeDupeSQL();
		Hasher getHash = new Hasher();
		File[] files = DirectoryScanner.getList(dir, sql);
		System.out.println(files.length);
		for (int i = 0; i < files.length; i++) {
			DedupeR.count++;
			System.out.println(i);
			if (files[i].isFile() && files[i].canRead()) {
				String file = files[i].toString();
				String hash = getHash.getSHA256(files[i].toString());
	/*			deDupeObj[DedupeR.count] = new DeDupeObj();
				deDupeObj[DedupeR.count].filepath = files[i].toString();
				deDupeObj[DedupeR.count].filehash = getHash.getSHA256(files[i].toString());
				if (DedupeR.count == (DedupeR.batchSize -1)) {
					System.out.println("");
					System.out.println("\t~~~~ Syncing Database ~~~~");
					System.out.println("\t  ~~~~ Please Wait ~~~~");
					System.out.println("");
					sql.sqlDB(deDupeObj);
					DedupeR.count = 0;
					deDupeObj = null;
					deDupeObj = new DeDupeObj[DedupeR.batchSize];
					
				}  */
				sql.sqlDB(file, hash);
				DedupeR.count++;
				System.out.println("Processing: \n\tFile: " + deDupeObj[DedupeR.count].filepath
						+ "\n\tHash: " + deDupeObj[DedupeR.count].filehash);
			}
		}
		return files;
	}
}
