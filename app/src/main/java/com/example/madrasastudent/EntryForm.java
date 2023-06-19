package com.example.madrasastudent;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EntryForm extends AppCompatActivity {

    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextClass;
    private EditText editTextDOB;
    private EditText editTextManzil;
    private EditText editTextSabaq;
    private EditText editTextSabqi;
    private Button buttonSubmit;

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_form);

        dbHelper = new DbHelper(this);

        // Find all the EditText and Button views by their IDs
        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextClass = findViewById(R.id.editTextClass);
        editTextDOB = findViewById(R.id.editTextDOB);
        editTextManzil = findViewById(R.id.editTextManzil);
        editTextSabaq = findViewById(R.id.editTextSabaq);
        editTextSabqi = findViewById(R.id.editTextSabqi);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set a click listener for the Submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the entered values from the EditText fields
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();
                String studentClass = editTextClass.getText().toString();
                String dob = editTextDOB.getText().toString();
                String manzil = editTextManzil.getText().toString();
                String sabaq = editTextSabaq.getText().toString();
                String sabqi = editTextSabqi.getText().toString();

                // Check if the student with the same ID already exists
                boolean studentExists = dbHelper.checkStudentExists(id);
                if (studentExists) {
                    // Student with the same ID already exists
                    Toast.makeText(EntryForm.this, "Student already exists with the same ID", Toast.LENGTH_SHORT).show();
                } else {
                    // Insert the data into the database
                    long newRowId = dbHelper.insertDataIntoDatabase(id, name, age, studentClass, dob, manzil, sabaq, sabqi);

                    if (newRowId != -1) {
                        Toast.makeText(EntryForm.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(EntryForm.this, "Error inserting data into database", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
