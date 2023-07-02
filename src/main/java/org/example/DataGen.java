package org.example;

public class DataGen {
    Time1 clock = new Time1();
    String data;

    public String dataGet() {
        String[] dataArr = {"mobileName", "data1", "data2", "data3", Long.toString(clock.time())};
        data = "@";
        for (int i = 0; i < dataArr.length; i++) {
            data += dataArr[i]+"@";
        }
        return data;
    }
}

