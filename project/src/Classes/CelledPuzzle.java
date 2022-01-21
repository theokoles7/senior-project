package Classes;

public class CelledPuzzle {
  Cell[][] grid;

  //==============================================================
  // Constructors
  //==============================================================

  public CelledPuzzle(){
    this.grid = new Cell[9][9];
  }

  public CelledPuzzle(int[][] g){
    for(int i = 0; i < g.length; i++){
      for(int j = 0; j < g.length; j++){
        this.grid[i][j] = new Cell(g[i][j]);
      }
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
    for(int i = 0; i < grid.length; i++){
      if(grid[i][c].getVal() == n){return true;}
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
      System.out.println();
      for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid.length; j++){
              if(j == 2 || j == 5){
                  System.out.print(grid[i][j].getVal() + " | ");
              }else if(j == 8){
                  System.out.print(grid[i][j].getVal() + "\n");
              }else{
                  System.out.print(grid[i][j].getVal() + " ");
              }
          }
          if(i == 2 || i == 5){
              System.out.println("---------------------");
          }
      }
      System.out.println();
  }
}
