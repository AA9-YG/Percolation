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
        if ((row > 0 && col > 0) || (row <= grid.length && col <= grid.length))
            grid[row - 1][col - 1] = true;
        else
            throw new IllegalArgumentException("Grid size must be of at least 1-by-1 ");
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if ((row > 0 && col > 0) || (row <= grid.length && col <= grid.length))
            return grid[row - 1][col - 1];

            return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row == 1 && col == 1) { // Top left corner case
            return isOpen(row, col + 1) || isOpen(row + 1, col);
        } else if (row == 1 && col == grid.length) { // Top right corner case
            return isOpen(row, col - 1) || isOpen(row + 1, col);
        } else if (row == grid.length && col == 1) { // Bottom left corner case
            return isOpen(row, col + 1) || isOpen(row - 1, col);
        } else if (row == grid.length && col == grid.length) { // Bottom right corner case
            return isOpen(row, col - 1) || isOpen(row - 1, col);
        } else if (row == 1) { // Top row case
            return isOpen(row, col + 1) || isOpen(row, col - 1) || isOpen(row - 1, col);
        } else if (row == grid.length) { // Bottom row case
            return isOpen(row, col + 1) || isOpen(row, col - 1) || isOpen(row + 1, col);
        } else if (col == 1) { // Left column case
            return isOpen(row, col + 1) || isOpen(row + 1, col) || isOpen(row - 1, col);
        } else if (col == grid.length) { // Right column case
            return isOpen(row, col - 1) || isOpen(row + 1, col) || isOpen(row - 1, col);
        } else { // All other cases
            return isOpen(row, col + 1) || isOpen(row + 1, col)
                    || isOpen(row, col - 1) || isOpen(row - 1, col);
        }
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
