package com.cgs.entity.constant;

/**
 * Created by Administrator on 2017/6/13.
 */
public enum KPeriod {

    MIN("min"),
    FIVE_MIN("5min"),
    FIFTEEN_MIN("fifteenMin"),
    HALF_HOUR("halfHour"),
    HOUR("hour"),
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    YEAR("year");

    private String value;

    KPeriod(String value){
        this.value = value;
    }

    public KPeriod parseFromInteger(int value){
        switch (value){
            case 0:
                return MIN;
            case 1:
                return FIVE_MIN;
            case 2:
                return FIFTEEN_MIN;
            case 3:
                return HALF_HOUR;
            case 4:
                return HOUR;
            case 5:
                return DAY;
            case 6:
                return WEEK;
            case 7:
                return MONTH;
            case 8:
                return YEAR;
            default:
                throw new IllegalArgumentException();
        }
    }
}
