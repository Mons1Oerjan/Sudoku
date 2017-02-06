package com.mons.sudoku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * This MainActivity class takes care of the app on a high-level.
 *
 * Created by mons on 2017-03-03.
 */
public class MainActivity extends AppCompatActivity
{
    public GridView gridView;
    public String[] gridItems = new String[81];
    private Sudoku sudoku = Sudoku.getInstance();

    /**
     * Creates the MainActivity view when the application starts up.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGame();

        gridView = (GridView) this.findViewById(R.id.myGridView);
        CustomGridAdapter gridAdapter = new CustomGridAdapter(MainActivity.this, gridItems);
        gridView.setAdapter(gridAdapter);
    }


    /**
     * Handles user input.
     *
     * @param view
     */
    //TODO: Need to handle user input and do a validation check
    public void set1(View view){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                String s = (String) gridView.getItemAtPosition(i);
                int c = Integer.parseInt(s);
                gridItems[c-1] = "1";
                CustomGridAdapter gridAdapter = new CustomGridAdapter(MainActivity.this, gridItems);
                gridView.setAdapter(gridAdapter);

            }
        });
    }

    /**
     * Function that creates a new sudoku grid and converts the grid to strings for the view.
     */
    public void newGame(){
        int[] grid = sudoku.newGrid();
        for (int i = 0; i < grid.length; i++) {
            if (grid[i] == 0){
                gridItems[i] = "";
            } else {
                gridItems[i] = Integer.toString(grid[i]);
            }
        }
    }


}
