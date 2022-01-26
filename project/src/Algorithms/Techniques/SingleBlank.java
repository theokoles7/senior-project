package Algorithms.Techniques;

import Classes.*;

/**
 * The "single blank" technique simply tests if a cell is the
 * only blank in a row, column, or box and assigns that cells
 * value as the difference of 45 minus the sum of the already
 * existing entries in the row/column/box.
 */

public class SingleBlank {

  public static void main(String args[]){
    //testSimplePuzzle();
    testCelledPuzzle();
  }

  //==============================================================
  // Simple Puzzle Single Blank
  //==============================================================

  /**
   * Sets p[r][c] as the only missing number in the row/column/box
   * if it p[r][c] is the only blanks cell in the row/col/box
   * @param p [SimplePuzzle] Puzzle containing cell being checked
   * @param r [int] Row component of cell coordinate being checked
   * @param c [int] Column component of cell coordinate being checked
   * @return boolean [TRUE] Cell was the only blank and assigned a value 
   * [FALSE] Cell was not assigned a value
   */
  public static boolean singleBlank(SimplePuzzle p, int r, int c){
    if(p.blankInRow(r) == 1){
      p.grid[r][c] = p.diffRow(r);
      System.out.printf(
        "[%1d, %1d] = %1d (Single Blank in row)\n", 
        r, c, p.grid[r][c]
        );
      return true;
    }else if(p.blankInCol(c) == 1){
      p.grid[r][c] = p.diffCol(c);
      System.out.printf(
        "[%1d, %1d] = %1d (Single Blank in col)\n", 
        r, c, p.grid[r][c]
        );
      return true;
    }else if(p.blankInBox(r, c) == 1){
      p.grid[r][c] = p.diffBox(r, c);
      System.out.printf(
        "[%1d, %1d] = %1d (Single Blank in box)\n", 
        r, c, p.grid[r][c]
        );
      return true;
    }
    return false;
  }

  /**
   * Runs @see singleBlank() on predefined puzzle to
   * test the single blank technique on 3 specific cells.
   */
  public static void testSimplePuzzle(){
    int[][] puzzle =  {
      {5, 8, 6, 1, 3, 2, 0, 4, 7},
      {0, 0, 0, 0, 0, 0, 2, 1, 6},
      {9, 1, 0, 7, 0, 4, 0, 0, 3},
      {8, 0, 0, 0, 2, 0, 0, 0, 0},
      {2, 0, 3, 9, 1, 0, 7, 0, 0},
      {7, 9, 0, 0, 0, 3, 4, 0, 5},
      {6, 0, 0, 0, 0, 1, 5, 0, 4},
      {1, 5, 0, 0, 4, 0, 6, 7, 2},
      {3, 0, 0, 2, 0, 0, 1, 8, 9}
    };
    SimplePuzzle p = new SimplePuzzle(puzzle);
    p.stringify();
    singleBlank(p, 0, 6); // Should result in p[0, 7] being assigned to 9
    singleBlank(p, 1, 0); // Should result in p[1, 0] being assigned to 4
    singleBlank(p, 6, 7); // Should result in p[6, 7] being assigned to 3
    p.stringify();
  }

  //==============================================================
  // Celled Puzzle Single Blank
  //==============================================================

  /**
   * Sets p[r][c] as the only missing number in the row/column/box
   * if it p[r][c] is the only blanks cell in the row/col/box
   * @param p [CelledPuzzle] Puzzle containing cell being checked
   * @param r [int] Row component of cell coordinate being checked
   * @param c [int] Column component of cell coordinate being checked
   * @return boolean [TRUE] Cell was the only blank and assigned a value 
   * [FALSE] Cell was not assigned a value
   */
  public static boolean singleBlank(CelledPuzzle p, int r, int c){
    if(p.blankInRow(r) == 1){
      p.grid[r][c].setVal(p.diffRow(r));
      System.out.printf(
        "[%1d, %1d] = %1d (Single Blank in row)\n", 
        r, c, p.grid[r][c].getVal()
        );
      return true;
    }else if(p.blankInCol(c) == 1){
      p.grid[r][c].setVal(p.diffCol(c));
      System.out.printf(
        "[%1d, %1d] = %1d (Single Blank in col)\n", 
        r, c, p.grid[r][c].getVal()
        );
      return true;
    }else if(p.blankInBox(r, c) == 1){
      p.grid[r][c].setVal(p.diffBox(r, c));
      System.out.printf(
        "[%1d, %1d] = %1d (Single Blank in box)\n", 
        r, c, p.grid[r][c].getVal()
        );
      return true;
    }
    return false;
  }

  /**
   * Runs @see singleBlank() on predefined puzzle to
   * test the single blank technique on 3 specific cells.
   */
  public static void testCelledPuzzle(){
    int[][] puzzle =  {
      {5, 8, 6, 1, 3, 2, 0, 4, 7},
      {0, 0, 0, 0, 0, 0, 2, 1, 6},
      {9, 1, 0, 7, 0, 4, 0, 0, 3},
      {8, 0, 0, 0, 2, 0, 0, 0, 0},
      {2, 0, 3, 9, 1, 0, 7, 0, 0},
      {7, 9, 0, 0, 0, 3, 4, 0, 5},
      {6, 0, 0, 0, 0, 1, 5, 0, 4},
      {1, 5, 0, 0, 4, 0, 6, 7, 2},
      {3, 0, 0, 2, 0, 0, 1, 8, 9}
    };
    CelledPuzzle p = new CelledPuzzle(puzzle);
    p.stringify();
    singleBlank(p, 0, 6); // Should result in p[0, 7] being assigned to 9
    singleBlank(p, 1, 0); // Should result in p[1, 0] being assigned to 4
    singleBlank(p, 6, 7); // Should result in p[6, 7] being assigned to 3
    p.stringify();
  }
}
