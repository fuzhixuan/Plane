package Levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bullet.BulletNumEachHint;
import Bullet.TimeEachHint;
import Enemy.Enemy;
import Enemy.EnemyWatched;
import HintsBox.BulletOut01;
import HintsBox.BulletOut02;
import HintsBox.TimeOut01;
import HintsBox.TimeOut02;
import Image.ImageURL;
import Listener.PlaneMoveListener;

public class Plane extends JFrame {

	private static JPanel contentPane;
	JButton plane;
	public static boolean noBullet = false;
	public static boolean isPass = false;

	public static EnemyWatched enemyWatched;
	public static JLabel time;
	public static JLabel bulletNum;
	public static int bNum;
	public static double bTime;
	public static int currentHint = 1;

	public Plane() {
		setResizable(false);
		setTitle("飞机大战");
		setIconImage(new ImageIcon(ImageURL.url_icon).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 506, 529);

		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO 自动生成的方法存根
				super.paintComponent(g);
				g.drawImage(new ImageIcon(ImageURL.url_wangge).getImage(), 0, 0, null);
			}
		};
		contentPane.setOpaque(false);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		plane = new JButton("");
		plane.setRequestFocusEnabled(true);
		plane.setBackground(Color.white);
		plane.setIcon(new ImageIcon(ImageURL.url_plane));
		plane.addKeyListener(new PlaneMoveListener(plane, contentPane));

		plane.setBounds(200, 450, 50, 50);
		contentPane.add(plane);
		setVisible(true);

		// 被观察者添加观察者
		enemyWatched = new EnemyWatched();
		enemyWatched.addWatcher(new Level01(contentPane, EnemyNumOfEachHint.Level01), "Level01");

		// 主界面添加组件
		bulletNum = new JLabel("");
		bulletNum.setBounds(10, 10, 100, 15);
		contentPane.add(bulletNum);
		// 获取当前级的子弹数量
		bNum = BulletNumEachHint.Level01;
		bulletNum.setText("子弹数量：" + bNum);
		bTime = TimeEachHint.Level01;

		time = new JLabel("倒计时：" + bTime + "S");
		time.setBounds(400, 10, 100, 15);
		contentPane.add(time);

		// System.out.println("->num0:" + Enemy.listWatcher.size());
		countDown();

	}

	public static void countDown() {
		// 开辟一个线程来倒计时
		new Thread(new Runnable() {
			public void run() {
				while (Math.abs(bTime) > 1e-6 && !noBullet) {
					// 如果游戏完成，时间停止跳动
					if (Enemy.listEnemy.size() <= 0) {
						System.out.println("->break;");
						// isPass = true;
						// 遗留问题
						// 最后一颗子弹在飞向敌机的途中，时间已经到了，已经显示出"时间到了"对话框
						// 但是，子弹还在飞，撞击飞机后，又弹出下一关的对话框
						// 已解决
						Plane.enemyWatched.notifyWatcher(Enemy.listEnemy.size(), true);

						break;
					}

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (bTime >= 0.1) {
						bTime -= 0.1;
						double tmp = Math.round(bTime * 10) / 10.0;
						time.setText("倒计时：" + tmp + "S");

						if (bTime == 0) {
							System.out.println("->时间到啦~");
						}
					} else {
						System.out.println("->时间到啦~");
						time.setText("倒计时：0S");
					}
				}

				if (Math.abs(bTime) <= 1e-6) {
					// 判断当前关卡
					switch (Plane.currentHint) {
					case 1:
						new TimeOut01(contentPane);
						break;

					case 2:
						new TimeOut02(contentPane);
						break;

					default:
						System.out.println("->Plane default");

					}

				}

			}
		}).start();
	}
}
