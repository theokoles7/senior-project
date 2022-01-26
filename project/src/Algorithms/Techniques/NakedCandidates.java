package Algorithms.Techniques;

import Classes.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 'Naked' in this context refers to all the remaining possible 
 * candidates on a cell which are going to be used in a strategy. 
 * The simplest such situation is a Naked Single - or the last 
 * remaining candidate on a cell.
 */

public class NakedCandidates {

  public static void main(String args[]){
    testNakedPairs();
    testNakedTriples();
    testNakedQuads();
  }

  //==============================================================
  // Pairs
  //==============================================================

  /**
   * Passes ArrayList of blank cells from row r to @see nakedPair()
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
   * Passes ArrayList of blank cells from column c to @see nakedPair()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param c [int] Column to be searched
   * @return @see nakedPair()
   */
  public static boolean nakedPairCol(CelledPuzzle p, int c){
    return nakedPair(p.getBlanksCol(c));
  }

  /**
   * Passes ArrayList of blank cells from box containing
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
      ArrayList<Integer> ipm = blanks.get(i).getPencilMarks();
      if(ipm.size() == 2){
        for(int j = i + 1; j < blanks.size(); j++){
          ArrayList<Integer> jpm = blanks.get(j).getPencilMarks();
          if(ipm.equals(jpm)){
              blanks.remove(j);
              blanks.remove(i);
              for(Cell cell : blanks){
                for(int n : ipm){
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

  //==============================================================
  // Triples
  //==============================================================

  /**
   * Passes ArrayList of blank cells from row r to @see nakedTriple()
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
   * Passes ArrayList of blank cells from column c to @see nakedTriple()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param c [int] Column to be searched
   * @return @see nakedTriple()
   */
  public static boolean nakedTripleCol(CelledPuzzle p, int c){
    return nakedTriple(p.getBlanksCol(c));
  }

  /**
   * Passes ArrayList of blank cells from box containing
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
      ArrayList<Integer> triple = new ArrayList<>();
      ArrayList<Integer> ipm = blanks.get(i).getPencilMarks();
      if(ipm.size() == 3){
        triple.add(i);
        for(int j = 0; j < blanks.size(); j++){
          ArrayList<Integer> jpm = blanks.get(j).getPencilMarks();
          if(
            (j != i) &&
            ((jpm.size() == 2
            && matchingPair(ipm, jpm))
            || (ipm.equals(jpm)))
          ){
            triple.add(j);
            for(int k = 0; k < blanks.size(); k++){
            ArrayList<Integer> kpm = blanks.get(k).getPencilMarks();
              if(
                (k != i && k != j) &&
                ((kpm.size() == 2
                && matchingPair(ipm, kpm)
                && matchingSingle(jpm, kpm))
                || (ipm.equals(kpm)))
              ){
                triple.add(k);
                Collections.sort(triple, Collections.reverseOrder());
                for(int n : triple){
                  blanks.remove(n);
                }
                for(Cell cell : blanks){
                  for(int n : ipm){
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
  // Quads
  //==============================================================

  /**
   * Passes ArrayList of blank cells from row r to @see nakedQuad()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param r [int] Row to be searched
   * @return @see nakedQuad()
   * [TRUE] Naked pair was found and eliminated from other blanks cells
   * [FALSE] Naked pair not found
   */
  public static boolean nakedQuadRow(CelledPuzzle p, int r){
    return nakedQuad(p.getBlanksRow(r));
  }

  /**
   * Passes ArrayList of blank cells from column c to @see nakedQuad()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param c [int] Column to be searched
   * @return @see nakedQuad()
   */
  public static boolean nakedQuadCol(CelledPuzzle p, int c){
    return nakedQuad(p.getBlanksCol(c));
  }

  /**
   * Passes ArrayList of blank cells from box containing
   * the cell (r, c) to @see nakedQuad()
   * @param p [CelledPuzzle] Puzzle being analyzed
   * @param r [int] Row component of cell coordinate
   * @param c [int] Column component of cell coordinate
   * @return @see nakedQuad()
   */
  public static boolean nakedQuadBox(CelledPuzzle p, int r, int c){
    return nakedQuad(p.getBlanksBox(r, c));
  }

