package 图;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	public HashMap<Integer,Node> nodes; //点集合
	public HashSet<Edge> edges;   //边集合

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
