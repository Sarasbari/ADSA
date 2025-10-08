import java.util.Scanner;

public class HamiltonianCycle
{
    static final int MAX = 20;

    // Function to print the Hamiltonian cycle
    static void printCycle(int[] path, int n)
    {
        System.out.print("Hamiltonian Cycle found: ");
        for (int i = 0; i < n; i++)
        {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]); // Return to starting vertex
    }

    // Function to check if vertex v can be added to the Hamiltonian Cycle
    static boolean isSafe(int v, int[][] graph, int[] path, boolean[] visited, int pos)
    {
        // Check if this vertex is adjacent to the previous vertex in the path
        if (graph[path[pos - 1]][v] == 0)
            return false;

        // Check if vertex has already been included
        if (visited[v])
            return false;

        return true;
    }

    // Recursive utility function to solve Hamiltonian Cycle problem
    static boolean hamCycleUtil(int[][] graph, int[] path, boolean[] visited, int pos, int n)
    {
        // Base case: if all vertices are included in the path
        if (pos == n)
        {
            // Check if last vertex connects back to the first vertex
            return graph[path[pos - 1]][path[0]] == 1;
        }

        // Try different vertices as the next candidate
        for (int v = 1; v < n; v++)
        {
            if (isSafe(v, graph, path, visited, pos))
            {
                path[pos] = v;
                visited[v] = true;

                // Recur to construct rest of the path
                if (hamCycleUtil(graph, path, visited, pos + 1, n))
                    return true;

                // Backtrack
                visited[v] = false;
                path[pos] = -1;
            }
        }

        return false;
    }

    // Function to find a Hamiltonian Cycle
    static void hamiltonianCycle(int[][] graph, int n)
    {
        int[] path = new int[MAX];
        boolean[] visited = new boolean[MAX];

        // Initialize path
        for (int i = 0; i < n; i++)
        {
            path[i] = -1;
            visited[i] = false;
        }

        // Start at vertex 0
        path[0] = 0;
        visited[0] = true;

        // Solve the problem using backtracking
        if (hamCycleUtil(graph, path, visited, 1, n))
            printCycle(path, n);
        else
            System.out.println("No Hamiltonian Cycle found.");
    }

    // Main function
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                graph[i][j] = sc.nextInt();
            }
        }

        hamiltonianCycle(graph, n);

        sc.close();
    }
}
