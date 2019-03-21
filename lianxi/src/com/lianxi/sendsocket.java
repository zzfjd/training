package com.lianxi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class sendsocket {

	public static void main(String[] args) throws IOException {
		tcpSend();
	}
	
	private static void tcpSend() throws IOException{
		// 创建Socket对象
		Socket s = new Socket("127.0.0.1", 34567);

		// 封装文本文件
		BufferedReader br = new BufferedReader(new FileReader(
				"abd.xml"));
		// 封装通道内的流
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));

		String line = null;
		while ((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine();
			bw.flush();
		}

		br.close();
		s.close();

	}
}
