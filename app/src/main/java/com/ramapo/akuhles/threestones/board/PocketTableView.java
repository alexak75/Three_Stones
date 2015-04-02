package com.ramapo.akuhles.threestones.board;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Alex on 3/29/2015.
 */
public class PocketTableView extends ViewGroup{

    private int pocketSize;
    private int numRow, numCol;
    private int width, height;

    public PocketTableView(Context context) {
        super(context);
    }
    public PocketTableView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public PocketTableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getRow(int y) {
        return (int) Math.ceil(y / pocketSize);
    }
    public int getColumn(int x) {
        return (int) Math.ceil( x / pocketSize);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            PocketImageView pImg = (PocketImageView) getChildAt(i);

            int left = pImg.getCol() * pocketSize;
            int top = pImg.getRow()  * pocketSize;
            int right = left + pocketSize ;
            int bottom = top + pocketSize ;

            pImg.layout(left, top, right, bottom);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentWidth  = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);

        this.setMeasuredDimension(parentWidth, parentHeight);
    }

    public int[] initializePockets(int w, int h, int pocketSize) {
        width = w;
        height = h;
        this.pocketSize = pocketSize;
        numRow = 11;
        numCol = 11;

        for (int r = 0; r < numRow; r++) {
            for (int c = 0; c < numCol; c++) {
                PocketImageView pImg = new PocketImageView(getContext(), r, c);
                this.addView(pImg);
            }
        }
        return new int[]{numRow, numCol};
    }
}
