package recursion;

import java.util.*;

public class RobotInAGrid {

    static int rows = 3;
    static int cols = 3;
    static String offLimitCells = "1,1|0,1"; //off-limit cells will be set to true in the visited array.

    public static void main(String[] args){
        int[][] grid = setUpGrid(rows, cols);
        int startX = 0;
        int startY = 0;
        moveThroughGrid(startX, startY, grid);
    }

    public static int[][] setUpGrid(int rows, int cols){
        System.out.println("\nSetting up grid of size: " + rows + "x" + cols);
        return new int[rows][cols];
    }

    public static void moveThroughGrid(int startX, int startY, int[][] grid){
        boolean[][] visited = new boolean[rows][cols];
        setOffLimitCells(offLimitCells, visited);
        Stack<String> stack = new Stack<>();
        stack.add(startX+","+startY);
        int noOfTimesVisitedPreVisitedCell = 0;
        int noOfTimesGoneOffGrid = 0;
        int noOfIterations = 0;
        System.out.print("PATH: ");
        while(!stack.isEmpty()){
            noOfIterations++;
            String currentPosition = stack.pop();
            int row = Integer.parseInt(currentPosition.split(",")[0]);
            int col = Integer.parseInt(currentPosition.split(",")[1]);

            if(checkIfCoordinateIsOffGrid(row, col)){
                noOfTimesGoneOffGrid++;
                continue; //skip iteration of while loop;
            }
            if(visited[row][col]){
                noOfTimesVisitedPreVisitedCell++;
                continue; //skip if cell has already been visited
            }
            visited[row][col] = true;
            System.out.print("("+ currentPosition + ")" + " ");
            stack.add((row+1)+","+col); //Move Down
            stack.add(row+","+(col+1)); //Move Right

            if(visited[rows-1][cols-1]){
                System.out.format("\nWe have reached the end of the grid.");
                break;
            }
        }

        if(!visited[rows-1][cols-1]){
            System.out.println("\nUnable to find a path to the end of the grid.");
        }

        System.out.format("\nWe have revisited pre-visited cells %d times",  noOfTimesVisitedPreVisitedCell);
        System.out.format("\nWe have attempted to go off the grid %d times", noOfTimesGoneOffGrid);
        System.out.format("\nWe have iterated through %d coordinates", noOfIterations);
    }

    public static boolean checkIfCoordinateIsOffGrid(int x, int y){
        return (x<0 || y<0 || x>=rows || y>=cols);
    }

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
