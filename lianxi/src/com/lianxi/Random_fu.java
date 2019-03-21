package com.lianxi;
import java.util.Random;


public class Random_fu {

	/**
	 * 产生start-end之间的随机整数
	 * @param start 开始整数
	 * @param end 结束整数
	 * @return 随机整数
	 * @throws Exception 
	 */
	public static int getRandom(int start, int end){
		if(start>end){
			throw new IllegalArgumentException("开始整数必须小于结束整数");
		}
		int number = (int) (Math.random() * (end - start + 1)) + start;
		return number;
	}
	/**
	 * 产生n位的随机数字字符串
	 * @param count 随机数字字符串位数
	 * @return n位的随机数字字符串
	 */
	public static String getRandom(int count){
		if(count<=0){
			throw new IllegalArgumentException("随机字符位数必须大于0");
		}
		int x=count/9;
		int y=count%9;
		String str = "";
		for (int i = 0; i < x; i++) {
			str+=setRandom(9);
		}
		if(y!=0){	
			str+=setRandom(y);
		}
		return str;
		
	}
	//为了保证在int范围内 所以最大9位
	private static String setRandom(int count){
		int x=9;
		int y=1;
		Random r=new Random();
		
		for(int i=1;i<count;i++){
			x=x*10;
			y=y*10;
		}
		if(count==1){
			x=10;
			y=0;
		}
		return ""+(r.nextInt(x)+y);
	}
	
	/**
	 * 产生n位的随机字符串，字符串中包含大小写字母和数字
	 * @param count 随机字符串位数
	 * @return n位的随机字符串
	 */
	public static String getRandomStr(int count){
		//数字和字母的ASCII码值范围：数字是48-57大小写字母是65-122
		//随机查询上面范围的数字
		int n;
		String str="";
		for (int i = 0; i < count; i++) {
			do{
				n=getRandom(48,122);
			}while(n>57&&n<65||n>90&&n<97);
			str+=(char)n;
	
		}
		return str;
		
	}
}
