package Classes;

import java.util.SortedSet;
import java.util.TreeSet;

public class Cell {
  public int value;
  public SortedSet<Integer> pencil_marks;

  //==============================================================
  // Constructors
  //==============================================================

  public Cell(){
    this.value = 0;
    this.pencil_marks = new TreeSet<>();
  }

  public Cell(int v){
    this.value = v;
    this.pencil_marks = new TreeSet<>();
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
  public boolean erase(int n){
    return this.pencil_marks.remove(n);
  }
}
