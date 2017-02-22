package com.mons.sudoku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.view.View;

/**
 * This is a Grid Adapter class which extends BaseAdapter
 *
 * Created by mons on 2017-03-03.
 */
public class CustomGridAdapter extends BaseAdapter {

    private Context context;
    private String[] items;
    LayoutInflater inflater;

    /**
     * Constructor using fields
     *
     * @param context
     * @param items
     */
    public CustomGridAdapter(Context context, String[] items, boolean startItems) {
        this.context = context;
        this.items = items;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Gets the view and sets the textviews at each position in the grid
     *
     * @param position
     * @param convertView
     * @param parent
     * @return View convertView
     */
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = inflater.inflate(R.layout.cell, null);
        }
        TextView t = (TextView) convertView.findViewById(R.id.grid_item);
        t.setText(items[position]);
        return convertView;
    }

    /**
     * Gets the number of grid items
     *
     * @return int
     */
    @Override
    public int getCount(){
        return items.length;
    }

    /**
     * Gets an item at a specific position in the grid.
     *
     * @param position
     * @return Object
     */
    @Override
    public Object getItem(int position){
        return items[position];
    }

    /**
     * Gets the position / index of the item
     *
     * @param position
     * @return int
     */
    @Override
    public long getItemId(int position){
        return position;
    }
}
