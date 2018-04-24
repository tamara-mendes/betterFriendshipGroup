import java.util.ArrayList;
import java.util.List;

public class GraphControl {

	private List<Node> nodes;
	private Kruskal kruskal;
	private BFS bfs;
	private static double increaseSearch = 0.000000000000001;

	public GraphControl() {
		this.kruskal = new Kruskal();
		this.nodes = new ArrayList<Node>();
		this.bfs = new BFS();
	}
	
    /*
     * O(2(V + E) + (E + V + E lg E) lg(cE))
     */
	public double run(List<String> lines, int n) {
		this.createNodes(n);//O(V)
		double out = 0;
		for (String line : lines) {//O(E)
			if (!this.addEdge(line, n)) {
				return -1000;
			}
		}

		if (bfs.isConnect()) {//O(V + E)
			bfs = null;
			//O((E + V + E lg E)lg(10^15 Sum(friendship)) )
			out = binarySearch(0.0, this.kruskal.totalDistanceSum);
			if (out == 0) {
				return this.kruskal.getQualiteFunction();
			}
		}

		return -1000;
	}

	/*
	 * O(E + 2V + E lg E)
	 */
	private double runKruskal(double ratio) {
		this.resetNodes();
		return this.kruskal.run(ratio);
	}
	/*
	 * 	O((E + V + E lg E)lg(10^15 Sum(friendship)))
 	 */
	private int binarySearch(double min, double max) {
		double first = min;
		double last = max;
		double middle = (first + last) / 2.0;
		double f = this.kruskal.run(middle);

		while (first <= last) {
			if (Util.doubleEquals(f, 0.0)) {
				return 0;
			} else if (f > 0.0) {
				first = middle + increaseSearch;
			} else {
				last = middle - increaseSearch;
			}

			middle = (first + last) / 2.0;
			f = this.runKruskal(middle);
		}
		return -1000;
	}

	/**
	 * 
	 * @param line linha do arquivo
	 * @param n número de vértices
	 * @return se a linha do arquivo é válida
	 */
	private boolean addEdge(String line, int n) {
		Integer[] values = UtilFile.readLine(line, n);

		if (values == null) {
			return false;
		}

		int node1 = values[0];
		int node2 = values[1];
		double friendship = (double) values[2];
		double distance = (double) values[3];

		Edge edge = new Edge(friendship, distance);
		edge.setNode1(this.nodes.get(node1));
		edge.setNode2(this.nodes.get(node2));

		this.bfs.addAdjacency(node1, node2);

		this.kruskal.addEdge(edge);
		return true;
	}

	/*
	 * O(V)
	 */
	private void createNodes(int n) {
		for (int i = 0; i < n; i++) {
			this.nodes.add(new Node(i));
			this.bfs.addVertice();
		}
	}

	/*
	 * O(V)
	 */
	private void resetNodes() {
		int i = 0;
		for (Node node : this.nodes) {
			node.resetColor(i++);
		}
	}

}
