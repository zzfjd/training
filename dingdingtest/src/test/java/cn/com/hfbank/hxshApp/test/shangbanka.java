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

public class shangbanka extends TimerTask {

	public AndroidDriver<WebElement> driver;
	
	public SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public shangbanka() {
	}

	@Override
	public void run() {
		int d = dingdingUtil.dayForWeek();
		if (d < 6) {
			inputPWD.nopwd();
			System.out.println("上班打卡开始--"+sdf.format(new Date(System.currentTimeMillis())));
			driver=dingdingUtil.testbefore();
			shangbanka();
			driver.quit();
		}

	}

	public void shangbanka() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement we = driver.findElement(By.name("工作"));
		we.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		we = driver.findElement(By.name("考勤打卡"));
		we.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			driver.findElement(By.name("打卡时间"));
		} catch (Exception e1) {
			System.out.println("未能急速打卡，将进行手动打卡");
			
			dingdingUtil.click(555, 849);
		}
		
		Date d = new Date(System.currentTimeMillis());

		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");

		String s = sf.format(d);
		
		dingdingUtil.Screenshot(s);
		
		

		try {
			Thread.sleep(1000);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		try {
			driver.findElement(By.name("正常"));
			System.out.println("上班打卡成功");
//			return true;
			
		} catch (Exception e) {
			System.out.println("上班打卡失败");
//			return false;
		}finally{
			driver.closeApp();
		}
	}

}
