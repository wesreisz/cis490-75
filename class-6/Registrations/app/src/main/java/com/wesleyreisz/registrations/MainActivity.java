package com.wesleyreisz.registrations;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean isRegisterOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new MainActivityFragment());
        fragmentTransaction.commit();

        final TextView textView = (TextView)findViewById(R.id.btnRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (isRegisterOn) {
                    fragmentTransaction.replace(R.id.container, new MainActivityFragment());
                    textView.setText("Login Now");
                    isRegisterOn = false;
                }else{
                    fragmentTransaction.replace(R.id.container, new RegisterFragment());
                    textView.setText("Register Now");
                    isRegisterOn = true;
                }
                fragmentTransaction.commit();
            }
        });
    }
}
