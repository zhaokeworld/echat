package cn.zhaokeworld.echat.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {

	private int port;
	
	public ChatServer(int port) {
		// TODO Auto-generated constructor stub
		this.port = port;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(port);
			Socket client = server.accept();
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			int len = 0;
			byte[] buf = new byte[1024];
			while((len=in.read(buf))!=-1){
				System.out.write(buf, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
