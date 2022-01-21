import Algorithms.*;
import Classes.*;

public class App {
    public static void main(String[] args) throws Exception {

        for(int[][] puzzle : Puzzles.minimum_clues){

            System.out.println(
                "\n=====================================" +
                "\n   SIMPLE (BRUTE FORCE/BACKTRACK)" +
                "\n====================================="
            );
            CelledPuzzle p = new CelledPuzzle(puzzle);
            Backtrack.solve(p);
        }
    }
}
