"""Puzzle class & utilities."""

from logging            import Logger
from math               import sqrt

from numpy              import count_nonzero

from components.cell    import Cell
from utilities          import LOGGER

class Puzzle():
    """Puzzle class."""
    
    def __init__(self,
        prompt:     list[list[int]],
        elements:   set[any] =          {1, 2, 3, 4, 5, 6, 7, 8, 9}
    ):
        """# Initialize Puzzle object.

        ## Args:
            * prompt    (list[list[int]]):              Puzzle prompt.
            * elements  (set[any]):                     Numbers/letters/symbols allowed in puzzle. Defaults to numbers 1-9.
        """
        # Data/value validation
        assert len(prompt) == len(elements),    f"Incongruency found between puzzle size ({len(prompt)}) and length of elements ({len(elements)}) provided."
        
        # Initialize logger
        self._logger:   Logger =            LOGGER.getChild("puzzle")
        
        # Define attributes
        self._elements: set[any] =          elements
        self._clues:    int =               count_nonzero(prompt)
        self._blanks:   int =               len(prompt) - self._clues
        self._root:     int =               int(sqrt(len(prompt)))
        
        # Initialize puzzle grid
        self._grid:     list[list[Cell]] =  [[Cell(value = cell, row_coordinate = r, column_coordinate = c) for c, cell in enumerate(row, start = 1)] for r, row in enumerate(prompt, start = 1)]
        
        # Log initialization for debugging
        self._logger.debug(f"Puzzle initialized (clues: {self._clues}, ({locals()}))")
        
    def __str__(self) -> str:
        """# Provide string format of Puzzle's grid.

        ## Returns:
            * str:  String format of Puzzle's grid.
        """
        # Initialize string format with top border
        str_fmt:    str =   f"""\n┏{("━━━┯" * (self._root - 1) + "━━━┳") * (self._root - 1)}{"━━━┯" * (self._root - 1)}━━━┓\n"""

        # Then for each row in puzzle...
        for r, row in enumerate(self._grid, start = 1):

            # And for each cell in the row...
            for c, cell in enumerate(row, start = 1):

                # Append cell to row in string
                str_fmt +=  f"""┃ {cell.value() if cell.value() != 0 else " "} """ if (c - 1) % self._root == 0 else f"""│ {cell.value() if cell.value() != 0 else " "} """

            # Append right-most border
            str_fmt +=  "┃\n"

            # Add separating line
            str_fmt +=  (
                f"""┣{("━━━┿" * (self._root - 1) + "━━━╋") * (self._root - 1)}{"━━━┿" * (self._root - 1)}━━━┫\n""" if r % self._root == 0 else \
                f"""┠{("───┼" * (self._root - 1) + "───╂") * (self._root - 1)}{"───┼" * (self._root - 1)}───┨\n"""
            ) if r != len(self._grid) else ""

        # Append bottom border and return
        return str_fmt + f"""┗{("━━━┷" * (self._root - 1) + "━━━┻") * (self._root - 1)}{"━━━┷" * (self._root - 1)}━━━┛"""
    
    def box(self,
        box_number: int
    ) -> list[any]:
        """# Access grid box.

        ## Args:
            * box_number    (int):  Number of box being accessed.

        ## Returns:
            * list[any]:    Specified grid box.
        """
        # Log action for debugging
        self._logger.debug(f"Getting box {box_number}")
        
        # Provide specified box
        return [
            cell.value()
            for row in self._grid[
                ((box_number - 1) // self._root) * self._root:(((box_number - 1) // self._root) * self._root) + self._root
            ]
            for cell in row[
                ((box_number - 1) % self._root) * self._root:(((box_number - 1) % self._root) * self._root) + self._root
            ]
        ]
        
    def cell(self,
        row_coordinate:     int,
        column_coordinate:  int
    ) -> Cell:
        """# Access Cell object at given grid coordinate.

        ## Args:
            * row_coordinate    (int):  Row coordinate of cell.
            * column_coordinate (int):  Column coordinate of cell.

        ## Returns:
            * Cell: Cell object at specified coordinate.
        """
        # Log action for debugging
        self._logger.debug(f"Getting cell[{row_coordinate}, {column_coordinate}]")
        
        # Provide specified cell
        return self._grid[row_coordinate - 1][column_coordinate - 1]
    
    def column(self,
        column_number:  int
    ) -> list[any]:
        """# Access grid column.

        ## Args:
            * column_number (int):  Number of column being accessed.

        ## Returns:
            * list[any]:    Specifed grid column.
        """
        # Log action for debugging
        self._logger.debug(f"Getting column {column_number}")
        
        # Provide specified column
        return [row[column_number - 1].value() for row in self._grid]
    
    def elements(self) -> set[any]:
        """# Access possible puzzle elements.

        ## Returns:
            * set[any]: Puzzle's elements.
        """
        return self._elements
    
    def element_is_valid(self,
        element:    any,
        row:        int,
        column:     int
    ) -> bool:
        """# Validate element does not pose violation at given coordinate.

        ## Args:
            * element   (any):  Proposed element entry.
            * row       (int):  Row coordinate of cell being validated.
            * column    (int):  Column coordinate of cell being validated.

        ## Returns:
            * bool:
                * True:     Element poses no violation at given coordinate.
                * False:    Element poses violation at given coordinate. 
        """
        # Log action for debugging
        self._logger.debug(f"Validating element {element} at [{row}, {column}]")
        
        # Return validation result
        return all([
            element not in self.box(box_number = ((((row - 1) // self._root) * self._root) + ((column - 1) // self._root)) + 1),
            element not in self.column(column_number = column),
            element not in self.row(row_number = row)
        ])
    
    def grid(self) -> list[list[Cell]]:
        """# Access puzzle grid.

        ## Returns:
            * list[list[Cell]]: Puzzle's grid.
        """
        return self._grid
    
    def pencil_mark_cell(self,
        row_coordinate:     int,
        column_coordinate:  int
    ) -> set[int]:
        """# Populate pencil marks for specified cell.

        ## Args:
            * row_coordinate    (int):  Row in which cell is located.
            * column_coordinate (int):  Column in which cell is located.

        ## Returns:
            * set[int]: Cell's populated pencil marks.
        """
        return self._grid[row_coordinate - 1][column_coordinate - 1].pencil_marks(
            insert =    self._elements.difference(*[
                self.row(row_number = row_coordinate),
                self.column(column_number = column_coordinate),
                self.box(box_number = ((((row_coordinate - 1) // self._root) * self._root) + ((column_coordinate - 1) // self._root)) + 1)
            ])
        )
    
    def pencil_mark_puzzle(self) -> None:
        """# Populate pencil marks for all cells in grid."""
        # For each row in grid...
        for r, row in enumerate(self._grid, start = 1):

            # For each cell in row...
            for c, _ in enumerate(row, start = 1):

                # Populate pencil marks for cell
                self.pencil_mark_cell(row_coordinate = r, column_coordinate = c)
    
    def row(self,
        row_number: int
    ) -> list[any]:
        """# Access grid row.

        ## Args:
            * row_number (int): Number of row being accessed.

        ## Returns:
            * list[any]:    Specified grid row.
        """
        # Log action for debugging
        self._logger.debug(f"Getting row {row_number}")
        
        # Provide specified row
        return [cell.value() for cell in self._grid[row_number - 1]]
    
    def to_list(self) -> list[list[any]]:
        """# Provide list format of grid values.

        ## Returns:
            * list[list[any]]:  List format of grid values.
        """
        return [[cell.value() for cell in row] for row in self._grid]