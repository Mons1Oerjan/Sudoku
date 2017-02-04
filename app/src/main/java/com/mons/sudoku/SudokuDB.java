package com.mons.sudoku;

import java.util.ArrayList;

/**
 * This class contains all the possible starting board states
 * for the Sudoku games.
 *
 * Created by mons on 2017-01-29.
 */

public class SudokuDB {

    private int[] emptyboard = new int[] {
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
    };

    private int[] game1 = new int[] {
            0, 0, 4, 8, 0, 0, 0, 0, 0,
            0, 9, 0, 4, 6, 0, 0, 7, 0,
            0, 5, 0, 0, 0, 0, 6, 1, 4,
            2, 1, 0, 6, 0, 0, 5, 0, 0,
            5, 8, 0, 7, 0, 9, 0, 4, 1,
            0, 0, 7, 0, 0, 8, 0, 6, 9,
            3, 4, 5, 0, 0, 0, 0, 9, 0,
            0, 6, 0, 0, 3, 7, 0, 2, 0,
            0, 0, 0, 0, 0, 4, 1, 0, 0,
    };

    private int[] game2 = new int[] {
            3, 0, 0, 0, 0, 2, 1, 0, 0,
            8, 0, 6, 0, 9, 0, 0, 3, 0,
            0, 7, 0, 0, 8, 5, 2, 4, 0,
            0, 1, 8, 0, 6, 0, 5, 0, 0,
            0, 9, 0, 8, 0, 0, 0, 1, 0,
            0, 0, 3, 7, 1, 0, 6, 8, 0,
            0, 3, 9, 5, 2, 0, 0, 6, 0,
            0, 8, 0, 0, 4, 0, 3, 0, 1,
            0, 0, 4, 1, 0, 0, 0, 0, 7,
    };

    private int[] game3 = new int[] {
            8, 5, 0, 2, 1, 0, 0, 9, 0,
            0, 0, 7, 0, 0, 3, 4, 0, 6,
            0, 0, 9, 0, 6, 0, 2, 0, 0,
            0, 4, 0, 0, 2, 0, 5, 0, 1,
            9, 0, 0, 4, 0, 0, 0, 0, 7,
            3, 0, 1, 0, 8, 5, 0, 6, 0,
            0, 0, 4, 0, 5, 0, 1, 0, 0,
            1, 0, 2, 6, 0, 0, 3, 0, 0,
            0, 9, 0, 0, 4, 8, 0, 7, 2,
    };

    /**
     * Constructor that fills the parameter with all starting game states.
     *
     * @param games
     */
    public SudokuDB(ArrayList<int[]> games){
        games.add(game1);
        games.add(game2);
        games.add(game3);
    }

    public int[] getGame1(){
        return game1;
    }

    public int[] getGame2(){
        return game2;
    }

    public int[] getGame3(){
        return game3;
    }


}
