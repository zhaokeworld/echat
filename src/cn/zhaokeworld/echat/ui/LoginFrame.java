package cn.zhaokeworld.echat.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.Color;
import java.awt.geom.Arc2D;

public class LoginFrame extends JFrame{
	
	public LoginFrame() {
		setTitle("hahaha");
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
//		contentPanel.setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setUndecorated(true);
		Button button = new Button("New button");
		contentPanel.add(button);
		setSize(500, 500);
//		setOpacity(0.2f);
		setVisible(true);
	}

	public static void main(String[] args) {
//		LoginFrame.setDefaultLookAndFeelDecorated(false);
		new LoginFrame();
	}
	
	
}
