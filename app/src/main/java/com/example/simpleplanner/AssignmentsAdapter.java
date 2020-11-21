package com.example.simpleplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AssignmentsAdapter extends RecyclerView.Adapter<AssignmentsAdapter.ViewHolder>{


    public interface OnLongClickListener {
        void onItemLongClicked(int position);
    }

    // Pass in context
    Context context;
    List<Assignment> assignment;
    OnLongClickListener longClickListener;

    public AssignmentsAdapter(AssignmentActivity assignmentActivity, List<String> assignments) {
        this.context = context;
        this.assignment = assignment;
        this.longClickListener = longClickListener;
    }



    // For each row, inflate layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_assignment, parent, false);
        return new ViewHolder(view);
    }

    // Bind values based on position of element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data at position
        Assignment assignment = assignment.get(position);
        // Bind the assignment with view holder
        holder.bind(assignment);
    }

    @Override
    public int getItemCount() {
        return assignment.size();
    }

    // Define a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvAssignmentName;
        TextView tvClassName;
        TextView tvDate;
        SeekBar seekBar;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAssignmentName = itemView.findViewById(R.id.tvAssignmentName);
            tvClassName = itemView.findViewById(R.id.tvClassName);
            tvDate = itemView.findViewById(R.id.tvDate);
            seekBar = itemView.findViewById(R.id.seekBar);
        }

        public void bind(Assignment assignment) {
            tvAssignmentName.setText(assignment.name);
            tvClassName.setText(assignment.courseName);
            tvDate.setText(assignment.date);


        }
    }
}
