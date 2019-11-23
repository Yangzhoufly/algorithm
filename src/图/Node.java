package 图;

import java.util.ArrayList;

public class Node {
	public int value;
	public int in;//入度
	public int out;//出度
	public ArrayList<Node> nexts;//从我出发能到的点
	public ArrayList<Edge> edges;//从我出去的边

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
