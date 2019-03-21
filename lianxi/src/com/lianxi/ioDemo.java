package com.lianxi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ioDemo {
	private ioDemo(){}
	private static ioDemo id=null;
	public synchronized static ioDemo getioDemo(){
		if(id==null){
			id=new ioDemo();
		}
		return id;
	}
	public static void main(String[] args) throws Exception {
		String src="src\\com\\lianxi\\Random_fu.java";

		stream(src);
		
	}
	//基本字节流 一次读取一个字节
	public static void baseyByte_one(String src) throws Exception{
		FileInputStream fis=new FileInputStream(src);
		FileOutputStream fos=new FileOutputStream("a.txt");
		int b;
		while((b=fis.read())!=-1){
			fos.write(b);
		}
		fis.close();
		fos.close();	
	}
	//基本字节流 一次读取一个字节数组
	public static void baseyByte_array(String src) throws Exception{
		FileInputStream fis=new FileInputStream(src);
		FileOutputStream fos=new FileOutputStream("a.txt");
		byte[] b=new byte[1024];
		int len=0;
		while((len=fis.read(b))!=-1){
			fos.write(b, 0, len);
		}
		fis.close();
		fos.close();
	}
	//缓冲字节流 一次读取一个字节
	public static void bufferByte_one(String src) throws Exception{
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("a.txt"));
		int b;
		while((b=bis.read())!=-1){
			bos.write(b);
		}
		bis.close();
		bos.close();
		
	}
	//缓冲字节流 一次读取一个字节数组
	public static void bufferByte_array(String src) throws Exception{
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream("a.txt"));
		byte[] b=new byte[1024];
		int len;
		while((len=bis.read(b))!=-1){
			bos.write(b, 0, len);
		}
		bis.close();
		bos.close();
	}
	//基本字符流 一次读取一个字符
	public static void baseyChar_one(String src)throws Exception{
		FileReader fr=new FileReader(src);
		FileWriter fw=new FileWriter("a.txt");
		int b = 0;
		while((fr.read())!=-1){
			fw.write(b);
		}
		fr.close();
		fw.close();
	}
	//基本字符流 一次读取一个字符数组
	public static void baseyChar_array(String src)throws Exception{
		FileReader fr=new FileReader(src);
		FileWriter fw=new FileWriter("a.txt");
		char[] ch=new char[1024];
		int len=0;
		while((len=fr.read(ch))!=-1){
			fw.write(ch);
		}
		fr.close();
		fw.close();
	}
	//缓存字符流一次读取个字符
	public static void bfferChar_one(String src)throws Exception{
		BufferedReader br=new BufferedReader(new FileReader(src));
		BufferedWriter bw=new BufferedWriter(new FileWriter("a.txt"));
		int ch;
		while((ch=br.read())!=-1){
			bw.write(ch);
		}
		br.close();
		bw.close();
		
	}
	//缓存字符流一次读取个字符串
	public static void bufferChar_array(String src) throws Exception{
		BufferedReader br=new BufferedReader(new FileReader(src));
		BufferedWriter bw=new BufferedWriter(new FileWriter("a.txt"));
		String line;
		while((line=br.readLine())!=null){
			
			System.out.println(line);
		}
		br.close();
		bw.close();
	}
	// 转换流
	public synchronized static void stream(String src) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(src),"utf-8"));
		String line;
		while((line=br.readLine())!=null){
			
			System.out.println(line);
		}
		br.close();
		
	}

}
