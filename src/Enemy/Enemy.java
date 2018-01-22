package Enemy;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.text.Position;
import javax.tools.DocumentationTool.Location;

import Bean.Position_Bean;
import Image.ImageURL;
import Levels.LevelWatcher;

public class Enemy{

	public static List<Position_Bean> listPosition;
	public static List<JPanel> listEnemy;

	public static void addEnemies(JPanel contentPane, int num) {
		// TODO 自动生成的方法存根
		listEnemy = new ArrayList<>();
		getRandomNumberXYList(num);		

		for (int i = 0; i < num; i++) {
			JPanel enemy = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					// TODO 自动生成的方法存根
					super.paintComponent(g);
					g.drawImage(new ImageIcon(ImageURL.url_enemy1).getImage(), 0, 0, null);
				}
			};
			enemy.setOpaque(false);
			enemy.setName("enemy:" + i);
			enemy.setBounds(listPosition.get(i).x * 50, listPosition.get(i).y * 50, 50, 50);
			listEnemy.add(enemy);
			contentPane.add(enemy, i);
		}
		
		contentPane.repaint();

	}

	public static void getRandomNumberXYList(int num) {
		listPosition = new ArrayList<>();
		for (int i = 0; listPosition.size() < num; i++) {
			Position_Bean pos = new Position_Bean();
			int x = new Random().nextInt(9);
			int y = new Random().nextInt(8);
			System.out.println("->x, y:" + x + ":" + y);
			pos.setX(x);
			pos.setY(y);

			if (!exitedInList(pos)) {
				listPosition.add(pos);
			}
		}

	}

	private static boolean exitedInList(Position_Bean pos) {
		for (int i = 0; i < listPosition.size(); i++) {
			if (pos.x == listPosition.get(i).x && pos.y == listPosition.get(i).y) {
				return true;
			}
		}
		return false;
	}

}
