package task2.console;

import lombok.Getter;
import lombok.Setter;
import task2.Task2;
import task2.console.structure.ConsoleObjs;
import task2.console.structure.ConsoleObj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter

/*

class which releases console operations in task 2
Task2 - main class
scanner - read lines in console
n - size of cities
temp1 - for definition check class ConsoleObjs please(it's just array of that definition)
temp2 - for definition check class ConsoleObj please(it's just array of that definition)
*/

public class ConsoledGraph {
    private Task2 task2;
    private Scanner scanner;
    private int n;
    private ConsoleObjs[] temp1;
    private ConsoleObj[] temp2;

    public ConsoledGraph(Task2 task2, Scanner scanner, int n) {
        this.task2 = task2;
        this.scanner = scanner;
        this.n = n;
        temp1 = new ConsoleObjs[n];
    }

    //Builds Graph data
    public void buildGraphData() {
        for (int i = 0; i < n; i++) {
            String city = scanner.nextLine();
            int sosedsCount = scanner.nextInt();
            scanner.nextLine();

            temp2 = new ConsoleObj[sosedsCount];

            for (int j = 0; j < sosedsCount; j++) {
                String line = scanner.nextLine(); //cost & index of neighbor
                String[] parts = line.split(" ");

                temp2[j] = new ConsoleObj(Integer.parseInt(parts[1]), Integer.parseInt(parts[0]) - 1);
            }
            temp1[i] = new ConsoleObjs(city, temp2);
        }
        buildGraph();
    }


    //Builds graph
    public void buildGraph() {
        int sosedCount;

        // Adding vertexes
        for (int i = 0; i < n; i++) {
            task2.graph.addVertex(temp1[i].getCurrentCity());
        }


        // Adding edges & weights
        for (int i = 0; i < n; i++) {
            sosedCount = temp1[i].getConsoleObjs().length;

            for (int j = 0; j < sosedCount; j++) {
                int currentNeighborIndex = temp1[i].getConsoleObjs()[j].getCityNeighborIndex();

                //Making sure that the index is valid
                if (currentNeighborIndex >= 0 && currentNeighborIndex < n) {
                    int currentNeighborWeight = temp1[i].getConsoleObjs()[j].getCost();
                    String from = temp1[i].getCurrentCity();
                    String to = temp1[currentNeighborIndex].getCurrentCity();

                    task2.graph.addEdge(from, to);
                    task2.graph.setEdgeWeight(from, to, currentNeighborWeight);
                }
            }
        }
    }

    //Reads queries and prints result of queries
    public void inputOutputQueries() {
        int queriesCount = scanner.nextInt();

        if(queriesCount > 100) {
            System.out.println("Error: the number of paths to find must be lower or equal 100!");
            return;
        }

        scanner.nextLine();

        List<String[]> queries = new ArrayList<>(queriesCount);

        for (int i = 0; i < queriesCount; i++) {
            String query = scanner.nextLine();
            queries.add(query.split(" "));
        }

        for (int i = 0; i < queries.size(); i++) {
            String[] queryBegEnd = queries.get(i);

            long minCost = task2.getMinSum(queryBegEnd[0], queryBegEnd[1]);
            System.out.println(minCost);
        }
    }
}
