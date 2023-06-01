import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    boolean [][] grid;
    public Percolation(int n) {
        grid = new boolean[n][n];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        grid[row][col] = true;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {

        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int counter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    // does the system percolate?
    public boolean percolates() {
        
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
