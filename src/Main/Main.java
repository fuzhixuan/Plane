package Main;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Image.ImageURL;
import Levels.Plane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Main();
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setTitle("飞机大战_主界面");
		setIconImage(new ImageIcon(ImageURL.url_icon).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 600, 400);
		contentPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				// TODO 自动生成的方法存根
				super.paintComponent(g);
				g.drawImage(new ImageIcon(ImageURL.url_bg).getImage(), 0, 0, null);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Plane();
				dispose();
			}
		});
		btnNewButton.setBounds(177, 122, 229, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HELP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton_1.setBounds(177, 182, 229, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ABOUT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new About();
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton_2.setBounds(177, 242, 229, 50);
		contentPane.add(btnNewButton_2);
		setVisible(true);
	}
}
