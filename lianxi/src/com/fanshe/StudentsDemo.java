package com.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StudentsDemo {

	public static void main(String[] args) throws Exception {

		//三种方式获取字节码,常用第三种通过类名反射
		Class c1=Students.class;
		Students s=new Students();
		Class c2=s.getClass();
		Class c3=Class.forName("com.fanshe.Students");
		//反射到无参构造
		Constructor con1=c3.getConstructor();
		Students s1=(Students)con1.newInstance();
		System.out.println(s1.toString());
		//反射到有参构造
		Constructor con2=c3.getConstructor(String.class,int.class);
		Students s2=(Students)con2.newInstance("力气宁夏",23);
		System.out.println(s2.toString());
		//反射到私有构造
		Constructor con3=c3.getDeclaredConstructor();
		con3.setAccessible(true);
		Students s3=(Students)con3.newInstance();
		//反射到成员变量并赋值
		Field f1=c3.getField("age");
		Field f2=c3.getField("name");
		f1.set(s1, 10);
		f2.set(s1, "林青霞");
		System.out.println(s1.toString());
		//反射到非public的成员变量
		Field f3=c3.getDeclaredField("age");
		f3.setAccessible(true);
		//反射到无参方法
		Method m= c3.getMethod("getName");
		System.out.println(m.invoke(s1));
		//反射到有参方法
		Method m1=c3.getMethod("setName", String.class);
		m1.invoke(s1, "邱淑贞");
		System.out.println(s1.toString());
		//反射到私有成员方法
		Method m2=c3.getDeclaredMethod("");
		m2.setAccessible(true);
		
	}
}
