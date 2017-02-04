package com.mons.sudoku;

import java.util.HashMap;
import java.util.Random;

/**
 * This class contains the Sudoku game logic.
 *
 * Created by mons on 2017-01-28.
 */
public class Sudoku {

    private static Sudoku instance;

    private static final int gridsize = 9;
    private static final int totalgridsize = 81;

    //hashmap that keeps track of the Sudoku logic:
    private HashMap available = new HashMap();

    Random randomGenerator = new Random();

    /**
     * Constructor
     */
    private Sudoku(){

    }

    /**
     * Sudoku uses the Singleton Pattern
     *
     * @return instance
     */
    public static Sudoku getInstance(){
        if (instance == null)
            instance = new Sudoku();
        return instance;
    }


    /**
     * Creates a new grid
     *
     * @return grid
     */
    public int[][] newGrid(){
        int[][] grid = new int[gridsize][gridsize];

        resetGrid(grid);
        initializeGridStartingNumbers(grid);



        return grid;
    }


    /**
     * Grab a random starting board state from the DB
     *
     * @param grid
     * @return grid
     */
    public int[][] initializeGridStartingNumbers(int[][] grid){



        return grid;
    }


    /**
     * Resets the given grid
     *
     * @param grid
     */
    public void resetGrid(int[][] grid){
        available.clear();

        //set each slot to -1 in the grid
        for (int i = 0; i < gridsize; i++) {
            for (int j = 0; j < gridsize; j++) {
                grid[j][i] = -1;
            }
        }

        //rebuild the hashmap with available inputs
        //fills in all 81 slots with numbers 1-9
        for (int i = 0; i < totalgridsize; i++) {
            for (int j = 0; j < gridsize; j++) {
                available.put(i, j);
            }
        }
    }




}
