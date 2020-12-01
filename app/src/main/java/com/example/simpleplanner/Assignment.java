package com.example.simpleplanner;

public class Assignment {
    public String name;
    public String courseName;
    public String date;

    // This is wrong. They just did it in one of the recycler view tutorial videos, so I did it
    public static Assignment fromAssignmentActivity(){
        Assignment assignment = new Assignment();
        assignment.name = AssignmentActivity.getString();
        assignment.courseName = AssignmentActivity.getString();
        assignment.date = AssignmentActivity.getString();


        return assignment;
    }
}
