package com.example.simpleplanner;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


public class AssignmentActivity extends AppCompatActivity {

    EditText etAssignmentName;
    EditText etClassName;
    EditText etDueDate;
    SeekBar seekBar;

    TextView header;
    Button btnNewAssign;
    RecyclerView rvAssignments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_assignment);

        etAssignmentName = findViewById(R.id.etAssignmentName);
        etClassName = findViewById(R.id.etClassName);
        etDueDate = findViewById(R.id.etDueDate);
        seekBar = findViewById(R.id.seekBar);

        header = findViewById(R.id.header);
        btnNewAssign = findViewById(R.id.btnNewAssign);
        rvAssignments = findViewById(R.id.rvAssignments);

        btnNewAssign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}


