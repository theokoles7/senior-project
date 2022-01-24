import Algorithms.BruteForce.*;
import Classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        runBacktrack();
        runEnhancedBacktrack();
    }

    public static void runBacktrack(){
        PuzzleBank puzzles = new PuzzleBank();
        System.out.print(
            "\n=====================================" +
            "\n|      BACKTRACK (BRUTE FORCE)      |" +
            "\n|===================================|" +
            "\n|DIFFICULTY     SOLVED          TIME|" +
            "\n|-----------------------------------|"
        );

        for(int[][] p : puzzles.easy){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "EASY",
                Backtrack.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : puzzles.medium){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "MEDIUM",
                Backtrack.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : puzzles.hard){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "HARD",
                Backtrack.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : puzzles.expert){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "EXPERT",
                Backtrack.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : puzzles.evil){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "EVIL",
                Backtrack.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : puzzles.minimum_clues){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "17 Clues",
                Backtrack.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }
        System.out.println(
            "\n=====================================\n"
        );
    }

    public static void runEnhancedBacktrack(){
        PuzzleBank puzzles = new PuzzleBank();
        System.out.print(
            "\n=====================================" +
            "\n|        ENHANCED BACKTRACK         |" +
            "\n|===================================|" +
            "\n|DIFFICULTY     SOLVED          TIME|" +
            "\n|-----------------------------------|"
        );

        for(int[][] p : puzzles.easy){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "EASY",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : puzzles.medium){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "MEDIUM",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : puzzles.hard){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "HARD",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : puzzles.expert){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "EXPERT",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : puzzles.evil){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "EVIL",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }

        for(int[][] p : puzzles.minimum_clues){
            CelledPuzzle cp = new CelledPuzzle(p);
            double time = System.nanoTime();
            System.out.printf(
                "\n|%-14s %-5b  %10.2f ms|",
                "17 Clues",
                BacktrackEnhanced.solve(cp),
                (System.nanoTime() - time) / 1000000
            );
        }
        System.out.println(
            "\n=====================================\n"
        );
    }
}
