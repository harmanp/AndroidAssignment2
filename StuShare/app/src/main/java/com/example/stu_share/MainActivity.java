package com.example.stu_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private Button btnCreateAcc, btnLogin,btnFgtPswd;
    private EditText txtEm,txtPswd;
    private TextView txtErr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCreateAcc = findViewById(R.id.btnReg);
        btnFgtPswd=findViewById(R.id.btnFgtPswd);
        txtEm=findViewById(R.id.txtRegEm);
        txtPswd=findViewById(R.id.txtPswd);
        final String  txtE = txtEm.getText().toString();
        final String txtP = txtPswd.getText().toString();
        txtErr=findViewById(R.id.txtVErr);
        btnFgtPswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(accCheck(txtE,txtP)!="good"){
                    txtErr.setText("accCheck(txtE,txtP");
                }else{
                    Intent intent =new Intent(getBaseContext(), Menu.class);
                    startActivity(intent);
                }

            }
        });
        btnCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupActivity();
            }
        });
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });
    }
    public void openSignupActivity(){
        Intent intent =new Intent(this, Signup.class);
        startActivity(intent);
    }
    public void openMainMenu(){
        Intent intent =new Intent(this, Menu.class);
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

