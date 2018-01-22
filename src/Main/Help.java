package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Font;

public class Help extends JFrame {

	private JPanel contentPane;
	String aboutText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Help();
	}

	/**
	 * Create the frame.
	 */
	public Help() {
		setResizable(false);
		setTitle("游戏玩法介绍");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		aboutText = "    嘻嘻嘻，灰常简单的玩法，只不过和以往的\"飞机大战\"有点不同，它是规定要使用给定的弹药数目和限定的时间之内完成当前关卡，否者通关失败，满足条件者继续关卡！";
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(175, 231, 93, 30);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setText(aboutText);
		textArea.setBounds(10, 10, 424, 73);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setLineWrap(true);
		textArea_1.setText("按键介绍：\n");
		textArea_1.append("向左移动飞机 —— 左箭头(←)\n");
		textArea_1.append("向右移动飞机 —— 右箭头(→)\n");
		textArea_1.append("飞机发射子弹 —— 空格键(SPACE)\n");
		textArea_1.setBounds(10, 90, 424, 131);
		contentPane.add(textArea_1);
		setVisible(true);
	}
}
