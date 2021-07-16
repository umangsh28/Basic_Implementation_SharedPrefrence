package com.example.remember_layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText mtname;
    private EditText mtpassw;
    private Button mtrem;
    private Button mthome;

    private static final String Key_main="main";
    private static final String Key_name="name";
    private   String call;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences =getSharedPreferences("main",MODE_PRIVATE);
        if (sharedPreferences.contains(Key_name)){
            Intent intent=new Intent(MainActivity.this,HomeScreen.class);
            startActivity(intent);
        }
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void initView() {
        mtrem=findViewById(R.id.button);
        mthome=findViewById(R.id.button2);
        mtname=findViewById(R.id.textView);
        mtpassw=findViewById(R.id.textView2);




        mthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,HomeScreen.class);
                startActivity(intent);

            }
        });

        mtrem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(Key_name,mtname.getText().toString());
                editor.apply();
                   Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                   startActivity(intent);

            }
        });

    }



    @Override
        public void onSaveInstanceState (@NonNull Bundle outState){
            super.onSaveInstanceState(outState);
            outState.putString(Key_name, mtname.getText().toString());
        }



}