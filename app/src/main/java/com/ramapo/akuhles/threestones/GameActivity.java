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
public class GameActivity extends Activity implements MenuFragment.OnColorSelectedListener {

    private String colorSelection;
    private static RadioGroup colorButtonGroup;
    private static RadioButton blackRB, whiteRB, clearRB;
    private BoardFragment pocketTableFrag;
    private LinearLayout linearLayout;

    @Override
    public void onColorSelected() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pocketTableFrag = (BoardFragment) getFragmentManager()
                .findFragmentById(R.id.board);
    }

    public String getColorSelection() {
        return colorSelection;
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
