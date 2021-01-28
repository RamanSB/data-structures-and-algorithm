package graphs;

import java.util.*;

public class Graph {

    private static final int MAX_VERTICES = 8*8;
    private List<Vertex> vertexList;
    private int[][] adjMatrix = new int[8][8];
    int nVertices = 0;

    Graph(List<Vertex> vertexList){
        this.vertexList = new ArrayList<>(MAX_VERTICES);
        for(int[] array : adjMatrix){
            Arrays.fill(array, 0);
        }
        this.vertexList = vertexList;
    }

    void addEdge(int source, int target){
        adjMatrix[source][target] = 1;
    }

    void removeEdge(int source, int target){
        adjMatrix[source][target] = 0;
    }

    boolean addVertex(Vertex vertex){
        if (!vertexList.contains(vertex)) {
            vertexList.add(vertex);
            return true;
        }
        System.out.println(vertex + " already exists in Graph.");
        return false;
    }

    void visit(Vertex vertex){
        vertex.setVisited(true);
    }

    public static void main(String[] args){
        Graph chessBoard = new Graph(createVertices());
        chessBoard.knightsTourDFS(new Vertex("H7"));
    }

    /**
     * initialises vertices used in a chess board.
     0-7 : A
     8-15: B
     16-23: C
     24-31: D
     32-39: E
     40-47: F
     48-55: G
     56-63: H
     * @return
     */
    static List<Vertex> createVertices(){
        List<Vertex> vertexList = new ArrayList<>();
        char[] labelPrefixes = {'A','B','C','D','E','F','G','H'};
        String label;
        for(int i=0; i<MAX_VERTICES; i++){
            label = ""+labelPrefixes[i/8]+((i%8)+1);
            vertexList.add(new Vertex(label));
        }
        return vertexList;
    }

    void knightsTourDFS(Vertex sourceNode){
        Deque<Vertex> stack = new ArrayDeque<>();
        stack.push(sourceNode);
        modifyAdjMatrixForKnight(stack.pop());
//        while(!stack.isEmpty()){
//
//        }
    }

    /**
     * A knight can move 2 steps horizontally or vertically follow by 1 step vertically or horizontally, respectively.
     *
     * @param currentVertex
     * @return
     */
    int[][] modifyAdjMatrixForKnight(Vertex currentVertex){
        for(int[] array : adjMatrix){ //clearing the adj matrix
            Arrays.fill(array, 0);
        }
        System.out.println(currentVertex);
        String vertexLabel = currentVertex.getLabel();
        String chessboardIndex = vertexLabelToIndex(vertexLabel);
        int i = Integer.parseInt(chessboardIndex.substring(0,1));
        int j = Integer.parseInt(chessboardIndex.substring(1,2)) - 1;
        System.out.println("Chessboad Index: " + chessboardIndex);
        System.out.println("Index on chessboard: " + i+","+j);
        if(i+2>=0 && i+2<=7){
            if(j+1>=0 && j+1<=7){
                adjMatrix[i+2][j+1] = 1;
                adjMatrix[j+1][i+2] = 1;
            }
            if(j-1>=0 && j-1<=7){
                adjMatrix[i+2][j-1] = 1;
                adjMatrix[j-1][i+2] = 1;
            }
        }
        if(i-2>=0 && i-2<=7){
            if(j+1>=0 && j+1<=7){
                adjMatrix[i-2][j+1] = 1;
                adjMatrix[j+1][i-2] = 1;
            }
            if(j-1>=0 && j-1<=7){
                adjMatrix[i-2][j-1] = 1;
                adjMatrix[j-1][i-2] = 1;
            }
        }if(i+1>=0 && i+1<=7){
            if(j+2>=0 && j+2<=7){
                adjMatrix[i+1][j+2] = 1;
                adjMatrix[j+2][i+1] = 1;
            }
            if(j-2>=0 && j-2<=7){
                adjMatrix[i-1][j-2] = 1;
                adjMatrix[j-2][i-1] = 1;
            }
        }if(i-1>=0 && i-1<=7){
            if(j+2>=0 && j+2<=7){
                adjMatrix[i-1][j+2] = 1;
                adjMatrix[j+2][i-1] = 1;
            }
            if(j-2>=0 && j-2<=7){
                adjMatrix[i-1][j-2] = 1;
                adjMatrix[j-2][i-1] = 1;
            }
        }
        displayAdjMatrix();
        return adjMatrix;
    }

    void displayAdjMatrix(){
        for(int[] row : adjMatrix){
            System.out.println(Arrays.toString(row));
        }
    }

    String vertexLabelToIndex(String label){
        char[] indexChars = {'x','|','x'};
        Map<Character, Integer> letterToIndexMap = new HashMap<>();
        letterToIndexMap.put('A', 0);
        letterToIndexMap.put('B', 1);
        letterToIndexMap.put('C', 2);
        letterToIndexMap.put('D', 3);
        letterToIndexMap.put('E', 4);
        letterToIndexMap.put('F', 5);
        letterToIndexMap.put('G', 6);
        letterToIndexMap.put('H', 7);
        indexChars[0] = String.valueOf(letterToIndexMap.get(label.charAt(0))).charAt(0);
        indexChars[2] = label.charAt(1);
        System.out.println(Arrays.toString(indexChars));
        return indexChars[0] + "" + indexChars[2];
    }



}
