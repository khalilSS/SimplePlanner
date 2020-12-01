package com.example.simpleplanner;

import android.os.Bundle;

import android.os.FileUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class AssignmentActivity extends AppCompatActivity {


    TextView header;
    Button btnNewAssign;
    RecyclerView rvAssignments;
    EditText etDueDate;
    EditText etCourse;
    EditText etAssignment;
    AssignmentsAdapter adapter;
    List<String> assignments;
    SeekBar seekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_assignment);


        header = findViewById(R.id.header);
        btnNewAssign = findViewById(R.id.btnNewAssign);
        etDueDate = findViewById(R.id.etDueDate);
        etCourse = findViewById(R.id.etCourse);
        etAssignment = findViewById(R.id.etAssignment);
        seekbar = findViewById(R.id.seekbar);

        // Find the recycler view
        rvAssignments = findViewById(R.id.rvAssignments);
        // Initialize list of assignments in adapter
        assignments = new ArrayList<>();
        adapter = new AssignmentsAdapter(this, assignments);
        // Recycler View set up: layout manager and adapter
        rvAssignments.setLayoutManager(new LinearLayoutManager(this));
        rvAssignments.setAdapter(adapter);

        loadItems();

        AssignmentsAdapter.OnLongClickListener onLongClickListener = new AssignmentsAdapter.OnLongClickListener() {
            @Override
            public void onItemLongClicked(int position) {
                //Delete the item from the model
                assignments.remove(position);
                //Notify the adapter
                adapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), "Item was removed", Toast.LENGTH_SHORT).show();
                saveItems();
            }
        };


        btnNewAssign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = etAssignment.getText().toString();
                String course = etCourse.getText().toString();
                String day = etDueDate.getText().toString();

                assignments.add(task);
                assignments.add(course);
                assignments.add(day);

                adapter.notifyItemInserted(assignments.size()-1);
                etAssignment.setText("");
                etCourse.setText("");
                etDueDate.setText("");

                Toast.makeText(getApplicationContext(), "Assignment was added", Toast.LENGTH_SHORT).show();
                saveItems();
            }
        });
    }

    private File getDataFile() {
        return new File(getFilesDir(), "data.txt");
    }

    private void loadItems() {
        try {
            assignments = new ArrayList<>(FileUtils.readLines(getDataFile(), Charset.defaultCharset()));
        } catch (IOException e) {
            Log.e("AssignmentActivity", "Error reading items", e);
            assignments = new ArrayList<>();
        }
    }

    private void saveItems() {
        try {
            FileUtils.writeLines(getDataFile(), assignments);
        } catch (IOException e) {
            Log.e("AssignmentActivity", "Error writing items", e);
        }
    }

}


