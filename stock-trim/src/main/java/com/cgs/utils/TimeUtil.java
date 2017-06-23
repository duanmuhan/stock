package com.cgs.utils;

import com.cgs.entity.constant.Constant;

public class TimeUtil {

    public static boolean isSameMinute(long startTime,long currentTime){
        long timePeriod = currentTime -startTime;
        if (timePeriod< Constant.MIN_PERIOD){
            return true;
        }
        return false;
    }

    public static boolean isSameFiveMinute(long startTime,long currentTime){
        long timePeriod = currentTime - startTime;
        if (timePeriod<Constant.FIVE_MIN_PERIOD){
            return true;
        }
        return false;
    }

    public static boolean isFifteenMinute(long startTime,long currentTime){
        long timePeriod = currentTime - startTime;
        if (timePeriod<Constant.FIFTEEN_MIN_PERIOD){
            return true;
        }
        return false;
    }

    public static boolean isHalfHour(long startTime,long currentTime){
        long timePeriod = currentTime - startTime;
        if (timePeriod < Constant.HALF_HOUR_PERIOD){
            return true;
        }
        return false;
    }

    private static boolean isHour(long startTime,long currentTime){
        long timePeriod = currentTime - startTime;
        if (timePeriod < Constant.HOUR_PERIOD){
            return true;
        }
        return false;
    }

}
