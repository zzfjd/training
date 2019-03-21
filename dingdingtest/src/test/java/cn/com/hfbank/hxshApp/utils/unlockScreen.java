package cn.com.hfbank.hxshApp.utils;

import java.io.IOException;

public class unlockScreen {

	static Log log = new Log(unlockScreen.class);
	static String pwd;

	// 点亮屏幕
	public static void illumineScreen() {
		try {
			Runtime.getRuntime().exec("adb shell input keyevent 26");
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("亮屏失败！");
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 向上滑屏解锁
	public static void screen_slideUp() {
		try {
			Runtime.getRuntime().exec("adb shell input swipe 540 1400 540 80");
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("滑动屏幕失败！");
		}
	}

	// 输入密码
	public static void keyPw(){
		char[] ch=pwd.toCharArray();
		try {
			for(char c:ch){
			Runtime.getRuntime().exec("adb shell input text "+c);
			Thread.sleep(500);	
			}
		} catch (Exception e) {
			log.error("输入密码失败！");
		}
	}

	public static void main(String[] args) throws Exception {
		illumineScreen();
		screen_slideUp();
		keyPw();

	}

}
