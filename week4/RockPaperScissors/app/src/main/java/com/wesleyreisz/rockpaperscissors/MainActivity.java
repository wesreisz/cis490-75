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
    public void onClick(View view) {
        Intent intent = new Intent(this,WinLoseActivity.class);
        intent.putExtra(RockPaperScissorsUtil.INPUT_TYPE,view.getId());
        startActivity(intent);
    }
}
