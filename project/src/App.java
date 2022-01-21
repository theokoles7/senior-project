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
            SimplePuzzle p = new SimplePuzzle(puzzle);
            Backtrack.solve(p);
        }
    }
}
