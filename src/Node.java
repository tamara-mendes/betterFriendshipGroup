import java.util.ArrayList;
import java.util.List;

public class Node {	

	private int color;

	private List<Node> connecteds;
	
	public Node(int color) {
		this.color = color;
		this.connecteds = new ArrayList<Node>(); 
	}

	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
		for(Node node : this.connecteds) {
			if(node.getColor() != color) {
				node.setColor(color);
			}
		}
	}

	public void resetColor(int color) {
		this.color = color;
		this.connecteds = new ArrayList<Node>();
	}
	
	private void addConnected(Node node) {
		this.connecteds.add(node);
	}
	
	public void union(Node node) {
		this.connecteds.add(node);
		node.addConnected(this);
	}
	
}
