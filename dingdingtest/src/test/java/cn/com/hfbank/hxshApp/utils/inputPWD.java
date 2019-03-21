package cn.com.hfbank.hxshApp.utils;
/**
 * inputPwd()：创建个窗体用于输入手机解锁密码
 * defaultPwd()：使用默认密码
 */


import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class inputPWD extends JDialog {

	public inputPWD() {
		super();
		setResizable(false);
		getContentPane().setBackground(new Color(225, 225, 225));
		getContentPane().setLayout(null);
		// initialize();
	}

	public static void inputPwd() {

		// 创建窗体对象
		final JFrame f = new JFrame("手机解锁密码");
		f.setBounds(500, 300, 350, 100);
		f.setLayout(new FlowLayout());// 别忘了布局设置
		f.setResizable(false);// 设置不能调整大小

		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 创建标签对象
		Label l = new Label("输入手机解锁密码");

		// 创建按钮
		JButton bu = new JButton("确定");
		bu.setSize(30, 10);

		// 创建文本框对象
		// final TextField tf = new TextField(20);

		final JPasswordField tf = new JPasswordField(10);

		final Label l1 = new Label("                                 ");

		// 把组件添加到窗体中
		f.add(l);
		f.add(tf);
		f.add(bu);
		f.add(l1);

		f.getRootPane().setDefaultButton(bu);
		f.requestFocus();
		// 设置显示窗体
		f.setVisible(true);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (tf.getPassword().length == 0) {
			System.out.println("10秒钟内未输入密码，将使用默认密码");
			f.dispose();
			unlockScreen.pwd = "0930";
			unlockScreen.illumineScreen();
			unlockScreen.screen_slideUp();
			unlockScreen.keyPw();
		}

		// 文本框监听，退格键实现退格，回车键实现确定按钮的功能
		tf.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {

			}

			public void keyReleased(KeyEvent e) {

				String s = new String(tf.getPassword()).trim();

				if (e.getKeyCode() == 8 && s.length() > 0) {
					tf.setText(s.substring(0, s.length()));
				}
				if (e.getKeyCode() == 10 && s.length() == 4) {

					Pattern pattern = Pattern.compile("[0-9]*");
					Matcher isNum = pattern.matcher(s);
					if (isNum.matches() && s.length() > 0) {

						f.dispose();

						unlockScreen.pwd = s;
						unlockScreen.illumineScreen();
						unlockScreen.screen_slideUp();
						unlockScreen.keyPw();

					} else {
						l1.setText("请输入4位数字");
						tf.setText("");
					}
				}

			}

			public void keyPressed(KeyEvent e) {

			}
		});

		// 设置窗体关闭监听事件
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// 监听按钮，当文本框输入内容为数字时 关闭窗口，如果不是提示输入数字
		bu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String s = new String(tf.getPassword()).trim();
				Pattern pattern = Pattern.compile("[0-9]*");
				Matcher isNum = pattern.matcher(s);
				if (isNum.matches() && s.length() == 4) {
					f.dispose();
					unlockScreen.pwd = s;
					unlockScreen.illumineScreen();
					unlockScreen.screen_slideUp();
					unlockScreen.keyPw();

				} else {
					l1.setText("请输入4位数字");
					tf.setText("");
				}
			}
		});

	}

	public static void defaultPwd() {
		unlockScreen.pwd = "0930";
		unlockScreen.illumineScreen();
		unlockScreen.screen_slideUp();
		unlockScreen.keyPw();
	}
	
	//点亮屏幕直接进入系统 不需要上滑屏幕解锁
	public static void nopwd(){
		unlockScreen.illumineScreen();
	}

	public static void main(String[] args) {
		inputPwd();
	}
}