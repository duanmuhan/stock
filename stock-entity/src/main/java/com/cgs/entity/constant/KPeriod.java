package com.cgs.entity.constant;

/**
 * Created by Administrator on 2017/6/13.
 */
public enum KPeriod {

    MIN("min"),
    FIVEMIN("5min"),
    FIFTEN_MIN("fiftenmin"),
    HALF_HOUR("halfhour"),
    HOUR("hour"),
    DAY("day"),
    WEEK("week"),
    MONTH("month");
    private String value;

    KPeriod(String value){
        this.value = value;
    }
}
