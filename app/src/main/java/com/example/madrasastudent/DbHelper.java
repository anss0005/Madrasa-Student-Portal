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




    public List<Student> searchStudent(String searchQuery) {
        List<Student> resultList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        // Define the columns to retrieve from the database
        String[] projection = {
                COLUMN_ID,
                COLUMN_NAME,
                COLUMN_AGE,
                COLUMN_CLASS,
                COLUMN_SABAQ,
                COLUMN_SABQI,
                COLUMN_MANZIL,
                COLUMN_DATE
        };

        // Define the selection criteria
        String selection = COLUMN_NAME + " LIKE ? OR " +
                COLUMN_CLASS + " LIKE ?";

        // Define the selection arguments
        String[] selectionArgs = { "%" + searchQuery + "%", "%" + searchQuery + "%" };

        // Execute the query
        Cursor cursor = db.query(
                TABLE_STUDENT,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        // Retrieve the column indexes
        int idColumnIndex = cursor.getColumnIndex(COLUMN_ID);
        int nameColumnIndex = cursor.getColumnIndex(COLUMN_NAME);
        int ageColumnIndex = cursor.getColumnIndex(COLUMN_AGE);
        int classColumnIndex = cursor.getColumnIndex(COLUMN_CLASS);
        int sabaqColumnIndex = cursor.getColumnIndex(COLUMN_SABAQ);
        int sabqiColumnIndex = cursor.getColumnIndex(COLUMN_SABQI);
        int manzilColumnIndex = cursor.getColumnIndex(COLUMN_MANZIL);
        int dateColumnIndex = cursor.getColumnIndex(COLUMN_DATE);

        // Iterate over the cursor and create Student objects
        while (cursor.moveToNext()) {
            int id = cursor.getInt(idColumnIndex);
            String name = cursor.getString(nameColumnIndex);
            int age = cursor.getInt(ageColumnIndex);
            String className = cursor.getString(classColumnIndex);
            String sabaq = cursor.getString(sabaqColumnIndex);
            String sabqi = cursor.getString(sabqiColumnIndex);
            String manzil = cursor.getString(manzilColumnIndex);
            String date = cursor.getString(dateColumnIndex);

            Student student = new Student(id, name, age, className, sabaq, sabqi, manzil, date);
            resultList.add(student);
        }

        // Close the cursor and database
        cursor.close();
        db.close();

        return resultList;
    }





    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query(TABLE_STUDENT, null, null, null, null, null, null);

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    int idIndex = cursor.getColumnIndex(COLUMN_ID);
                    int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
                    int ageIndex = cursor.getColumnIndex(COLUMN_AGE);
                    int classIndex = cursor.getColumnIndex(COLUMN_CLASS);
                    int sabaqIndex = cursor.getColumnIndex(COLUMN_SABAQ);
                    int sabqiIndex = cursor.getColumnIndex(COLUMN_SABQI);
                    int manzilIndex = cursor.getColumnIndex(COLUMN_MANZIL);
                    int dateIndex = cursor.getColumnIndex(COLUMN_DATE);

                    if (idIndex >= 0 && nameIndex >= 0 && ageIndex >= 0 && classIndex >= 0 &&
                            sabaqIndex >= 0 && sabqiIndex >= 0 && manzilIndex >= 0 && dateIndex >= 0) {
                        String id = cursor.getString(idIndex);
                        String name = cursor.getString(nameIndex);
                        String age = cursor.getString(ageIndex);
                        String className = cursor.getString(classIndex);
                        String sabaq = cursor.getString(sabaqIndex);
                        String sabqi = cursor.getString(sabqiIndex);
                        String manzil = cursor.getString(manzilIndex);
                        String date = cursor.getString(dateIndex);

                        Student student = new Student(Integer.parseInt(id), name, Integer.parseInt(age), className, sabaq, sabqi, manzil, date);
                        studentList.add(student);
                    }
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }

        return studentList;
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




