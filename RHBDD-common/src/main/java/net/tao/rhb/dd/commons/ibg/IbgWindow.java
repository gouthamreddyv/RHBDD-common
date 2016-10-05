package net.tao.rhb.dd.commons.ibg;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.LocalTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public enum IbgWindow {

    WINDOW_ONE("0700", "A", "1"),

    WINDOW_TWO("1000", "B", "2"),

    WINDOW_THREE("1300", "C", "3"),

    WINDOW_FOUR("1600", "D", "4"),

    WINDOW_FIVE("1900", "E", "5");

    private final String cutoffTime;

    private final String dnFileId;

    private final String drFileId;

    IbgWindow(String cutoffTime, String dnFileId, String drFileId) {
        this.cutoffTime = cutoffTime;
        this.dnFileId = dnFileId;
        this.drFileId = drFileId;
    }

    /**
     * Cutoff time of the given window.
     *
     * @return cutoff time in 24-hour format
     */
    public String cutoffTime() {
        return cutoffTime;
    }

    public String drFileId() {
        return drFileId;
    }

    public String dnFileId() {
        return dnFileId;
    }

    protected List<Interval> interval() {
        List<Interval> intervals = new ArrayList<>();
        switch (cutoffTime) {
          case "0700":
              // 0000AM - 0700AM
              intervals.add(new TimeInterval(
                      new LocalTime(0, 0), new LocalTime(7, 0)).toInterval());
              // 1900PM - 0000AM
              intervals.add(new TimeInterval(
                      new LocalTime(19, 0), new LocalTime(23, 59, 59)).toInterval());
              break;
          case "1000":
              intervals.add(new TimeInterval(
                      new LocalTime(7, 0), new LocalTime(10, 0)).toInterval());
              break;
          case "1300":
              intervals.add(new TimeInterval(
                      new LocalTime(10, 0), new LocalTime(13, 0)).toInterval());
              break;
          case "1600":
              intervals.add(new TimeInterval(
                      new LocalTime(13, 0), new LocalTime(16, 0)).toInterval());
              break;
          case "1900":
              intervals.add(new TimeInterval(
                      new LocalTime(16, 0), new LocalTime(19, 0)).toInterval());
              break;
          default:
              throw new IllegalArgumentException(
                      "No interval for cutoff time: " + cutoffTime);
        }

        return intervals;
    }

    /**
     * @param time current time or specified time. Only time info will be used.
     * @return the IBG processing window with cutoff time
     */
    public static IbgWindow nextAvailableWindow(Date time) {
        if (time != null) {
            DateTime trimmedDate = new LocalTime(time.getTime()).toDateTime(new Instant(0));
            for (IbgWindow ibgWindow : IbgWindow.values()) {
                for (Interval interval : ibgWindow.interval()) {
                    if (interval.contains(trimmedDate)) {
                        return ibgWindow;
                    }
                }
            }
            throw new IllegalArgumentException("Couldn't find next available window for " + time);

        } else {
            throw new IllegalArgumentException("Null value is not accepted");
        }
    }

    /**
     * Lookup IbgWindow by using cutoff time.
     * @param cutoffTime the cutoff time to lookup
     * @return the IbgWindow
     */
    public static IbgWindow lookupByCutoffTime(String cutoffTime) {
        IbgWindow found = null;
        for (IbgWindow window : IbgWindow.values()) {
            if (window.cutoffTime().equals(cutoffTime)) {
                found = window;
            }
        }

        if (found == null) {
            throw new IllegalArgumentException("Invalid cut off time: " + cutoffTime);
        }

        return found;
    }

    private static class TimeInterval {
        private static final Instant CONSTANT = new Instant(0);
        private final LocalTime from;
        private final LocalTime to;

        TimeInterval(LocalTime from, LocalTime to) {
            this.from = from;
            this.to = to;
        }

        private Interval toInterval() throws IllegalArgumentException {
            return new Interval(from.toDateTime(CONSTANT), to.toDateTime(CONSTANT));
        }
    }

    @Override
    public String toString() {
        return "IbgWindow{"
               + "cutoffTime='" + cutoffTime + '\''
               + ", dnFileId='" + dnFileId + '\''
               + ", drFileId='" + drFileId + '\''
               + '}';
    }
}
