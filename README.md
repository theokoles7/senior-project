# Sudoku Solver
A suite of algorithms designed to solve sudoku puzzles.

## Algorithms

### Backtrack
The back track algorithm works by traversing every empty cell in the grid (row by row, column by column) and tests each of the numbers 1 through 9 as valid candidates in the cell. If a number is found to be a valid candidate (meaning that it violates none of the rules of Sudoku), that number is assigned to the cell.
If, when the algorithm moves to the next empty cell, there is no valid candidate, that simply means that the number previously entered was an invalid entry after all. The back track mechanism of the algorithm is then utilized to go back to the previous cell and find the next valid candidate before again moving on to the following empty cells.
```
=====================================
|      BACKTRACK (BRUTE FORCE)      |
|===================================|
|DIFFICULTY     SOLVED          TIME|
|-----------------------------------|
|EASY           true         1.03 ms|
|EASY           true         0.14 ms|
|EASY           true         0.24 ms|
|MEDIUM         true         2.07 ms|
|MEDIUM         true         1.13 ms|
|MEDIUM         true         0.24 ms|
|HARD           true         0.24 ms|
|HARD           true         6.27 ms|
|HARD           true         6.15 ms|
|EXPERT         true        13.02 ms|
|EXPERT         true         5.65 ms|
|EXPERT         true         7.51 ms|
|EVIL           true        16.11 ms|
|EVIL           true        13.17 ms|
|EVIL           true         2.79 ms|
|17 Clues       true       522.46 ms|
|17 Clues       true      1437.04 ms|
|17 Clues       true       225.94 ms|
=====================================
```

### Enhanced Backtrack
An enhanced version of the backtrack algorithm that first populates every cells pencil marks with any valid candidates then tests only those pencil marks as valid entries instead of all numbers 1 - 9.
```
=====================================
|        ENHANCED BACKTRACK         |
|===================================|
|DIFFICULTY     SOLVED          TIME|
|-----------------------------------|
|EASY           true         1.33 ms|
|EASY           true         0.44 ms|
|EASY           true         0.39 ms|
|MEDIUM         true         0.47 ms|
|MEDIUM         true         0.29 ms|
|MEDIUM         true         0.24 ms|
|HARD           true         0.21 ms|
|HARD           true         0.17 ms|
|HARD           true         0.13 ms|
|EXPERT         true         0.13 ms|
|EXPERT         true         0.11 ms|
|EXPERT         true         0.11 ms|
|EVIL           true         0.11 ms|
|EVIL           true         0.11 ms|
|EVIL           true         0.11 ms|
|17 Clues       true         0.14 ms|
|17 Clues       true         0.12 ms|
|17 Clues       true         0.12 ms|
=====================================
```

## Terminology

### Box
A 3x3 Cell region; There are 9 boxes in a traditional 9x9 Sudoku, placed in a 3x3 arrangement; Can be thought of as a smaller grid, with 3 columns, 3 rows, and a total of 9 cells

```
 1 | 2 | 3 |   |   |   |   |   | 
-----------------------------------
 4 | 5 | 6 |   |   |   |   |   |
-----------------------------------
 7 | 8 | 9 |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
```

### Cell
Refers to any individual input square/spot within a row, column, or box; Holds exactly one number; There are 81 cells in a traditional 9x9 Sudoku

### Column
A vertical group of 9 cells; There are 9 columns in a traditional 9x9 Sudoku

```
 1 |   |   |   |   |   |   |   | 
-----------------------------------
 2 |   |   |   |   |   |   |   |
-----------------------------------
 3 |   |   |   |   |   |   |   |
-----------------------------------
 4 |   |   |   |   |   |   |   |
-----------------------------------
 5 |   |   |   |   |   |   |   |
-----------------------------------
 6 |   |   |   |   |   |   |   |
-----------------------------------
 7 |   |   |   |   |   |   |   |
-----------------------------------
 8 |   |   |   |   |   |   |   |
-----------------------------------
 9 |   |   |   |   |   |   |   |
```

### Row
A horizontal group of 9 cells; There are 9 rows in a traditional 9x9 Sudoku

```
 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
-----------------------------------
   |   |   |   |   |   |   |   |
```

### Sudoku
A puzzle in which a grid consisting of several cells is to be filled with numbers so that every row, column, and 3x3 box contains only one instance of each number. The most common format is a grid of nine rows and columns that are divided into nine smaller boxes of three rows and three columns into which the numbers 1 through 9 must be placed.
