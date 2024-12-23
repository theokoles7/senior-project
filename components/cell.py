"""Cell class & utilities."""

from logging    import Logger

from utilities  import LOGGER

class Cell():
    """Cell class."""
    
    def __init__(self,
        value:              int,
        row_coordinate:     int,
        column_coordinate:  int,
        pencil_marks:       set[int] =  set()
    ):
        """# Initialize Cell object.

        ## Args:
            * value             (int):                  Cell's initial value.
            * row_coordinate    (int):                  Row of puzzle in which cell is located.
            * column_coordinate (int):                  Column of puzzle in which cell is located.
            * pencil_marks      (set[int], optional):   Cell's candidate values.
        """
        # Define attributes
        self._value:        int =       value
        self._row:          int =       row_coordinate
        self._col:          int =       column_coordinate
        self._pencil_marks: set[int] =  pencil_marks
        
        # Initialize logger
        self._logger:   Logger =    LOGGER.getChild(f"cell[{row_coordinate}, {column_coordinate}]")
        
        # Log initialization for debugging
        self._logger.debug(f"Cell initialized ({locals()})")
        
    def __eq__(self, other) -> bool:
        """# Indeicate equality of self to other.

        ## Args:
            * other (Cell): Cell being compared.

        ## Returns:
            * bool:
                * True:     Cell objects hold the same value.
                * False:    Cell objects do not hold the same value
        """
        # If the other object is indeed a Cell...
        if isinstance(other, Cell):
            
            # Return the equality of their values
            return self._value == other._value
        
        # Otherwise, objects of different types can never be equal
        return False
        
    def __str__(self) -> str:
        """# Provide string format of Cell object.

        ## Returns:
            * str:  Cell value.
        """
        return str(self._value)
        
    def column(self) -> int:
        """# Access Cell's column coordinate.

        ## Returns:
            * int:  Cell's column coordinate.
        """
        return self._col
    
    def coordinates(self) -> tuple[int]:
        """# Access cell coordinates.

        ## Returns:
            * tuple[int]:   Cell's row, column coordinate.
        """
        return (self._row, self._col)
    
    def pencil_marks(self,
        insert: set[int] =  set(),
        delete: set[int] =  set()
    ) -> set[int]:
        """# Access/mutate Cell's pencil marks.

        ## Args:
            * insert    (set[int], optional):   Candidate values to be inserted.
            * delete    (set[int], optional):   Candidate values to be deleted.

        ## Returns:
            * set[int]: Cell's pencil marks after insertion/deletion.
        """
        # Insert pencil marks
        self._pencil_marks =    self._pencil_marks.union(insert)
        
        # Delete pencil marks
        self._pencil_marks =    self._pencil_marks.difference(delete)
        
        # Provide pencil marks
        return self._pencil_marks
    
    def row(self) -> int:
        """# Access Cell's row coordinate.

        ## Returns:
            * int:  Cell's row coordinate.
        """
        return self._row
    
    def value(self,
        new_value:  int =   None
    ) -> int:
        """# Access/mutate Cell's value.

        ## Args:
            * new_value (int, optional):    New value to be assigned to Cell.

        ## Returns:
            * int:  Cell's value.
        """
        # Set new cell value if provided
        if new_value is not None: self._value = new_value
        
        # Provide value
        return self._value