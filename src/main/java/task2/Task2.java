package task2;

import org.jgrapht.Graph;
import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import task2.console.ConsoledGraph;

import java.util.Scanner;

//Class to release Task 2(Main class)
public class Task2 {
    // Using DirectedWeightedMultigraph, which supports edge weight
    public Graph<String, DefaultWeightedEdge> graph = new DirectedWeightedMultigraph<>(DefaultWeightedEdge.class);

    // Method to find the minimum cost of a path from cityStart to cityEnd
    public long getMinSum(String cityStart, String cityEnd) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
        var path = dijkstra.getPath(cityStart, cityEnd);

        // If a path exists, return its total cost (weight)
        if (path != null && path.getWeight() < 200000) {
            return (long) path.getWeight();
        } else {
            System.out.println("Error in Task2.java, method getMinSum: path.getWeight() is above than 200000 or path is null");
            return Long.MAX_VALUE;
        }

    }

    //main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount, n;
        testCount = scanner.nextInt();
        scanner.nextLine();

        if(testCount > 10) {
            System.out.println("Error: the number of tests must be lower or equal 10!");
            return;
        }

        for (int i = 0; i < testCount; i++) {
            n = scanner.nextInt();
            scanner.nextLine();

            if(n > 10000) {
                System.out.println("Error: the number of cities must be lower or equal 10000!");
                return;
            }

            ConsoledGraph consoledGraph = new ConsoledGraph(new Task2(), scanner, n);

            consoledGraph.buildGraphData();

            consoledGraph.inputOutputQueries();

            if (i < testCount - 1) {
                scanner.nextLine();  //removes empty string between tests
            }
        }
    }
}
