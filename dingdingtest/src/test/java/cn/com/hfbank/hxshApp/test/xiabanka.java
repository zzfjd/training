package cn.com.hfbank.hxshApp.test;

import io.appium.java_client.android.AndroidDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.com.hfbank.hxshApp.utils.MailInfo;
import cn.com.hfbank.hxshApp.utils.MailSender;
import cn.com.hfbank.hxshApp.utils.dingdingUtil;
import cn.com.hfbank.hxshApp.utils.inputPWD;

public class xiabanka extends TimerTask {

	public static AndroidDriver<WebElement> driver;
	public SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public xiabanka() {
	}

	@Override
	public void run() {
		int d = dingdingUtil.dayForWeek();
		int i=0;
		if (d < 6) {
			inputPWD.defaultPwd();
			System.out.println("下班打卡开始--"+sdf.format(new Date(System.currentTimeMillis())));
			driver=dingdingUtil.testbefore();

			while(true){
				
				if(xiabanka()||i>5) break;
				i++;
				
				try {
					Thread.sleep(300000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			driver.quit();
		}

	}

	public static Boolean xiabanka() {
		
		dingdingUtil.waitForElementToLoad(100,By.name("工作"));

		WebElement we = driver.findElement(By.name("工作"));
		we.click();
		
		dingdingUtil.waitForElementToLoad(100,By.name("考勤打卡"));
		
		we = driver.findElement(By.name("考勤打卡"));
		we.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		dingdingUtil.click(546, 1239);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Date d = new Date(System.currentTimeMillis());

		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");

		String s = sf.format(d);
		
		dingdingUtil.Screenshot(s);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//将打卡截图发送至邮件
		
		String filename=System.getProperty("user.dir")+"\\Screenshot\\" + s + ".jpg";
		
		MailSender mailSender = MailSender.getInstance();
	    MailInfo mailInfo = mailSender.getMailInfo(filename,s);
	    try {
			mailSender.sendHtmlMail(mailInfo,3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			driver.findElement(By.name("打卡成功"));
			System.out.println("下班打卡成功");
			return true;
			
		} catch (Exception e) {
			System.out.println("下班打卡失败");
			return false;
		}finally{
			driver.closeApp();
		}

		
	}

	public static void main(String[] args) {
		int d = dingdingUtil.dayForWeek();
		if (d < 6) {
			System.out.println("今天是星期" + d + "--下班打卡开始");
			driver=dingdingUtil.testbefore();
			 xiabanka();
			 driver.quit();
		}
	}

}
