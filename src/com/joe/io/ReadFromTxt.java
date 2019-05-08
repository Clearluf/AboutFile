package com.joe.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;


public class ReadFromTxt {
	public static void main(String arg[]) throws UnsupportedEncodingException, FileNotFoundException {
		String fileName=("C:\\Users\\Superred\\Desktop\\txt\\demo.txt");
		readFileByLines(fileName);
	}
	//随机读取
	 public static void readFileByRandomAccess(String fileName) {
		 RandomAccessFile raf=null;
		 try {
			raf=new RandomAccessFile(fileName,"r");
			long fileLength = raf.length();
			int beginIndex = (fileLength > 4) ? 0 : 0; 
			raf.seek(beginIndex); 
			byte[] bytes = new byte[10];
			int byteread=0;
			while ((byteread = raf.read(bytes)) != -1) {
				 System.out.write(bytes, 0, byteread); 
			 }
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(raf!=null) {
				try {
					raf.close();
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		}
	 }
	 public static void readFileByLines(String fileName) throws UnsupportedEncodingException, FileNotFoundException { 
		 File file = new File(fileName);  		 
		 BufferedReader reader = null;
		 InputStreamReader isr=new InputStreamReader(new FileInputStream(file), "GBK");
		 try {
			  //System.out.println("以行为单位读取文件内容，一次读一整行：");  
			  reader = new BufferedReader(isr);
			  String tempString = null;
			  int line = 1;  
			// 一次读入一行，直到读入null为文件结束
			  while ((tempString = reader.readLine()) != null) {  
				  System.out.printf(tempString);				 
			  }
			  reader.close();
		 }
		 catch (IOException e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 finally {
				if(reader!=null) {
					try {
						reader.close();
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}

			}
	 }
	 
}
