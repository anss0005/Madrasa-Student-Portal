package com.example.madrasastudent;

import android.content.ContentValues;

public class Student {
    private String id;
    private String name;
    private String age;
    private String clas;
    private String sabaq;
    private String sabqi;
    private String manzil;
    private String date;

    public Student(String id, String name, String age, String className, String sabaq, String sabqi, String manzil, String date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clas = className;
        this.sabaq = sabaq;
        this.sabqi = sabqi;
        this.manzil = manzil;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getSabaq() {
        return sabaq;
    }

    public void setSabaq(String sabaq) {
        this.sabaq = sabaq;
    }

    public String getSabqi() {
        return sabqi;
    }

    public void setSabqi(String sabqi) {
        this.sabqi = sabqi;
    }

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("age", age);
        values.put("class", clas);
        values.put("sabaq", sabaq);
        values.put("sabqi", sabqi);
        values.put("manzil", manzil);
        values.put("date", date);
        return values;
    }

}
