package Bullet;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Bean.Position_Bean;
import Enemy.Enemy;
import Enemy.EnemyWatched;
import Image.ImageURL;
import Levels.LevelWatcher;
import Levels.Plane;

public class Bullet1 {

	private JPanel contentPane;
	private int x, y;
	private int strikeID;
	private int move_delta_time = 25;// 子弹移动时间间隔
	private int move_delta_distance = 5;// 在单位时间间隔内移动距离

	public Bullet1(JPanel contentPane, int x, int y) {
		super();
		this.contentPane = contentPane;
		this.x = x;
		this.y = y;

		autoMove();

	}

	private void autoMove() {
		// TODO 自动生成的方法存根
		JPanel bullet = new JPanel() {
			@Override
			public void paint(Graphics g) {
				// TODO 自动生成的方法存根
				super.paint(g);
				g.drawImage(new ImageIcon(ImageURL.url_bullet1).getImage(), 0, 0, null);
			}
		};

		bullet.setBackground(Color.BLACK);
		int xPos = x + 22;
		int yPos = y;
		bullet.setBounds(xPos, yPos, 5, 10);
		contentPane.add(bullet);

		while (bullet.getY() > 0) {
			try {
				Thread.sleep(move_delta_time);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			// 设置子弹移动
			bullet.setLocation(xPos, yPos -= move_delta_distance);
			// 判断子弹是否与敌机相撞
			if (isStrike(bullet)) {
				
				// System.out.println("->num1:" + Enemy.listWatcher.size());

				// 销毁子弹
				contentPane.remove(bullet);
				System.out.println("->destroy bullet");
				// 销毁敌机
				JPanel enemy = Enemy.listEnemy.get(strikeID);
				Enemy.listEnemy.remove(strikeID);
				// Enemy.listEnemy删除第i项
				contentPane.remove(enemy);

				System.out.println("->ID:" + strikeID);
				// 刷新界面
				contentPane.repaint();
				// 判断敌机全部打死没？
				/*if (Enemy.listEnemy.size() <= 0) {

					System.out.println("->哈哈，敌机全部死亡");
				}*/
				
				// 当子弹装机敌机时，观察者模式开始
				Plane.enemyWatched.notifyWatcher(Enemy.listEnemy.size(), false);

				break;
			}

		}
		// 销毁子弹
		try {
			if (bullet.getY() <= 0) {
				contentPane.remove(bullet);
				System.out.println("->destroy bullet");
			}
		} catch (Exception e) {
			System.out.println("->子弹已经销毁啦~");
		}

	}

	// 子弹撞到了敌机
	private boolean isStrike(JPanel bullet) {
		List<Position_Bean> list = Enemy.listPosition;
		strikeID = -1;
		int bulletX = bullet.getX();
		int bulletY = bullet.getY();
		int bulletHeight = bullet.getHeight();

		for (int i = 0; i < list.size(); i++) {
			Position_Bean pos = list.get(i);
			int enemyX = pos.x * 50;
			int enemyY = pos.y * 50;
			int enemyWidth = 50;
			int enemyHeight = 50;

			// System.out.println("->Bullet:" + bulletX + ":" + bulletY);
			// System.out.println("->Enemy:" + enemyX + ":" + enemyY);

			if (bulletX > enemyX && bulletX < enemyX + enemyWidth && bulletY < enemyY + enemyHeight
					&& bulletY > enemyY + enemyHeight - bulletHeight) {
				strikeID = i;
				// Enemy.listPostion删除第i项
				Enemy.listPosition.remove(i);

				return true;
			}
		}
		return false;
	}

}
