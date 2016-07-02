package cn.zhaokeworld.echat.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ChatUDPServer implements Runnable{

	private DatagramSocket server;
	private DatagramPacket p;
	private ReceiveMsg receive = null;
	public ChatUDPServer(int port) {
		// TODO Auto-generated constructor stub
		try {
			server = new DatagramSocket(port);
			byte[] buf = new byte[1024];
			p = new DatagramPacket(buf, buf.length);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				server.receive(p);
				if(receive!=null){
					receive.showMsg(p.getPort()+":\n\t"+new String(p.getData())+"\n");
				}
				System.out.print(p.getPort()+":");
				System.out.write(p.getData());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg(String s, int port){
		try {
			System.out.println("发送到"+port+s);
			DatagramSocket so = new DatagramSocket();
			so.connect(InetAddress.getByName("127.0.0.1"), port);
			DatagramPacket p = new DatagramPacket(s.getBytes(), s.getBytes().length);
			so.send(p);
//			new DatagramPacket(s.getBytes(), s.getBytes().length, InetAddress.getByName("127.0.0.1"), port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void setReceive(ReceiveMsg receive){
		this.receive = receive;
	}
	
	public interface ReceiveMsg{
		public void showMsg(String str);
	}
	
}
