

package com.example.madrasastudent;

public class Student {
    private String id;
    private String name;
    private int age;
    private String studentClass;
    private String dob;
    private String manzil;
    private String sabaq;
    private String sabqi;

    public Student(String id, String name, int age, String studentClass, String dob, String manzil, String sabaq, String sabqi) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.studentClass = studentClass;
        this.dob = dob;
        this.manzil = manzil;
        this.sabaq = sabaq;
        this.sabqi = sabqi;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getDob() {
        return dob;
    }

    public String getManzil() {
        return manzil;
    }

    public String getSabaq() {
        return sabaq;
    }

    public String getSabqi() {
        return sabqi;
    }
}
