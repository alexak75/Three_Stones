package com.ramapo.akuhles.threestones;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onExit(View view) {
        finish();
    }

    public void onNewGameClick(View view) {
        Intent getNewGameActivity = new Intent(this, Game.class);
        final int result = 1;
        boolean userResumeGame = false;
        getNewGameActivity.putExtra("callingActivity", userResumeGame);
        startActivity(getNewGameActivity);
    }

    public void onResumeGameClick(View view) {
        Intent getNewGameActivity = new Intent(this, Game.class);
        final int result = 1;
        boolean userResumeGame = true;
        getNewGameActivity.putExtra("callingActivity", userResumeGame);
        startActivity(getNewGameActivity);
    }
}
