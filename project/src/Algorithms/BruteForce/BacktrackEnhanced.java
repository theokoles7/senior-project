package Algorithms.BruteForce;

import Classes.*;

/**
 * An enhanced version of the backtrack algorithm that first populates 
 * every empty cell's pencil marks with any valid candidates then tests 
 * only those pencil marks as valid entries instead of all numbers 1 - 9.
 */

public class BacktrackEnhanced {
  
  /**
     * Acts as the controller for the BacktrackEnhanced 
     * algorithm; First makes the call to @see pencilMarks()
     * and then makes the call to @see _solve().
     * @param p [SimplePuzzle] Puzzle to be solved
     * @return boolean 
     * [TRUE] Puzzle is solved successfully 
     * [FALSE] Failed to solve puzzle
     */
  public static boolean solve(CelledPuzzle p){
    //p.stringify();    // Print initial
    pencilMarks(p);
    if(_solve(p)){
      //p.stringify();  // Print final
      return true;
    }else{
      return false;
    }
  }


  /**
   * A version of the brute force back tracking algorithm that
   * utilizes populated pencil marks for testing versus 1 - 9
   * @param p [CelledPuzzle] Puzzle to be solved
   * @return boolean 
   * [TRUE] Puzzle is solved successfully or valid 
   * candidate was found for cell 
   * [FALSE] Sudoku violation is found
   */
  public static boolean _solve(CelledPuzzle p){
    for(int r = 0; r < p.grid.length; r++){
      for(int c = 0; c < p.grid.length; c++){
        if(p.grid[r][c].getVal() == 0){
          for(int n : p.grid[r][c].getPencilMarks()){
            if(p.numValid(n, r, c)){
              p.grid[r][c].setVal(n);
              // Used to monitor moves being made by the algorithm
              //System.out.println("[" + r + ", " + c + "] = " + n);
              if(_solve(p)){
                return true;
              }else{
                p.grid[r][c].resVal();
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Traverses through every cell of the grid, row by row,
   * column by column, while calling @see CelledPuzzle.pencilMark()
   * for each.
   * @param p [CelledPuzzle] Puzzle to populate pencil marks on
   */
  public static void pencilMarks(CelledPuzzle p){
    for(int r = 0; r < p.grid.length; r++){
      for(int c = 0; c < p.grid.length; c++){
        p.pencilMarkCell(r, c);
      }
    }
  }
}
