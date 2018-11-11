package com.fortune.pojo;

import javafx.scene.chart.PieChart;

/**
 * Created by admin on 2017/8/16.
 */
public class DataBaseError {

    int errorCode = 0;
    Throwable cause;

    public DataBaseError(int code, Throwable cause) {
        this.cause = cause;
        this.errorCode = code;
    }

    @Override
    public String toString() {
        return "DataBaseError{" +
                "errorCode=" + errorCode +
                ", cause='" + cause + '\'' +
                '}';
    }
}
