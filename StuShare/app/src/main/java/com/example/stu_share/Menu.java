package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
        private Button btnMyEvents, btnViewEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnMyEvents = findViewById(R.id.btnMyEvents);
        btnMyEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyEventsActivity();
            }
        });
        btnViewEvents = findViewById(R.id.btnViewEvents);
        btnViewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewEventsActivity();
            }
        });

    }
    public void openMyEventsActivity(){
        Intent intent =new Intent(this, MyEvents.class);
        startActivity(intent);
    }
    public void openViewEventsActivity(){
        Intent intent =new Intent(this, ViewEvents.class);
        startActivity(intent);
    }
}
