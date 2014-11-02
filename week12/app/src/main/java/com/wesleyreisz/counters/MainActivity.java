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

import com.wesleyreisz.counters.util.CounterConstants;
import com.wesleyreisz.counters.util.HttpUtil;

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
        new Thread(new MyCounter(++threadsCount)).start();
    }

    class CounterHandler extends Handler{
        public void setSong(final String songs){
            runOnUiThread( new Runnable() {
                public void run() {
                    mTxtView.setText(songs);
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
            mHandler.setMessage("Started: " + localCount + "!");
            Log.d("Counter", "Started fetch for songs");
            String results = HttpUtil.getJson(CounterConstants.HTTPS_ITUNES_APPLE_COM_US_RSS_TOPSONGS);
            Log.d("Counter", "Got Songs: " + results);
            mHandler.setSong(results);
            mHandler.setMessage("Finished: " + localCount + "!");
        }
    }


}
