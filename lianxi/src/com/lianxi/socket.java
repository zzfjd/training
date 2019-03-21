package com.lianxi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class socket {
	
	public static void main(String[] args) throws Exception {
		tcpReceive();
	}



	private static void tcpReceive() throws IOException {
		// 创建服务器Socket对象
		ServerSocket ss = new ServerSocket(34567);

		// 监听客户端连接
		Socket s = ss.accept();

		// 封装通道内的流
		BufferedReader br = new BufferedReader(new InputStreamReader(
				s.getInputStream()));

		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		
		s.close();

	}
}
