package 图;

public class GraphGenerator {

	/**
	 * matrix
	 * 【
	 *    【边权值，from，to】
	 *    【边权值，from，to】
	 *    【边权值，from，to】
	 *    						】
	 *    【7,2,3】
	 */
	public static Graph createGraph(Integer[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			//取出边权值，from，to
			Integer weight = matrix[i][0];
			Integer from = matrix[i][1];
			Integer to = matrix[i][2];

			//添加没有的 from，to 点
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}

			//建立新的边
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge newEdge = new Edge(weight, fromNode, toNode);


			fromNode.nexts.add(toNode);//from的邻居加上to
			fromNode.out++;//from出度+1
			toNode.in++;//to的入度+1
			fromNode.edges.add(newEdge);//from出去的边+1
			graph.edges.add(newEdge);//graph多一条边
		}
		return graph;
	}

}
