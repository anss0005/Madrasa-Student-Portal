package com.example.madrasastudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ViewAll extends AppCompatActivity {
    List<Student> StudentsList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    //
    List<Student> listofstudents;
    Button btnShow;

    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);






        btnShow = findViewById(R.id.btn_show);


        db = new DbHelper(this);



        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listofstudents = (List<Student>)db.selectAllStudents();
                recyclerView = findViewById(R.id.recylerView);


                recyclerView.setHasFixedSize(true);

                //LinearLayoutManager GridLayoutManager
                layoutManager = new LinearLayoutManager(ViewAll.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                false);
                recyclerView.setLayoutManager(layoutManager);

                adapter = new StudentAdapter(listofstudents);
                recyclerView.setAdapter(adapter);
                //adapter.notifyDataSetChanged();


            }
        });
    }
}


