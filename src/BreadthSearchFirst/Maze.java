package BreadthSearchFirst;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {

    Location[][] grid;

    public Maze(char[][] charMaze) {
        // You need to write this constructor.
        grid = new Location[charMaze.length][charMaze[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Location(i, j, charMaze[i][j] == '.'? true: false);
            }
        }

    }

    // YOU DO NOT NEED TO MODIFY THIS METHOD, and you do not need to use it.
    // It is just here to allow me to write helpful tests for your code.
    public Location[][] getGrid() {
        return grid;
    }

    public LinkedList<Location> shortestPath(int startRow, int startCol, int endRow, int endCol) {
        // You need to write this method.
        if(startRow < 0 || startRow > grid.length || startCol < 0 || startCol > grid[0].length ||
                endRow < 0 || endRow > grid.length || endCol < 0 || endCol > grid[0].length) {
            return new LinkedList<Location>();
        }

        Queue<Location> q = new LinkedList<Location>();
        grid[startRow][startCol].markAsVisited();
        q.add(grid[startRow][startCol]);


        while(!q.isEmpty()) {
            Location loc = q.remove();
            LinkedList<Location> n = getUnvisitedOpenNeighbors(loc);

            if(loc.getRow() == endRow && loc.getCol() == endCol) {
                return backtracePath(loc);
            }else {
                for(int i = 0; i < n.size(); i++) {
                    grid[n.get(i).getRow()][n.get(i).getCol()].markAsVisited();
                    grid[n.get(i).getRow()][n.get(i).getCol()].setPreviousLocation(loc);
                    q.add(grid[n.get(i).getRow()][n.get(i).getCol()]);
                }
            }


        }

        return new LinkedList<Location>();
    }

    public LinkedList<Location> getUnvisitedOpenNeighbors(Location current) {
        // You need to write this method.
        LinkedList<Location> neighbors = new LinkedList<Location>();
        Location loc;
        if(current.getRow()-1 >= 0) {
            loc = grid[current.getRow()-1][current.getCol()];

            if(loc.isOpen() && !loc.isVisited()) {
                neighbors.add(loc);
            }
        }

        if(current.getCol()-1 >= 0) {
            loc = grid[current.getRow()][current.getCol()-1];

            if(loc.isOpen() && !loc.isVisited()) {
                neighbors.add(loc);
            }
        }

        if(current.getRow()+1 < grid.length) {
            loc = grid[current.getRow()+1][current.getCol()];

            if(loc.isOpen() && !loc.isVisited()) {
                neighbors.add(loc);
            }
        }

        if(current.getCol()+1 < grid[0].length) {
            loc = grid[current.getRow()][current.getCol()+1];

            if(loc.isOpen() && !loc.isVisited()) {
                neighbors.add(loc);
            }
        }

        return neighbors;
    }

    public static LinkedList<Location> backtracePath(Location goal) {
        // You need to write this method.
        LinkedList<Location> result = new LinkedList<Location>();
        Location pointer = goal;

        while(pointer != null) {
            result.add(0, pointer);
            pointer = pointer.getPreviousLocation();
        }

        return result;
    }

}