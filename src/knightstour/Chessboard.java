package knightstour;

import java.util.*;

public class Chessboard {

    int NO_OF_VERTICES = 64;
    List<Vertex> vertexList;
    Map<String, Vertex> vertexLabelMap;
    int[][] adjMatrix;
    int nVertices = 0;
    Map<Integer, Character> indexToCharLabelMap = new HashMap<>();
    Map<Character, Integer> charLabelToIndexMap = new HashMap<>();
    List<Vertex> visitedVertices = new ArrayList<>();

    {
        indexToCharLabelMap.put(0, 'A');
        indexToCharLabelMap.put(1, 'B');
        indexToCharLabelMap.put(2, 'C');
        indexToCharLabelMap.put(3, 'D');
        indexToCharLabelMap.put(4, 'E');
        indexToCharLabelMap.put(5, 'F');
        indexToCharLabelMap.put(6, 'G');
        indexToCharLabelMap.put(7, 'H');
        charLabelToIndexMap.put('A', 0);
        charLabelToIndexMap.put('B', 1);
        charLabelToIndexMap.put('C', 2);
        charLabelToIndexMap.put('D', 3);
        charLabelToIndexMap.put('E', 4);
        charLabelToIndexMap.put('F', 5);
        charLabelToIndexMap.put('G', 6);
        charLabelToIndexMap.put('H', 7);
    }

    Chessboard() {
        this.vertexList = new ArrayList<>();
        this.vertexLabelMap = new HashMap<>();
        this.adjMatrix = new int[8][8];
        nVertices = 0;
    }

    void createVertices() {

        for (int i = 0; i < NO_OF_VERTICES; i++) {
            String charLabel = indexToCharLabelMap.get(i / 8) + "" + ((i % 8) + 1);
            Vertex newVertex = new Vertex(charLabel);
            vertexList.add(nVertices++, newVertex);
            vertexLabelMap.put(charLabel, newVertex);
        }
    }

    void knightsTourDfs(Vertex startVertex) {
        Deque<Vertex> stack = new ArrayDeque<>();
        if (startVertex != null) {
            stack.push(startVertex);
        }
        visit(startVertex);

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.peek();
            //System.out.println("Current vertex: " + currentVertex);
            Vertex nextAdjVertex = getUnvisitedAdjacentVertexForGivenVertex(currentVertex);
            //System.out.println("Next Adjacent (unvisited) vertex: " + nextAdjVertex);
            if (nextAdjVertex == null) {
                stack.pop();
            } else {
                visit(nextAdjVertex);
                stack.push(nextAdjVertex);
            }
        }
    }

    void visit(Vertex v) {
        v.setVisited(true);
        visitedVertices.add(v);
    }

    void resetAdjMatrix() {
        for (int[] array : adjMatrix) {
            Arrays.fill(array, 0);
        }
    }

    Vertex getUnvisitedAdjacentVertexForGivenVertex(Vertex vertex) {
        modifyAdjMatrixForKnightsGivenPosition(vertex);
        for (int i = 0; i < NO_OF_VERTICES; i++) {
            if (adjMatrix[i / 8][i % 8] == 1) {
                if (!vertexList.get(i).isVisited()) {
                    return vertexList.get(i);
                }
            }
        }
        return null;
    }

    void modifyAdjMatrixForKnightsGivenPosition(Vertex vertex) {
        resetAdjMatrix();
        String vertexLabel = vertex.getLabel();
        int i = charLabelToIndexMap.get(vertexLabel.charAt(0)); //The row the knight is on i.e. A-H, but in array index form 0-7
        int j = Integer.parseInt(vertexLabel.charAt(1) + "") - 1; //The column the knight is on (index) (0-7)

        if (i + 2 <= 7 && i + 2 >= 0) {
            if (j - 1 >= 0 && j - 1 <= 7) {
                adjMatrix[i + 2][j - 1] = 1;
            }
            if (j + 1 >= 0 && j + 1 <= 7) {
                adjMatrix[i + 2][j + 1] = 1;
            }
        }
        if (i - 2 <= 7 && i - 2 >= 0) {
            if (j - 1 >= 0 && j - 1 <= 7) {
                adjMatrix[i - 2][j - 1] = 1;
            }
            if (j + 1 >= 0 && j + 1 <= 7) {
                adjMatrix[i - 2][j + 1] = 1;
            }
        }
        if (i + 1 <= 7 && i + 1 >= 0) {
            if (j - 2 >= 0 && j - 2 <= 7) {
                adjMatrix[i + 1][j - 2] = 1;
            }
            if (j + 2 >= 0 && j + 2 <= 7) {
                adjMatrix[i + 1][j + 2] = 1;
            }
        }
        if (i - 1 <= 7 && i - 1 >= 0) {
            if (j - 2 >= 0 && j - 2 <= 7) {
                adjMatrix[i - 1][j - 2] = 1;
            }
            if (j + 2 >= 0 && j + 2 <= 7) {
                adjMatrix[i - 1][j + 2] = 1;
            }
        }
    }


    void displayAdjMatrix() {
        System.out.println("-----------");
        for (int[] array : adjMatrix) {
            System.out.println(Arrays.toString(array));
        }
        System.out.println("-----------");
    }

    public static void main(String[] args) {
        Chessboard g = new Chessboard();
        g.createVertices();
        g.displayAdjMatrix();
        g.knightsTourDfs(g.vertexList.get(62));
        for(int i=0; i<g.visitedVertices.size(); i++){
            System.out.println(i+1 + ") " + g.visitedVertices.get(i).getLabel());
        }
    }

}

