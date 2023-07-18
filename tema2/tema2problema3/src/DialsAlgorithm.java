import java.io.*;
import java.util.*;

public class DialsAlgorithm {

    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(destination, weight);
            adjacencyList.get(source).add(edge);
        }

        void dialAlgorithm(int source) throws IOException {
            int[] distance = new int[vertices];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[source] = 0;

            TreeSet<Integer> bucket = new TreeSet<>();
            bucket.add(source);

            while (!bucket.isEmpty()) {
                int u = bucket.first();
                bucket.remove(u);

                for (Edge edge : adjacencyList.get(u)) {
                    int v = edge.destination;
                    int weight = edge.weight;

                    if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                        if (distance[v] != Integer.MAX_VALUE) {
                            bucket.remove(v);
                        }
                        distance[v] = distance[u] + weight;
                        bucket.add(v);
                    }
                }
            }
            FileWriter fileWriter = new FileWriter( "C:\\Users\\andre\\OneDrive\\Desktop\\Prezentare_tema2_PA\\tema2\\tema2problema3\\pb3_tests\\my_test10.out");


            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < vertices; i++) {
                if(distance[i] < 2147483647)
                    bufferedWriter.write(distance[i] + " ");
                else
                    bufferedWriter.write("-1 " );
            }

            bufferedWriter.newLine();
            bufferedWriter.close();
        }
    }

    public static void main(String[] args) throws IOException {

        File myObj = new File("C:\\Users\\andre\\OneDrive\\Desktop\\Prezentare_tema2_PA\\tema2\\tema2problema3\\pb3_tests\\test10.in");
        Scanner myReader = new Scanner(myObj);
        String data = myReader.nextLine();
        int N = Integer.parseInt(data.split(" ")[0]);
        int M = Integer.parseInt(data.split(" ")[1]);
        int S = Integer.parseInt(data.split(" ")[2]);
        Graph graph = new Graph(N);
        graph.vertices = N;

        for(int i = 0; i< M; i++) {
            data = myReader.nextLine();
            int x = Integer.parseInt(data.split(" ")[0]);
            int y = Integer.parseInt(data.split(" ")[1]);
            int cost = Integer.parseInt(data.split(" ")[2]);
            graph.addEdge(x-1,y-1,cost);
        }
        myReader.close();

        graph.dialAlgorithm(S - 1);
    }
}
