package com.example.madrasastudent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "madrasa_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_CLASS = "class";
    private static final String COLUMN_DOB = "dob";
    private static final String COLUMN_MANZIL = "manzil";
    private static final String COLUMN_SABAQ = "sabaq";
    private static final String COLUMN_SABQI = "sabqi";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AGE + " INTEGER,"
                + COLUMN_CLASS + " TEXT,"
                + COLUMN_DOB + " TEXT,"
                + COLUMN_MANZIL + " TEXT,"
                + COLUMN_SABAQ + " TEXT,"
                + COLUMN_SABQI + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean checkStudentExists(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_ID + "=?", new String[]{id}, null, null, null);
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }

    public long insertDataIntoDatabase(String id, String name, String age, String studentClass, String dob,
                                       String manzil, String sabaq, String sabqi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AGE, age);
        values.put(COLUMN_CLASS, studentClass);
        values.put(COLUMN_DOB, dob);
        values.put(COLUMN_MANZIL, manzil);
        values.put(COLUMN_SABAQ, sabaq);
        values.put(COLUMN_SABQI, sabqi);
        long newRowId = db.insert(TABLE_NAME, null, values);
        db.close();
        return newRowId;
    }

    public Student searchStudentById(String searchId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_ID + "=?", new String[]{searchId}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(COLUMN_ID);
            int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
            int ageIndex = cursor.getColumnIndex(COLUMN_AGE);
            int classIndex = cursor.getColumnIndex(COLUMN_CLASS);
            int dobIndex = cursor.getColumnIndex(COLUMN_DOB);
            int manzilIndex = cursor.getColumnIndex(COLUMN_MANZIL);
            int sabaqIndex = cursor.getColumnIndex(COLUMN_SABAQ);
            int sabqiIndex = cursor.getColumnIndex(COLUMN_SABQI);

            String id = cursor.getString(idIndex);
            String name = cursor.getString(nameIndex);
            int age = cursor.getInt(ageIndex);
            String studentClass = cursor.getString(classIndex);
            String dob = cursor.getString(dobIndex);
            String manzil = cursor.getString(manzilIndex);
            String sabaq = cursor.getString(sabaqIndex);
            String sabqi = cursor.getString(sabqiIndex);

            cursor.close();
            return new Student(id, name, age, studentClass, dob, manzil, sabaq, sabqi);
        }

     else
         return null;

    }

    public List<Student> viewAllStudents() {
        List<Student> studentList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
                int ageIndex = cursor.getColumnIndex(COLUMN_AGE);
                int classIndex = cursor.getColumnIndex(COLUMN_CLASS);
                int dobIndex = cursor.getColumnIndex(COLUMN_DOB);
                int manzilIndex = cursor.getColumnIndex(COLUMN_MANZIL);
                int sabaqIndex = cursor.getColumnIndex(COLUMN_SABAQ);
                int sabqiIndex = cursor.getColumnIndex(COLUMN_SABQI);

                String id = cursor.getString(idIndex);
                String name = cursor.getString(nameIndex);
                int age = cursor.getInt(ageIndex);
                String studentClass = cursor.getString(classIndex);
                String dob = cursor.getString(dobIndex);
                String manzil = cursor.getString(manzilIndex);
                String sabaq = cursor.getString(sabaqIndex);
                String sabqi = cursor.getString(sabqiIndex);

                Student student = new Student(id, name, age, studentClass, dob, manzil, sabaq, sabqi);
                studentList.add(student);
            } while (cursor.moveToNext());
            cursor.close();
        }

        return studentList;
    }








}
