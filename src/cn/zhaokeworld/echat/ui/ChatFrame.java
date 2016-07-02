package cn.zhaokeworld.echat.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import cn.zhaokeworld.echat.main.ChatUDPServer;
import cn.zhaokeworld.echat.main.ChatUDPServer.ReceiveMsg;

import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChatFrame extends JFrame implements ReceiveMsg{
	
	private JTextPane textPane;
	
	public ChatFrame() {
		setSize(500, 500);
		setTitle("聊天");
		
		ChatUDPServer me = new ChatUDPServer(9999);
		me.setReceive(this);
		Thread t2 = new Thread(me);
		t2.start();
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(6, 6, 438, 140);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		
		JScrollPane scrollPane_1 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setBounds(6, 158, 438, 154);
		contentPane.add(scrollPane_1);
		
		
		JButton button = new JButton("发送");
		button.setBounds(130, 324, 117, 29);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textArea.getText()==""||textArea.getText()==null)
					return;
				System.out.println(textArea.getText());
				me.sendMsg(textArea.getText(), 9998);
				StringBuilder sb = new StringBuilder();
				sb.append(textPane.getText());
				sb.append("我:\n\t"+textArea.getText()+"\n");
				textPane.setText(sb.toString());
				textArea.setText("");
					
			}
		});
		contentPane.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(274, 324, 117, 29);
		contentPane.add(button_1);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChatFrame();
	}

	@Override
	public void showMsg(String str) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(textPane.getText());
		sb.append(str);
		textPane.setText(sb.toString());
		
	}
}
