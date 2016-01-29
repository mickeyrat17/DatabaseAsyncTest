package com.blank.databaseasynctest;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blank.databaseasynctest.database.constants.FeedContract;
import com.blank.databaseasynctest.database.helper.DatabaseUser;
import com.blank.databaseasynctest.database.model.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText eUsername, ePassword;
    private Button bLogin, bAdd;
    private SQLiteDatabase db;
    private DatabaseUser dbUser;
    private Context context;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    public void init() {
        eUsername = (EditText)findViewById(R.id.username);
        ePassword = (EditText)findViewById(R.id.password);
        bLogin = (Button)findViewById(R.id.loginButton);
        bAdd = (Button)findViewById(R.id.addButton);

        dbUser = new DatabaseUser(this);
        db = dbUser.getReadableDatabase();
        context = LoginActivity.this;

        bLogin.setOnClickListener(this);
        bAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        user = new User(eUsername.getText().toString(), ePassword.getText().toString());
        switch(v.getId()) {

            case R.id.loginButton:
                CheckUserRegistrationOperation userCheck =
                        new CheckUserRegistrationOperation(user);
                userCheck.execute();
                break;

            case R.id.addButton:
                AddUserOperation addCheck =
                        new AddUserOperation(user);
                addCheck.execute();
                break;
        }
    }

    //Checks whether the inputted username and password are valid
    private class CheckUserRegistrationOperation extends AsyncTask<Void, Void, String> {

        private User user;
        private DatabaseUser dbUser;
        private SQLiteDatabase db;


        CheckUserRegistrationOperation(User user) {
            this.user = user;

            dbUser = new DatabaseUser(context);
            db = dbUser.getReadableDatabase();

        }

        //Returns String which will be displayed on Toast notifying the user
        //which field was incorrect
        @Override
        protected String doInBackground(Void... aVoid) {
            Cursor cursor;
            String login;

            //Selects Username and Password columns and searches for a username matching
            //the inputted username
            String query = "SELECT " + FeedContract.FeedUser.COL_NAME_USERNAME + ", " +
                    FeedContract.FeedUser.COL_NAME_PASSWORD + " FROM " +
                    FeedContract.FeedUser.TABLE_NAME + " WHERE " +
                    FeedContract.FeedUser.COL_NAME_USERNAME + " = \"" + user.getUsername() + "\"";

            cursor = db.rawQuery(query, null);

            //Checks if Username is stored in database
            if(cursor.moveToFirst()) {

                //Checks if Password matches the username
                int passwordIndex = cursor.getColumnIndex(FeedContract.FeedUser.COL_NAME_PASSWORD);
                if(!cursor.getString(passwordIndex).equals(user.getPassword()))
                    login = "Incorrect Password";
                else
                    login = "Correct";
            }
            else {
                login = "Invalid Username";
            }

            return login;
        }

        //If new intent is not opened, Toast notifies user which field is incorrect
        @Override
        protected void onPostExecute(String result) {
            if(result.equals("Correct")) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), ImageUploadActivity.class);
                startActivity(mainActivityIntent);
            }
            else {
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }

        }
    }

    //Checks whether a user can be added to the database
    //checks if username is already used
    private class AddUserOperation extends AsyncTask<Void, Void, Boolean> {

//        private Context context;
        private User user;
        private DatabaseUser dbUser;
        private SQLiteDatabase db;


        AddUserOperation(User user) {
            this.user = user;

            dbUser = new DatabaseUser(getApplicationContext());
            db = dbUser.getReadableDatabase();
        }

        //Checks if username is already stored in the database
        @Override
        protected Boolean doInBackground(Void... aVoid) {
            Cursor cursor;
            boolean added = false;

            //Returns username and password
            String query = "SELECT " + FeedContract.FeedUser.COL_NAME_USERNAME +  " FROM " +
                    FeedContract.FeedUser.TABLE_NAME + " WHERE " +
                    FeedContract.FeedUser.COL_NAME_USERNAME + " = \"" + user.getUsername() + "\"";
            cursor = db.rawQuery(query, null);

            if(!cursor.moveToFirst() && dbUser.insertUser(user.getUsername(), user.getPassword())) {
                added = true;
            }
            return added;
        }

        //Toast notifies user if information is added or if username is taken
        @Override
        protected void onPostExecute(Boolean result) {
            if(result)
                Toast.makeText(getApplicationContext(), "User Added", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "Username taken", Toast.LENGTH_SHORT).show();
        }
    }
}
