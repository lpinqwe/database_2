package org.example;
import java.time.Instant;
public class Time1 {
    private long clock = Instant.now().toEpochMilli();

    public long time(){
        return clock;
    }
}
