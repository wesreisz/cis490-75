package com.wesleyreisz.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "Rock, Paper, Scissors";
    public static final String PLAYER_CHOICE = "com.wesleyreisz.rock_paper_scissors.player_choice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton rock = (ImageButton)findViewById(R.id.btnRock);
        rock.setOnClickListener(this);
        ImageButton page = (ImageButton)findViewById(R.id.btnPaper);
        page.setOnClickListener(this);
        ImageButton scissors = (ImageButton)findViewById(R.id.btnScissors);
        scissors.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        //adds animation to the click
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        v.startAnimation(animAlpha);

        Intent intent = new Intent(this, GameResultActivity.class);
        intent.putExtra(PLAYER_CHOICE, v.getId());
        startActivity(intent);
    }
}
