package 图;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 宽度优先，广度优先，queue+set
 */
public class Code_01_BFS {

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> set = new HashSet<>();//用于注册，一旦点在set中，就不要加了，不想让已经进过队列的数据重复进
		queue.add(node);
		set.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();//
			System.out.println(cur.value);//弹出，打印
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					set.add(next);
					queue.add(next);
				}
			}
		}
	}

}
