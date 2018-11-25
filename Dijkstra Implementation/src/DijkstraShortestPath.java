import java.util.*;

public class DijkstraShortestPath {
 
	public void computeShortestPaths(Node sourceVertex){
 
		sourceVertex.setDistance(0);
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceVertex);
		sourceVertex.setVisited(true);
 
		while( !priorityQueue.isEmpty() ){
           
			Node actualVertex = priorityQueue.poll();
 
			for(Edge edge : actualVertex.getAdjacenciesList()){
 
				Node v = edge.getTargetVertex();
				if(!v.isVisited())
				{
					int newDistance =  (actualVertex.getDistance() + edge.getWeight());
 
					if( newDistance < v.getDistance() ){
						priorityQueue.remove(v);
						v.setDistance(newDistance);
						v.setPredecessor(actualVertex);
						priorityQueue.add(v);
					}
				}
			}
			actualVertex.setVisited(true);
		}
	}
 
	public List<Node> getShortestPathTo(Node targetVertex){
		List<Node> path = new ArrayList<>();
 
		for(Node vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){
			path.add(vertex);
		}
 
		Collections.reverse(path);
		return path;
	}
}
