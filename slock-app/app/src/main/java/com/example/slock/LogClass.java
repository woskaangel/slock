package com.example.slock;

public class LogClass {
    String time;
    String state;

    public LogClass() {}
    public LogClass(String time, String state) {
        this.time = time;
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public String getState() {
        return state;
    }
}