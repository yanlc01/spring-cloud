package com.cloud.common.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

public class Tools {
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/Administrator/Desktop/spring-cloud/");
		File dest = new File("C:/Users/Administrator/Desktop/test.txt");
		
		FileOutputStream fos = new FileOutputStream(dest);
		
		if (file.exists()) {
			flushFile(file, fos);
		}
		IOUtils.closeQuietly(fos);
	}
	
	public static void flushFile(File file, FileOutputStream fos) throws IOException {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				flushFile(f, fos);
			}
		} else {
			if ("java".equalsIgnoreCase(FilenameUtils.getExtension(file.getName()))) {
				System.out.println(file.getAbsolutePath());
				FileInputStream fis = new FileInputStream(file);
				byte[] b = new byte[1000];
				int i = 0;
				while ((i = fis.read(b)) > -1) {
					fos.write(b, 0, i);
				}
				IOUtils.closeQuietly(fis);
			}
		}
	}
	
}
