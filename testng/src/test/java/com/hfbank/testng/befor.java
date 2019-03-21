package com.hfbank.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class befor {

	@Parameters({"include"})
	@BeforeClass()
	public void d(){
		System.out.println(";;;;");
	}
}
