package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");
        // DataGen data1 =new DataGen();
        // System.out.println(data1.dataGet());
       // Postgre app = new Postgre();
        //app.connect();
        //app.getFilms();
        String[] data={"personalComputer", "data1", "data2", "data3"};
       Postgre_Send newApp = new Postgre_Send();
       newApp.sendSQL(data);

    }
}