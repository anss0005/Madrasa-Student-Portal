package com.example.madrasastudent;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//--
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {




    Button btnSave, btnEdit,btnSearch,btnShowAll,btnGit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSave = findViewById(R.id.btn_save);
        btnEdit = findViewById(R.id.btn_edit);
       btnGit=findViewById(R.id.Git);
        btnSearch= findViewById(R.id.btn_search);
        btnShowAll=findViewById(R.id.btn_showall);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(MainActivity.this,EntryForm.class);
                startActivity(intent);

            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,EditStudent.class);
                startActivity(intent);
            }
        });

     /*   btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DeleteStudent.class);
                startActivity(intent);
            }
        });*/

        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ViewAll.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Search.class);
                startActivity(intent);
            }
        });


        btnGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://github.com/anss0005/Madrasa-Student-Portal";
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }


}