  /**
   * Searches ArrayList of cells for a quad containing the same 
   * quad of pencil marks, then erases those pencil marks from
   * all other Cells in the ArrayList
   * @param blanks [ArrayList<Cell>] Blank cells
   * @return boolean
   * [TRUE] Naked quad was found and erased from other cells
   * [FALSE] Naked quad not found
   */
  public static boolean nakedQuad(ArrayList<Cell> blanks){
    for(int i = 0; i < blanks.size(); i++){
      ArrayList<Integer> quad = new ArrayList<>();
      ArrayList<Integer> ipm = blanks.get(i).getPencilMarks();
      if(ipm.size() == 4){
        quad.add(i);
        for(int j = 0; j < blanks.size(); j++){
          ArrayList<Integer> jpm = blanks.get(j).getPencilMarks();
          if(
            (j != i) &&
            ((jpm.size() == 2
            && matchingPair(ipm, jpm))
            || (ipm.equals(jpm)))
          ){
            quad.add(j);
            for(int k = 0; k < blanks.size(); k++){
              ArrayList<Integer> kpm = blanks.get(k).getPencilMarks();
              if(
                (k != i && k != j) &&
                ((kpm.size() == 2
                && matchingPair(ipm, kpm)
                && matchingSingle(jpm, kpm))
                ||(ipm.equals(kpm)))
              ){
                quad.add(k);
                for(int l = 0; l < blanks.size(); l++){
                  ArrayList<Integer> lpm = blanks.get(l).getPencilMarks();
                  if(
                    (l != i && l != j && l != k) &&
                    ((lpm.size() == 2
                    && matchingPair(ipm, lpm)
                    && matchingSingle(jpm, lpm)
                    && matchingSingle(kpm, lpm))
                    ||(ipm.equals(lpm)))
                  ){
                    quad.add(l);
                    Collections.sort(quad, Collections.reverseOrder());
                    for(int n : quad){
                      blanks.remove(n);
                    }
                    for(Cell cell : blanks){
                      for(int n : ipm){
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

  /**
   * Runs @see nakedQuadRow() on a predefined puzzle 
   * to test @see nakedQuad() on box 1 of said puzzle
   */
  public static void testNakedQuads(){
    System.out.print(
        "\n=====================================" +
        "\n|          Naked Quad Test          |" +
        "\n|===================================|"
    );
    int[][] puzzle = {
      {0, 0, 0, 0, 3, 0, 0, 8, 6},
      {0, 0, 0, 0, 2, 0, 0, 4, 0},
      {0, 9, 0, 0, 7, 8, 5, 2, 0},
      {3, 7, 1, 8, 5, 6, 2, 9, 4},
      {9, 0, 0, 1, 4, 2, 3, 7, 5},
      {4, 0, 0, 3, 9, 7, 6, 1, 8},
      {2, 0, 0, 7, 0, 3, 8, 5, 9},
      {0, 3, 9, 2, 0, 5, 4, 6, 7},
      {7, 0, 0, 9, 0, 4, 1, 3, 2}
    };
    CelledPuzzle p = new CelledPuzzle(puzzle);
    p.pencilMarkPuzzle();
    p.stringify();
    System.out.println(
      "Candidates before nakedQuad():"
    );
    for(int r = 0; r < 3; r++){
      for(int c = 0; c < 3; c++){
        System.out.println(
          "[" + r + ", " + c + "] = " +
          p.grid[r][c].getPencilMarks()
          );
      }
    }
    System.out.println(
      "\nNaked Quad Found: " + nakedQuadBox(p, 0, 0));
    System.out.println(
      "\nCandidates after nakedQuad():"
    );
    for(int r = 0; r < 3; r++){
      for(int c = 0; c < 3; c++){
        System.out.println(
          "[" + r + ", " + c + "] = " +
          p.grid[r][c].getPencilMarks()
          );
      }
    }
    System.out.println(
        "\n=====================================\n"
    );
  }

  /**
   * Runs @see nakedTripleRow() on a predefined puzzle 
   * to test @see nakedTriple() on row 5 of said puzzle
   */
  public static void testNakedTriples(){
    System.out.print(
        "\n=====================================" +
        "\n|         Naked Triple Test         |" +
        "\n|===================================|"
    );
    int[][] puzzle = {
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
    CelledPuzzle p = new CelledPuzzle(puzzle);
    p.pencilMarkPuzzle();
    p.stringify();
    System.out.println(
      "Candidates before nakedTriple():"
    );
    for(int c = 0; c < p.grid[4].length; c++){
      System.out.println(
        "[" + 4 + ", " + c + "] = " +
        p.grid[4][c].getPencilMarks());
    }
    System.out.println(
      "\nNaked triple found: " + nakedTripleRow(p, 4));
    System.out.println(
      "\nCandidates after nakedTriple():"
    );
    for(int c = 0; c < p.grid[4].length; c++){
      System.out.println(
        "[" + 4 + ", " + c + "] = " +
        p.grid[4][c].getPencilMarks());
    }
    System.out.println(
        "\n=====================================\n"
    );
  }

  /**
   * Runs @see nakedPairBox() on a predefined puzzle 
   * to test @see nakedPair() on box 7 of said puzzle
   */
  public static void testNakedPairs(){
    System.out.print(
        "\n=====================================" +
        "\n|          Naked Pair Test          |" +
        "\n|===================================|"
    );
    int[][] puzzle = {
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
    CelledPuzzle p = new CelledPuzzle(puzzle);
    p.pencilMarkPuzzle();
    p.stringify();
    System.out.println(
      "Candidates before nakedPair():"
    );
    for(int r = 6; r <= 8; r++){
      for(int c = 0; c <= 2; c++){
        System.out.println(
          "[" + r + ", " + c + "] = " +
          p.grid[r][c].getPencilMarks()
          );
      }
    }
    System.out.println("\nNaked pair found: " + nakedPairBox(p, 7, 1));
    System.out.println(
      "\nCandidates after nakedPair():"
    );
    for(int r = 6; r <= 8; r++){
      for(int c = 0; c <= 2; c++){
        System.out.println(
          "[" + r + ", " + c + "] = " +
          p.grid[r][c].getPencilMarks()
          );
      }
    }
    System.out.println(
        "\n=====================================\n"
    );
  }
  
}
