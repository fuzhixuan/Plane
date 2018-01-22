package HintsBox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bullet.BulletNumEachHint;
import Bullet.TimeEachHint;
import Levels.EnemyNumOfEachHint;
import Levels.Level02;
import Levels.Plane;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PassLevel01 extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		new PassLevel01(new JPanel());
	}

	public PassLevel01(final JPanel panel) {
		setTitle("关卡01-通关成功");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("提示：是否进入下一关？？？");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
				JButton btnNewButton = new JButton("进入下一关");
				panel_1.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("退出游戏");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				panel_1.add(btnNewButton_1);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						Plane.enemyWatched.addWatcher(new Level02(panel, EnemyNumOfEachHint.Level02), "Level02");
						Plane.bNum = BulletNumEachHint.Level02;
						Plane.bTime = TimeEachHint.Level02;
						Plane.bulletNum.setText("子弹数量：" + Plane.bNum);
						Plane.time.setText("倒计时：" + Plane.bTime + "S");
						Plane.countDown();
						// 可以用观察者模式
					}
				});
		setVisible(true);
	}

}
