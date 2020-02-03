import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DijsktraTester {

	public static void main(String[] args) throws FileNotFoundException {
			
			int graph[][] = new int[10][10];
			int start = 0, end, weight;
			File newFile = new File("graph2a.txt");
			Scanner in = new Scanner(newFile);
			
			
			//Read in data
			while(in.hasNextInt()) {
				start = in.nextInt();
				end = in.nextInt();
				weight = in.nextInt();
				graph[start][end] = weight;
			}
			
			//Use Dijsktras Alg to find Shortest Path
			Dijsktra shortestPath = new Dijsktra(graph);	
		}

	}
