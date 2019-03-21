package com.lianxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class demo {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("abd.xml");
		FileOutputStream fos=new FileOutputStream("ddd.txt");
		int len=0;
		byte[] b = new byte[1024];
		while((len=fis.read(b))!=-1){
			fos.write(b,0,len);
		}
		fis.close();
		fos.close();
		
	}
	
	public static void filename(File f){
		if(f.isDirectory()){
			System.out.println("文件夹："+f.getName());
			File[] file=f.listFiles();
			for(File n:file){
				if(n.isDirectory()){
					filename(n);
				}else{
					if(n.getName().endsWith(".java")){
						System.out.println("\t"+n.getName());
					}
				}
				
			}
			
		}else{
			if(f.getName().endsWith(".java")){
				System.out.println(f.getName());
			}
		}
		
	}
	
//	A:基本查找
//	针对数组无序的情况
	
	public static int getIndex(int[] arr,int value) {
		int index = -1;
		
		for(int x=0; x<arr.length; x++) {
			if(arr[x] == value) {
				index = x;
				break;
			}
		}
		
		return index;
	}
//B:二分查找(折半查找)
//	针对数组有序的情况(千万不要先排序，在查找)
	
	public static int binarySearch(int[] arr,int value) {
		int min = 0;
		int max = arr.length-1;
		int mid = (min+max)/2;
		
		while(arr[mid] != value) {
			if(arr[mid] > value) {
				max = mid - 1;
			}else if(arr[mid] < value) {
				min = mid + 1;
			}
			
			if(min > max) {
				return -1;
			}
			
			mid = (min+max)/2;
		}
		
		return mid;
	}
}