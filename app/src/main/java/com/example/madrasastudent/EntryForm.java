package com.example.madrasastudent;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.madrasastudent.DbHelper;

import androidx.appcompat.app.AppCompatActivity;

public class EntryForm extends AppCompatActivity {

    private EditText editTextId, editTextName, editTextAge, editTextClass, editTextSabaq, editTextSabqi, editTextManzil, editTextDate;
    private Button buttonSave;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_form);

        // Initialize views
        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextClass = findViewById(R.id.editTextClass);
        editTextSabaq = findViewById(R.id.editTextSabaq);
        editTextSabqi = findViewById(R.id.editTextSabqi);
        editTextManzil = findViewById(R.id.editTextManzil);
        editTextDate = findViewById(R.id.editTextDate);
        buttonSave = findViewById(R.id.buttonSave);

        // Initialize DbHelper
        dbHelper = new DbHelper(this);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the data from the EditText fields
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();
                String className = editTextClass.getText().toString();
                String sabaq = editTextSabaq.getText().toString();
                String sabqi = editTextSabqi.getText().toString();
                String manzil = editTextManzil.getText().toString();
                String date = editTextDate.getText().toString();

                // Create a new instance of the Student class
                Student student = new Student(id, name, age, className, sabaq, sabqi, manzil, date);

                // Create a new instance of SQLiteDatabase for writing to the database
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                // Define the columns to be queried
                String[] projection = {DbHelper.COLUMN_ID};

                // Define the selection criteria
                String selection = DbHelper.COLUMN_ID + " = ?";

                // Define the selection arguments
                String[] selectionArgs = {id};

                // Perform the query
                Cursor cursor = db.query(
                        DbHelper.TABLE_STUDENT,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null
                );

                // Check if the cursor has any rows
                if (cursor.moveToFirst()) {
                    Toast.makeText(EntryForm.this, "Student with ID already exists", Toast.LENGTH_SHORT).show();
                    // Student with the given ID already exists
                    // You can add any desired actions or display an error message here
                } else {
                    // Insert the data into the database
                    long result = db.insert(DbHelper.TABLE_STUDENT, null, student.toContentValues());

                    // Check if the data was successfully inserted
                    if (result != -1) {
                        Toast.makeText(EntryForm.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                        // Data inserted successfully
                        // You can add any desired actions or display a success message here
                    } else {
                        Toast.makeText(EntryForm.this, "Data Failed to Insert", Toast.LENGTH_SHORT).show();
                        // Failed to insert data
                        // You can add any desired actions or display an error message here
                    }
                }

                // Close the cursor and the database connection
                cursor.close();
                db.close();
            }
        });




    }




    }


