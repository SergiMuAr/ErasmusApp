package com.example.sergi.erasmusapp;

/**
 * Created by Sergi on 07/02/2018.
 */

class AppDataBase {
    private static final AppDataBase ourInstance = new AppDataBase();

    static AppDataBase getInstance() {
        return ourInstance;
    }

    private AppDataBase() {
    }
}
