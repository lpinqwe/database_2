package org.example;

import java.sql.*;

public class Postgre {
    private final String url = "jdbc:postgresql://192.168.99.106:5432/postgres";
    //private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "password";

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

    public String properCase(String s) {
        String result = s;
        try (Connection conn = this.connect();
             CallableStatement properCase = conn.prepareCall("{ ? = call initcap( ? ) }")) {
            properCase.registerOutParameter(1, Types.VARCHAR);
            properCase.setString(2, s);
            properCase.execute();
            result += properCase.getString(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void getFilms() {

        String SQL = "SELECT * FROM public.newdata";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                String a1 = rs.getString("mac");
                String b1 = rs.getString("data1");
                String c1 = rs.getString("data2");
                String d1 = rs.getString("data3");
                String e1 = rs.getString("date");
                System.out.println(a1+b1+c1+d1+e1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


}