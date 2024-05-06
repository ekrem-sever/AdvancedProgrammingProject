package com.example.advancedprogrammingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button LangButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        configureLogOutButton();
        configureActivityButtons();

        // Language Button and its Popup Menu being configured
        LangButton = (Button) findViewById(R.id.langButton);

        PopupMenu langMenu = new PopupMenu(this, LangButton);
        langMenu.getMenuInflater().inflate(R.menu.langmenu, langMenu.getMenu());

        langMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.TR_item){
                    Toast.makeText(MainActivity.this, "TR Clicked..", Toast.LENGTH_SHORT).show();
                    // TR language selected
                }
                else if(id == R.id.ENG_item){
                    Toast.makeText(MainActivity.this, "ENG Clicked..", Toast.LENGTH_SHORT).show();
                    // ENG language selected
                }
                return false;
            }
        });

        configureLangButton(LangButton, langMenu);
    }

    public void configureLogOutButton(){

        Button backbutton = (Button) findViewById(R.id.logOutButton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // might need to add extra functionality here to succesfully log out of the user!!!!!!!!!!!!!!!!!!!!!!
                finish();
            }
        });
    }
    public void configureLangButton(Button langButton, PopupMenu langMenu){
        langButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                langMenu.show();
            }
        });
    }

    public void configureActivityButtons(){
        Button activityButton1 = (Button) findViewById(R.id.activity1);
        activityButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
        Button activityButton2 = (Button) findViewById(R.id.activity2);
        activityButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
        Button activityButton3 = (Button) findViewById(R.id.activity3);
        activityButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
        Button activityButton4 = (Button) findViewById(R.id.activity4);
        activityButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
        Button activityButton5 = (Button) findViewById(R.id.activity5);
        activityButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
        Button activityButton6 = (Button) findViewById(R.id.activity6);
        activityButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
        Button activityButton7 = (Button) findViewById(R.id.activity7);
        activityButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
        Button activityButton8 = (Button) findViewById(R.id.activity8);
        activityButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
        Button activityButton9 = (Button) findViewById(R.id.activity9);
        activityButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
        Button activityButton10 = (Button) findViewById(R.id.activity10);
        activityButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
        Button activityButton11 = (Button) findViewById(R.id.activity11);
        activityButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleActivity.class));
            }
        });
    }

}