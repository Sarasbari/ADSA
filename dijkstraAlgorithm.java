
// Dijkstra's Algorithm in Java
import java.util.*;

public class dijkstraAlgorithm {

    static final int INF = 999999;

    int findMinDistance(int dist[], boolean visited[], int V) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void dijkstra(int graph[][], int src, int V) {
        int dist[] = new int[V]; // shortest distances
        boolean visited[] = new boolean[V]; // visited vertices

        // Initialize distances
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            int u = findMinDistance(dist, visited, V);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }

        // Print results
        System.out.println("\nVertex\tDistance from Source (" + src + ")");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t" + dist[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        int graph[][] = new int[V][V];

        System.out.println("Enter cost adjacency matrix (0 if no edge):");
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = sc.nextInt();

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        dijkstraAlgorithm d = new dijkstraAlgorithm();
        d.dijkstra(graph, src, V);

        sc.close();
    }
}