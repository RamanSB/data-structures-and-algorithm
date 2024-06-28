package recursion;

import java.util.*;

/**
 * Only 2 possible moves can be made in this problem; down or right.
 * Some cells are off-limit (this has been achieved by setting the off-limit cells to true meaning they have already been visited).
 */

public class RobotInAGrid {

    static int rows = 3;
    static int cols = 3;
    static String offLimitCells = "1,1|0,1"; //off-limit cells will be set to true in the visited array.

    public static void main(String[] args){
        int[][] grid = setUpGrid(rows, cols); //We simply use a 2D array to represent the grid in question.
        int startX = 0; //defining starting point.
        int startY = 0;
        moveThroughGrid(startX, startY, grid); //begin Depth first search.
    }

    public static int[][] setUpGrid(int rows, int cols){
        System.out.println("\nSetting up grid of size: " + rows + "x" + cols);
        return new int[rows][cols];
    }

    public static void moveThroughGrid(int startX, int startY, int[][] grid){
        boolean[][] visited = new boolean[rows][cols];
        setOffLimitCells(offLimitCells, visited); //Here we state cells/coordinates/points in the grid that we must NOT traverse.
        Stack<String> stack = new Stack<>(); //Depth First Search (DFS) use Stack & reveals shortest path.
        stack.add(startX+","+startY); //We add the starting point to the top of our stack. (Stacks are LIFO) (Last in, first out)
        int noOfTimesVisitedPreVisitedCell = 0;
        int noOfTimesGoneOffGrid = 0;
        int noOfIterations = 0;
        System.out.print("PATH: ");
        while(!stack.isEmpty()){
            noOfIterations++;
            String currentPosition = stack.pop(); //Remove/pop current position from the Stack
            int row = Integer.parseInt(currentPosition.split(",")[0]);
            int col = Integer.parseInt(currentPosition.split(",")[1]);

            if(checkIfCoordinateIsOffGrid(row, col)){ //If the coordinate popped from the stack is off the grid, we skip it.
                noOfTimesGoneOffGrid++;
                continue; //skip iteration of while loop;
            }
            if(visited[row][col]){ //If the coordinate popped from the stack has been visited already, we skip it.
                noOfTimesVisitedPreVisitedCell++;
                continue; //skip if cell has already been visited
            }
            visited[row][col] = true;
            System.out.print("("+ currentPosition + ")" + " ");
            stack.add((row+1)+","+col); //Move Down (add the coordinates of the next coordinate in the grid if we were to move down to the stack)
            stack.add(row+","+(col+1)); //Move Right (add the coordinates of the next coordinate in the grid if we were to move right to the stack.)

            if(visited[rows-1][cols-1]){
                System.out.format("\nWe have reached the end of the grid.");
                break;
            }
        }

        if(!visited[rows-1][cols-1]){ //If the stack is empty and the last cell in the grid hasn't been visited - then unfortunately no valid path was found.
            System.out.println("\nUnable to find a path to the end of the grid.");
        }

        System.out.format("\nWe have revisited pre-visited cells %d times",  noOfTimesVisitedPreVisitedCell);
        System.out.format("\nWe have attempted to go off the grid %d times", noOfTimesGoneOffGrid);
        System.out.format("\nWe have iterated through %d coordinates", noOfIterations);
    }

    public static boolean checkIfCoordinateIsOffGrid(int x, int y){
        return (x<0 || y<0 || x>=rows || y>=cols);
    }

    /**
     * Used to set cells that are off-limits as described in the question.
     * @param offLimitCells
     * @param visitedArray
     */
    public static void setOffLimitCells(String offLimitCells, boolean[][] visitedArray){
        String[] cells = offLimitCells.split("\\|");
        System.out.println("Off limit cells: " + Arrays.toString(cells));
        Arrays.stream(cells).forEach(
                data -> {
                    int x = Integer.parseInt(data.split(",")[0]);
                    int y = Integer.parseInt(data.split(",")[1]);
                    visitedArray[x][y] = true;
                }
        );
    }

}
