package com.gloria.case10;

public class Stats {
    Data p2;

    public Data getData() {
        return p2;
    }

    public void setData(Data p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "stats{" +
                p2 + '\'' +
                '}';
    }
}
