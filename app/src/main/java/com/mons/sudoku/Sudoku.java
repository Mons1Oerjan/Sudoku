package com.mons.sudoku;

import java.util.ArrayList;

/**
 * This class contains the Sudoku game logic.
 *
 * Created by mons on 2017-01-28.
 */
public class Sudoku {

    //singleton instance of this class:
    private static Sudoku instance;

    //constants:
    private static final int gridsize = 9;
    private static final int totalgridsize = 81;

    //hashmap that keeps track of the Sudoku logic:
    private ArrayList<ArrayList<Integer>> available = new ArrayList<>();

    private int[] grid;

    /**
     * Private constructor satisfies the singleton pattern
     */
    private Sudoku() {}

    /**
     * Lazy initialization of the Sudoku singleton.
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
        grid = new int[totalgridsize];

        resetGrid();

        return grid;
    }

    /**
     * Resets the grid
     *
     */
    private void resetGrid(){

        //set all grid entries to 0:
        for (int i = 0; i < totalgridsize; i++) {
            grid[i] = 0;
        }

        //clear the map containing the logic:
        available.clear();

        //rebuild the hashmap with available inputs
        //fills in all 81 slots with numbers 1-9
        for (int i = 0; i < totalgridsize; i++) {
            ArrayList<Integer> inputs = new ArrayList<>();
            for (int j = 1; j <= gridsize; j++) {
                inputs.add(j);
            }
            available.add(i, inputs);
        }

        //get a new random game
        grid = SudokuDB.getRandomGame();

        //remove unavailable numbers from the map
        updateAvailableInputs();

    }

    /**
     * Function that checks each grid tile and removes inputted values from the hashmap.
     * This function updates the legal moves for the player.
     */
    private void updateAvailableInputs(){

        //loop over each tile in the entire grid:
        for (int i = 0; i < totalgridsize; i++) {
            int value = grid[i];

            //check the current grid position for input:
            if (value != 0) {
                //this tile has some input. We must remove it from the available inputs
                removeValueFromMap(i, value);
                //remove all values from this specific index. This prevents the user to overwrite the starting board state:
                removeAllValuesAt(i);
            }
        }
    }

    /**
     * Function that removes all values at the given gridIndex.
     *
     * @param key
     */
    private void removeAllValuesAt(int key){
        ArrayList<Integer> values = available.get(key);
        values.clear();
    }

    /**
     * Function that removes the value from the hashmap in the 3x3 grid, the row, and the column
     *
     * @param gridIndex
     * @param value
     */
    private void removeValueFromMap(int gridIndex, int value){

        //find the column:
        int column = (gridIndex+1) % 9;
        if (column == 0){
            //(the 9th column) mod 9 = 0, so set it to 9
            column = 9;
        }

        //find the row:
        int row;
        if (gridIndex <= 8){
            row = 1;
        } else if (gridIndex >= 9 && gridIndex <= 17){
            row = 2;
        } else if (gridIndex >= 18 && gridIndex <= 26){
            row = 3;
        } else if (gridIndex >= 27 && gridIndex <= 35){
            row = 4;
        } else if (gridIndex >= 36 && gridIndex <= 44){
            row = 5;
        } else if (gridIndex >= 45 && gridIndex <= 53){
            row = 6;
        } else if (gridIndex >= 54 && gridIndex <= 62){
            row = 7;
        } else if (gridIndex >= 63 && gridIndex <= 71){
            row = 8;
        } else {
            row = 9;
        }

        //find the 3x3 grid based on row and column:
        int smallGridId;
        if (row <= 3) {
            if (column <= 3) {
                smallGridId = 1;
            } else if (column >= 4 && column <= 6){
                smallGridId = 2;
            } else {
                smallGridId = 3;
            }
        } else if (row <= 6) {
            if (column <= 3) {
                smallGridId = 4;
            } else if (column >= 4 && column <= 6){
                smallGridId = 5;
            } else {
                smallGridId = 6;
            }
        } else {
            if (column <= 3) {
                smallGridId = 7;
            } else if (column >= 4 && column <= 6){
                smallGridId = 8;
            } else {
                smallGridId = 9;
            }
        }

        //remove the value param from the row:
        int interval_finish = (9 * row)-1;
        int interval_start = interval_finish - 8;
        for (int i = interval_start; i <= interval_finish; i++) {
            removeValueAtIndex(i, value);
        }

        //remove the value param from the column:
        for (int i = column-1; i < totalgridsize ; i+=9) {
            removeValueAtIndex(i, value);
        }

        //remove the value param from the smallerGrid:
        int startTile = 0;
        switch(smallGridId){
            case 1:
                startTile = 0;
                break;
            case 2:
                startTile = 3;
                break;
            case 3:
                startTile = 6;
                break;
            case 4:
                startTile = 27;
                break;
            case 5:
                startTile = 30;
                break;
            case 6:
                startTile = 33;
                break;
            case 7:
                startTile = 54;
                break;
            case 8:
                startTile = 57;
                break;
            case 9:
                startTile = 60;
                break;
        }
        for (int i = 0; i < 3; i++) { //loop over three rows
            //remove value from each entry in the smallerGrid row:
            for (int j = startTile; j < (startTile+3); j++) {
                removeValueAtIndex(j, value);
            }
            startTile += 9; //go to next row
        }
    }

    /**
     * Function that removes the value from the key list in the hashmap
     *
     * @param key
     * @param value
     */
    private void removeValueAtIndex(int key, int value) {
        if (available.get(key).contains(value)){
            available.get(key).remove(available.get(key).indexOf(value));
        }
    }

    /**
     * Function that validates the user's sudoku game move.
     *
     * @param movePosition
     * @param moveValue
     * @return
     */
    public boolean validateMove(int movePosition, int moveValue) {
        ArrayList<Integer> legalMoves = available.get(movePosition);
        return legalMoves.contains(moveValue);
    }

    /**
     * Function that performs a new move and updates available positions.
     *
     * @param movePosition
     */
    public void newMove(int movePosition, int moveValue){
        grid[movePosition] = moveValue;
        removeValueFromMap(movePosition, moveValue);
        removeAllValuesAt(movePosition);
    }

    /**
     * Function that checks if the player completed the game and won.
     * If all values for each key in the hashmap is empty, then the player has won.
     *
     * @return boolean
     */
    public boolean checkWinState(){
        for (int i = 0; i < totalgridsize; i++) {
            ArrayList<Integer> legalMoves = available.get(i);
            if (!legalMoves.isEmpty()){
                return false;
            }
        }
        return true;
    }
}
