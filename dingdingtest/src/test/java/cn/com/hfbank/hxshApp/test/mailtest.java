package cn.com.hfbank.hxshApp.test;

import cn.com.hfbank.hxshApp.utils.MailInfo;
import cn.com.hfbank.hxshApp.utils.MailSender;

public class mailtest {
public static void main(String[] args) throws Exception {
	MailSender mailSender = MailSender.getInstance();
    MailInfo mailInfo = mailSender.getMailInfo("D:\\aa.txt","2018");
    mailSender.sendHtmlMail(mailInfo,3);
}
}
