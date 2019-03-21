package com.test;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
//@Listeners({HTMLReporter.class,JUnitXMLReporter.class})


public class test {

	@Test(dataProvider = "renmai", dataProviderClass = test1.class)
	/**
	 * hhhhhhhh
	 * @param d
	 */
	public void test01(String d){
		System.out.println("duuuuuuuu");
		Reporter.log("ddddd");
		Assert.assertTrue(true);
	}
	@Test(dataProvider = "renmai", dataProviderClass = test1.class)
	public void test02(String d){
		List<String> l=Reporter.getOutput();
		for(String str:l){
			System.out.println("****************"+str);
		}
		Assert.assertTrue(true);
	}
	@Test(dataProvider = "renmai", dataProviderClass = test1.class)
	public void test03(String d){
		Assert.assertTrue(true);
	}
	@Test(dataProvider = "renmai", dataProviderClass = test1.class)
	public void test04(String d){
		Assert.assertTrue(false);
	}
	@Test(dataProvider = "renmai", dataProviderClass = test1.class)
	public void test05(String d){
		Assert.assertTrue(true);
	}
	@Test(dataProvider = "renmai", dataProviderClass = test1.class)
	public void test06(String d){
		Assert.assertTrue(false);
	}
	@Test(dataProvider = "renmai", dataProviderClass = test1.class)
	public void test07(String d){
		Assert.assertTrue(true);
	}
	@Test(dataProvider = "renmai", dataProviderClass = test1.class)
	public void test08(String d){
		Assert.assertTrue(true);
	}
	
}
