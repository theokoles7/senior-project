import Algorithms.*;
import Sudoku.*;

public class App {
    public static void main(String[] args) throws Exception {

        for(int[][] puzzle : Puzzles.minimum_clues){

            System.out.println(
                "\n========================================" +
                "\n     SIMPLE (BRUTE FORCE/BACKTRACK)" +
                "\n========================================"
            );
            Puzzle_Simple p = new Puzzle_Simple(puzzle);
            Simple.solve(p);
        }
    }
}
