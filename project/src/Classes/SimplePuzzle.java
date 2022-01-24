package Classes;

public class SimplePuzzle {
    public int[][] grid;

    //==============================================================
    // Constructors
    //==============================================================

    public SimplePuzzle(){
        this.grid = new int[9][9];
    }

    public SimplePuzzle(int[][] g){
        this.grid = g;
    }

    //==============================================================
    // Candidate Validation
    //==============================================================

    /**
     * Returns true if number n already exists in row r
     * @param n Number to be searched for
     * @param r Row to be searched
     * @return  boolean [TRUE] number is in row [FALSE] number is not in row
     */
    public boolean numInRow(int n, int r){
        for(int i : grid[r]){
            if(i == n){return true;}
        }
        return false;
    }

    /**
     * Returns true if number n already exists in column c
     * @param n Number to be searched for
     * @param c Column to be searched
     * @return boolean [TRUE] number is in column [FALSE] number is not in column
     */
    public boolean numInCol(int n, int c){
        for(int i = 0; i < grid.length; i ++){
            if(grid[i][c] == n){return true;}
        }
        return false;
    }

    /**
     * Returns true if number n already exists in box containing coordinate (r, c)
     * @param n Number to be searched for
     * @param r Row component of coordinate 
     * @param c Column component of coordinate
     * @return boolean [TRUE] number is in box [FALSE] number is not in box
     */
    public boolean numInBox(int n, int r, int c){
        for(int i = r - (r % 3); i <= (r - (r % 3)) + 2; i++){
            for(int j = c - (c % 3); j <= (c - (c % 3)) + 2; j++){
                if(grid[i][j] == n){return true;}
            }
        }
        return false;
    }

    /**
     * Returns true if number n is a valid candidate for coordinate (r, c)
     * @param n Number to be searched for
     * @param r Row component of coordinate
     * @param c Column component of coordinate
     * @return boolean [TRUE] number is a valid candidate [FALSE] number is not a valid candidate
     * @see numInRow(), numInCol(), numInBox()
     */
    public boolean numValid(int n, int r, int c){
        return !numInRow(n, r)
        && !numInCol(n, c)
        && !numInBox(n, r, c);
    }

    //==============================================================
    // Difference
    //==============================================================

    /**
     * Returns the difference of 45 minus the sum of the specified row
     * @param r [int] Row to be subtracted
     * @return [int] Difference of 45 - @see sumRow(r)
     */
    public int diffRow(int r){
        return 45 - sumRow(r);
    }

    /**
     * Returns the difference of 45 minus the sum of the specified column
     * @param c [int] Column to be subtracted
     * @return [int] Difference of 45 - @see sumCol(c)
     */
    public int diffCol(int c){
        return 45 - sumCol(c);
    }

    /**
     * Returns the difference of 45 minus the sum of the box containing 
     * the specified (r, c) coordinate
     * @param r [int] Row component of coordinate
     * @param c [int] Column component of coordinate
     * @return [int] Difference of 45 - @see sumBox(r, c)
     */
    public int diffBox(int r, int c){
        return 45 - sumBox(r, c);
    }

    //==============================================================
    // Sum
    //==============================================================

    /**
     * Returns the sum of the already existing entries withing the specified row
     * @param r [int] Row to be summed
     * @return [int] Sum of the row
     */
    public int sumRow(int r){
        int sum = 0;
        for(int n : grid[r]){
            sum += n;
        }
        return sum;
    }
    
    /**
     * Returns the sum of the already existing entries within the specified column
     * @param c [int] Column to be summed
     * @return [int] Sum of the column
     */
    public int sumCol(int c){
        int sum = 0;
        for(int r = 0; r < grid.length; r++){
            sum += grid[r][c];
        }
        return sum;
    }

    /**
     * Returns the sum of the already existing entries within the box containing 
     * the spcified (r, c) coordinate
     * @param r [int] Row component of coordinate
     * @param c [int] Column component of coordinate
     * @return [int] Sum of the box
     */
    public int sumBox(int r, int c){
        int sum = 0;
        for(int i = r - (r % 3); i <= (r - (r % 3)) + 2; i++){
            for(int j = c - (c % 3); j <= (c - (c % 3)) + 2; j++){
                sum += grid[i][j];
            }
        }
        return sum;
    }

    //==============================================================
    // Utility
    //==============================================================

    /**
     * Prints Puzzle object in traditional sudoku format (9 rows, 9 columns)
     */
    public void stringify(){
        System.out.println("\n-------------------------------------");
        for(int i = 0; i < grid.length; i++){
            System.out.print("|");
            for(int j = 0; j < grid.length; j++){
                if(grid[i][j] != 0){
                    System.out.print(" " + grid[i][j] + " |");
                }else{
                    System.out.print("   |");
                }
            }
            System.out.println("\n-------------------------------------");
        }
        System.out.println();
    }
}
