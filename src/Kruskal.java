import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
	
	public List<Edge> edges;
	
	/** Soma das arestas que estão na árvore */
	private double friendshipSum;
	private double distanceSum;
	
	private double weightSum;
	
	public double totalDistanceSum;
	public double ratio;
	
	public Kruskal() {
		this.edges = new ArrayList<Edge>();
	}
	
	public void addEdge(Edge edge) {
		edge.setKruskal(this);
		this.edges.add(edge);
		this.totalDistanceSum += edge.getFriendship();
	}
	/** 
	 * O(E lg E)
	 * Ordena a lista de arestas em ordem decrescente 
	 */
	private List<Edge> descendingSort(List<Edge> edgeList) {
		Collections.sort(edgeList, new Comparator<Edge>() {
			public int compare(final Edge edge1, final Edge edge2) {
				return  edge1.getWeight() > edge2.getWeight() ? -1 : 1;
			}
		});
		return edgeList;
	}
	
	/**
	 * O(E + 2V) 
	 * Encontrar árvore geradora máxima
	 */
	private void findMST() {
		for(Edge e : this.edges) {
			if(e.getNode1().getColor() != e.getNode2().getColor()) {
				e.getNode2().setColor(e.getNode1().getColor());
				e.getNode1().union(e.getNode2());
				
				this.addTreeEdge(e);
			} else if(e.getWeight() > 0.0) {
				this.addTreeEdge(e);
			}
		}
	}
	
	private void addTreeEdge(Edge edge) {
		this.weightSum += edge.getWeight();
		this.friendshipSum += edge.getFriendship();
		this.distanceSum += edge.getDistance();
	}
	
	public double getQualiteFunction() {
		return this.friendshipSum / this.distanceSum;
	}
	/*
	 * O(E + V + E lg E)
	 */
	public double run(double ratio) {
		this.ratio = ratio;
		this.friendshipSum = 0.0;
		this.distanceSum = 0.0;
		this.weightSum = 0.0;
		
		this.edges = this.descendingSort(this.edges);
		this.findMST();
		
		return this.weightSum;
	}
}
