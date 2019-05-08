package com.joe.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ReaderFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private void readByLine(String filePath,String charset) {
		// TODO Auto-generated method stub		
		try {
			File file=new File(filePath);
			//����ָ�����뽫�ļ�����������
			InputStreamReader isr=new InputStreamReader(new FileInputStream(file),charset);
			//�����������뻺����
			BufferedReader br=new BufferedReader(isr);
			//��ӡ�����
			while(br.readLine()!=null) {
				System.out.println(br.readLine());
			}
			br.close();		
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
