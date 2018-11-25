import java.util.*;

public class Node implements Comparable<Node> {
 
	private String name;
	private List<Edge> adjacenciesList;
	private boolean visited;
	private Node predecessor;
	private int distance = Integer.MAX_VALUE;
 
	public Node(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<>();
	}
 
	public void addNeighbour(Edge edge) {
		this.adjacenciesList.add(edge);
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}
 
	public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}
 
	public boolean isVisited() {
		return visited;
	}
 
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
 
	public Node getPredecessor() {
		return predecessor;
	}
 
	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}
 
	public int getDistance() {
		return distance;
	}
 
	public void setDistance(int distance) {
		this.distance = distance;
	}
 
	@Override
	public String toString() {
		return this.name;
	}
 
	@Override
	public int compareTo(Node otherVertex) {
		return Integer.compare(this.distance, otherVertex.getDistance());
	}
}
