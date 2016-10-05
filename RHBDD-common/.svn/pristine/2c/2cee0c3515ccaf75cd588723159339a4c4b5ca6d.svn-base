package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.ibg.FieldUtils;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    /**
     * Set the date to 2076 January 1.
     */
    public SimpleDate() {
        this.year = 76;
        this.month = 1;
        this.day = 1;
    }
    
    /**
     * Take note that the year field must be two digits.
     */
    public SimpleDate(int year, int month, int day) {

        if (year < 0 || year > 99) {
            throw new IllegalArgumentException("The year value must be a two digit year");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("The month value is invalid");
        }

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("The day value is invalid");
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


    @Override
    public String toString() {
        return FieldUtils.leftPad(Integer.toString(getYear()), '0', 2)
               + FieldUtils.leftPad(Integer.toString(getMonth()), '0', 2)
               + FieldUtils.leftPad(Integer.toString(getDay()), '0', 2); 
    }
}
