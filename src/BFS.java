import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BFS {

	private List<Vertice> vertices;
	private Stack<Vertice> stackAux;

	public BFS() {
		this.vertices = new ArrayList<Vertice>();
		this.stackAux = new Stack<Vertice>();
	}

	public void addVertice() {
		vertices.add(new Vertice());
	}

	public void addAdjacency(int v1, int v2) {
		vertices.get(v1).addAdjacency(vertices.get(v2));
		vertices.get(v2).addAdjacency(vertices.get(v1));
	}

	/*
	 * O(V+E)
	 */
	public boolean isConnect() {
		boolean connected = (runBFS() == vertices.size());
		this.vertices = null;
		this.stackAux = null;
		return connected;
	}

	/*
	 * O(V+E)
	 */
	private int runBFS() {
		int blackVertices = 0;
		this.stackAux.push(vertices.get(0));
		while (!this.stackAux.isEmpty()) {
			Vertice v = this.stackAux.pop();
			for (Vertice adj : v.adjacency) {
				if (adj.color == Color.WHITE) {
					adj.color = Color.GRAY;
					this.stackAux.push(adj);
				}
			}
			v.color = Color.BLACK;
			blackVertices++;
		}
		return blackVertices;
	}
}

class Vertice {
	public Color color;
	public List<Vertice> adjacency;

	public Vertice() {
		adjacency = new ArrayList<Vertice>();
		this.color = Color.WHITE;
	}

	public void addAdjacency(Vertice v) {
		this.adjacency.add(v);
	}

}

enum Color {
	GRAY, WHITE, BLACK
}
