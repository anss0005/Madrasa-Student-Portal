package com.example.madrasastudent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> studentList;

    public StudentAdapter() {
        this.studentList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.textViewId.setText("ID: " + student.getId());
        holder.textViewName.setText("Name: " + student.getName());
        holder.textViewAge.setText("Age: " + student.getAge());
        holder.textViewClass.setText("Class: " + student.getClass());
        holder.textViewDOB.setText("DOB: " + student.getDob());
        holder.textViewManzil.setText("Manzil: " + student.getManzil());
        holder.textViewSabaq.setText("Sabaq: " + student.getSabaq());
        holder.textViewSabqi.setText("Sabqi: " + student.getSabqi());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void clearStudents() {
        studentList.clear();
        notifyDataSetChanged();
    }

    public void setStudents(List<Student> students) {
        studentList.clear();
        studentList.addAll(students);
        notifyDataSetChanged();
    }

    public void addStudent(List<Student> students) {
        studentList.addAll(students);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewId;
        public TextView textViewName;
        public TextView textViewAge;
        public TextView textViewClass;
        public TextView textViewDOB;
        public TextView textViewManzil;
        public TextView textViewSabaq;
        public TextView textViewSabqi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewClass = itemView.findViewById(R.id.textViewClass);
            textViewDOB = itemView.findViewById(R.id.textViewDOB);
            textViewManzil = itemView.findViewById(R.id.textViewManzil);
            textViewSabaq = itemView.findViewById(R.id.textViewSabaq);
            textViewSabqi = itemView.findViewById(R.id.textViewSabqi);
        }
    }
}
