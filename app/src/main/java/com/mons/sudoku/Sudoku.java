package com.mons.sudoku;

import java.util.ArrayList;

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
    private ArrayList<ArrayList<Integer>> available = new ArrayList<>();


    /**
     * Empty constructor
     */
    private Sudoku(){}

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
    public int[] newGrid(){
        int[] grid = new int[totalgridsize];

        resetGrid(grid);



        return grid;
    }

    /**
     * Resets the given grid
     *
     * @param grid
     */
    public void resetGrid(int[] grid){

        //clear the map containing the logic:
        available.clear();

        //rebuild the hashmap with available inputs
        //fills in all 81 slots with numbers 1-9
        for (int i = 0; i < totalgridsize; i++) {
            ArrayList<Integer> newList = new ArrayList<>();
            for (int j = 1; j <= gridsize; j++) {
                newList.add(j);
            }
            available.add(i, newList);
        }

        //get a new random game
        grid = SudokuDB.getRandomGame();

        //remove unavailable numbers from the map
        updateAvailableInputs(grid, available);

    }

    /**
     * Function that checks each grid tile and removes inputted values from the hashmap.
     * This function updates the legal moves for the player.
     *
     * @param grid
     * @param available
     */
    public void updateAvailableInputs(int[] grid, ArrayList<ArrayList<Integer>> available){

        //loop over each tile in the entire grid
        for (int i = 0; i < totalgridsize; i++) {

            int gridTileValue = grid[i];
            ArrayList<Integer> availableInputs = available.get(i);

            //check the current grid position for input
            if (gridTileValue != 0) {
                //This tile has some input. We must remove it from the available inputs
                removeValueFromMap(i, gridTileValue, available);
            }
        }
    }

    /**
     * Function that removes the value from the hashmap in the 3x3 grid, the row, and the column
     *
     * @param gridIndex
     * @param value
     * @param map
     */
    public void removeValueFromMap(int gridIndex, int value, ArrayList<ArrayList<Integer>> map){

        //shift gridIndex by 1 because it originally ranges from 0-80
        gridIndex += 1;

        //find the column:
        int column = gridIndex % 9;
        if (column == 0){
            //the 9th column mod 9 = 0, so set it to 9
            column = 9;
        }

        //find the row:
        int row;
        if (gridIndex <= 9){
            row = 1;
        } else if (gridIndex >= 10 && gridIndex <= 18){
            row = 2;
        } else if (gridIndex >= 19 && gridIndex <= 27){
            row = 3;
        } else if (gridIndex >= 28 && gridIndex <= 36){
            row = 4;
        } else if (gridIndex >= 37 && gridIndex <= 45){
            row = 5;
        } else if (gridIndex >= 46 && gridIndex <= 54){
            row = 6;
        } else if (gridIndex >= 55 && gridIndex <= 63){
            row = 7;
        } else if (gridIndex >= 64 && gridIndex <= 72){
            row = 8;
        } else {
            row = 9;
        }

        //find the 3x3 grid based on row and column:
        int smallGrid;
        if (row <= 3) {
            if (column <= 3) {
                smallGrid = 1;
            } else if (column >= 4 && column <= 6){
                smallGrid = 2;
            } else {
                smallGrid = 3;
            }
        } else if (row >= 4 && row <= 6) {
            if (column <= 3) {
                smallGrid = 4;
            } else if (column >= 4 && column <= 6){
                smallGrid = 5;
            } else {
                smallGrid = 6;
            }
        } else {
            if (column <= 3) {
                smallGrid = 7;
            } else if (column >= 4 && column <= 6){
                smallGrid = 8;
            } else {
                smallGrid = 9;
            }
        }

        //we now know which column, row, and smallerGrid to remove available inputs from
        //remove the value parameter from the hashmap in these locations


    }

}
