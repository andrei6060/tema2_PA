import java.io.*;
import java.util.*;
import java.util.Scanner;

class Graph {
    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 1; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source - 1).add(destination - 1);
    }

    private boolean hasCycleUtil(int vertex, boolean[] visited, boolean[] recursionStack) {
        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (Integer neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                if (hasCycleUtil(neighbor, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack[neighbor]) {
                return true;
            }
        }

        recursionStack[vertex] = false;
        return false;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        boolean[] recursionStack = new boolean[vertices];

        for (int i = 1; i <= vertices; i++) {
            if (!visited[i - 1] && hasCycleUtil(i - 1, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }
}

public class CycleDetection {
    public static void main(String[] args) throws IOException {

        File myObj = new File("C:\\Users\\andre\\OneDrive\\Desktop\\Prezentare_tema2_PA\\tema2\\tema2problema1\\pb1_tests\\test10.in");
        Scanner myReader = new Scanner(myObj);
        String data = myReader.nextLine();
        int N = Integer.parseInt(data.split(" ")[0]);
        int M = Integer.parseInt(data.split(" ")[1]);
        Graph graph = new Graph(N);
        for(int i = 0; i< M; i++) {
            data = myReader.nextLine();
            int x = Integer.parseInt(data.split(" ")[0]);
            int y = Integer.parseInt(data.split(" ")[1]);
            graph.addEdge(x,y);
        }
        myReader.close();



            FileWriter fileWriter = new FileWriter("C:\\Users\\andre\\OneDrive\\Desktop\\Prezentare_tema2_PA\\tema2\\tema2problema1\\pb1_tests\\my_test10.out");


            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if (graph.hasCycle()) {
                bufferedWriter.write("are ciclu");
            } else {
                bufferedWriter.write("nu are ciclu");
            }
            bufferedWriter.newLine();
            bufferedWriter.close();


    }
}
