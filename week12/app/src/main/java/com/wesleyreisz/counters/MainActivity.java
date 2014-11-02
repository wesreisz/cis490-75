package com.wesleyreisz.counters;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;



public class MainActivity extends Activity {
    private TextView mCount;

    final Handler countHandler = new Handler(){
        public void handleMessage(Message msg){
            mCount.setText((String)msg.obj);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCount = (TextView)findViewById(R.id.count);
        mCount.setText("0");
        count();
    }

    private void count() {
        new Thread(new Runnable() {
            int seconds = 0;
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                        seconds++;

                        Message msg = Message.obtain();
                        msg.obj = seconds + "";
                        countHandler.sendMessage(msg);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Log.w("COUNTER", e);
                    }

                }
            }
        }).start();
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

    public void reset(View view) {
        count();
    }
}
