class Puzzle {
    private final int n;
    private final Grid2D grid;


    Puzzle(int n) {
        this.n = n;
        this.grid = createNewGrid(new Grid2D(n), n);
    }

    private Puzzle(Grid2D grid, int n) {
        this.n = n;
        this.grid = grid;
    }

    Grid2D createNewGrid(Grid2D newGrid, int n) {
        for (int i = 1; i <= n * n; i++) {
            if (i == n * n) {
                newGrid = newGrid.add(0);
            } else {
                newGrid = newGrid.add(i);
            }
        }
        return newGrid;
    }

    // this method is to find the row index for a num
    private int rowFinder(int num) {
        int row = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid.get(i, j) == num) {
                    row = i;
                }
            }
        }
        return row;
    }

    // this method is to find the column index for a num
    private int colFinder(int num) { 
        int col = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid.get(i, j) == num) {
                    col = j;
                }
            }
        }
        return col;
    }
    
    Puzzle move(int num) {
        int r = rowFinder(num);
        int c = colFinder(num);
        int rowOfDot = rowFinder(0);
        int colOfDot = colFinder(0);

        if (r == rowOfDot) {
            if (colOfDot == c + 1 || colOfDot == c - 1) {
                //move shit here
                return new Puzzle(this.grid.set(r, c, 0).set(rowOfDot, colOfDot, num), this.n);
            }
        } else if (c == colOfDot) {
            if (rowOfDot == r + 1 || rowOfDot == r - 1) {
                //move shit here
                return new Puzzle(this.grid.set(r, c, 0).set(rowOfDot, colOfDot, num), this.n);
            }
        } 
        return this;
    
    }

    boolean isSolved() {
        int numInGrid = 1;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid.get(i, j) == numInGrid) {         
                    numInGrid++;
                }
            }
        }
        return numInGrid == n * n;
    }
    
    @Override 
    public String toString() {
        String output = "\n";
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.grid.get(i,j) == 0) {
                    output += String.format("%4s", ".");
                } else {
                    output += String.format("%4d", this.grid.get(i, j));

                } 
                if (j == this.n - 1 && i != this.n - 1) {
                    output += "\n";
                }
            }
        }
        return output; 
    }
}



