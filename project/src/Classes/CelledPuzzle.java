package Classes;

public class CelledPuzzle {
  public Cell[][] grid;

  //==============================================================
  // Constructors
  //==============================================================

  public CelledPuzzle(){
    this.grid = new Cell[9][9];
  }

  public CelledPuzzle(int[][] g){
    this.grid = new Cell[9][9];
    for(int r = 0; r < g.length; r++){
      for(int c = 0; c < g.length; c++){
        this.grid[r][c] = new Cell(g[r][c]);
      }
    }
  }

  //==============================================================
  // Pencil Marks
  //==============================================================

  /**
   * Adds pencil marks for valid candidates in grid[r][c]
   * @param r [int] Row component of coordinate
   * @param c [int] Column component of coordinate
   * @see Cell.mark()
   */
  public void pencilMark(int r, int c){
    for(int i = 1; i <= grid.length; i++){
      if(numValid(i, r, c)){ grid[r][c].mark(i);}
      //else{grid[r][c].erase(i);}
    }
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
    for(Cell c : grid[r]){
      if(c.getVal() == n){return true;}
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
    for(int r = 0; r < grid.length; r++){
      if(grid[r][c].getVal() == n){return true;}
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
        if(grid[i][j].getVal() == n){return true;}
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
  // Utility
  //==============================================================

  /**
   * Prints Puzzle object in traditional sudoku format (9 rows, 9 columns)
   */
    public void stringify(){
      System.out.println("\n-------------------------------------");
      for(int r = 0; r < grid.length; r++){
          System.out.print("|");
          for(int c = 0; c < grid.length; c++){
              if(grid[r][c].getVal() != 0){
                  System.out.print(" " + grid[r][c].getVal() + " |");
              }else{
                  System.out.print("   |");
              }
          }
          System.out.println("\n-------------------------------------");
      }
      System.out.println();
  }
}
