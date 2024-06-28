package treesandgraphs;

import java.util.*;

/**
 * 4.1 Route between nodes: Given a directed graph, design an algorithm to find out whether there is a route between
 * 2 nodes.
 *
 * Attempting a BFS this will check all nearest neighbors of node k, before checking the neighbors of nodes k+1.
 *
 * BFS is preferred in this case as a DFS could traverse deeply in to subsequent neighbors and will be waste of computational
 * work. DFS is easier to implement as it can be done recusrvively. BFS is NOT recursive. BFS can be used to find the shortest
 * path.
 */

public class Graph41 {

    List<Vertex> vertexList;
    int nVertices;
    int[][] adjMatrix;

    Graph41(int nVertices){
        this.nVertices = nVertices;
        this.vertexList = new ArrayList<>();
        this.adjMatrix = new int[nVertices][nVertices];
        for(char c='A'; c<'A'+nVertices; c++){
            this.vertexList.add(new Vertex(c));
        }
        System.out.println("Vertex list: " + vertexList);
    }

    void addDirectedEdge(int start, int end){
        adjMatrix[start][end] = 1;
    }

    void addDirectedEdge(char startLabel, char endLabel){
        addDirectedEdge(((int) startLabel) - 65, ((int) endLabel) - 65);
    }

    void displayAdjMatrix(){
        System.out.println("----Adj Matrix----");
        for(int[] rows : adjMatrix){
            System.out.println(Arrays.toString(rows));
        }
    }

    public static void main(String[] args){
        Graph41 graph = new Graph41(5);
        graph.addDirectedEdge('A', 'E');
        graph.addDirectedEdge('A', 'D');
        graph.addDirectedEdge('B', 'C');
        graph.addDirectedEdge('C', 'D');
        graph.addDirectedEdge('D', 'B');
        graph.displayAdjMatrix();
        graph.bfs(graph.vertexList.get(0), graph.vertexList.get(2));
    }

    void bfs(Vertex startVertex, Vertex endVertex){
        Queue<Vertex> queue = new ArrayDeque<>();
        queue.offer(startVertex);
        visit(startVertex);
        Vertex adjUnvisitedVertex;

        while(!queue.isEmpty()){
            System.out.println(queue);
            Vertex currentVertex = queue.poll();
            while((adjUnvisitedVertex = getAdjacentUnvisitedVertex(currentVertex)) != null){
                visit(adjUnvisitedVertex);
                queue.offer(adjUnvisitedVertex);
                System.out.println("*" + currentVertex + "" + adjUnvisitedVertex);
                System.out.println("Visited vertex: " + adjUnvisitedVertex);
                if(endVertex == adjUnvisitedVertex){
                    System.out.println("Visited end vertex");
                    break;
                }
            }
        }
    }

    Vertex getAdjacentUnvisitedVertex(Vertex vertex){
        int vertexRow = ((int) vertex.getLabel()) - 65;
        for(int i=0; i<nVertices; i++){
            if(adjMatrix[vertexRow][i] == 1 && !vertexList.get(i).wasVisited){
                return vertexList.get(i);
            }
        }
        return null; //If no adjacent vertices that are unvisited exist.
    }

    void visit(Vertex vertex){
        vertex.wasVisited = true;
    }





    static class Vertex{
        final char label;
        boolean wasVisited;

        Vertex(char label){
            this.label = label;
            this.wasVisited = false; //already defaults to false anyway
        }

        @Override
        public String toString(){
            return String.format("%s", label);
        }

        public Character getLabel(){
            return label;
        }
    }

}
