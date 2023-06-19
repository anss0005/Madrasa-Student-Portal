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
    private static final String DATABASE_NAME = "StudentDatabase";
    private static final int DATABASE_VERSION = 1;

   public static final String TABLE_STUDENT = "student";
    public static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_CLASS = "class";
    private static final String COLUMN_SABAQ = "sabaq";
    private static final String COLUMN_SABQI = "sabqi";
    private static final String COLUMN_MANZIL = "manzil";
    private static final String COLUMN_DATE = "date";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_STUDENT + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_AGE + " INTEGER, " +
                COLUMN_CLASS + " TEXT, " +
                COLUMN_SABAQ + " TEXT, " +
                COLUMN_SABQI + " TEXT, " +
                COLUMN_MANZIL + " TEXT, " +
                COLUMN_DATE + " TEXT)";

        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }


    public long insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = student.toContentValues();
        long result = db.insert(TABLE_STUDENT, null, values);
        db.close();
        return result;
    }

}






    /*public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);



        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range")  String age = cursor.getString(cursor.getColumnIndex(COLUMN_AGE));
                @SuppressLint("Range") String clas = String.valueOf(cursor.getInt(cursor.getColumnIndex(COLUMN_CLASS)));
                students.add(new Student(id, name,Integer.parseInt(age),clas));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }*/




