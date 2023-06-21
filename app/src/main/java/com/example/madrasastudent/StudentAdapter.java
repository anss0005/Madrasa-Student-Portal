package com.example.madrasastudent;




import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyVH> {

    List<Student> StudentsList;
    public StudentAdapter(List<Student> StudentsList) {
        this.StudentsList = StudentsList;
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
        holder.data=StudentsList.get(position);
        holder.Name.setText(holder.data.getName());
        holder.Age.setText(holder.data.getAge());
        holder.Clas.setText(holder.data.getClas());
        holder.Sabaq.setText(holder.data.getSabaq());
        holder.Sabqi.setText(holder.data.getSabqi());
        holder.Manzil.setText(holder.data.getManzil());


    }

    @Override
    public int getItemCount() {
        return StudentsList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {

        TextView Name;
        TextView Age;
        TextView Clas;
        TextView Sabaq;
        TextView Sabqi;
        TextView Manzil;

        Student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.name);
            Age=itemView.findViewById(R.id.age);
            Clas=itemView.findViewById(R.id.clas);
            Sabaq=itemView.findViewById(R.id.sabaq);
            Sabqi=itemView.findViewById(R.id.sabqi);
            Manzil=itemView.findViewById(R.id.manzil);
        }
    }
}
