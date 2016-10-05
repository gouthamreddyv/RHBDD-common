package net.tao.rhb.dd.commons.ibg;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class IbgWindowTest {

    @Test
    public void drFileId_IbgWindowGiven_DrFileIdReturned() {
        assertThat(IbgWindow.WINDOW_ONE.drFileId(), is("1"));
        assertThat(IbgWindow.WINDOW_TWO.drFileId(), is("2"));
        assertThat(IbgWindow.WINDOW_THREE.drFileId(), is("3"));
        assertThat(IbgWindow.WINDOW_FOUR.drFileId(), is("4"));
        assertThat(IbgWindow.WINDOW_FIVE.drFileId(), is("5"));
    }

    @Test
    public void dnFileId_IbgWindowGiven_DnFileIdReturned() {
        assertThat(IbgWindow.WINDOW_ONE.dnFileId(), is("A"));
        assertThat(IbgWindow.WINDOW_TWO.dnFileId(), is("B"));
        assertThat(IbgWindow.WINDOW_THREE.dnFileId(), is("C"));
        assertThat(IbgWindow.WINDOW_FOUR.dnFileId(), is("D"));
        assertThat(IbgWindow.WINDOW_FIVE.dnFileId(), is("E"));
    }

    @Test
    public void cutoffTime_IbgWindowGiven_CutoffTimeReturned() {
        assertThat(IbgWindow.WINDOW_ONE.cutoffTime(), is("0700"));
        assertThat(IbgWindow.WINDOW_TWO.cutoffTime(), is("1000"));
        assertThat(IbgWindow.WINDOW_THREE.cutoffTime(), is("1300"));
        assertThat(IbgWindow.WINDOW_FOUR.cutoffTime(), is("1600"));
        assertThat(IbgWindow.WINDOW_FIVE.cutoffTime(), is("1900"));
    }

    @Test
    public void nextAvailableWindow_TimeWithinFirstWindowGiven_Window1Returned() {
        assertThat(IbgWindow.nextAvailableWindow(toTime("03:00:59 am")),
                is(IbgWindow.WINDOW_ONE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("06:59:59 am")),
                is(IbgWindow.WINDOW_ONE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("07:00:00 pm")),
                is(IbgWindow.WINDOW_ONE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("08:00:00 pm")),
                is(IbgWindow.WINDOW_ONE));

        assertThat(IbgWindow.nextAvailableWindow(toTime("07:00:00 am")),
                not(IbgWindow.WINDOW_ONE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("08:59:59 am")),
                not(IbgWindow.WINDOW_ONE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("09:59:59 am")),
                not(IbgWindow.WINDOW_ONE));
    }

    @Test
    public void nextAvailableWindow_TimeWithinSecondWindowGiven_Window2Returned() {
        assertThat(IbgWindow.nextAvailableWindow(toTime("07:00:00 am")),
                is(IbgWindow.WINDOW_TWO));
        assertThat(IbgWindow.nextAvailableWindow(toTime("08:00:00 am")),
                is(IbgWindow.WINDOW_TWO));
        assertThat(IbgWindow.nextAvailableWindow(toTime("09:59:59 am")),
                is(IbgWindow.WINDOW_TWO));

        assertThat(IbgWindow.nextAvailableWindow(toTime("10:00:00 am")),
                not(IbgWindow.WINDOW_TWO));
        assertThat(IbgWindow.nextAvailableWindow(toTime("01:00:00 pm")),
                not(IbgWindow.WINDOW_TWO));
    }

    @Test
    public void nextAvailableWindow_TimeWithinThirdWindowGiven_Window3Returned() {
        assertThat(IbgWindow.nextAvailableWindow(toTime("10:00:00 am")),
                is(IbgWindow.WINDOW_THREE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("11:30:07 am")),
                is(IbgWindow.WINDOW_THREE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("12:59:59 pm")),
                is(IbgWindow.WINDOW_THREE));

        assertThat(IbgWindow.nextAvailableWindow(toTime("01:00:00 pm")),
                not(IbgWindow.WINDOW_THREE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("04:00:00 pm")),
                not(IbgWindow.WINDOW_THREE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("06:59:59 pm")),
                not(IbgWindow.WINDOW_THREE));
    }

    @Test
    public void nextAvailableWindow_TimeWithinForthWindowGiven_Window4Returned() {
        assertThat(IbgWindow.nextAvailableWindow(toTime("01:00:00 pm")),
                is(IbgWindow.WINDOW_FOUR));
        assertThat(IbgWindow.nextAvailableWindow(toTime("2:30:56 pm")),
                is(IbgWindow.WINDOW_FOUR));
        assertThat(IbgWindow.nextAvailableWindow(toTime("03:59:59 pm")),
                is(IbgWindow.WINDOW_FOUR));

        assertThat(IbgWindow.nextAvailableWindow(toTime("07:00:00 pm")),
                not(IbgWindow.WINDOW_FOUR));
        assertThat(IbgWindow.nextAvailableWindow(toTime("01:00:00 am")),
                not(IbgWindow.WINDOW_FOUR));
        assertThat(IbgWindow.nextAvailableWindow(toTime("07:59:59 pm")),
                not(IbgWindow.WINDOW_FOUR));
    }

    @Test
    public void nextAvailableWindow_TimeWithinFifthWindowGiven_Window5Returned() {
        assertThat(IbgWindow.nextAvailableWindow(toTime("04:00:00 pm")),
                is(IbgWindow.WINDOW_FIVE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("05:30:56 pm")),
                is(IbgWindow.WINDOW_FIVE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("06:59:59 pm")),
                is(IbgWindow.WINDOW_FIVE));

        assertThat(IbgWindow.nextAvailableWindow(toTime("07:00:00 pm")),
                not(IbgWindow.WINDOW_FIVE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("10:00:00 pm")),
                not(IbgWindow.WINDOW_FIVE));
        assertThat(IbgWindow.nextAvailableWindow(toTime("04:59:59 am")),
                not(IbgWindow.WINDOW_FIVE));
    }

    private Date toTime(String time) {
        try {
            return new SimpleDateFormat("hh:mm:ss a").parse(time);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid time (hh:mm:ss a): " + time, e);
        }
    }

}
