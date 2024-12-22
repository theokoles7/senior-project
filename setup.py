"""Dr. Sudoku setup utility."""

from setuptools import find_packages, setup

setup(
    name =              "dr-sudoku",
    version =           "0.0.1",
    author =            "Gabriel C. Trahan",
    author_email =      "gabrieltrahan777@gmail.com",
    description =       ("Suite of algorithms designed for solving Sudoku puzzles."),
    license =           "MIT",
    url =               "https://github.com/theokoles7/sudoku-solver",
    packages =          find_packages(),
    python_requires =   ">=3.10",
    install_requires =  [
        "numpy",
        "pytest"
    ]
)