package com.ramapo.akuhles.threestones.board;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.ramapo.akuhles.threestones.BoardConfig;
import com.ramapo.akuhles.threestones.R;

/**
 * Created by Alex on 3/29/2015.
 */
public class PocketImageView extends ImageView {

    int row, col;
    private int leftBound;
    private int topBound;
    private int rightBound;
    private int bottomBound;
    private int childIndex;
    private int pocketId;
    private int currentCellId;
    private int currentPocketId;
    private Context context;


    public PocketImageView(Context context) {
        super(context);
    }
    public PocketImageView(Context context, int row, int col) {
        super(context);
        this.context = context;
        this.row = row;
        this.col = col;
        Drawable img  = getResources().getDrawable(BoardConfig.pocketImg);
        setImageDrawable(img);
        this.currentCellId = BoardConfig.pocketImg;
        this.pocketId = (row * 100) + col;
    }
    public PocketImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public PocketImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getLeftBound() {
        return leftBound;
    }

    public int getTopBound() {
        return topBound;
    }

    public int getRightBound() {
        return rightBound;
    }

    public int getBottomBound() {
        return bottomBound;
    }

    public int getPocketId() {
        return pocketId;
    };

    public int getChildIndex() {
        return childIndex;
    }

    public void setBottomBound(int bottomBound) {
        this.bottomBound = bottomBound;
    }

    public void setLeftBound(int leftBound) {
        this.leftBound = leftBound;
    }

    public void setTopBound(int topBound) {
        this.topBound = topBound;
    }

    public void setRightBound(int rightBound) {
        this.rightBound = rightBound;
    }

    public void setChildIndex(int childIndex) {
        this.childIndex = childIndex;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void placeStone(int resId) {

        PocketTableView ptv = new PocketTableView(context);
        this.currentPocketId = resId;
        final Drawable d = getResources().getDrawable(resId);
        if (resId != R.drawable.pocket50_circle) {
            setImageDrawable(d);
            this.setVisibility(View.GONE);
        }
    }
}


