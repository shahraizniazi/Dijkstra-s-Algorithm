
public class Edge {
 
	private int weight;
	private Node startVertex;
	private Node targetVertex;
	
	public Edge(int weight, Node startVertex, Node targetVertex) {
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}
 
	public int getWeight() {
		return weight;
	}
 
	public void setWeight(int weight) {
		this.weight = weight;
	}
 
	public Node getStartVertex() {
		return startVertex;
	}
 
	public void setStartVertex(Node startVertex) {
		this.startVertex = startVertex;
	}
 
	public Node getTargetVertex() {
		return targetVertex;
	}
 
	public void setTargetVertex(Node targetVertex) {
		this.targetVertex = targetVertex;
	}
}
