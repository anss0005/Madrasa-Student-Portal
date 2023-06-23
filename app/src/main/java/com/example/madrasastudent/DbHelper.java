package com.example.madrasastudent;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_Age = "age";
    private static final String COLUMN_Clas = "clas";
    private static final String COLUMN_Sabaq = "sabaq";
    private static final String COLUMN_Sabaqi = "sabaqi";
    private static final String COLUMN_Manzil = "manzil";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_Age + " INTEGER,"
                + COLUMN_Clas + " TEXT,"
                + COLUMN_Sabaq + " TEXT,"
                + COLUMN_Sabaqi + " INTEGER ,"
                + COLUMN_Manzil + " TEXT"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_Age, student.getAge());
        values.put(COLUMN_Clas, student.getClas());
        values.put(COLUMN_Sabaq, student.getSabaq());
        values.put(COLUMN_Sabaqi, student.getSabqi());
        values.put(COLUMN_Manzil, student.getManzil());



        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public boolean isStudentIdExists(String studentID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        boolean exists = false;

        try {
            // Query the database to check if the student ID exists
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?";
            cursor = db.rawQuery(query, new String[]{studentID});

            // If a row is returned, it means the student ID already exists
            if (cursor != null && cursor.moveToFirst()) {
                exists = true;
            }
        } finally {
            // Close the cursor and database connection
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return exists;
    }


    public void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_Age, student.getAge());
        values.put(COLUMN_Clas, student.getClas());
        values.put(COLUMN_Sabaq, student.getSabaq());
        values.put(COLUMN_Sabaqi, student.getSabqi());
        values.put(COLUMN_Manzil, student.getManzil());

        db.update(TABLE_NAME, values, COLUMN_NAME + " = ?", new String[] {student.getName()});
        db.close();
    }

    public void deleteStudent(String Name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_NAME + " = ?", new String[] {Name});
        db.close();
    }


    public List<Student> searchStudentByID(String id) {
        List<Student> students = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "=?";
        String[] selectionArgs = {id}; // Provide the value for the search criteria

        Cursor cursor = db.rawQuery(sql, selectionArgs);

        if (cursor != null && cursor.moveToFirst()) {
            int columnIndexId = cursor.getColumnIndex(COLUMN_ID);
            int columnIndexName = cursor.getColumnIndex(COLUMN_NAME);
            int columnIndexAge = cursor.getColumnIndex(COLUMN_Age);
            int columnIndexClas = cursor.getColumnIndex(COLUMN_Clas);
            int columnIndexSabaq = cursor.getColumnIndex(COLUMN_Sabaq);
            int columnIndexSabqi = cursor.getColumnIndex(COLUMN_Sabaqi);
            int columnIndexManzil = cursor.getColumnIndex(COLUMN_Manzil);

            do {
                int studentId = cursor.getInt(columnIndexId);
                String name = columnIndexName != -1 ? cursor.getString(columnIndexName) : "";
                String age = columnIndexAge != -1 ? cursor.getString(columnIndexAge) : "";
                String clas = columnIndexClas != -1 ? cursor.getString(columnIndexClas) : "";
                String sabaq = columnIndexSabaq != -1 ? cursor.getString(columnIndexSabaq) : "";
                String sabqi = columnIndexSabqi != -1 ? cursor.getString(columnIndexSabqi) : "";
                String manzil = columnIndexManzil != -1 ? cursor.getString(columnIndexManzil) : "";

                students.add(new Student(id,name, age, clas, sabaq, sabqi, manzil));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }




    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());

        }
        * */

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") String age = cursor.getString(cursor.getColumnIndex(COLUMN_Age));
                @SuppressLint("Range") String clas = cursor.getString(cursor.getColumnIndex(COLUMN_Clas));
                @SuppressLint("Range") String sabaq = cursor.getString(cursor.getColumnIndex(COLUMN_Sabaq));
                @SuppressLint("Range") String sabqi = cursor.getString(cursor.getColumnIndex(COLUMN_Sabaqi));
                @SuppressLint("Range") String manzil = cursor.getString(cursor.getColumnIndex(COLUMN_Manzil));

                students.add(new Student(String.valueOf(id),name, age, clas,sabaq,sabqi,manzil));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }
}
