

package com.example.madrasastudent;


public class Student {
    private String name;
    private String age;
    private String clas;
    private String sabaq;
    private String sabqi;
    private String manzil;
    public Student(String name, String age, String clas, String sabaq, String sabqi, String manzil) {
        this.name = name;
        this.age = age;
        this.clas = clas;
        this.sabaq = sabaq;
        this.sabqi = sabqi;
        this.manzil = manzil;
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
        return "Student [name=" + name + ", age=" + age + ", Class=" + clas + ", sabaq=" + sabaq + ", sabaqi=" + sabqi + ", manzil=" + manzil +"]";
    }

}
