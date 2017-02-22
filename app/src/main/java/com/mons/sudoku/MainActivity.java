package com.mons.sudoku;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

/**
 * This MainActivity class takes care of the app on a high-level.
 *
 * Created by mons on 2017-03-03.
 */
public class MainActivity extends AppCompatActivity
{
    public GridView gridView;
    public Button restartGameButton, button_1, button_2,
            button_3, button_4, button_5, button_6, button_7,
            button_8, button_9, buttonSelected;
    //public TextView gridViewItems;
    CustomGridAdapter gridAdapter;
    public String buttonValue = "";

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

        //initialize UI elements:
        initComponents();

        //set the first game on startup:
        newGame();

        //set button on click listeners:
        setButtonOnClickListeners();
    }

    /**
     * Handles user input.
     *
     * @param view
     */
    public void selectGridItem(View view){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int moveNumericValue = Integer.parseInt(buttonValue);

                //perform a move validation:
                boolean legalMove = sudoku.validateMove(i, moveNumericValue);
                if (legalMove){
                    gridItems[i] = buttonValue;
                } else {
                    System.out.println("Illegal Move. Please try again.");
                }


                CustomGridAdapter gridAdapter = new CustomGridAdapter(MainActivity.this, gridItems, false);
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
        gridAdapter = new CustomGridAdapter(MainActivity.this, gridItems, true);
        gridView.setAdapter(gridAdapter);
    }


    /**
     * Function that initializes the UI components.
     */
    private void initComponents(){
        gridView = (GridView) this.findViewById(R.id.myGridView);
        restartGameButton = (Button) this.findViewById(R.id.new_game_button);
        button_1 = (Button) this.findViewById(R.id.button_1);
        button_2 = (Button) this.findViewById(R.id.button_2);
        button_3 = (Button) this.findViewById(R.id.button_3);
        button_4 = (Button) this.findViewById(R.id.button_4);
        button_5 = (Button) this.findViewById(R.id.button_5);
        button_6 = (Button) this.findViewById(R.id.button_6);
        button_7 = (Button) this.findViewById(R.id.button_7);
        button_8 = (Button) this.findViewById(R.id.button_8);
        button_9 = (Button) this.findViewById(R.id.button_9);
        //gridViewItems = (TextView) this.findViewById(R.id.grid_item);
    }

    /**
     * Function that sets click listeners for buttons.
     */
    private void setButtonOnClickListeners(){
        restartGameButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                newGame();
            }
        });
        button_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                buttonValue = button_1.getText().toString();
                selectGridItem(view);
            }
        });
        button_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                buttonValue = button_2.getText().toString();
                selectGridItem(view);
            }
        });
        button_3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                buttonValue = button_3.getText().toString();
                selectGridItem(view);
            }
        });
        button_4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                buttonValue = button_4.getText().toString();
                selectGridItem(view);
            }
        });
        button_5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                buttonValue = button_5.getText().toString();
                selectGridItem(view);
            }
        });
        button_6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                buttonValue = button_6.getText().toString();
                selectGridItem(view);
            }
        });
        button_7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                buttonValue = button_7.getText().toString();
                selectGridItem(view);
            }
        });
        button_8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                buttonValue = button_8.getText().toString();
                selectGridItem(view);
            }
        });
        button_9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                buttonValue = button_9.getText().toString();
                selectGridItem(view);
            }
        });
    }


}






