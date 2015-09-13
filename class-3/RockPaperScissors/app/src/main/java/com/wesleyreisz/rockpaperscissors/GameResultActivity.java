package com.wesleyreisz.rockpaperscissors;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameResultActivity extends AppCompatActivity {

    private static final String TAG = "Result Page";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        RelativeLayout rl = (RelativeLayout)findViewById(R.id.resultLayout);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //get the player selected choice
        Intent intent = getIntent();

        Integer playerSelectedChoice = (Integer)intent.getIntExtra(MainActivity.PLAYER_CHOICE,1);
        ImageView player = (ImageView) findViewById(R.id.btnPlayer);
        player.setImageResource(GameUtils.convertButtonToImage(playerSelectedChoice));

        //get the a random computer choice
        Integer computerSelectedChoice = GameUtils.getComputerChoice();
        ImageView computer = (ImageView) findViewById(R.id.btnComputer);
        computer.setImageResource(GameUtils.convertButtonToImage(computerSelectedChoice));

        //evaluate winner
        TextView result = (TextView)findViewById(R.id.txtResult);
        result.setText(GameUtils.evaluateWinner(playerSelectedChoice, computerSelectedChoice));
        result.setTextSize(28);
        result.setTextColor(GameUtils.defineTextColor(result.getText().toString()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_result, menu);
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
}
