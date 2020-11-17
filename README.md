Original App Design Project - README Template
===

# SimplePlanner

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
A simple planner application for college students to stay organized

### App Evaluation
Evaluation of app across the following attributes:
- **Category: Organization**
- **Mobile: Android phones exclusively**
- **Story: Allows users to keep track of assignments, upcoming tests, and make a todo list**
- **Market: HighSchool and College Students**
- **Habit:This application is intended to be used everyday**
- **Scope: Make available on more platforms**

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* [ ] An assignment tab that displays upcoming assignments and their due dates.
* [x] A to do list tab that allows users to create and edit to do items.
* [x] Display current calendar day in the calendar tab.
* [ ] A tab that includes a Calendar that can be edited to display due dates in a weekly, monthly, and yearly view.



**Optional Nice-to-have Stories**

* [ ] A reminder alarm when due date are approaching.
* [ ] A progress bar to show how much of an assignment is complete. 
* [ ] Custom Theme for the app.
* [ ] A notes tab for jotting down and saving notes.

### 2. Screen Archetypes

* Calendar View
   * user can add event to calendar
   * user can view calendar by month
* Assignment View
   * user can add upcoming assignments to this screen
   * user can add associated course came and due date to each assignment
   * user can click on "NEW ASSIGNMENT" button to add assignment
   * user can remove an assignment after completion by clickin red x next to task
* To-Do List View
   * user can add other tasks to to-do list
   * possible task can include applying to internship, update resume, email a professor, etc
  

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Calendar
* Assignments
* To-Do List

**Flow Navigation** (Screen to Screen)

* No need to log in  or create an account
* upon launch, open calendar screen
* from there, user can decide which screen to navigate to using the bottom navigation bar


## Digital Wireframes
<img src="Screen Shot 2020-10-26 at 4.23.21 PM.png" width=400>
<img src="Screen Shot 2020-10-25 at 11.14.23 PM.png" width=400>
<img src="Screen Shot 2020-10-25 at 11.18.14 PM.png" width=400>


## Schema 

### Models
 | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the assignment post (default field) |
   | caption       | String   | assignment name & to do list task |
   | caption       | String   | class name |
   
### Networking
  - Home Feed Screen
      - (Read/GET) Query all posts where user is author
         ```Java
         // Run query
          Cursor cur = null;
          ContentResolver cr = getContentResolver();
          Uri uri = Calendars.CONTENT_URI;
          String selection = "((" + Calendars.ACCOUNT_NAME + " = ?) AND ("
                                  + Calendars.ACCOUNT_TYPE + " = ?) AND ("
                                  + Calendars.OWNER_ACCOUNT + " = ?))";
          String[] selectionArgs = new String[] {"hera@example.com", "com.example",
                  "hera@example.com"};
          // Submit the query and get a Cursor object back.
          cur = cr.query(uri, EVENT_PROJECTION, selection, selectionArgs, null);
         ```

#### [OPTIONAL:] Existing API Endpoints
- Google Calendar and Google Reminders APIs: https://developer.android.com/guide/topics/providers/calendar-provider
## Helpful Links
- [Our Figma](https://www.figma.com/file/veWER1TfYVvqIGnqhXDo3P/SimplePlanner-App?node-id=5%3A2)
- [Our Git Repository](https://github.com/khalilSS/SimplePlanner.git)
