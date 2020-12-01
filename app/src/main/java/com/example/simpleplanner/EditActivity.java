package com.example.simpleplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.simpleplanner.MainActivity;
import com.example.simpleplanner.fragments.todo;

import static android.app.Activity.RESULT_OK;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit Item");

        etItem.setText(getIntent().getStringExtra(todo.KEY_ITEM_TEXT));
        //When the user is done editing, they click on the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an intent which will contain the results
                Intent intent = new Intent();
                //pass the data results of editing
                intent.putExtra(todo.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(todo.KEY_ITEM_POSITION, getIntent().getExtras().getInt(todo.KEY_ITEM_POSITION));
                //set the result of the intent
                setResult(RESULT_OK, intent);
                //finish the activity, close the screen and go back
                finish();

            }
        });
    }
}