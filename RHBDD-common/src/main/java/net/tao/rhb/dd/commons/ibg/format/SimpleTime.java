package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.ibg.FieldUtils;

public class SimpleTime {

    private int hours;
    private int minutes;

    /**
     * @param hours   valid hour value.
     * @param minutes valid minutes value.
     */
    public SimpleTime(int hours, int minutes) {

        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("The hours value is invalid: " + hours);
        }

        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("The minutes value is invalid: " + minutes);
        }

        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }


    @Override
    public String toString() {
        return FieldUtils.leftPad(Integer.toString(getHours()), '0', 2)
               + FieldUtils.leftPad(Integer.toString(getMinutes()), '0', 2);
    }
}
