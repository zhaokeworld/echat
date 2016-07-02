package cn.zhaokeworld.echat.main;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient implements Runnable{

	private int port;
	
	public ChatClient(int port) {
		// TODO Auto-generated constructor stub
		this.port = port;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Socket client = new Socket("127.0.0.1", port);
			OutputStream out = client.getOutputStream();
			String msg = "发送消息";
			out.write(msg.getBytes());
			System.out.println("发送结束");
			while(true);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
