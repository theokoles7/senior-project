"""Algorithm selector."""

from algorithms.backtrack           import Backtrack
from algorithms.enhanced_backtrack  import EnhancedBacktrack

def select_algorithm(
    algorithm:  str
) -> Backtrack | EnhancedBacktrack:
    """# Provide initialized algorithm specified.

    ## Args:
        * algorithm (str):  Selection of algorithm.

    ## Returns:
        * Backtrack | EnhancedBacktrack:    Selected algorithm, initialized for solving.
    """
    # Match algorithm selection
    match algorithm:

        # Backtrack
        case "backtrack":           return Backtrack()

        # Enhanced Backtrack
        case "enhanced-backtrack":  return EnhancedBacktrack()

        # Invalid selection
        case _:                     raise NotImplementedError(f"Invalid algorithm selection: {algorithm}")