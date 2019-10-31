package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Signup extends AppCompatActivity {
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupActivity2();
            }
        });
    }

    public void openSignupActivity2(){
        Intent intent =new Intent(this, Signup2.class);
        startActivity(intent);
    }
    public  String accCheck(String em,String pswd){
        for (int i=0;i<AccountHandler.ACCOUNTS.size();i++){
            if(AccountHandler.ACCOUNTS.get(i).email==em){
                if(AccountHandler.ACCOUNTS.get(i).password==pswd){
                    return "good";
                }else{
                    return "You have wrong password!";
                }
            }
        }return "You account can't be found";
    }
    public void load(){
        try {
            AccountHandler.ACCOUNTS.clear();
            AccountHandler.ACC_MAP.clear();
            FileInputStream fileInputStream = openFileInput("account.txt");
            InputStreamReader inputStreamReader=new InputStreamReader((fileInputStream));
            BufferedReader bufferedReader=new BufferedReader((inputStreamReader));
            String tt="";
            while ((tt=bufferedReader.readLine())!=null){

                AccountHandler.addItemElement(AccountHandler.createElement( split(tt)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String[] split(String test){
        String[] acct=new String[]{};
        acct=test.split(",");
        return acct;
    }
}
