package graphs.directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The purpose of this class is to demonstrate how to determine if a cycle exists within a
 * directed graph.
 *
 * --Method--
 *
 * Consider a directec connected graph.
 *
 * 1) We start at a source vertex and perform DFS.
 *
 * 2) At each iteration of our DFS we begin by setting the vertexes beingVisited property to true.
 *
 * 3) We then iterate across the neighbor vertices and if they have the property 'beingVisited' as true, then we
 * have identified a backward edge and hence a cycle has been detected as we have traversed right back to the vertex
 * we had already encountered in our DFS.
 *
 * 4) If the vertex has not been visited we move to that vertex and check for a cycle.
 *
 * 5) If after iterating through all of a nodes neighbors we cannot detect a cycle, we set the sourceVertices beingVisited
 * property to false and setVisited to true. (backtracking esque).
 *
 *
 */
public class CycleDetection {

    public static void main(String[] args) {
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");
        Vertex v3 = new Vertex("D");

        v0.addNeighbor(v2);
        v0.addNeighbor(v3);
        v1.addNeighbor(v0);
        v2.addNeighbor(v1);
        List<Vertex> vertices = Arrays.asList(v0, v1, v2, v3);
        Graph graph = new Graph(vertices);
        System.out.println(graph.hasCycle(v0));
    }
}


class Graph {

    private List<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public Graph(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    void addVertex(Vertex vertex) {
        this.vertices.add(vertex);
    }

    void addEdge(Vertex from, Vertex to) {
        from.addNeighbor(to);
    }

    boolean hasCycle(Vertex sourceVertex) {
        sourceVertex.setBeingVisited(true);
        for (Vertex neighbor : sourceVertex.getAdjacencyList()) {
            if (neighbor.isBeingVisited()) {
                return true;
            } else if (!neighbor.isVisited()) {
                return hasCycle(neighbor);
            }
        }
        sourceVertex.setBeingVisited(false);
        sourceVertex.setVisited(true);
        return false;
    }

}

class Vertex {

    private String label;
    private boolean beingVisited;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(String label) {
        this.label = label;
        this.adjacencyList = new ArrayList<>();
    }

    public void addNeighbor(Vertex adjacent) {
        this.adjacencyList.add(adjacent);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Vertex> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}
