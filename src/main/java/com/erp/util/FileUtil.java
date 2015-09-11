package com.erp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

public class FileUtil {

	public static String genUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String uuidFileName(String originfilename) {
		return genUUID()
				+ originfilename.substring(originfilename.indexOf('.') + 1);
	}

	public static File createNewFile(String filepath, boolean overwrite) {
		File file = new File(filepath);
		try {
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} else {
				if (overwrite) {
					file.delete();
					file.createNewFile();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public static String md5Hex(String file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			String md5 = DigestUtils.md5Hex(fis);
			fis.close();
			return md5;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String md5Hex(InputStream is) {
		try {
			String md5 = DigestUtils.md5Hex(is);
			is.close();
			return md5;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
