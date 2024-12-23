"""Puzzle component testing."""

from components import Puzzle

def test_puzzle_initialization():
    """# Test initialization of Puzzle object."""
    # Define puzzle prompt
    prompt:   list[list[int]] = [
      [5, 8, 0, 1, 0, 2, 0, 4, 0],
      [0, 0, 0, 0, 0, 0, 2, 1, 6],
      [9, 1, 0, 7, 0, 4, 0, 0, 3],
      [0, 0, 0, 0, 2, 0, 0, 0, 0],
      [2, 0, 3, 9, 1, 0, 7, 0, 0],
      [7, 9, 0, 0, 0, 3, 4, 0, 5],
      [6, 0, 0, 0, 0, 1, 5, 0, 4],
      [1, 5, 0, 0, 4, 0, 6, 7, 2],
      [3, 0, 0, 2, 0, 0, 0, 8, 9]
    ]
    
    # Initialize puzzle
    puzzle: Puzzle =    Puzzle(prompt = prompt, elements = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    
    # Verify attributes
    assert puzzle.elements() == {1, 2, 3, 4, 5, 6, 7, 8, 9},  f"Puzle elements not initialized properly. Expected {{1, 2, 3, 4, 5,6, 7, 8, 9}}, got {puzzle.elements()}"
    
def test_puzzle_access():
    """# Test access of puzzle attributes and objects."""
    # Define puzzle prompt
    prompt:   list[list[int]] = [
    [5, 8, 0, 1, 0, 2, 0, 4, 0],
    [0, 0, 0, 0, 0, 0, 2, 1, 6],
    [9, 1, 0, 7, 0, 4, 0, 0, 3],
    [0, 0, 0, 0, 2, 0, 0, 0, 0],
    [2, 0, 3, 9, 1, 0, 7, 0, 0],
    [7, 9, 0, 0, 0, 3, 4, 0, 5],
    [6, 0, 0, 0, 0, 1, 5, 0, 4],
    [1, 5, 0, 0, 4, 0, 6, 7, 2],
    [3, 0, 0, 2, 0, 0, 0, 8, 9]
    ]

    # Initialize puzzle
    puzzle: Puzzle =    Puzzle(prompt = prompt, elements = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    
    # Access to cell[7, 7]
    assert puzzle.cell(row_coordinate = 7, column_coordinate = 7).value() == 5, f"Puzzle cell access malfunction. Expected 5, got {puzzle.cell(row_coordinate = 7, column_coordinate = 7).value()}."
    
    # Access to row 7
    assert puzzle.row(row_number = 7) == [6, 0, 0, 0, 0, 1, 5, 0, 4],           f"Puzzle row access malfunction. Expected [6, 0, 0, 0, 0, 1, 5, 0, 4], got {puzzle.row(row_number = 7)}."
    
    # Access to column 7
    assert puzzle.column(column_number = 7) == [0, 2, 0, 0, 7, 4, 5, 6, 0],     f"Puzzle column access malfunction. Expected [0, 2, 0, 0, 7, 4, 5, 6, 0], got {puzzle.column(column_number = 7)}."
    
    # Access to box 7
    assert puzzle.box(box_number = 7) == [6, 0, 0, 1, 5, 0, 3, 0, 0],           f"Puzzle box access malfunction. Expected [6, 0, 0, 1, 5, 0, 3, 0, 0], got {puzzle.box(box_number = 7)}."
    
def test_puzzle_validation():
    """# Test validation of puzzle cells."""
    # Define puzzle prompt
    prompt:   list[list[int]] = [
    [5, 8, 0, 1, 0, 2, 0, 4, 0],
    [0, 0, 0, 0, 0, 0, 2, 1, 6],
    [9, 1, 0, 7, 0, 4, 0, 0, 3],
    [0, 0, 0, 0, 2, 0, 0, 0, 0],
    [2, 0, 3, 9, 1, 0, 7, 0, 0],
    [7, 9, 0, 0, 0, 3, 4, 0, 5],
    [6, 0, 0, 0, 0, 1, 5, 0, 4],
    [1, 5, 0, 0, 4, 0, 6, 7, 2],
    [3, 0, 0, 2, 0, 0, 0, 8, 9]
    ]

    # Initialize puzzle
    puzzle: Puzzle =    Puzzle(prompt = prompt, elements = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    
    # Assert 7 is a valid element for cell[1, 3]
    assert puzzle.element_is_valid(element = 7, row = 1, column = 3),       f"Candidate element validation malfunction. 7 should be a valid element for cell[1, 3]."
    
    # Assert 8 is not a valid element for cell[1, 3]
    assert not puzzle.element_is_valid(element = 8, row = 1, column = 3),   f"Candidate element validation malfunction. 8 should not be a valid element for cell[1, 3]."

def test_puzzle_pencil_marks():
    """# Test pencil mark operations from puzzle level."""
    # Define puzzle prompt
    prompt:   list[list[int]] = [
    [5, 8, 0, 1, 0, 2, 0, 4, 0],
    [0, 0, 0, 0, 0, 0, 2, 1, 6],
    [9, 1, 0, 7, 0, 4, 0, 0, 3],
    [0, 0, 0, 0, 2, 0, 0, 0, 0],
    [2, 0, 3, 9, 1, 0, 7, 0, 0],
    [7, 9, 0, 0, 0, 3, 4, 0, 5],
    [6, 0, 0, 0, 0, 1, 5, 0, 4],
    [1, 5, 0, 0, 4, 0, 6, 7, 2],
    [3, 0, 0, 2, 0, 0, 0, 8, 9]
    ]

    # Initialize puzzle
    puzzle: Puzzle =    Puzzle(prompt = prompt, elements = {1, 2, 3, 4, 5, 6, 7, 8, 9})

    # Populate pencil marks for cell[1,3]
    pencil_marks_1_3:   set[int] =  puzzle.pencil_mark_cell(
        row_coordinate =    1,
        column_coordinate = 3
    ) 
    
    # Verify pencil marks for cell[1,3]
    assert pencil_marks_1_3 == {6, 7},                                                      f"Pencil marking cell[1,3] expected {{6,7}}, got {pencil_marks_1_3}."

    # Populate pencil marks for rest of grid
    puzzle.pencil_mark_puzzle()

    # Verify pencil marks for cell[9,7]
    assert puzzle.cell(row_coordinate = 9, column_coordinate = 7).pencil_marks() == {1},    f"Pencil marking grid expected cell[9,7] marks to be {{1}}, got {puzzle.cell(row_coordinate = 9, column_coordinate = 7).pencil_marks()}"