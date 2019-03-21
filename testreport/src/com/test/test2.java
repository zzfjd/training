package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class test2 implements IReporter {

	public void generateReport(List<XmlSuite> XmlSuites, List<ISuite> ISuites, String str) {

		for(ISuite iSuite:ISuites){
			for(ISuiteResult suiteResult:iSuite.getResults().values()){
				Set<ITestResult> iTestResults=suiteResult.getTestContext().getPassedTests().getAllResults();
				for(ITestResult iTestResult:iTestResults){

				}
			}
			
			
		}
	}

	public static void main(String[] args) {
		String str="com.hfbank.diiid.dkdkk";
		System.out.println(str.substring(str.lastIndexOf(".")+1));
		HashMap<String,String> ha=new HashMap<String, String>();
		ha.put("dfad", "dddd");
		System.out.println(ha.get("d").toString());
	}

}
