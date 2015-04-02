package com.ramapo.akuhles.threestones;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import com.ramapo.akuhles.threestones.fragments.BoardFragment;
import com.ramapo.akuhles.threestones.fragments.MenuFragment;

/**
 * Created by Alex on 3/25/2015.
 */
public class GameActivity extends Activity {

    private BoardFragment pocketTableFrag;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pocketTableFrag = (BoardFragment) getFragmentManager()
                .findFragmentById(R.id.board);
    }
}
