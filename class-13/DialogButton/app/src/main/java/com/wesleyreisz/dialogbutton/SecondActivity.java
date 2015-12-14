package com.wesleyreisz.dialogbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String messsage = getIntent().getStringExtra(MainActivity.MESSAGE_TEXT);
        TextView textView = (TextView)findViewById(R.id.txtMessage);
        textView.setText(messsage);
    }
}
