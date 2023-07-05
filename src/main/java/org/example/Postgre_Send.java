package org.example;

import java.sql.*;

public class Postgre_Send {

    long id = 0;

   // private final String url = "jdbc:postgresql://localhost/postgres";
   private final String url = "jdbc:postgresql://192.168.99.106:5432/postgres";

    private final String user = "postgres";
    private final String password = "password";
    private String SQLstring = "insert into newdata\n" +
            "(mac, data1, data2, data3,\"date\")\n" +
            "values\n" +
            "('volodar','data1','data2','data3',now())\n" +
            ";";
    private String SQLdata = "";
    public Connection connect() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return conn;
    }

    public String sendSQL(String[] data) {
        String newString = "";
        for (int i = 0; i < data.length; i++) {
            newString += data[i];
        }
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQLstring)) {
            ResultSet rs = pstmt.executeQuery();//todo изменить на нормальный запрос(убрать ошибку)
            System.out.println("sended: " + newString);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return newString;
    }


}


