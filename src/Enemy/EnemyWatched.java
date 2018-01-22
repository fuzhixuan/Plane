package Enemy;

import java.util.ArrayList;
import java.util.List;

import Levels.LevelWatcher;

public class EnemyWatched {
	List<LevelWatcher> listWatcher;
	List<String> listTag;

	public EnemyWatched() {
		listWatcher = new ArrayList<>();
		listTag = new ArrayList<>();
	}

	public void addWatcher(LevelWatcher watcher, String tag) {
		listWatcher.add(watcher);
		listTag.add(tag);
	};

	public void removeWatcher(LevelWatcher watcher, String tag) {
		int index;
		if (tag.equals(null) || tag.equals("")){
			index = listWatcher.indexOf(watcher);
		}else{
			index = listTag.indexOf(tag);
		}
		System.out.println("->index:" + index);
		listWatcher.remove(index);
		listTag.remove(index);
	};

	public void notifyWatcher(int enemyNum, boolean isPass) {
		System.out.println("->watchersNumber:" + listWatcher.size());
		for (LevelWatcher watcher: listWatcher){
			watcher.update(enemyNum, isPass);
		}
	};

}
