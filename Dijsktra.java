import java.util.Arrays;

/*
 * Creates shortest path from starting vertex (Dijkstra's Algorithm)
 */

public class Dijsktra {
	
	//Initialize variables
	int[] distance;
	int start, size = 10;
	Boolean shortestPath[];
	
	/**
	 * Construct setup for dijsktra's algorithm
	 * @param graph - graph to find shortest path of
	 */
	public Dijsktra(int graph[][]) {
		//Distance is path length, shortestPath is true if vertex is in the path yet
		distance = new int[size];
		start = 0;
		shortestPath = new Boolean[size];
		
		//Set distance as very large placeholder, set shortestPath as false
		for(int i = 0; i<size; i++) {
			distance[i] = 99999;
			shortestPath[i] = false;
		}
		
		//Distance of first vertex is 0
		distance[start] = 0;
		
		//Find paths
		for(int i = 0; i<size;i++) {
			
			int min_ind = minDistance();
			
			//Add path to shortestPath
			shortestPath[min_ind] = true;
			
			//Check dijkstra's alg 
			for (int k = 0; k < size; k++) {
				if (!shortestPath[k] && graph[min_ind][k]!=0 && distance[min_ind] != 99999 && distance[min_ind] + graph[min_ind][k] < distance[k]) 
					distance[k] = distance[min_ind] + graph[min_ind][k]; 
			}
	    } 
		
		printDijResult();
	}
	
	/**
	 * Get the vertex with least distance
	 * @return int - index of least distance
	 */
	public int minDistance() {
		
		//Initialize min very large
		int min = 99999;
		int min_ind = 0;
		for(int i = 0; i<size;i++) {
			//If not in final graph and is smaller, get index
			if(shortestPath[i] == false && distance[i] < min) {
				min = distance[i];
				min_ind = i;
			}
		}
		
		return min_ind;
		
	}
	
	/**
	 * Prints the Shortest Path
	 */
	public void printDijResult() {
		System.out.println("Dijsktra's");
		Arrays.sort(distance);
        for (int i = 1; i < distance.length; i++) 
        	if(distance[i] < 99999) {
        		System.out.println(distance[i]); 
        	}
	}
}
