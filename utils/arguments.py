"""CLI argument definitions & parsing."""

from argparse   import ArgumentParser, _ArgumentGroup, Namespace, _SubParsersAction

# Initialize parser
_parser:    ArgumentParser =    ArgumentParser(
    prog =          "dr-sudoku",
    description =   "A suite of algorithms designed to solve Sudoku puzzles."
)

# Initialize sub-parser
_subparser: _SubParsersAction = _parser.add_subparsers(
    dest =          "cmd",
    help =          "Dr. Sudoku commands."
)

# +================================================================================================+
# | BEGIN ARGUMENTS                                                                                |
# +================================================================================================+

# LOGGING ==========================================================================================
_logging:   _ArgumentGroup =    _parser.add_argument_group("Logging")

_logging.add_argument(
    "--logging-level",
    type =          str,
    choices =       ["DEBUG", "INFO", "WARNING", "ERROR", "CRITICAL"],
    default =       "INFO",
    help =          """Minimum logging level (DEBUG < INFO < WARNING < ERROR < CRITICAL). Defaults 
                    to "INFO"."""
)

_logging.add_argument(
    "--logging-path",
    type =          str,
    default =       "logs",
    help =          """Path at which logs will be written. Defaults to "./logs/"."""
)

# SOLVE ============================================================================================
_solve:     ArgumentParser =    _subparser.add_parser(
    name =          "solve",
    help =          "Solve a puzzle with an algorithm."
)

_solve.add_argument(
    "--algorithm",
    type =          str,
    choices =       ["backtrack"],
    default =       "backtrack",
    help =          "Algorithm with which puzzle will be solved."
)

_solve.add_argument(
    "--puzzle-difficulty",
    type =          str,
    choices =       ["easy", "medium", "hard", "expert", "evil", "17-clues"],
    default =       "easy",
    help =          """Difficulty of puzzle to be solved. Defaults to "easy"."""
)

_solve.add_argument(
    "--puzzle-number",
    type =          int,
    default =       1,
    help =          """Number of puzle within directory (difficulty) to be solved. Defaults to 1."""
)

# +================================================================================================+
# | END ARGUMENTS                                                                                  |
# +================================================================================================+

# Parse arguments
ARGS:       Namespace =         _parser.parse_args()