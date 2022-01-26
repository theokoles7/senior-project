package Algorithms.Techniques;

import Classes.*;
import java.util.ArrayList;

/**
 * 'Naked' in this context refers to all the remaining possible 
 * candidates on a cell which are going to be used in a strategy. 
 * The simplest such situation is a Naked Single - or the last 
 * remaining candidate on a cell.
 */

public class NakedCandidates {

  public static void main(String args[]){
    //testNakedPairs();
    testNakedTriples();
  }

  //==============================================================
  // Pairs
  //==============================================================

  /**
   * Passes ArrayList of blanks cells from row r to @see nakedPair()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param r [int] Row to be searched
   * @return @see nakedPair()
   * [TRUE] Naked pair was found and eliminated from other blanks cells
   * [FALSE] Naked pair not found
   */
  public static boolean nakedPairRow(CelledPuzzle p, int r){
    return nakedPair(p.getBlanksRow(r));
  }

  /**
   * Passes ArrayList of blanks cells from column c to @see nakedPair()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param c [int] Column to be searched
   * @return @see nakedPair()
   */
  public static boolean nakedPairCol(CelledPuzzle p, int c){
    return nakedPair(p.getBlanksCol(c));
  }

  /**
   * Passes ArrayList of blanks cells from box containing
   * the cell (r, c) to @see nakedPair()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param r [int] Row component of cell coordinate
   * @param c [int] Column component of cell coordinate
   * @return @see nakedPair()
   */
  public static boolean nakedPairBox(CelledPuzzle p, int r, int c){
    return nakedPair(p.getBlanksBox(r, c));
  }

  /**
   * Searches ArrayList of cells for a pair containing the same 
   * pair of pencil marks, then erases those pencil marks from
   * all other Cells in the ArrayList
   * @param blanks [ArrayList<Cell>] Blank cells
   * @return boolean
   * [TRUE] Naked pair was found and erase from other cells
   * [FALSE] Naked pair not found
   */
  public static boolean nakedPair(ArrayList<Cell> blanks){
    for(int i = 0; i < blanks.size() - 1; i++){
      for(int j = i + 1; j < blanks.size(); j++){
        if(
          blanks.get(i).getPencilMarks().size() == 2 
          && blanks.get(i).getPencilMarks().equals(blanks.get(j).getPencilMarks())
          ){
            blanks.remove(j);
            Cell temp = blanks.remove(i);
            for(Cell cell : blanks){
              for(int n : temp.getPencilMarks()){
                cell.erase(n);
              }
            }
            return true;
        }
      }
    }
    return false;
  }

  //==============================================================
  // Triples
  //==============================================================

  /**
   * Passes ArrayList of blanks cells from row r to @see nakedTriple()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param r [int] Row to be searched
   * @return @see nakedTriple()
   * [TRUE] Naked pair was found and eliminated from other blanks cells
   * [FALSE] Naked pair not found
   */
  public static boolean nakedTripleRow(CelledPuzzle p, int r){
    return nakedTriple(p.getBlanksRow(r));
  }

  /**
   * Passes ArrayList of blanks cells from column c to @see nakedTriple()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param c [int] Column to be searched
   * @return @see nakedTriple()
   */
  public static boolean nakedTripleCol(CelledPuzzle p, int c){
    return nakedTriple(p.getBlanksCol(c));
  }

  /**
   * Passes ArrayList of blanks cells from box containing
   * the cell (r, c) to @see nakedTriple()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param r [int] Row component of cell coordinate
   * @param c [int] Column component of cell coordinate
   * @return @see nakedTriple()
   */
  public static boolean nakedTripleBox(CelledPuzzle p, int r, int c){
    return nakedTriple(p.getBlanksBox(r, c));
  }

