import Algorithms.*;
import Classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        //runBacktrack();
        runEnhancedBacktrack();
    }

    public static void runBacktrack(){
        System.out.println(
            "\n=====================================" +
            "\n       BACKTRACK (BRUTE FORCE)" +
            "\n=====================================" +
            "\nDIFFICULTY     SOLVED           TIME" +
            "\n-------------------------------------"
        );

        for(int[][] p : Puzzles.easy){
            SimplePuzzle sp = new SimplePuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "EASY",
                Backtrack.solve(sp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : Puzzles.medium){
            SimplePuzzle sp = new SimplePuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "MEDIUM",
                Backtrack.solve(sp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : Puzzles.hard){
            SimplePuzzle sp = new SimplePuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "HARD",
                Backtrack.solve(sp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : Puzzles.expert){
            SimplePuzzle sp = new SimplePuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "EXPERT",
                Backtrack.solve(sp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : Puzzles.evil){
            SimplePuzzle sp = new SimplePuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "EVIL",
                Backtrack.solve(sp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : Puzzles.minimum_clues){
            SimplePuzzle sp = new SimplePuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "17 Clues",
                Backtrack.solve(sp),
                (System.nanoTime() - time) / 1000000
            );
        }
        System.out.println();
    }

    public static void runEnhancedBacktrack(){
        System.out.println(
            "\n=====================================" +
            "\n         ENHANCED BACKTRACK" +
            "\n=====================================" +
            "\nDIFFICULTY     SOLVED           TIME" +
            "\n-------------------------------------"
        );

        for(int[][] p : Puzzles.easy){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "EASY",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : Puzzles.medium){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "MEDIUM",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : Puzzles.hard){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "HARD",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : Puzzles.expert){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "EXPERT",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : Puzzles.evil){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "EVIL",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : Puzzles.minimum_clues){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n%-14s %-5b  %12.2f ms",
                "17 Clues",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }
        System.out.println();
    }
}
