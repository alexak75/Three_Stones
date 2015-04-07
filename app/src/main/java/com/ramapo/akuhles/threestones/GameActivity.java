package com.ramapo.akuhles.threestones;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ramapo.akuhles.threestones.board.PocketTableView;
import com.ramapo.akuhles.threestones.fragments.BoardFragment;
import com.ramapo.akuhles.threestones.fragments.MenuFragment;

/**
 * Created by Alex on 3/25/2015.
 */
public class GameActivity extends Activity {

    private String colorSelection;
    private static RadioGroup colorButtonGroup;
    private static RadioButton blackRB, whiteRB, clearRB;
    private BoardFragment pocketTableFrag;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pocketTableFrag = (BoardFragment) getFragmentManager()
                .findFragmentById(R.id.board);

        RadioButton blackRB = (RadioButton) findViewById(R.id.rb_black);
        RadioButton whiteRB = (RadioButton) findViewById(R.id.rb_white);
        RadioButton clearRB = (RadioButton) findViewById(R.id.rb_clear);

        blackRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        whiteRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        clearRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch(view.getId()) {
            case R.id.rb_black:
                if (checked)
                    colorSelection = "black";
                break;
            case R.id.rb_white:
                if (checked)
                    colorSelection = "white";
                break;
            case R.id.rb_clear:
                if (checked)
                    colorSelection = "clear";
                break;
        }
    }

}
