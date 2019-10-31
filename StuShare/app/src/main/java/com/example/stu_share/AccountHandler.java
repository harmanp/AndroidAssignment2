package com.example.stu_share;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class AccountHandler extends Application {

    public static final List<Account> ACCOUNTS = new ArrayList<Account>();
    private static Random random = new Random(System.currentTimeMillis());
    public static final Map<String, Account> ACC_MAP = new HashMap<String, Account>();

    public static void addItemElement(Account item) {
        ACCOUNTS.add(item);
        ACC_MAP.put(item.id, item);
    }

    public static Account createElement(String email,String pswd,String fn,String ln) {
        return new Account(String.valueOf(random.nextLong()), email,pswd,ln,fn);
    }
    public static Account createElement(String[] acct) {

        return new Account(String.valueOf(random.nextLong()), acct[1],acct[2],acct[3],acct[5]);
    }

    public static class Account implements Serializable {
        public final String id;
        public final String email;
        public final String password;
        public final String firstName;
        public final String lastName;

        public Account(String id, String email,String password,String fn,String ln) {
            this.id = id;
            this.email = email;
            this.password=password;
            this.firstName=fn;
            lastName=ln;
        }

        @Override
        public String toString() {
            return "Email: "+email+" Password: "+password+" Name: "+firstName+" ,"+lastName+"/n";
        }
    }
}

