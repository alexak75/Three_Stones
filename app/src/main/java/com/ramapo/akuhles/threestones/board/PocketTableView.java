package com.ramapo.akuhles.threestones.board;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Alex on 3/29/2015.
 */
public class PocketTableView extends ViewGroup{

    private final int POCKET_SIZE = 65;
    private int boardMargin;
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
        return (int) Math.ceil(y / POCKET_SIZE);
    }
    public int getColumn(int x) {
        return (int) Math.ceil( x / POCKET_SIZE);
    }

    public int[] initializePockets(int w, int h) {
        width = w;
        height = h;
        boardMargin = (width - (POCKET_SIZE * 11)) / 2;
        numRow = 11;
        numCol = 11;

        for (int r = 0; r < numRow; r++) {
            for (int c = 0; c < numCol; c++) {
                if ((r == 0 && c > 3 && c < 7) || (r == 1 && c > 2 && c < 8) || (r == 2 && c > 1 && c < 9) ||
                        (r == 3 && c > 0 && c < 10) || ((r > 3 && r < 7) && c >= 0 && c <= 11) ||
                        (r == 7 && c > 0 && c < 10) || (r == 8 && c > 1 && c < 9) ||
                        (r == 9 && c > 2 && c < 8) || (r == 10 && c > 3 && c < 7)) {

                    if (!(r == 5 && c == 5)) {
                        PocketImageView pImg = new PocketImageView(getContext(), r, c);
                        this.addView(pImg);
                    }

                }
            }
        }
        return new int[]{numRow, numCol};
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentWidth  = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);

        this.setMeasuredDimension(parentWidth, parentHeight);
    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            PocketImageView pImg = (PocketImageView) getChildAt(i);

            int left = pImg.getCol() * POCKET_SIZE + boardMargin;
            int top = pImg.getRow()  * POCKET_SIZE + boardMargin;
            int right = left + POCKET_SIZE;
            int bottom = top + POCKET_SIZE;

            pImg.layout(left, top, right, bottom);
        }

    }
}
