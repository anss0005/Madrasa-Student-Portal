package com.example.madrasastudent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_search, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewAge;
        private TextView textViewClass;
        private TextView textViewSabaq;
        private TextView textViewSabqi;
        private TextView textViewManzil;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewClass = itemView.findViewById(R.id.textViewClass);
            textViewSabaq = itemView.findViewById(R.id.textViewSabaq);
            textViewSabqi = itemView.findViewById(R.id.textViewSabqi);
            textViewManzil = itemView.findViewById(R.id.textViewManzil);
        }

        public void bind(Student student) {
            textViewName.setText(student.getName());
            textViewAge.setText(String.valueOf(student.getAge()));
            textViewClass.setText(student.getClassName());
            textViewSabaq.setText(student.getSabaq());
            textViewSabqi.setText(student.getSabqi());
            textViewManzil.setText(student.getManzil());
        }
    }
}
