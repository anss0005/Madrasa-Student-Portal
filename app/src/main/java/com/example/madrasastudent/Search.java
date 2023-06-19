
package com.example.madrasastudent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madrasastudent.DbHelper;
import com.example.madrasastudent.Student;
import com.example.madrasastudent.StudentAdapter;

import java.util.List;

public class Search extends AppCompatActivity {
    private EditText editTextSearch;
    private Button buttonSearch;
    private Button buttonViewAll;
    private RecyclerView recyclerViewStudents;
    private StudentAdapter studentAdapter;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        dbHelper = new DbHelper(this);

        editTextSearch = findViewById(R.id.editTextSearch);
        buttonSearch = findViewById(R.id.buttonSearch);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        recyclerViewStudents = findViewById(R.id.recyclerViewStudents);
        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(this));
        studentAdapter = new StudentAdapter();

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchId = editTextSearch.getText().toString().trim();
                if (!searchId.isEmpty()) {
                    Student student = dbHelper.searchStudentById(searchId);
                    if (student != null) {
                        studentAdapter.clearStudents();
                        studentAdapter.addStudent((List<Student>) student);
                        recyclerViewStudents.setAdapter(studentAdapter);
                    } else {
                        studentAdapter.clearStudents();
                        recyclerViewStudents.setAdapter(studentAdapter);
                        Toast.makeText(Search.this, "No student found with ID: " + searchId, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Search.this, "Please enter a valid ID", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> studentList = dbHelper.viewAllStudents();
                studentAdapter.setStudents(studentList);
                recyclerViewStudents.setAdapter(studentAdapter);
            }
        });
    }
}
