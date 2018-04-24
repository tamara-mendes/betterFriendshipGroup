public class Edge {

	private Node node1;
	private Node node2;

	/* Friendship */
	private double friendship;
	/* Distance */
	private double distance;

	private Kruskal kruskal;
	
	public Edge(double friendship, double distance) {
		this.friendship = friendship;
		this.distance = distance;
	}

	public Node getNode1() {
		return node1;
	}

	public void setNode1(Node node1) {
		this.node1 = node1;
	}

	public Node getNode2() {
		return node2;
	}

	public void setNode2(Node node2) {
		this.node2 = node2;
	}

	public double getFriendship() {
		return friendship;
	}

	public void setFriendship(double friendship) {
		this.friendship = friendship;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getWeight() {
		return (this.friendship) - (this.kruskal.ratio * this.distance);
	}

	public Kruskal getKruskal() {
		return kruskal;
	}

	public void setKruskal(Kruskal kruskal) {
		this.kruskal = kruskal;
	}

}
