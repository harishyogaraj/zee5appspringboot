package com.zee.zee5.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {

	public byte[]  readFile(File file) throws IOException
	{
		FileInputStream fileInputStream=new FileInputStream(file);
		byte[] allBytes = new byte[(int) file.length()];
		fileInputStream.read(allBytes);
		return allBytes;
		
	}
	public String writeFile(byte[] allBytes,String filename) throws IOException {
	
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(filename);
			fileOutputStream.write(allBytes);
			
			return "success";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
	}
}
