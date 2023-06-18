package com.example.madrasastudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madrasastudent.R;

public class EntryForm extends AppCompatActivity {

    EditText editTextId, editTextName, editTextAge, editTextClass;
    Button buttonSubmit;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_form);

        // Find views by their IDs
        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextClass = findViewById(R.id.editTextClass);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        dbHelper = new DbHelper(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString().trim();
                String name = editTextName.getText().toString().trim();
                String age = editTextAge.getText().toString().trim();
                String className = editTextClass.getText().toString().trim();

                if (name.isEmpty() || id.isEmpty() || age.isEmpty() || className.isEmpty()) {
                    Toast.makeText(EntryForm.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                    return;
                }

                Student student = new Student(id, name, age, className);
                dbHelper.insertStudent(student);

                Toast.makeText(EntryForm.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

                // Clear the input fields
                editTextId.setText("");
                editTextName.setText("");
                editTextAge.setText("");
                editTextClass.setText("");
            }
        });
    }
}
