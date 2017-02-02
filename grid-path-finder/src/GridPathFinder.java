import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by mystique on 11/20/16.
 */
public class GridPathFinder {

    public ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length-1, maze[0].length-1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        if(row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col);
        if (failedPoints.contains(p)) {
            return false;
        }
        boolean isAtOrigin = (row == 0 && col == 0);
        if(isAtOrigin || getPath(maze, row, col-1, path, failedPoints) || getPath(maze, row-1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }

    public static void main(String[] args) {
        boolean[][] maze = new boolean[10][10];
        for(int i = 0; i < 10; i++) {
            System.out.println();
            for(int j = 0; j < 10; j++) {
                maze[i][j] = true;
                System.out.print(" " + maze[i][j]);
            }
            System.out.println();
        }
        GridPathFinder finder = new GridPathFinder();
        ArrayList<Point> path = finder.getPath(maze);
        System.out.println(path);
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
