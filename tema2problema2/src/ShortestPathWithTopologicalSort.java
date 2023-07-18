import java.io.*;
import java.util.*;

public class ShortestPathWithTopologicalSort {

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void shortestPath(List<List<Edge>> graph, int source) throws IOException {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge edge : graph.get(u)) {
                    int v = edge.destination;
                    int weight = edge.weight;

                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }
        FileWriter fileWriter = new FileWriter("C:\\Users\\andre\\OneDrive\\Desktop\\Prezentare_tema2_PA\\tema2\\tema2problema2\\pb2_tests\\my_test9.out");


        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < n; i++) {
            if(dist[i] < 2147483647)
                bufferedWriter.write(dist[i] + " ");
            else
                bufferedWriter.write( "-1 ");
        }

        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    static void topologicalSortUtil(List<List<Edge>> graph, int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;

        for (Edge edge : graph.get(u)) {
            int v = edge.destination;

            if (!visited[v]) {
                topologicalSortUtil(graph, v, visited, stack);
            }
        }

        stack.push(u);
    }

    public static void main(String[] args) throws IOException {

        File myObj = new File("C:\\Users\\andre\\OneDrive\\Desktop\\Prezentare_tema2_PA\\tema2\\tema2problema2\\pb2_tests\\test9.in");
        Scanner myReader = new Scanner(myObj);
        String data = myReader.nextLine();
        int N = Integer.parseInt(data.split(" ")[0]);
        int M = Integer.parseInt(data.split(" ")[1]);
        int S = Integer.parseInt(data.split(" ")[2]);

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i< M; i++) {
            data = myReader.nextLine();
            int x = Integer.parseInt(data.split(" ")[0]);
            int y = Integer.parseInt(data.split(" ")[1]);
            int cost = Integer.parseInt(data.split(" ")[2]);
            graph.get(x - 1).add(new Edge(y - 1, cost));
        }
        myReader.close();


        shortestPath(graph, S - 1);
    }
}