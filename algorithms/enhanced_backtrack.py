"""Enhanced Backtrack algorithm implementation and utilities."""

from datetime   import datetime
from logging    import Logger

from components import Cell, Puzzle
from utils      import LOGGER

class EnhancedBacktrack():
    """# Enhanced Backtrack Algorithm.
    
    The enhanced back track algorithm works much like the classic, brute-force equivalent, except 
    that instead of guessing all candidate elements defined for the puzzle, it will only use pencil 
    marks defined for each cell.
    """
    
    def __init__(self):
        """# Initialize algorithm statistics."""
        # Initialize statistics
        self._backtracks:   int =   0
        self._backtrack_locations:  list[tuple] =   []
        self._considered:   int =   0
        self._guesses:      int =   0
        
        # Initialize logger
        self._logger:       Logger =    LOGGER.getChild("enhanced-backtrack")
        

    def solve(self,
        puzzle: Puzzle
    ) -> dict[str, Puzzle | datetime | int]:
        """# Solve puzzle using enhanced backtrack algorithm.

        ## Args:
            puzzle  (Puzzle):   Puzzle object.

        ## Returns:
            * dict[str, Puzzle | datetime]:
                * "solution":   Solved Puzzle object.
                * "time":       Time taken to solve puzzle.
                * "backtracks": Backtracks taken during solve.
                * "considered": Elements considered during solve.
                * "guesses":    Guesses made during solve.
        """
        # Define recursive solve
        def _solve(
            puzzle: Puzzle
        ) -> bool:
            """# Solve subset of puzzle.

            ## Args:
                * puzzle    (Puzzle):   Subset of puzzle.

            ## Returns:
                * bool:
                    * True:     Subset was solved without violation.
                    * False:    Violation made in solving subset.
            """
            # For each row in puzzle...
            for r, row in enumerate(puzzle.grid(), start = 1):
                
                # Log row number for debugging
                self._logger.debug(f"Row {r}")
                
                # For each cell in row...
                for c, cell in enumerate(row, start = 1):
                    
                    # If cell is empty...
                    if cell.value() == 0:
                    
                        # Log for cell coordinates debugging
                        self._logger.debug(f"\tCell{cell.coordinates()}")
                        
                        # For each elemnt in cell's pencil marks
                        for element in puzzle._grid[r - 1][c - 1].pencil_marks():
                            
                            # Increment elements considered
                            self._considered += 1
                            
                            # If element does not violate puzzle...
                            if puzzle.element_is_valid(element = element, row = r, column = c):
                                
                                # Set new value for cell
                                cell.value(new_value = element)
                                
                                # Log action for debugging
                                self._logger.debug(f"\t\tCell[{r}, {c}] = {element}")
                                
                                # Increment elements guessed
                                self._guesses += 1
                                
                                # Return true if the rest of the puzzle is solved without violation
                                if(_solve(puzzle)): return True
                                
                                # Otherwise, reset the cell's value to zero and carry on backtracking
                                else: cell.value(new_value = 0)
                                
                                # Log backtrack for debugging
                                self._logger.debug(f"\t\t\tBacktracking from Cell[{r}, {c}]")
                                
                                # Increment backtracks made
                                self._backtracks += 1
                                self._backtrack_locations.append((r, c))
                                
                        # Candidate elements exhausted
                        return False
                    
            # Puzzle subset was solved
            return True
        
        # Populate pencil marks for puzzle grid
        puzzle.pencil_mark_puzzle()
        
        # Record starting time
        start_time: datetime =  datetime.now()
        
        # Solve & return results
        return {
            "solved":       _solve(puzzle),
            "solution":     puzzle.to_list(),
            "time":         str(datetime.now() - start_time),
            "backtracks":   self._backtracks,
            "backtrack_locations":  self._backtrack_locations,
            "considered":   self._considered,
            "guesses":      self._guesses
        }