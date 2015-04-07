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
import android.widget.RadioButton;

import com.ramapo.akuhles.threestones.BoardConfig;
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

        pocketTable.setCurrentColor(BoardConfig.blackStone);
        this.setRetainInstance(true);

        RadioButton blackRB = (RadioButton) pocketTable.findViewById(R.id.rb_black);
        RadioButton whiteRB = (RadioButton) pocketTable.findViewById(R.id.rb_white);
        RadioButton clearRB = (RadioButton) pocketTable.findViewById(R.id.rb_clear);
/*
        blackRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pocketTable.setCurrentColor(BoardConfig.blackStone);
            }
        });
*/
        whiteRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pocketTable.setCurrentColor(BoardConfig.whiteStone);
            }
        });

        clearRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pocketTable.setCurrentColor(BoardConfig.clearStone);
            }
        });

        return v;
    }

    private void dothis() {


    }

    private void createBoard() {
        p = new Point();
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        display.getSize(p);
        pocketTable.initializePockets(p.x, p.y);
    }

    public PocketTableView getPocketTable() {
        return this.pocketTable;
    }


}
