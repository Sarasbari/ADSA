import java.util.Scanner;
import java.util.Arrays;

public class dijkstraAlgorithm
{
    static final int MAX = 100;
    static final int INF = Integer.MAX_VALUE;

    // Function to find the vertex with the minimum distance value
    static int minDistance(int[] dist, boolean[] visited, int n)
    {
        int min = INF, minIndex = -1;

        for (int v = 0; v < n; v++)
        {
            if (!visited[v] && dist[v] <= min)
            {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to implement Dijkstra's algorithm
    static void dijkstra(int[][] graph, int src, int n)
    {
        int[] dist = new int[n];         // Array to hold shortest distances
        boolean[] visited = new boolean[n]; // Track visited vertices

        // Initialize distances as INFINITE and visited[] as false
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        // Distance to the source itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < n - 1; count++)
        {
            // Pick the minimum distance vertex from the set of unvisited vertices
            int u = minDistance(dist, visited, n);

            // Mark the chosen vertex as visited
            visited[u] = true;

            // Update dist[v] for all adjacent vertices of u
            for (int v = 0; v < n; v++)
            {
                // Update dist[v] only if:
                // 1. v is not visited
                // 2. There is an edge from u to v (graph[u][v] != 0)
                // 3. dist[u] is not infinity
                // 4. A shorter path is found
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF
                        && dist[u] + graph[u][v] < dist[v])
                {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the final shortest distances
        System.out.println("\nVertex\tDistance from Source (" + src + ")");
        for (int i = 0; i < n; i++)
        {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    // Main function
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter the adjacency matrix (0 if no edge):");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the source vertex (0 to " + (n - 1) + "): ");
        int src = sc.nextInt();

        dijkstra(graph, src, n);

        sc.close();
    }
}
