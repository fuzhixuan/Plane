package Listener;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Bullet.Bullet1;
import Enemy.Enemy;
import HintsBox.BulletOut01;
import HintsBox.BulletOut02;
import Levels.Plane;

public class PlaneMoveListener extends KeyAdapter {

	JComponent plane;
	JPanel contentPane;

	public PlaneMoveListener(JComponent plane, JPanel contentPane) {
		super();
		this.plane = plane;
		this.contentPane = contentPane;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		super.keyPressed(e);

		int x = plane.getX();
		int y = plane.getY();
		int width = plane.getWidth();
		int height = plane.getHeight();

		switch (e.getKeyCode()) {
		// case KeyEvent.VK_UP:
		// if (y > 0) {
		// y -= 50;
		// }
		// break;
		//
		// case KeyEvent.VK_DOWN:
		// if (y < 450) {
		// y += 50;
		// }
		// break;

		case KeyEvent.VK_LEFT:
			if (x > 0) {
				x -= 50;
			} else {
				x = 450;
			}
			break;

		case KeyEvent.VK_RIGHT:
			if (x < 450) {
				x += 50;
			} else {
				x = 0;
			}
			break;

		case KeyEvent.VK_SPACE:
			if (Plane.bNum > 0 && Plane.bTime > 0) {
				// 子弹总数量减少1
				// 使用观察者模式
				bulletMove();
				// 修改子弹数量：
				Plane.bNum -= 1;
				Plane.bulletNum.setText("子弹数量：" + Plane.bNum);
			} else {
				// 如果敌机数量大于1，则弹出对话框，停止游戏，没过关
				if (Enemy.listEnemy.size() > 0) {
					Plane.noBullet = true;

					// 判断当前关卡
					switch (Plane.currentHint) {
					case 1:
						new BulletOut01(contentPane);
						break;

					case 2:
						new BulletOut02(contentPane);
						break;

					default:
						System.out.println("->PlaneMoveListener default");

					}
				}
				System.out.println("->子弹用完~");
			}
			break;
		}

		plane.setBounds(x, y, width, height);
	}

	public void bulletMove() {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("create bullet");
				new Bullet1(contentPane, plane.getX(), plane.getY());
			}
		}).start();
	}
}
