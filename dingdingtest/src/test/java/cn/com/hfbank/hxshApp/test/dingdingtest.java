package cn.com.hfbank.hxshApp.test;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.com.hfbank.hxshApp.utils.Log;
import cn.com.hfbank.hxshApp.utils.inputPWD;

public class dingdingtest {
	public static void main(String[] args) {

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1=null;
		Date d2=null;
		try {
			d1=sdf.parse("2018-05-16 16:15:00");
			d2=sdf.parse("2018-05-16 17:30:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timer timer1 = new Timer();
		Timer timer2 = new Timer();
        timer1.schedule(new shangbanka(),d1, 600000);//此处启动要运行的程序
        timer1.schedule(new xiabanka(),d2, 600000);//此处启动要运行的程序\

	}

}
