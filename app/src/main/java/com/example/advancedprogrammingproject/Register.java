package com.example.advancedprogrammingproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {
    private EditText userReg, passwordReg;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sp = getSharedPreferences("users", Context.MODE_PRIVATE);
        ConfigureBackButton();
        SetVariable();
        ConfigureRegisterButton();
    }
    public void ConfigureRegisterButton(){
        Button RegButton = (Button) findViewById(R.id.register_button);
        SharedPreferences.Editor editor = sp.edit();
        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // find the first nontaken username
                String newKey;
                boolean found = false;
                int iteration = 0;
                String username_reg_input = userReg.getText().toString();
                while (!found){
                    if(username_reg_input.equals(sp.getString(("username"+iteration),""))){
                        Toast.makeText(Register.this, "This user already exists.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if(sp.getString(("username"+iteration),"").equals("")){
                        // nontaken username found
                        found = true;
                        newKey = "username"+iteration;
                    }
                    else{
                        iteration += 1;
                    }
                }
                // if no same username, look for password length bigger than 3, less than 10
                if(passwordReg.getText().toString().length()<3 || passwordReg.getText().toString().length()>10){
                    Toast.makeText(Register.this, "Password length cant be more than 10, less than 3.", Toast.LENGTH_SHORT).show();
                }
                // if all checks out, register and save data.
                else if(found){
                    editor.putString("username"+iteration,username_reg_input);
                    editor.putString("password"+iteration,passwordReg.getText().toString());
                    editor.commit();
                    Toast.makeText(Register.this, "Welcome", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Register.this, Log_In.class));
                }
            }
        });
    }
    public void SetVariable(){
        userReg = findViewById(R.id.reg_username);
        passwordReg = findViewById(R.id.reg_password);
    }
    public void ConfigureBackButton(){
        Button backToLogButton = (Button) findViewById(R.id.register_toLogin);
        backToLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

