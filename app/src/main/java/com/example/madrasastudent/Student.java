package com.example.madrasastudent;

public class Student {
    private String studentID;
    private String name;
    private String age;
    private String clas;
    private String sabaq;
    private String sabqi;
    private String manzil;

    public Student(String studentID, String name, String age, String clas, String sabaq, String sabqi, String manzil) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.clas = clas;
        this.sabaq = sabaq;
        this.sabqi = sabqi;
        this.manzil = manzil;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

    @Override
    public String toString() {
        return "Student [studentID=" + studentID + ", name=" + name + ", age=" + age + ", Class=" + clas + ", sabaq=" + sabaq + ", sabqi=" + sabqi + ", manzil=" + manzil + "]";
    }
}
