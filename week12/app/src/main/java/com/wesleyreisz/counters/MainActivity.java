package com.wesleyreisz.counters;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Handler;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView mTxtView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mTxtView.setText((String)msg.obj);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtView = (TextView)findViewById(R.id.txtView);
        Button btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
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
       new Thread(new MyCounter()).start();
    }

    class MyCounter implements Runnable {
        @Override
        public void run() {
            int seconds = 0;
            while(seconds<20){
                try {
                    seconds++;
                    Thread.sleep(1000);
                    String stringMessage = "Counter: " + seconds;
                    Message msg = Message.obtain();
                    msg.obj = stringMessage;
                    handler.sendMessage(msg);
                    Log.d("Counter", stringMessage);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class CounterHandler extends Handler{
        public void setCounter(String counterText){
            mTxtView.setText(counterText);
        }
    }
}
