package com.sample_spring.core;

import javax.xml.crypto.Data;

public class Database {

    private static Database database;

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    private Database() {

    }
}
