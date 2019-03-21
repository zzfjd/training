package cn.com.hfbank.hxshApp.test;

import cn.com.hfbank.hxshApp.utils.Log;

public class test {

	public static void main(String[] args) {
		Log log=new Log(test.class);
		
		log.error("error：adshfkjadsfasdfhk");
		log.info("info:adshfkjadsfasdfhk");
		log.warn("warn:adshfkjadsfasdfhk");
		log.debug("debug:adshfkjadsfasdfhk");
	}
}
