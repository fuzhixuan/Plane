package Levels;

import javax.swing.JPanel;

import Enemy.Enemy;
import HintsBox.PassLevel01;

public class Level01 implements LevelWatcher {
                                                                                                                                                                                 
	private JPanel contentPane;
	private int enemyNum;

	public Level01(JPanel contentPane, int num) {

		// Enemy.addEnemies(contentPane, num);
		this.contentPane = contentPane;
		this.enemyNum = num;

		// 随机生成n个敌机
		Enemy.addEnemies(contentPane, num);
		// System.out.println("->num:" + Enemy.listWatcher.size());
	}

	@Override
	public void update(int enemyNum, boolean isPass) {
		this.enemyNum = enemyNum;
		System.out.println("->01被观察者发来消息：" + this.enemyNum);
		if (enemyNum <= 0 && isPass) {
			System.out.println("->进入下一关");
			// 删除前面的观察者
			
			/*Error:网上说：在循环notifyWatcher（）的同时，删除watcher出错
			 * Exception in thread "Thread-5" java.util.ConcurrentModificationException
			at java.util.ArrayList$Itr.checkForComodification(Unknown Source)
			at java.util.ArrayList$Itr.next(Unknown Source)
			at Enemy.EnemyWatched.notifyWatcher(EnemyWatched.java:36)
			at Bullet.Bullet1.autoMove(Bullet1.java:86)
			at Bullet.Bullet1.<init>(Bullet1.java:32)
			at Listener.PlaneMoveListener$1.run(PlaneMoveListener.java:78)
			at java.lang.Thread.run(Unknown Source)*/
			
			Plane.enemyWatched.removeWatcher(null, "Level01");
			new PassLevel01(contentPane);

		}
	}

}
