package com.example.madrasastudent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyVH> {

    List<Student> studentsList;

    public StudentAdapter(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public StudentAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.MyVH holder, int position) {
        Student student = studentsList.get(position);
        holder.studentID.setText(student.getStudentID());
        holder.name.setText(student.getName());
        holder.age.setText(student.getAge());
        holder.clas.setText(student.getClas());
        holder.sabaq.setText(student.getSabaq());
        holder.sabqi.setText(student.getSabqi());
        holder.manzil.setText(student.getManzil());
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView studentID;
        TextView name;
        TextView age;
        TextView clas;
        TextView sabaq;
        TextView sabqi;
        TextView manzil;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            studentID = itemView.findViewById(R.id.student_id);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            clas = itemView.findViewById(R.id.clas);
            sabaq = itemView.findViewById(R.id.sabaq);
            sabqi = itemView.findViewById(R.id.sabqi);
            manzil = itemView.findViewById(R.id.manzil);
        }
    }
}
