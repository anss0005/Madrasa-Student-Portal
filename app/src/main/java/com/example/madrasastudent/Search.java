
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

public class Search extends AppCompatActivity {
    List<Student> studentsList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    EditText etId; // Rename the EditText variable
    List<Student> listOfStudents;
    Button btnSearch;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etId = findViewById(R.id.et_id); // Update the EditText ID

        btnSearch = findViewById(R.id.btn_search);

        db = new DbHelper(this);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etId.getText().toString(); // Get the student ID
                listOfStudents = db.searchStudentByID(id); // Call the searchStudentByID method

                recyclerView = findViewById(R.id.recylerViewStudent);
                recyclerView.setHasFixedSize(true);

                layoutManager = new LinearLayoutManager(Search.this);
                recyclerView.setLayoutManager(layoutManager);

                adapter = new StudentAdapter(listOfStudents);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}


