package com.test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.testng.annotations.DataProvider;


public class test1 {
	static final String PROPERTY_KEY_PREFIX = "org.uncommons.reportng.";
	static final String TITLE_KEY = PROPERTY_KEY_PREFIX + "title";
	// static final String DEFAULT_TITLE = "Test Results Report";
	static final String DEFAULT_TITLE = "恒丰银行自动化测试报告";
	static final String COVERAGE_KEY = PROPERTY_KEY_PREFIX + "coverage-report";
	static final String EXCEPTIONS_KEY = PROPERTY_KEY_PREFIX + "show-expected-exceptions";
	static final String OUTPUT_KEY = PROPERTY_KEY_PREFIX + "escape-output";
	static final String XML_DIALECT_KEY = PROPERTY_KEY_PREFIX + "xml-dialect";
	static final String STYLESHEET_KEY = PROPERTY_KEY_PREFIX + "stylesheet";
	static final String LOCALE_KEY = PROPERTY_KEY_PREFIX + "locale";

	public static void main(String[] args) {
		final ResourceBundle misse = ResourceBundle.getBundle("reportng", getLocale());
	}

	private static Locale getLocale() {
		System.out.println();
		if (System.getProperties().containsKey(LOCALE_KEY)) {
			String locale = System.getProperty(LOCALE_KEY);
			String[] components = locale.split("_", 3);
			switch (components.length) {
			case 1:
				return new Locale(locale);
			case 2:
				return new Locale(components[0], components[1]);
			case 3:
				return new Locale(components[0], components[1], components[2]);
			default:
				System.err.println("Invalid locale specified: " + locale);
			}
		}
		return Locale.getDefault();
	}
	
	  @DataProvider(name="renmai")
	  public static Object[][] dp(){
		  Object[][] ob={{"数据1"},{"数据2"},{"shuju3"}};
		  return ob;
	  }
}
