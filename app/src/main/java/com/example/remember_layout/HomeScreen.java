package com.example.remember_layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    private TextView mtvname;

    SharedPreferences sharedPreferences;

    private static final String Key_main="main";
    private static final String Key_name="name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        mtvname=findViewById(R.id.textView3);


        sharedPreferences=getSharedPreferences(Key_main,MODE_PRIVATE);

        String name=sharedPreferences.getString(Key_name,"");
        mtvname.setText(name);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String data=savedInstanceState.getString(Key_name);
        mtvname.setText(data);

    }
}