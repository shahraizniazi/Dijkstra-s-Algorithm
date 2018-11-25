import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class main {

	
	
	public static void main(String[] args) {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		String sourceString = "";
		int count=0;
		String[] split;
		int trackIndexNode1 = 0;
		int trackIndexNode2=0;
		int index=0;
		int index2 =0;
		Node source = null;
		boolean node1 = false;
		boolean node2 = false;
		
	
		BufferedReader reader;
		
		
		
		
		
		
		
		
		try {
			reader = new BufferedReader(new FileReader(
					"src/InputFile.txt"));
			String line = reader.readLine();
			while (line != null) {
				
				if(count==0) {
					sourceString = line.toString();
					source = new Node(sourceString);
					nodes.add(source);
					
					
					
				}
				else {
					
					split = line.split(" ");
					
					Node temps = new Node(split[0]);
					Node temps2 = new Node(split[1]);
					
					
					
					for(int i=0; i<nodes.size();i++) {
						if(nodes.get(i).getName().equals(temps.getName())){
							node1 = true;
							trackIndexNode1=i;
						}
						if(nodes.get(i).getName().equals(temps2.getName())){
							
							node2 = true;
							trackIndexNode2 = i;
						}
						
					}
								
					
					
					if(node1 && node2) {
						
						
						nodes.get(trackIndexNode1).addNeighbour(new Edge(Integer.parseInt(split[2]), nodes.get(trackIndexNode1), nodes.get(trackIndexNode2) ));
						nodes.get(trackIndexNode2).addNeighbour(new Edge(Integer.parseInt(split[2]), nodes.get(trackIndexNode2), nodes.get(trackIndexNode1) ));
						
					}
					else if(node1 && !node2) {
						nodes.add(temps2);
						index = nodes.indexOf(temps2);
						nodes.get(trackIndexNode1).addNeighbour(new Edge(Integer.parseInt(split[2]), nodes.get(trackIndexNode1), nodes.get(index) ));
						nodes.get(index).addNeighbour(new Edge(Integer.parseInt(split[2]), nodes.get(index), nodes.get(trackIndexNode1) ));
					
					}
					else if(!node1 && node2) {
						nodes.add(temps);
						index2 = nodes.indexOf(temps);
						nodes.get(index2).addNeighbour(new Edge(Integer.parseInt(split[2]), nodes.get(index2), nodes.get(trackIndexNode2) ));
						nodes.get(trackIndexNode2).addNeighbour(new Edge(Integer.parseInt(split[2]), nodes.get(trackIndexNode2), nodes.get(index2) ));
				}
					
					else if(!node1 && !node2) {
						
						nodes.add(temps2);
						nodes.add(temps);
						index = nodes.indexOf(temps);
						index2 = nodes.indexOf(temps2);
						nodes.get(index).addNeighbour(new Edge(Integer.parseInt(split[2]), nodes.get(index), nodes.get(index2) ));
						nodes.get(index2).addNeighbour(new Edge(Integer.parseInt(split[2]), nodes.get(index2), nodes.get(index) ));
						
				}
					else {
						continue;
					}
					
					
					
			}

				node1 = false;
				node2 = false;	
				count++;
				line = reader.readLine();
			}
			reader.close();
		} 
		
		catch (IOException e) {
			System.err.println("No file found");
		}
		
		
		
	
		
		
		
		
		DijkstraShortestPath shortestPath = new DijkstraShortestPath();
		
		shortestPath.computeShortestPaths(nodes.get(0));
		
	
		String hop ="";
		for(int i =0; i< nodes.size();i++) {
			if(nodes.get(i).getName() == source.getName()) {
				hop = "None";
				
			}
			
			else {
				
				hop = shortestPath.getShortestPathTo(nodes.get(i)).get(1).getName();
			} 
			
			System.out.println("The shortest path from source " + source.toString() + " to destination " + nodes.get(i) +
			" has cost " + nodes.get(i).getDistance() + " and the next hop is: " + hop);
		}
		
	}
	
	
	
		
		
		
		

}

	







