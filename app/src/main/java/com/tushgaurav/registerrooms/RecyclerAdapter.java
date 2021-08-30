package com.tushgaurav.registerrooms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<Student> student;
    Context context;

    public RecyclerAdapter(Context ct,DataBaseHelper db) {
        student = db.getRegisteredStudents();
        context = ct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup viewStudents;
        View view = inflater.inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(student.get(position).getName());
        holder.txtPhone.setText(student.get(position).getPhone());
        holder.txtEmail.setText(student.get(position).getEmail());
        holder.txtBlock.setText('A');
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtEmail, txtBlock, txtPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            txtBlock = itemView.findViewById(R.id.txtBlock);
        }
    }
}
