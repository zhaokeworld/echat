package cn.zhaokeworld.echat.main;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
//		Thread t1 = new Thread(new ChatUDPServer(9999));
//		t1.start();
		
		ChatUDPServer me = new ChatUDPServer(9998);
		Thread t2 = new Thread(me);
		t2.start();
		while(true){
			System.out.println("请输入");
			Scanner sc = new Scanner(System.in);
			String str = sc.next();
			me.sendMsg(str, 9999);
		}
		
	}
	
}
