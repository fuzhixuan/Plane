package HintsBox;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Bullet.BulletNumEachHint;
import Bullet.TimeEachHint;
import Enemy.Enemy;
import Levels.EnemyNumOfEachHint;
import Levels.Plane;

public class BulletOut02 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//new BulletOut();
	}

	/**
	 * Create the frame.
	 * @param contentPane2 
	 */
	public BulletOut02(final JPanel conPane) {
		setTitle("关卡02-子弹用完了啊~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("子弹用完了，你输了，请重新开始游戏哦~");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("重新开始");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 清理身下的敌机
				new Enemy();
				for (int i = 0; i < Enemy.listEnemy.size(); i++){
					conPane.remove(Enemy.listEnemy.get(i));
				}
				
				// 添加敌机
				Plane.noBullet = false;
				Enemy.addEnemies(conPane, EnemyNumOfEachHint.Level02);
				
				Plane.bNum = BulletNumEachHint.Level02;
				Plane.bTime = TimeEachHint.Level02;
				Plane.bulletNum.setText("子弹数量：" + Plane.bNum);
				Plane.time.setText("倒计时：" + Plane.bTime + "S");
				Plane.countDown();
				dispose();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出游戏");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnNewButton_1);
		setVisible(true);
	}

}
