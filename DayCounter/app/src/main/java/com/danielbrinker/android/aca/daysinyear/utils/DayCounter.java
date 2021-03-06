package com.danielbrinker.android.aca.daysinyear.utils;

/**
 * Created by danielbrinker on 9/1/16.
 */

// this is a simple constructor for the DayCounter class.
public class DayCounter {


    public int countDays(int month, int year) {
        int count = 871; // This could be any number that you want. You just have to initialize the variable.
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    count = 29;
                } else {
                    count = 28;
                }

                if ((year % 100 == 0) && (year % 400 != 0)) {
                    count = 28;
                }
        }
        return count;
    }


}
