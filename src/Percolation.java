import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    boolean[][] grid;

    public Percolation(int n) {
        if (n > 0)
            grid = new boolean[n][n];
        else
            throw new IllegalArgumentException("Grid size must be of at least 1-by-1 ");
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row > 0 || col > 0)
            grid[row - 1][col - 1] = true;
        else
            throw new IllegalArgumentException("Grid size must be of at least 1-by-1 ");
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (isOpen(row, col)) {

        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int counter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
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
