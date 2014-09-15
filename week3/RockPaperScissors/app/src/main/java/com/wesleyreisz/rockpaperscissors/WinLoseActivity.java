package com.wesleyreisz.rockpaperscissors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class WinLoseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_lose);
        Intent intent = getIntent();
        int clickedType = intent.getIntExtra(RockPaperScissorsUtil.INPUT_TYPE,0);

        RockPaperScissorType player1Choice = RockPaperScissorType.ROCK;
        if(clickedType==R.id.imageRock){
            player1Choice=RockPaperScissorType.ROCK;
        }else if(clickedType==R.id.imagePaper){
            player1Choice=RockPaperScissorType.PAPER;
        }else if(clickedType==R.id.imageScissors){
            player1Choice=RockPaperScissorType.SCISSORS;
        }

        RockPaperScissorsAI player2 = new RockPaperScissorsAI();
        RockPaperScissorType player2Choice = player2.play();

        //set picture
        ImageView imageComputer = (ImageView)findViewById(R.id.imageComputer);
        if(player2Choice==RockPaperScissorType.ROCK){
            imageComputer.setImageResource(R.drawable.rock);
        }else if(player2Choice==RockPaperScissorType.PAPER){
            imageComputer.setImageResource(R.drawable.paper);
        }else if(player2Choice==RockPaperScissorType.SCISSORS){
            imageComputer.setImageResource(R.drawable.scissors);
        }

        //set result
        String result = RockPaperScissorsUtil.eval(player1Choice,player2Choice);
        TextView textView = (TextView)findViewById(R.id.textResult);
        textView.setText(result);

        Button button = (Button) findViewById(R.id.btnAgain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WinLoseActivity.this.finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.win_lose, menu);
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
