package Main;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Font;

public class About extends JFrame {

	private JPanel contentPane;
	String aboutText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new About();
	}

	/**
	 * Create the frame.
	 */
	public About() {
		setResizable(false);
		setTitle("游戏玩法介绍");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		aboutText = "    闲来无事，以前用Unity3D做了一个《飞机大战》的炫彩游戏，现在就用Java来做做玩玩看！然后各位要是有什么意见或者建议可以在我的博客留言哈";
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(175, 131, 93, 30);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setText(aboutText);
		textArea.setBounds(10, 10, 424, 73);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("进入我的博客——《飞机大战》");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()){
					URI uri = URI.create("http://blog.csdn.net/qq_19260033");
					Desktop desktop = Desktop.getDesktop();
					if (desktop.isSupported(Desktop.Action.BROWSE)){
						try {
							desktop.browse(uri);
						} catch (IOException e1) {
							// TODO 自动生成的 catch 块
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton_1.setBounds(10, 93, 424, 23);
		contentPane.add(btnNewButton_1);
		setVisible(true);
	}
}
