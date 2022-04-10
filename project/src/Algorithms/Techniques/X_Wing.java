package Algorithms.Techniques;

import Classes.*;

 /**
  * The "X-Wing" technique is used when two rows/columns each have
  * exactly two cells that, when lines are drawn from each of the
  * opposing cells, form an "X" and contain the same valid candidate. 
  * In such a case, said valid candidate is eliminated from all cells
  * in orthogonal rows/columns of those cells.
  */

public class X_Wing {

  public static void main(String args[]){
    System.out.print(
        "\n=====================================" +
        "\n|            X_Wing Test            |" +
        "\n|===================================|"
    );

    testRow();

    System.out.print(
      "\n=====================================\n"
    );

    testCol();
  }

  //==============================================================
  // Searches
  //==============================================================

  /**
   * Executes the X-Wing technique on specified row in puzzle
   * @param p [CelledPuzzle] Puzzle object
   * @param r1 [int] Row number in puzzle
   */
  public static void row(CelledPuzzle p, int r1){
    for(int n = 0; n < p.grid.length; n++){
      if(nQuantRow(p.grid[r1], n) == 2){
        System.out.println("\nRow " + r1 + " has 2 " + n + "'s");
        for(int r2 = 0; r2 < p.grid.length; r2++){
          if(r2 != r1 && nQuantRow(p.grid[r2], n) == 2){
            System.out.println("\tRow " + r2 + " has 2 " + n + "'s");
            for(int c1 = 0; c1 < p.grid.length; c1++){
              if(p.grid[r1][c1].hasMark(n) && p.grid[r2][c1].hasMark(n)){
                System.out.println("\t\tMatch 1 at column " + c1);
                for(int c2 = c1 + 1; c2 < p.grid.length; c2++){
                  if(p.grid[r1][c2].hasMark(n) && p.grid[r2][c2].hasMark(n)){
                    System.out.println("\t\t\tMatch 2 at column " + c2);
                    eraseN(p, r1, r2, c1, c2, n);
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  /**
   * Executes the X-Wing technique on specified column in puzzle
   * @param p [CelledPuzzle] Puzzle object
   * @param c1 [int] Column number in puzzle
   */
  public static void col(CelledPuzzle p, int c1){
    for(int n = 0; n < p.grid.length; n++){
      if(nQuantCol(p, c1, n) == 2){
        System.out.println("\nColumn " + c1 + " has 2 " + n + "'s");
        for(int c2 = 0; c2 < p.grid.length; c2++){
          if(c2 != c1 && nQuantCol(p, c2, n) == 2){
            System.out.println("\tColumn " + c2 + " has 2 " + n + "'s");
            for(int r1 = 0; r1 < p.grid.length; r1++){
              if(p.grid[r1][c1].hasMark(n) && p.grid[r1][c2].hasMark(n)){
                System.out.println("\t\tMatch 1 at row " + r1);
                for(int r2 = r1 + 1; r2 < p.grid.length; r2++){
                  if(p.grid[r2][c1].hasMark(n) && p.grid[r2][c2].hasMark(n)){
                    System.out.println("\t\t\tMatch 2 at row " + r2);
                    eraseN(p, r1, r2, c1, c2, n);
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  //==============================================================
  // Erase
  //==============================================================

  /**
   * Erases integer n from pencil marks of all cells in rows and
   * columns specified, except for the cells at which the rows and
   * columns intersect
   * @param p [CelledPuzzle] Puzzle object
   * @param r1 [int] Row 1
   * @param r2 [int] Row 2
   * @param c1 [int] Column 1
   * @param c2 [int] Column 2
   * @param n [int] Integer being erased
   */
  public static void eraseN(CelledPuzzle p, int r1, int r2, int c1, int c2, int n){
    System.out.println(
      "\t\t\t\tErasing " + n + " from row " +
      r1 + ", row " + r2 + ", col " + c1 +
      ", and col " + c2
    );
    for(int r = 0, c = 0; r < p.grid.length; r++, c++){
      if(c != c1 && c != c2){
        p.grid[r1][c].erase(n);
        p.grid[r2][c].erase(n);
      }
      if(r != r1 && r != r2){
        p.grid[r][c1].erase(n);
        p.grid[r][c2].erase(n);
      }
    }
  }

  //==============================================================
  // Helpers
  //==============================================================

  /**
   * Counts occurences of n in row
   * @param r [Cell[]] Row being parsed
   * @param n [int] Integer being counted in row
   * @return [int] Occurences of n
   */
  public static int nQuantRow(Cell[] r, int n){
    int q = 0;
    for(Cell c : r){
      if(c.hasMark(n)){q++;}
    }
    return q;
  }

  /**
   * Counts occurences of n in column
   * @param p [CelledPuzzle] Puzzle containing column
   * @param p [int] Column number in puzzle
   * @param n [int] Integer being counted in column
   * @return [int] Occurences of n
   */
  public static int nQuantCol(CelledPuzzle p, int c, int n){
    int q = 0;
    for(Cell[] r : p.grid){
      if(r[c].hasMark(n)){q++;}
    }
    return q;
  }

  /**
   * Prints pencil marks of each cell in row
   * @param p [CelledPuzzle] Puzzle containing row
   * @param r [int] Row number in puzzle
   */
  public static void printMarksRow(CelledPuzzle p, int r){
    System.out.println(
      "\nPencil marks for row " + r + ":"
    );
    for(int c = 0; c < p.grid.length; c++){
      System.out.println(
        "[" + r + ", " + c + "] = " + p.grid[r][c].getPencilMarks()
      );
    }
  }

  /**
   * Prints pencil marks of each cell in column
   * @param p [CelledPuzzle] Puzzle containing column
   * @param c [int] Column number in puzzle
   */
  public static void printMarksCol(CelledPuzzle p, int c){
    System.out.println(
      "\nPencil marks for column " + c + ":"
    );
    for(int r = 0; r < p.grid.length; r++){
      System.out.println(
        "[" + r + ", " + c + "] = " + p.grid[r][c].getPencilMarks()
      );
    }
  }

  //==============================================================
  // Testing
  //==============================================================

  /**
   * Runs @see row() on a predefined puzzle 
   * to test @see row() on row 2 of said puzzle
   */
  public static void testRow(){
    int[][] puzzle = {
      {0, 0, 3, 8, 0, 0, 5, 1, 0},
      {0, 0, 8, 7, 0, 0, 9, 3, 0},
      {1, 0, 0, 3, 0, 5, 7, 2, 8},
      {0, 0, 0, 2, 0, 0, 8, 4, 9},
      {8, 0, 1, 9, 0, 6, 2, 5, 7},
      {0, 0, 0, 5, 0, 0, 1, 6, 3},
      {9, 6, 4, 1, 2, 7, 3, 8, 5},
      {3, 8, 2, 6, 5, 9, 4, 7, 1},
      {0, 1, 0, 4, 0, 0, 6, 9, 2}
    };

    CelledPuzzle p = new CelledPuzzle(puzzle);
    p.pencilMarkPuzzle();

    System.out.println(
      "\nBefore row test:"
    );
    p.stringify();

    printMarksRow(p, 2);
    printMarksRow(p, 4);

    printMarksCol(p, 1);
    printMarksCol(p, 4);

    row(p, 2);

    System.out.println(
      "\nAfter row test:"
    );

    printMarksRow(p, 2);
    printMarksRow(p, 4);

    printMarksCol(p, 1);
    printMarksCol(p, 4);
  }

  /**
   * Runs @see col() on a predefined puzzle 
   * to test @see col() on row 1 of said puzzle
   */
  public static void testCol(){
    int[][] puzzle = {
      {6, 0, 0, 0, 9, 5, 0, 0, 7},
      {5, 4, 0, 0, 0, 7, 1, 0, 0},
      {0, 0, 2, 8, 0, 0, 0, 5, 0},
      {8, 0, 0, 0, 0, 0, 0, 9, 0},
      {0, 0, 0, 0, 7, 8, 0, 0, 0},
      {0, 3, 0, 0, 0, 0, 0, 0, 8},
      {0, 5, 0, 0, 0, 2, 3, 0, 0},
      {3, 0, 4, 5, 0, 0, 0, 2, 0},
      {9, 2, 0, 0, 3, 0, 5, 0, 4}
    };

    CelledPuzzle p = new CelledPuzzle(puzzle);
    p.pencilMarkPuzzle();

    System.out.println(
      "\nBefore column test:"
    );
    p.stringify();

    printMarksCol(p, 1);
    printMarksCol(p, 6);

    printMarksRow(p, 0);
    printMarksRow(p, 7);

    col(p, 1);

    System.out.println(
      "\nAfter column test:"
    );

    printMarksCol(p, 1);
    printMarksCol(p, 6);

    printMarksRow(p, 0);
    printMarksRow(p, 7);
  }
}
