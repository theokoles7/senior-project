package Classes;

import java.util.ArrayList;

public class Cell {
  private int value;
  private ArrayList<Integer> pencil_marks;

  //==============================================================
  // Constructors
  //==============================================================

  public Cell(){
    this.value = 0;
    this.pencil_marks = new ArrayList<>();
  }

  public Cell(int v){
    this.value = v;
    this.pencil_marks = new ArrayList<>();
  }

  //==============================================================
  // Value
  //==============================================================

  /**
   * Returns the cell's value
   * @return [int] Cell.value
   */
  public int getVal(){
    return this.value;
  }

  /**
   * Sets the cell's value
   * @param n [int] Number to set Cell.value to
   */
  public void setVal(int n){
    this.value = n;
  }

  /**
   * Resets Cell.value to zero
   */
  public void resVal(){
    this.value = 0;
  }

  //==============================================================
  // Pencil Marks
  //==============================================================

  /**
   * Adds a pencil mark (valid candidate) for the cell
   * @param n [int] Number being added as pencil mark
   * @return [TRUE] Number added [FALSE] Number already present
   */
  public boolean mark(int n){
    return this.pencil_marks.add(n);
  }

  /**
   * Removes a pencil mark (valid candidate) for the cell
   * @param n [int] Number to be removed from pencil marks
   * @return [TRUE] Number was removed [FALSE] Number did not exist
   */
  public boolean erase(Integer n){
    return this.pencil_marks.remove(n);
  }

  /**
   * Returns the cell's pencil marks
   * @return [SortedSet<Int>] Cell.pencil_marks
   */
  public ArrayList<Integer> getPencilMarks(){
    return this.pencil_marks;
  }
}
