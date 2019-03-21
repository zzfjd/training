package com.jihe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.fanshe.Students;

/**
 * Collection
 * |-Set
 * 		|--TreeSet
 * 		|--HashSet
 * |-List
 * 		|--ArrayList
 * 		|--Vector
 * 		|--linkedList
 * 
 * Map
 * |--HashMap
 * |--HashTable
 */
public class collectiondemo {
	public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
		c.add("www");
		c.add("sss");
		c.add("xxx");
		Iterator i=c.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		Collection<Students> c2=new ArrayList<Students>();
		Students s1=new Students("qqq", 11);
		Students s2=new Students("aaa", 12);
		Students s3=new Students("zzz", 13);
		Students s4=new Students("xxx", 14);
		c2.add(s1);
		c2.add(s2);
		c2.add(s3);
		c2.add(s4);
		Iterator i1=c2.iterator();
		while(i1.hasNext()){
			System.out.println(i1.next().toString());
		}
	}
}
