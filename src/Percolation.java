import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    boolean[][] grid;

    public Percolation(int n) {
        if (n > 0) {
            grid = new boolean[n][n];

            // Set initial values to false
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] = false;
                }
            }

        } else
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
        if (isOpen(row, col)) {
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
        } else return false;
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

        if (numberOfOpenSites() < grid.length)
            return false;
        else {
            for (int i = grid[grid.length - 1].length - 1; i >= 0; i--) { // looping through the columns (in this case the row index is unnecessary since the grid is a square)
                if (isFull(grid.length, i)) {

                }
            }
        }
        return false;
    }

    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");

            for (int j = 0; j < grid[i].length; j++) {
                if (isOpen(i + 1, j + 1))
                    System.out.print("T | ");
                else
                    System.out.print("F | ");
            }

            System.out.println();
        }

        System.out.println();
    }

    // test client (optional)
    public static void main(String[] args) {

//        Percolation percolation = new Percolation(5);
//        percolation.printGrid();
//
//        percolation.open(1, 1);
//        percolation.open(1, 2);
//        percolation.open(2, 2);
//        percolation.open(3, 2);
//        percolation.open(4, 2);
//        percolation.open(5, 2);
//        percolation.open(5, 3);
//        percolation.open(4, 4);
//
//        percolation.printGrid();
//
//        // Check corner cases
//        System.out.println("Is (1,1) open? -> " + percolation.isOpen(1, 1));
//        System.out.println("Is (1,1) full? -> " + percolation.isFull(1, 1));
//        System.out.println("Is (1,5) open? -> " + percolation.isOpen(1, 5));
//        System.out.println("Is (1,5) full? -> " + percolation.isFull(1, 5));
//        System.out.println("Is (5,1) open? -> " + percolation.isOpen(5, 1));
//        System.out.println("Is (5,1) full? -> " + percolation.isFull(5, 1));
//        System.out.println("Is (5,5) open? -> " + percolation.isOpen(5, 5));
//        System.out.println("Is (5,5) full? -> " + percolation.isFull(5, 5));
//
//        // Check top & bottom row cases
//        System.out.println("Is (1,3) open? -> " + percolation.isOpen(1, 3));
//        System.out.println("Is (1,3) full? -> " + percolation.isFull(1, 3));
//        System.out.println("Is (5,3) open? -> " + percolation.isOpen(5, 3));
//        System.out.println("Is (5,3) full? -> " + percolation.isFull(5, 3));
//
//        // Check left & right column cases
//        System.out.println("Is (3,1) open? -> " + percolation.isOpen(3, 1));
//        System.out.println("Is (3,1) full? -> " + percolation.isFull(3, 1));
//        System.out.println("Is (3,5) open? -> " + percolation.isOpen(3, 5));
//        System.out.println("Is (3,5) full? -> " + percolation.isFull(3, 5));
//
//        // Check other cases
//        System.out.println("Is (2,2) open? -> " + percolation.isOpen(2, 2));
//        System.out.println("Is (2,2) full? -> " + percolation.isFull(2, 2));
//        System.out.println("Is (3,3) open? -> " + percolation.isOpen(3, 3));
//        System.out.println("Is (3,3) full? -> " + percolation.isFull(3, 3));
//        System.out.println("Is (4,4) open? -> " + percolation.isOpen(4, 4));
//        System.out.println("Is (4,4) full? -> " + percolation.isFull(4, 4));
//
//        System.out.println(percolation.numberOfOpenSites());
    }

}
