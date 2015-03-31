package com.ramapo.akuhles.threestones.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.ramapo.akuhles.threestones.R;

/**
 * Created by Alex on 3/29/2015.
 */
public class BoardFragment extends Fragment implements View.OnTouchListener {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.board_fragment, container, false);
        return v;
    }

    private void createBoard() {

    }

}
