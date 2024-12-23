"""Drive application."""

from json       import dump, dumps, load

from algorithms import Backtrack, EnhancedBacktrack, select_algorithm
from components import Puzzle
from utils      import ARGS, BANNER, LOGGER

if __name__ == "__main__":
    """Execute requested command."""
    
    # Log banner
    LOGGER.info(BANNER)
    
    # Match command
    match ARGS.cmd:
        
        # Solve a puzzle
        case "solve":
            
            # Initialize algorithm (for statistical purposes)
            algorithm:      Backtrack | EnhancedBacktrack = select_algorithm(ARGS.algorithm)
            
            # Load puzle JSON
            puzzle_json:    dict =                          load(fp = open(file = f"puzzles/{ARGS.puzzle_difficulty}/{ARGS.puzzle_number}.json", mode = "r"))
            
            # Initialize puzzle object
            puzzle:         Puzzle =                        Puzzle(puzzle_json["prompt"])
            
            # Record results
            results:        dict =                          algorithm.solve(puzzle)
            
            # If solution has not yet been recorded
            if puzzle_json["solution"] == None:
                
                # Record solution
                puzzle_json["solution"] =   results["solution"]
                                
                # Record solution
                dump(puzzle_json, open(file = f"puzzles/{ARGS.puzzle_difficulty}/{ARGS.puzzle_number}.json", mode = "w"), indent = 2, default = str)
            
            # Log results
            LOGGER.info(f"Results: {dumps(obj = results, indent = 2, default = str)}")