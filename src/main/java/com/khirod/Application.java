package com.khirod;

import java.sql.SQLException;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Micronaut.run(Application.class, args);
        String DBname= "khiroddb8" ;
        CheakAndCreate.createDB(DBname);
       
    }
}
