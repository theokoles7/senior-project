package Algorithms;

import Sudoku.Puzzle;

public class Simple{

    /**
     * Recursive, brute force algorithm that uses the backtracking method
     * @param p Puzzle to be solved
     * @return boolean [TRUE] Puzzle is solved successfully or valid 
     * candidate was found for cell [FALSE] if Sudoku violation is found
     */
    public static boolean _solve(Puzzle p){
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

    /**
     * Acts as the controller function for the Simple 
     * algorithm; Makes the call to @see _solve().
     * If the puzzle is solved successfully, "SOLVED" 
     * is printed along with the solution. Otherwise
     * "FAILED" is printed and no solution is provided.
     * @param p Puzzle to be solved
     */
    public static void solve(Puzzle p){
        p.stringify();
        if(_solve(p)){
            System.out.println("*******SOLVED*******");
            p.stringify();
        }else{
            System.out.println("*******FAILED*******");
        }
    }
}