  /**
   * Searches ArrayList of cells for a triple containing the same 
   * triple of pencil marks, then erases those pencil marks from
   * all other Cells in the ArrayList
   * @param blanks [ArrayList<Cell>] Blank cells
   * @return boolean
   * [TRUE] Naked triple was found and erased from other cells
   * [FALSE] Naked triple not found
   */
  public static boolean nakedTriple(ArrayList<Cell> blanks){
    for(int i = 0; i < blanks.size() - 2; i++){
      if(blanks.get(i).getPencilMarks().size() == 3){
        for(int j = 0; j < blanks.size(); j++){
          if(
            (j != i) &&
            ((blanks.get(j).getPencilMarks().size() == 2
            && matchingPair(blanks.get(i).getPencilMarks(), blanks.get(j).getPencilMarks()))
            || (blanks.get(j).getPencilMarks().size() == 3
            && blanks.get(i).getPencilMarks().equals(blanks.get(j).getPencilMarks())))
          ){for(int k = 0; k < blanks.size(); k++){
              if(
                (k != i && k != j) &&
                ((blanks.get(k).getPencilMarks().size() == 2
                && matchingPair(blanks.get(i).getPencilMarks(), blanks.get(k).getPencilMarks())
                && matchingSingle(blanks.get(j).getPencilMarks(), blanks.get(k).getPencilMarks()))
                || (blanks.get(k).getPencilMarks().size() == 3
                && blanks.get(i).getPencilMarks().equals(blanks.get(k).getPencilMarks())))
              ){
                blanks.remove(k);
                blanks.remove(j);
                Cell temp = blanks.remove(i);
                for(Cell cell : blanks){
                  for(int n : temp.getPencilMarks()){
                    cell.erase(n);
                  }
                }
                return true;
              }
            }           
          }
        }
      }
    }
    return false;
  }

  //==============================================================
  // Helpers
  //==============================================================

