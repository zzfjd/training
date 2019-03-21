package cn.com.hfbank.hxshApp.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class Log{
	private final Class<?> clazz;
	private Logger logger;
	private String filePath="";
	
	public Log(Class<?> clazz){
		this.clazz = clazz;
		this.logger = LogManager.getLogger(this.clazz);
//		PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
	}
	public void info(String message){
		logger.info(message);
	}
	
	public void debug(String message){
		logger.debug(message);
	}
	
	public void error(String message){
		logger.error(message);
	}

	
	public void warn(String message){
		logger.warn(message);
	}

	
}