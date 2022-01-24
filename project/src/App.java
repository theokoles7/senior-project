import Algorithms.BruteForce.*;
import Classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        runBacktrack();
        runEnhancedBacktrack();
    }

    public static void runBacktrack(){
        PuzzleBank puzzles = new PuzzleBank();
        String diff;
        int outer = 0;
        System.out.print(
            "\n=====================================" +
            "\n|      BACKTRACK (BRUTE FORCE)      |" +
            "\n|===================================|" +
            "\n|DIFFICULTY     SOLVED          TIME|" +
            "\n|-----------------------------------|"
        );

        for(int[][][] level : puzzles.bank){
            switch(outer){
                case 0: diff = "EASY"; break;
                case 1: diff = "MEDIUM"; break;
                case 2: diff = "HARD"; break;
                case 3: diff = "EXPERT"; break;
                case 4: diff = "EVIL"; break;
                case 5: diff = "17 CLUES"; break;
                default: diff = "ERROR"; break;
            }
            for(int[][] p : level){
                CelledPuzzle cp = new CelledPuzzle(p);
                double time = System.nanoTime();
                System.out.printf(
                    "\n|%-14s %-5b  %10.2f ms|",
                    diff,
                    Backtrack.solve(cp),
                    (System.nanoTime() - time) / 1000000
                );
            }
            outer++;
        }
        System.out.println(
            "\n=====================================\n"
        );
    }

    public static void runEnhancedBacktrack(){
        PuzzleBank puzzles = new PuzzleBank();
        String diff;
        int outer = 0;
        System.out.print(
            "\n=====================================" +
            "\n|         ENHANCED BACKTRACK        |" +
            "\n|===================================|" +
            "\n|DIFFICULTY     SOLVED          TIME|" +
            "\n|-----------------------------------|"
        );

        for(int[][][] level : puzzles.bank){
            switch(outer){
                case 0: diff = "EASY"; break;
                case 1: diff = "MEDIUM"; break;
                case 2: diff = "HARD"; break;
                case 3: diff = "EXPERT"; break;
                case 4: diff = "EVIL"; break;
                case 5: diff = "17 CLUES"; break;
                default: diff = "ERROR"; break;
            }
            for(int[][] p : level){
                CelledPuzzle cp = new CelledPuzzle(p);
                double time = System.nanoTime();
                System.out.printf(
                    "\n|%-14s %-5b  %10.2f ms|",
                    diff,
                    BacktrackEnhanced.solve(cp),
                    (System.nanoTime() - time) / 1000000
                );
            }
            outer++;
        }
        System.out.println(
            "\n=====================================\n"
        );
    }
}
