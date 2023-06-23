package com.example.madrasastudent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class EntryForm extends AppCompatActivity {
    EditText etStudentID, etName, etAge, etClas, etSabaq, etSabqi, etManzil;
    Button btnSave;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_form);

        etStudentID = findViewById(R.id.et_student_id);
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etClas = findViewById(R.id.et_clas);
        etSabaq = findViewById(R.id.et_sabaq);
        etSabqi = findViewById(R.id.et_sabqi);
        etManzil = findViewById(R.id.et_manzil);
        btnSave = findViewById(R.id.btn_save);

        db = new DbHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentID = etStudentID.getText().toString();
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String clas = etClas.getText().toString();
                String sabaq = etSabaq.getText().toString();
                String sabqi = etSabqi.getText().toString();
                String manzil = etManzil.getText().toString();

                // Check for empty values
                if (name.isEmpty()) {
                    Toast.makeText(EntryForm.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (studentID.isEmpty() || age.isEmpty() || clas.isEmpty() || sabaq.isEmpty() || sabqi.isEmpty() || manzil.isEmpty()) {
                    Toast.makeText(EntryForm.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if student with ID already exists
                if (db.isStudentIdExists(studentID)) {
                    Toast.makeText(EntryForm.this, "Student with ID already exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                Student student = new Student(studentID, name, age, clas, sabaq, sabqi, manzil);
                db.insertStudent(student);

                Toast.makeText(EntryForm.this, "Data successfully inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
