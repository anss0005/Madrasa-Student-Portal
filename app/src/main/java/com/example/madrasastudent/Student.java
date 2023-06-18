package com.example.madrasastudent;

public class Student
{
    private String id;
    private String name;
    private String age;
    private String clas;

    public Student(String id, String name, String age, String clas) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clas = clas;
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


    public String toString() {
        return "com.example.madrasastudent.Student [  id=" + id + ", name=" + name + ",  age=" + age +  ", class=" + clas + "]";
    }
}
