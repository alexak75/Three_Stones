package com.ramapo.akuhles.threestones.fragments;

import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

import com.ramapo.akuhles.threestones.R;
import com.ramapo.akuhles.threestones.board.PocketTableView;

/**
 * Created by Alex on 3/29/2015.
 */
public class BoardFragment extends Fragment implements OnTouchListener {

    private Point p;
    private PocketTableView pocketTable;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int touchx = (int) event.getX();
        int touchy = (int) event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            pocketTable.setStone(touchx, touchy);
            return true;
        }
        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.board_fragment, container, true);
        pocketTable = (PocketTableView) v.findViewById(R.id.board);
        pocketTable.setOnTouchListener(this);

        createBoard();

        pocketTable.setCurrentColor(R.drawable.pocket50);
        this.setRetainInstance(true);
        return v;
    }

    private void createBoard() {
        p = new Point();
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        display.getSize(p);
        pocketTable.initializePockets(p.x, p.y);
    }

}
