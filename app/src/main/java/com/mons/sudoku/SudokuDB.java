package com.mons.sudoku;

import java.util.ArrayList;

/**
 * This class contains all the possible starting board states
 * for the Sudoku games.
 *
 * Created by mons on 2017-01-29.
 */

public class SudokuDB {

    private ArrayList<int[][]> startingBoardStates = new ArrayList<>();


    public SudokuDB(){

    }

    private void initDB(){


    }

    private void seeds(){
        int[][] grid = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[j][i] = -1;
            }
        }

        //first seed:


    }

}
