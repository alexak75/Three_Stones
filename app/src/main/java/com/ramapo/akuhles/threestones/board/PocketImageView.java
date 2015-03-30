package com.ramapo.akuhles.threestones.board;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Alex on 3/29/2015.
 */
public class PocketImageView extends ImageView {

    int row, col;

    public PocketImageView(Context context) {
        super(context);
    }
    public PocketImageView(Context context, int row, int col) {
        super(context);
        this.row = row;
        this.col = col;
    }
    public PocketImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public PocketImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


}


