package Puzzle;

public class Puzzle {
    public int[][] grid;

    public Puzzle(){
        this.grid = new int[9][9];
    }

    public Puzzle(int[][] g){
        this.grid = g;
    }

    public boolean numInRow(int n, int r){
        for(int i : grid[r]){
            if(i == n){return true;}
        }
        return false;
    }

    public boolean numInCol(int n, int c){
        for(int i = 0; i < grid.length; i ++){
            if(grid[i][c] == n){return true;}
        }
        return false;
    }

    public boolean numInBox(int n, int r, int c){
        for(int i = r - (r % 3); i <= (r - (r % 3)) + 2; i++){
            for(int j = c - (c % 3); j <= (c - (c % 3)) + 2; j++){
                if(grid[i][j] == n){return true;}
            }
        }
        return false;
    }

    public boolean numValid(int n, int r, int c){
        return !numInRow(n, r)
        && !numInCol(n, c)
        && !numInBox(n, r, c);
    }

    public void stringify(){
        System.out.println();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                if(j == 2 || j == 5){
                    System.out.print(grid[i][j] + " | ");
                }else if(j == 8){
                    System.out.print(grid[i][j] + "\n");
                }else{
                    System.out.print(grid[i][j] + " ");
                }
            }
            if(i == 2 || i == 5){
                System.out.println("---------------------");
            }
        }
        System.out.println();
    }
}
