package com.ramapo.akuhles.threestones.board;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Alex on 3/29/2015.
 */
public class PocketTableView extends ViewGroup{

    private final int POCKET_SIZE = 65;
    private int currentColor;
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

    public void setCurrentColor(int currentColor) {
        this.currentColor = currentColor;
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

            pImg.setChildIndex(i);

            int left = pImg.getCol() * POCKET_SIZE + boardMargin;
            int top = pImg.getRow()  * POCKET_SIZE + boardMargin;
            int right = left + POCKET_SIZE;
            int bottom = top + POCKET_SIZE;

            pImg.setLeftBound(left);
            pImg.setTopBound(top);
            pImg.setRightBound(right);
            pImg.setBottomBound(bottom);

            pImg.layout(left, top, right, bottom);
        }

    }

    public int getChildIndex(int id) {
        for (int i = 0; i < 80; i++) {
            PocketImageView p = (PocketImageView) getChildAt(i);

            if (p.getPocketId() == id) {
                return p.getChildIndex();
            }
        }
        return -1;
    }

    public int getPocketIdAt(int x, int y) {
        for (int i = 0; i < 80; i++) {
            PocketImageView p = (PocketImageView) getChildAt(i);

            if (x > p.getLeftBound() && x < p.getRightBound()
                    && y < p.getBottomBound() && y > p.getTopBound()) {
                return p.getPocketId();
            }
        }
        return -1;
    }

    public void setStone(int touchx, int touchy) {
        PocketImageView pImg = (PocketImageView) getChildAt(getChildIndex(getPocketIdAt(touchx, touchy)));

        if (pImg != null) {
            pImg.placeStone(currentColor);
        }
    }
}
