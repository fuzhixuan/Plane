package Levels;

import javax.swing.JPanel;

import Enemy.Enemy;
import Enemy.EnemyWatched;
import HintsBox.PassLevel01;

public class Level02 implements LevelWatcher {

	private int enemyNum;
	private JPanel contentPane;

	public Level02(JPanel contentPane, int num) {
		this.contentPane = contentPane;
		this.enemyNum = num;
		Plane.currentHint += 1;
		Enemy.addEnemies(contentPane, num);
	}

	@Override
	public void update(int enemyNum, boolean isPass) {
		// TODO 自动生成的方法存根
		this.enemyNum = enemyNum;
		System.out.println("->02被观察者发来消息：" + this.enemyNum);
		if (enemyNum <= 0) {
			// new SuccessPassHint(contentPane);
			Plane.enemyWatched.removeWatcher(null, "Level02");
			
			System.out.println("->level02:pass");
		}
	}

}
