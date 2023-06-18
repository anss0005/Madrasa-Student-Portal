package com.example.madrasastudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Search extends AppCompatActivity {

    EditText editTextSearchId;
    Button buttonSearch, buttonDisplayAll;
    RecyclerView recyclerView;
    DbHelper dbHelper;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editTextSearchId = findViewById(R.id.editTextSearchId);
        buttonSearch = findViewById(R.id.buttonSearch);
        buttonDisplayAll = findViewById(R.id.buttonDisplayAll);
        recyclerView = findViewById(R.id.recyclerView);
        dbHelper = new DbHelper(this);

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentAdapter = new StudentAdapter();
        recyclerView.setAdapter(studentAdapter);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchId = editTextSearchId.getText().toString().trim();
                if (searchId.isEmpty()) {
                    Toast.makeText(Search.this, "Please enter a valid student ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                Student student = dbHelper.searchStudent(Integer.parseInt(searchId));
                if (student != null) {
                    studentAdapter.setStudents(List.of(student));
                } else {
                    studentAdapter.setStudents(List.of());
                    Toast.makeText(Search.this, "No student found with ID: " + searchId, Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonDisplayAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Student> allStudents = dbHelper.getAllStudents();
                if (allStudents.isEmpty()) {
                    Toast.makeText(Search.this, "No students found in the database", Toast.LENGTH_SHORT).show();
                }
                studentAdapter.setStudents(allStudents);
            }
        });
    }
}
