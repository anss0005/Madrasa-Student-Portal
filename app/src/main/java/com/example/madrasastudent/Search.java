package com.example.madrasastudent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {

    private EditText editTextSearch;
    private Button searchButton, viewAllButton;
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Initialize views
        editTextSearch = findViewById(R.id.editTextSearch);
        searchButton = findViewById(R.id.searchButton);
        viewAllButton = findViewById(R.id.viewAllButton);
        recyclerView = findViewById(R.id.recyclerView);

        // Initialize database helper
        dbHelper = new DbHelper(this);

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentList = new ArrayList<>();
        studentAdapter = new StudentAdapter(studentList);
        recyclerView.setAdapter(studentAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQuery = editTextSearch.getText().toString().trim();
                searchStudents(searchQuery);
            }
        });

        viewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAllStudents();
            }
        });
    }

    private void searchStudents(String query) {
        List<Student> searchResults = dbHelper.searchStudent(query);
        if (searchResults.isEmpty()) {
            Toast.makeText(this, "No results found", Toast.LENGTH_SHORT).show();
        }
        studentList.clear();
        studentList.addAll(searchResults);
        studentAdapter.notifyDataSetChanged();
    }

    private void displayAllStudents() {
        List<Student> allStudents = dbHelper.getAllStudents();
        if (allStudents.isEmpty()) {
            Toast.makeText(this, "No students found", Toast.LENGTH_SHORT).show();
        }
        studentList.clear();
        studentList.addAll(allStudents);
        studentAdapter.notifyDataSetChanged();
    }
}
