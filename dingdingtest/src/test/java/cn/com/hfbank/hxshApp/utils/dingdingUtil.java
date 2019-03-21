package cn.com.hfbank.hxshApp.utils;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class dingdingUtil {
	
	public static AndroidDriver<WebElement> driver;
	
	static Log log=new Log(dingdingUtil.class);
	//截屏
	public static void Screenshot(String s) {

		File srcFile = driver.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile, new File("Screenshot\\" + s + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//创建driver
	public static AndroidDriver<WebElement> testbefore(){

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "app");
		File app = new File(appDir, "dingding.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "Appium");// 自动化名字:jdk1.7及以上为Appium，以下为Selendroid
		capabilities.setCapability("platformName", "Android");// 测试平台名字：值有三个Android、iOS和FirefoxOS
		capabilities.setCapability("deviceName", "Android Emulator");// 移动设备的名字
		capabilities.setCapability("platformVersion", "8.0.0");// 测试平台版本，移动设备固件的版本号：安卓或ios的版本号

		// 钉钉package-com.alibaba.android.rimet
		// 钉钉active--com.alibaba.android.rimet.biz.SplashActivity
		capabilities.setCapability("app", app.getAbsolutePath());// 定义测试用app在本地的存储路径
		capabilities.setCapability("appPackage", "com.alibaba.android.rimet");// app的包名？？？？
		capabilities.setCapability("appActivity", ".biz.SplashActivity");// app的界面？？？？？？
		capabilities.setCapability("noReset", true);// 设置是否每次测试都重新安装app

		System.out.println("创建连接deiver");
		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			System.out.println("创建连接deiver成功");
		} catch (MalformedURLException e) {
			System.out.println("创建连接deiver失败");
			e.printStackTrace();
		}
		
		
		
		return driver;
	}
	
	
//	判断当前日期是星期几
	public static int dayForWeek(){  
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		 Calendar c = Calendar.getInstance();  
		 c.setTime(new Date(System.currentTimeMillis()));  
		 int dayForWeek = 0;  
		 if(c.get(Calendar.DAY_OF_WEEK) == 1){  
		  dayForWeek = 7;  
		 }else{  
		  dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;  
		 }  
		 return dayForWeek;  
		}
	//不同分辨率下点击像素点的转换
	//基准像素1920*1080
	public static void click(int x,int y){
		int screen_width_execute_phone = driver.manage().window().getSize().width;//screen width
		int screen_height_execute_phone = driver.manage().window().getSize().height; //screen height

		int x_click = x * screen_width_execute_phone / 1080; //x coordinates on execute phone
		int y_click = y * screen_height_execute_phone / 1920; //y coordinates on execute phone
		driver.tap(1, x_click, y_click, 0);
	}
	/**
	 * 在给定的时间内去查找元素，如果没找到则超时，抛出异常
	 * */
	public static void waitForElementToLoad(int elementTimeOut, final By By) {
		log.info("开始查找元素[" + By + "]");
		try {
			(new WebDriverWait(driver, elementTimeOut)).until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					WebElement element = driver.findElement(By);
					return element.isDisplayed();
				}
			});
		} catch (Exception e) {
			log.error("超时!! " + elementTimeOut + " 秒之后还没找到元素 [" + By + "]");
			Assert.fail("超时!! " + elementTimeOut + " 秒之后还没找到元素 [" + By + "]");

		}
		log.info("找到了元素 [" + By + "]");
	}

	public static void main(String[] args) {
		inputPWD.defaultPwd();
		testbefore();
		int screen_width_execute_phone = driver.manage().window().getSize().width;//screen width
		int screen_height_execute_phone = driver.manage().window().getSize().height; //screen height
		System.out.println(screen_width_execute_phone+"*"+screen_height_execute_phone);
		driver.quit();
	}
}
