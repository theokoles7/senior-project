package Algorithms.BruteForce;

import Classes.*;

/**
 * The back track algorithm works by traversing every empty cell in the 
 * grid (row by row, column by column) and tests each of the numbers 1 
 * through 9 as valid candidates in the cell. If a number is found to be 
 * a valid candidate (meaning that it violates none of the rules of Sudoku), 
 * that number is assigned to the cell. If, when the algorithm moves to 
 * the next empty cell, there is no valid candidate, that simply means 
 * that the number previously entered was an invalid entry after all. 
 * The back track mechanism of the algorithm is then utilized to go 
 * back to the previous cell and find the next valid candidate before 
 * again moving on to the following empty cells.
 */

public class Backtrack{

    //==============================================================
    // Simple Puzzle Backtrack
    //==============================================================

    /**
     * Acts as the controller function for the Backtrack 
     * algorithm; Makes the call to @see _solve().
     * If the puzzle is solved successfully, "SOLVED" 
     * is printed along with the solution. Otherwise
     * "FAILED" is printed and no solution is provided.
     * @param p [SimplePuzzle] Puzzle to be solved
     */
    public static boolean solve(SimplePuzzle p){
        //p.stringify();
        if(_solve(p)){
            //p.stringify();
            return true;
        }else{
            return false;
        }
    }

    /**
     * Recursive, brute force algorithm that uses the backtracking method
     * @param p [SimplePuzzle] Puzzle to be solved
     * @return boolean [TRUE] Puzzle is solved successfully or valid 
     * candidate was found for cell [FALSE] if Sudoku violation is found
     */
    public static boolean _solve(SimplePuzzle p){
        for(int i = 0; i < p.grid.length; i++){
            for(int j = 0; j < p.grid.length; j++){
                if(p.grid[i][j] == 0){
                    for(int k = 1; k <= 9; k++){
                        if(p.numValid(k, i, j)){
                            p.grid[i][j] = k;
                            // Used to monitor moves being made by the algorithm
                            //System.out.println("[" + i + ", " + j + "] = " + k);
                            if(_solve(p)){
                                return true;
                            }else{
                                p.grid[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //==============================================================
    // Celled Puzzle Backtrack
    //==============================================================

    /**
     * Acts as the controller function for the Simple 
     * algorithm; Makes the call to @see _solve().
     * If the puzzle is solved successfully, "SOLVED" 
     * is printed along with the solution. Otherwise
     * "FAILED" is printed and no solution is provided.
     * @param p [CelledPuzzle] Puzzle to be solved
     */
    public static boolean solve(CelledPuzzle p){
        //p.stringify();
        if(_solve(p)){
            // p.stringify();
            return true;
        }else{
            return false;
        }
    }

    /**
     * Recursive, brute force algorithm that uses the backtracking method
     * @param p [CelledPuzzle] Puzzle to be solved
     * @return boolean [TRUE] Puzzle is solved successfully or valid 
     * candidate was found for cell [FALSE] if Sudoku violation is found
     */
    public static boolean _solve(CelledPuzzle p){
        for(int i = 0; i < p.grid.length; i++){
            for(int j = 0; j < p.grid.length; j++){
                if(p.grid[i][j].getVal() == 0){
                    for(int k = 1; k <= 9; k++){
                        if(p.numValid(k, i, j)){
                            p.grid[i][j].setVal(k);
                            // Used to monitor moves being made by the algorithm
                            //System.out.println("[" + i + ", " + j + "] = " + k);
                            if(_solve(p)){
                                return true;
                            }else{
                                p.grid[i][j].resVal();
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}