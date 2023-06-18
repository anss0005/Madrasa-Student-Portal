package com.example.madrasastudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button enterBtn,SearchBtn,GitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Binding ui elements
        enterBtn=findViewById(R.id.entrBtn);
        SearchBtn=findViewById(R.id.searchBtn);
        GitBtn=findViewById(R.id.gitBtn);



        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,EntryForm.class);
                startActivity(intent);

            }
        });



    }






}