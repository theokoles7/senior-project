"""Cell component testing."""

from components import Cell

def test_cell_initialization():
    """# Test initialization of Cell object."""
    # Initialize cell with predetermined value
    cell:   Cell =  Cell(value = 7, row_coordinate = 3, column_coordinate = 5, pencil_marks = {1, 3, 5, 7, 9})
    
    # Ensure attributes are defined properly
    assert cell.value() ==          7,                  f"Cell value not initialized properly. Expected 7, got {cell.value()}."
    assert cell.row() ==            3,                  f"Cell row coordinate not initialized properly. Expected 3, got {cell.row()}."
    assert cell.column() ==         5,                  f"Cell column coordinate not initialized properly. Expected 5, got {cell.column()}."
    assert cell.pencil_marks() ==   {1, 3, 5, 7, 9},    f"Cell pencil marks not initialized properly. Expected (1, 3, 5, 7, 9), got {cell.pencil_marks()}."
    
def test_cell_updates():
    """# Test updates of Cell attributes."""
    # Initialize cell with predetermined value
    cell:   Cell =  Cell(value = 7, row_coordinate = 3, column_coordinate = 5, pencil_marks = {1, 3, 5, 7, 9})
    
    # Update value
    assert cell.value(new_value = 5) == 5,                                          f"Cell value not updated properly. Expected 5, got {cell.value(new_value = 5)}"
    
    # Insert pencil marks
    assert cell.pencil_marks(insert = {2, 4, 6, 8}) == {1, 2, 3, 4, 5, 6, 7, 8, 9}, f"Insertion of pencil marks expected to return {{1, 2, 3, 4, 5, 6, 7, 8, 9}}, got {cell.pencil_marks(insert = {2, 4, 6, 8})}."
    
    # Delete pencil marks
    assert cell.pencil_marks(delete = {1, 2, 3, 4, 5, 6, 8, 9}) == {7},             f"Deletion of pencil marks expected to return {{7}}, got {cell.pencil_marks(delete = {1, 2, 3, 4, 5, 6, 8, 9})}."
    
def test_cell_comparison():
    """# Test comparison of Cell objects."""
    # Initialize new cells
    cell1:  Cell =  Cell(value = 1, row_coordinate = 2, column_coordinate = 3)
    cell2:  Cell =  Cell(value = 1, row_coordinate = 3, column_coordinate = 2)
    
    # Assert that they are equal
    assert cell1 == cell2,  f"Malfunction in check of equality of cells: cell1({cell1.value()}) == cell2({cell2.value()})"
    
    # Update one cell to be a different value
    cell2.value(new_value = 2)
    
    # Assert that they are now not equal
    assert cell1 != cell2, f"Malfunction in check of inequality of cells: cell1({cell1.value()}) != cell2({cell2.value()})"