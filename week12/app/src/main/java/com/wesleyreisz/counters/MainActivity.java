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
    private int threadsCount=0;
    private TextView mTxtView;
    private TextView mTextMessage;
    private CounterHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtView = (TextView)findViewById(R.id.txtView);
        mTextMessage = (TextView)findViewById(R.id.txtMessage);

        Button btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);

        mHandler = new CounterHandler();
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
        //mTextMessage.setText("Started...");
        new Thread(new MyCounter(++threadsCount)).start();
        //mTextMessage.setText("Finished...");
    }

    class CounterHandler extends Handler{
        public void setCounter(final String counterText){
            runOnUiThread( new Runnable() {
                public void run() {
                    mTxtView.setText(counterText);
                }
            });
        }
        public void setMessage(final String counterText){
            runOnUiThread( new Runnable() {
                public void run() {
                    mTextMessage.setText(counterText);
                }
            });
        }
    }

    class MyCounter implements Runnable {
        int localCount=0;
        public MyCounter(int threadNumber){
            localCount=threadNumber;
        }
        @Override
        public void run() {
            int seconds = 0;
            mHandler.setMessage("Started: " + localCount + "!");
            while(seconds<20){
                try {
                    seconds++;
                    Thread.sleep(1000);
                    String stringMessage = "Counter: " + seconds;
                    mHandler.setCounter(stringMessage);
                    Log.d("Counter", stringMessage);

                    if(seconds%10==0){
                        mHandler.setMessage(
                            "Multiple of 10: " + seconds + " on thread #: " +localCount
                        );
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mHandler.setMessage("Finished: " + localCount + "!");
        }
    }


}
