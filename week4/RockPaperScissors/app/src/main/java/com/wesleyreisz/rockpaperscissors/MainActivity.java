package com.wesleyreisz.rockpaperscissors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageViewRock = (ImageView)findViewById(R.id.imageRock);
        imageViewRock.setOnClickListener(this);

        ImageView imageViewPaper = (ImageView)findViewById(R.id.imagePaper);
        imageViewPaper.setOnClickListener(this);

        ImageView imageViewScissors = (ImageView)findViewById(R.id.imageScissors);
        imageViewScissors.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    public void onClick(View view) {
        Intent intent = new Intent(this,WinLoseActivity.class);
        intent.putExtra(RockPaperScissorsUtil.INPUT_TYPE,view.getId());
        startActivity(intent);
    }
}
