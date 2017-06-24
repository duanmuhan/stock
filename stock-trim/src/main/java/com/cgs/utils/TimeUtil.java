package com.cgs.utils;

import com.cgs.entity.constant.Constant;
import com.cgs.entity.constant.KPeriod;
import com.cgs.entity.constant.TrendPeriod;

public class TimeUtil {

    private static boolean isSameMinute(long startTime,long currentTime){
        long timePeriod = currentTime - startTime;
        if (timePeriod< Constant.MIN_PERIOD){
            return true;
        }
        return false;
    }

    private static boolean isSameFiveMinute(long startTime,long currentTime){
        long timePeriod = currentTime - startTime;
        if (timePeriod<Constant.FIVE_MIN_PERIOD){
            return true;
        }
        return false;
    }

    private static boolean isFifteenMinute(long startTime,long currentTime){
        long timePeriod = currentTime - startTime;
        if (timePeriod<Constant.FIFTEEN_MIN_PERIOD){
            return true;
        }
        return false;
    }

    private static boolean isHalfHour(long startTime,long currentTime){
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

    public static boolean isSamePeriod(long startTime, long currentTime, KPeriod period){
        if (period.equals(KPeriod.MIN)){
            return isSameMinute(startTime,currentTime);
        }
        if (period.equals(KPeriod.FIVE_MIN)){
            return isSameFiveMinute(startTime,currentTime);
        }
        if (period.equals(KPeriod.FIFTEEN_MIN)){
            return isFifteenMinute(startTime,currentTime);
        }
        if (period.equals(KPeriod.HALF_HOUR)){
            return isHalfHour(startTime,currentTime);
        }
        if (period.equals(KPeriod.HOUR)){
            return isHour(startTime,currentTime);
        }
        return false;
    }

    public static boolean isSameTrendPeriod(long startTime, long currentTime, TrendPeriod trendPeriod){
        if (trendPeriod.equals(TrendPeriod.MIN)){
            return isSameMinute(startTime,currentTime);
        }
        if (trendPeriod.equals(TrendPeriod.FIVE_MIN)){
            return isSameFiveMinute(startTime,currentTime);
        }
        return false;
    }

}
