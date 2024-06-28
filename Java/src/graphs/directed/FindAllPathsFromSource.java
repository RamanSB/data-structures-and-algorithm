package graphs.directed;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for determining all paths from a source vertex to a destination vertex using
 * backtracking (DFS).
 */
class FindAllPathsFromSourceToDestination {

    public static void main(String[] args) {

        int n=5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {4, 1}, {2, 1}};

        // Generating adjacencyList
        List<List<Integer>> adjacencyList = generateAdjacencyList(n, edges);
        // Select source vertex.
        int sourceVertex = 0;
        int destinationVertex = 4;
        // Find all paths from sourceVertex that traverse all nodes only once.
        List<List<Integer>> solutions = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(sourceVertex);
        backtrack(currentPath, sourceVertex, destinationVertex, solutions, adjacencyList);
        System.out.println(solutions);
    }

    private static void backtrack(
            List<Integer> currentPath,
            int currentVertex,
            int destinationVertex,
            List<List<Integer>> solutions,
            List<List<Integer>> adjacencyList) {

        if (currentVertex == destinationVertex) {
            solutions.add(new ArrayList<>(currentPath));
            return;
        }

        for (Integer neighbor: adjacencyList.get(currentVertex)) {
            currentPath.add(neighbor);
            backtrack(new ArrayList<>(currentPath), neighbor, destinationVertex, solutions, adjacencyList);
            currentPath.remove(neighbor);
        }
    }

    private static List<List<Integer>> generateAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i< n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
        }
        return adjacencyList;
    }

}