package com.example.advancedprogrammingproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Log_In extends AppCompatActivity {

    private EditText usrInput, passwordInput;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setVariables();
        configureMenuButton();
        configureQuitButton();
        configureRegisterClick();
        configureLoginButton();

    }
    public void setVariables(){
        usrInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.passwordinput);
        sp = getApplicationContext().getSharedPreferences("users", Context.MODE_PRIVATE);
    }
    public void configureLoginButton(){
        Button LogButton = (Button) findViewById(R.id.log_log);
        // load data here.
        LogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usrInput.getText().toString().isEmpty() || passwordInput.getText().toString().isEmpty()){
                    Toast.makeText(Log_In.this, "Please input login information", Toast.LENGTH_SHORT).show();
                }
                else if(usrInput.getText().toString().equals("admin") && passwordInput.getText().toString().equals("admin")){
                    Toast.makeText(Log_In.this, "Welcome admin", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Log_In.this, MainActivity.class));
                }
                else{
                    int iteration = 0;
                    boolean found = false;
                    while(!sp.getString(("username"+iteration),"").equals("")){
                        if(usrInput.getText().toString().equals(sp.getString(("username"+iteration),""))){
                            // username correct
                            if(passwordInput.getText().toString().equals(sp.getString(("password"+iteration),""))){
                                //password correct
                                found = true;
                                SharedPreferences.Editor editor = sp.edit();
                                editor.putString("logged_user", usrInput.getText().toString());
                                editor.commit();
                                startActivity(new Intent(Log_In.this, MainActivity.class));
                                break;
                                // log in
                            }
                            // password incorrect
                            else{
                                Toast.makeText(Log_In.this, "Incorrect password .", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }
                        else iteration += 1;
                        // username not found this iteration
                    }
                    // no suitable username found
                    if(!found){
                        Toast.makeText(Log_In.this, "No users with this name found, maybe you should register?", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void configureRegisterClick(){
        TextView register = (TextView) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Log_In.this, Register.class));
            }
        });
    }
    public void configureQuitButton(){
        Button backbutton = (Button) findViewById(R.id.quitButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void configureMenuButton(){
        Button backbutton = (Button) findViewById(R.id.menuButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Log_In.this, MainActivity.class));
            }
        });
    }
}