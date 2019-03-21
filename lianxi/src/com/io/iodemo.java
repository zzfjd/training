package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class iodemo {
	public static void main(String[] args) throws Exception {
	
	String filePath="src\\com\\lianxi\\Random_fu.java";
	//基本字节流 一次读取一个字节
	FileInputStream fis=new FileInputStream(filePath);
	FileOutputStream fos=new FileOutputStream(filePath);
	int b;
	while((b=fis.read())!=-1){
		fos.write(b);
	}
	//基本字节流一次读取一个字节数组
	byte[] by=new byte[1024];
	b=0;
	while((b=fis.read(by))!=-1){
		fos.write(by, 0, b);
	}
	fis.close();
	fos.close();
	//缓冲字节流一次读取一个字节
	BufferedInputStream bis=new BufferedInputStream(new FileInputStream(filePath));
	BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filePath));
	int i;
	while((i=bis.read())!=-1){
		bos.write(i);
	}
	//缓冲字节流一次读取一个字节数组
	byte[] by1=new byte[1024];
	while((i=bis.read(by1))!=-1){
		bos.write(by1, 0, i);
	}
	//基本字符流一次读取一个字符
	FileReader fr=new FileReader(filePath);
	FileWriter fw=new FileWriter(filePath);
	//基本字符流一次读取一个字符数组
	//缓冲字符流一次读取一个字符
	//缓冲字符流一次读取一个字符数组
	//转换流
		
	}
}
