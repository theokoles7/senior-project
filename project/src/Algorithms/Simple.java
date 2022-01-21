package Algorithms;

import Sudoku.Puzzle;

public class Simple{

    public static boolean _solve(Puzzle p){
        for(int i = 0; i < p.grid.length; i++){
            for(int j = 0; j < p.grid.length; j++){
                if(p.grid[i][j] == 0){
                    for(int k = 1; k <= 9; k++){
                        if(p.numValid(k, i, j)){
                            p.grid[i][j] = k;
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