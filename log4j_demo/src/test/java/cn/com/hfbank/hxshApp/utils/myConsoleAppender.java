package cn.com.hfbank.hxshApp.utils;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Priority;

public class myConsoleAppender extends ConsoleAppender {
/**
 * 最定义ConsoleAppender类 重写isAsSevereAsThreshold方法，不再是比Threshold（配置文件配置的）高级别的日志就显示，
 * 而是 等于设置的级别 才显示，这样可以更好的控制 每个级别的日志
 */
	@Override
	public boolean isAsSevereAsThreshold(Priority priority){
		return (threshold == null) ||this.getThreshold().equals(priority); 
		
	}
}