  /**
   * Determines if two lists of pencil marks contain at least one matching candidate
   * @param pm1 [ArrayList<Integer>] Pencil marks of first cell being compared
   * @param pm2 [ArrayList<Integer>] Pencil marks of second cell being compared
   * @return boolean
   * [TRUE] At least one match found
   * [FALSE] No match found
   */
  public static boolean matchingSingle(ArrayList<Integer> pm1, ArrayList<Integer> pm2){
    for(int n1 : pm1){
      for(int n2 : pm2){
        if(n1 == n2){
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Determines if two lists of pencil marks contain at least one matching pair of candidates
   * @param pm1 [ArrayList<Integer>] Pencil marks of first cell being compared
   * @param pm2 [ArrayList<Integer>] Pencil marks of second cell being compared
   * @return boolean
   * [TRUE] At least one matching pair found
   * [FALSE] No matching pair found
   */
  public static boolean matchingPair(ArrayList<Integer> pm1, ArrayList<Integer> pm2){
    int matches = 0;
    for(int n1 : pm1){
      for(int n2 : pm2){
        if(n1 == n2){
          if(++matches == 2){return true;}
        }
      }
    }
    return false;
  }

  /**
   * Determines if two lists of pencil marks contain at least one matching triple of candidates
   * @param pm1 [ArrayList<Integer>] Pencil marks of first cell being compared
   * @param pm2 [ArrayList<Integer>] Pencil marks of second cell being compared
   * @return boolean
   * [TRUE] At least on matching triple found
   * [FALSE] No matching triple found
   */
  public static boolean matchingTriple(ArrayList<Integer> pm1, ArrayList<Integer> pm2){
    int matches = 0;
    for(int n1 : pm1){
      for(int n2 : pm2){
        if(n1 == n2){
          if(++matches == 3){return true;}
        }
      }
    }
    return false;
  }

  /**
   * Determines if two lists of pencil marks contain at least one matching quad of candidates
   * @param pm1 [ArrayList<Integer>] Pencil marks of first cell being compared
   * @param pm2 [ArrayList<Integer>] Pencil marks of second cell being compared
   * @return boolean
   * [TRUE] At least on matching quad found
   * [FALSE] No matching quad found
   */
  public static boolean matchingQuad(ArrayList<Integer> pm1, ArrayList<Integer> pm2){
    int matches = 0;
    for(int n1 : pm1){
      for(int n2 : pm2){
        if(n1 == n2){
          if(++matches == 4){return true;}
        }
      }
    }
    return false;
  }

  //==============================================================
  // Testing
  //==============================================================

  public static void testNakedTriples(){
    int[][] puzzle1 = {
      {0, 7, 0, 4, 0, 8, 0, 2, 9},
      {0, 0, 2, 0, 0, 0, 0, 0, 4},
      {8, 5, 4, 0, 2, 0, 0, 0, 7},
      {0, 0, 8, 3, 7, 4, 2, 0, 0},
      {0, 2, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 3, 2, 6, 1, 7, 0, 0},
      {0, 0, 0, 0, 9, 3, 6, 1, 2},
      {2, 0, 0, 0, 0, 0, 4, 0, 3},
      {1, 3, 0, 6, 4, 2, 0, 7, 0}
    };
    CelledPuzzle p1 = new CelledPuzzle(puzzle1);
    p1.pencilMarkPuzzle();

    for(Cell c : p1.grid[4]){
      System.out.println(c.getPencilMarks());
    }

    System.out.println(nakedTripleRow(p1, 4));

    for(Cell c : p1.grid[4]){
      System.out.println(c.getPencilMarks());
    }
  }

  public static void testNakedPairs(){
    // int[][] puzzle = {
    //   {4, 0, 0, 0, 0, 0, 9, 3, 8},
    //   {0, 3, 2, 0, 9, 4, 1, 0, 0},
    //   {0, 9, 5, 3, 0, 0, 2, 4, 0},
    //   {3, 7, 0, 6, 0, 9, 0, 0, 4},
    //   {5, 2, 9, 0, 0, 1, 6, 7, 3},
    //   {6, 0, 4, 7, 0, 3, 0, 9, 0},
    //   {9, 5, 7, 0, 0, 8, 3, 0, 0},
    //   {0, 0, 3, 9, 0, 0, 4, 0, 0},
    //   {2, 4, 0, 0, 3, 0, 7, 0, 9}
    // };
    // CelledPuzzle p = new CelledPuzzle(puzzle);
    // p.pencilMarkPuzzle();

    // for(Cell c : p.grid[2]){
    //   System.out.println(
    //     c.getPencilMarks()
    //   );
    // }

    // System.out.println(nakedPairRow(p, 2));

    // for(Cell c : p.grid[2]){
    //   System.out.println(
    //     c.getPencilMarks()
    //   );
    // }

    System.out.println("---------------------------------");
    int[][] puzzle2 = {
      {0, 8, 0, 0, 9, 0, 0, 3, 0},
      {0, 3, 0, 0, 0, 0, 0, 6, 9},
      {9, 0, 2, 0, 6, 3, 1, 5, 8},
      {0, 2, 0, 8, 0, 4, 5, 9, 0},
      {8, 5, 1, 9, 0, 7, 0, 4, 6},
      {3, 9, 4, 6, 0, 5, 8, 7, 0},
      {5, 6, 3, 0, 4, 0, 9, 8, 7},
      {2, 0, 0, 0, 0, 0, 0, 1, 5},
      {0, 1, 0, 0, 5, 0, 0, 2, 0}
    };
    CelledPuzzle p2 = new CelledPuzzle(puzzle2);
    p2.pencilMarkPuzzle();

    for(int r = 6; r <= 8; r++){
      for(int c = 0; c <= 2; c++){
        System.out.println(p2.grid[r][c].getPencilMarks());
      }
    }

    System.out.println("\n" + nakedPairBox(p2, 7, 1) + "\n");

    for(int r = 6; r <= 8; r++){
      for(int c = 0; c <= 2; c++){
        System.out.println(p2.grid[r][c].getPencilMarks());
      }
    }

    // System.out.println("---------------------------------");
    // int[][] puzzle3 = {
    //   {0, 8, 0, 0, 9, 0, 0, 3, 0},
    //   {0, 3, 0, 0, 0, 0, 0, 6, 9},
    //   {9, 0, 2, 0, 6, 3, 1, 5, 8},
    //   {0, 2, 0, 8, 0, 4, 5, 9, 0},
    //   {8, 5, 1, 9, 0, 7, 0, 4, 6},
    //   {3, 9, 4, 6, 0, 5, 8, 7, 0},
    //   {5, 6, 3, 0, 4, 0, 9, 8, 7},
    //   {2, 0, 0, 0, 0, 0, 0, 1, 5},
    //   {0, 1, 0, 0, 5, 0, 0, 2, 0}
    // };
    // CelledPuzzle p3 = new CelledPuzzle(puzzle3);
    // p3.pencilMarkPuzzle();

    // for(Cell[] row : p3.grid){
    //   System.out.println(row[5].getPencilMarks());
    // }

    // System.out.println(nakedPairCol(p3, 5));

    // for(Cell[] row : p3.grid){
    //   System.out.println(row[5].getPencilMarks());
    // }
  }
  
}
