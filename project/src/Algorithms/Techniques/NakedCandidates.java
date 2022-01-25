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
    testNakedPairs();
  }

  public static void testNakedPairs(){
    int[][] puzzle = {
      {4, 0, 0, 0, 0, 0, 9, 3, 8},
      {0, 3, 2, 0, 9, 4, 1, 0, 0},
      {0, 9, 5, 3, 0, 0, 2, 4, 0},
      {3, 7, 0, 6, 0, 9, 0, 0, 4},
      {5, 2, 9, 0, 0, 1, 6, 7, 3},
      {6, 0, 4, 7, 0, 3, 0, 9, 0},
      {9, 5, 7, 0, 0, 8, 3, 0, 0},
      {0, 0, 3, 9, 0, 0, 4, 0, 0},
      {2, 4, 0, 0, 3, 0, 7, 0, 9}
    };
    CelledPuzzle p = new CelledPuzzle(puzzle);
    p.pencilMarkPuzzle();

    for(Cell c : p.grid[2]){
      System.out.println(
        c.getPencilMarks()
      );
    }

    System.out.println(nakedPairRow(p, 2));

    for(Cell c : p.grid[2]){
      System.out.println(
        c.getPencilMarks()
      );
    }

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

    //System.out.println(p2.getBlanksBox(7, 1) + " " + p2.blankInBox(7, 1));
    System.out.println(nakedPairBox(p2, 7, 1));

    for(int r = 6; r <= 8; r++){
      for(int c = 0; c <= 2; c++){
        System.out.println(p2.grid[r][c].getPencilMarks());
      }
    }
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
    ArrayList<Cell> blanks = p.getBlanksBox(r, c);
    if(nakedPair(blanks)){
      return true;
    }
    return false;
  }

  /**
   * Searches ArrayList of cells for a pair containing the same 
   * pair of pencil marks, then erases those pencil marks from
   * all other Cells in the ArrayList
   * @param blanks [ArrayList<Cell>] Blanks cells
   * @return boolean
   * [TRUE] Naked pair was found and erases from other cells
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

  public static boolean nakedTripleRow(CelledPuzzle p, int r){
    ArrayList<Cell> blanks = p.getBlanksCol(r);
    for(int i = 0; i < blanks.size() - 2; i++){
      for(int j = i + 1; j < blanks.size() - 1; j++){
        for(int k = j + 1; k < blanks.size(); k++){
          if(
            blanks.get(i).getPencilMarks().size() == 3
            && blanks.get(i).getPencilMarks().equals(blanks.get(j).getPencilMarks())
            && blanks.get(i).getPencilMarks().equals(blanks.get(k).getPencilMarks())
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
    return false;
  }
  
}
