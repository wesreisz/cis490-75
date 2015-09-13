package com.wesleyreisz.core_java_interface_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wesleyreisz.core_java_interface_example.animal.Animal;
import com.wesleyreisz.core_java_interface_example.animal.Cat;
import com.wesleyreisz.core_java_interface_example.animal.Dog;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Core Java Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void doExample(View view) {
        Animal animal;
        if(view.getId()==R.id.btnCat){
            //cat
            animal = new Cat();
        }else if(view.getId()==R.id.btnDog){
            //dog
            animal = new Dog();
        }else if(view.getId()==R.id.btnSnake){
            //snake
            animal = new Snake();
        }else{
            //animal
            animal = new Animal();
        }

        Log.d(TAG, "Animal says: " + animal.speak());

       ;

    }
}
