package com.example.brookesnutrition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Parcelable;
import android.provider.Settings;
import android.view.KeyEvent;


import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brookesnutrition.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    boolean validname;
    boolean validage;

    User user = new User();

    ImageView error_mark;
    ImageView error_mark2;
    EditText username;
    EditText email;
    EditText password;
    TextView name_error;
    TextView age_error;
    EditText userage;
    FirebaseAuth fbaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // find the id of the relevant fields in the xml file
        username = findViewById(R.id.text_name);
        email = findViewById(R.id.text_email);
        password = findViewById(R.id.text_password);
        name_error = findViewById(R.id.name_error);
        error_mark = findViewById(R.id.redemark);
        fbaseAuth = FirebaseAuth.getInstance();

        username.setOnKeyListener(new EditText.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        validname = isValidname(username.getText().toString());
                    }
                return false;
            }
        });
        userage = findViewById(R.id.text_age);
        //if user enters enter key
        userage.setOnKeyListener(new EditText.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        String age = userage.getText().toString();
                        if (!isNum(age)){
                            return false;
                        }
                        else{
                            final int r_age = Integer.parseInt(age);
                            validage = isValidAge(r_age);
                            if (!validage || !validname) {
                                Toast.makeText(MainActivity.this, "Please complete both fields correctly", Toast.LENGTH_LONG).show();
                                if (!validname) {
                                    if (userage.requestFocus()) {
                                        userage.clearFocus();
                                        username.requestFocus();
                                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                        imm.showSoftInput(username, InputMethodManager.SHOW_IMPLICIT);
                                    }
                                } else {
                                    userage.requestFocus();
                                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                    imm.showSoftInput(username, InputMethodManager.SHOW_IMPLICIT);
                                }
                            }
                            if (validage && validname) {
                                user.setAge(r_age);
                                String uEmail = email.getText().toString();
                                String uPass = password.getText().toString();
                                fbaseAuth.createUserWithEmailAndPassword(uEmail, uPass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!task.isSuccessful()){
                                            Toast.makeText(MainActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                //Toast.makeText(MainActivity.this, "Age saved", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                intent.putExtra("myUser", user);
                                startActivity(intent);
                            }

                        }
                    }
                return false;
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void activity2(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
    public boolean isValidname(String name) {
        name_error = findViewById(R.id.name_error);
        error_mark = findViewById(R.id.redemark);
        if (!isAlpha(name) && name.length() > 1) {
            Toast.makeText(MainActivity.this, "Special characters not allowed", Toast.LENGTH_LONG).show();
            return false;
        }else if(name.length() < 2){
            name_error.setVisibility(View.VISIBLE);
            error_mark.setVisibility(View.VISIBLE);
            return false;
        }
        else {
            Toast.makeText(MainActivity.this,"Name saved", Toast.LENGTH_LONG).show();
            user.setName(name);
            name_error.setVisibility(View.INVISIBLE);
            error_mark.setVisibility(View.INVISIBLE);
            return true;
        }
    }
    public boolean isValidAge(int age){
        age_error = findViewById(R.id.name_error);
        error_mark2 = findViewById(R.id.redemark2);
        if (age > 99 || age < 13){
            age_error.setVisibility(View.VISIBLE);
            error_mark2.setVisibility(View.VISIBLE);
            return false;
        }
        else{
            age_error.setVisibility(View.INVISIBLE);
            error_mark2.setVisibility(View.INVISIBLE);
            return true;
        }
    }
    public boolean isNum(String age){
        if (!age.matches("[0-9]+")) {
            Toast.makeText(MainActivity.this, "Enter a number", Toast.LENGTH_LONG).show();
            return false;
        }else if(age.matches("[0-9]+") && age.length() < 2){
            Toast.makeText(MainActivity.this, "Enter a number between 13 and 99", Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            return true;
        }

        }
<<<<<<< HEAD

=======
    public boolean setPlan = false;
>>>>>>> Initial commit
}
