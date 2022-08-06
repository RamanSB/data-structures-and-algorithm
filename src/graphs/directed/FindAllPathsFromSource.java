package graphs.directed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class finds all paths from a source vertex to another vertex whereby nodes can only be visited once.
 */
class FindAllPathsFromSource {

    public static void main(String[] args) {

        int n=5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {4, 1}};

        // Generating adjacencyList
        List<List<Integer>> adjacencyList = generateAdjacencyList(n, edges);
        // Select source vertex.
        int sourceVertex = 0;
        // Find all paths from sourceVertex that traverse all nodes only once.
        List<List<Integer>> solutions = new ArrayList<>();
        generatePathFromSource(sourceVertex, adjacencyList, new ArrayList<>(), solutions, new HashSet<Integer>());
        System.out.println(solutions);
    }

    private static void generatePathFromSource(
            int sourceVertex,
            List<List<Integer>> adjacencyList,
            List<Integer> path,
            List<List<Integer>> solutions,
            Set<Integer> visited) {

        if (adjacencyList.get(sourceVertex).isEmpty() || visited.containsAll(adjacencyList.get(sourceVertex))) {
            path.add(sourceVertex);
            solutions.add(path);
            return;
        }

        path.add(sourceVertex);
        visited.add(sourceVertex);
        for (int neighbor: adjacencyList.get(sourceVertex)) {
            if (!visited.contains(neighbor)) {
                generatePathFromSource(neighbor, adjacencyList, new ArrayList<>(path), solutions, new HashSet<>(visited));
            }
        }
        path.remove(new Integer(sourceVertex));
        visited.remove(sourceVertex);
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