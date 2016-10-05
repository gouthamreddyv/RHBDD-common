package net.tao.rhb.dd.commons.ibg;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class EntryHashingCalculatorTest {

    private EntryHashingCalculator hashingCalculator;

    @Before
    public void beforeTest() {
        hashingCalculator = new EntryHashingCalculator();
    }

    @Test
    public void calculateControlValue_NullValuesGiven_ExceptionThrown() {
        //TODO handle null or empty values
    }

    @Test
    public void calculateControlValue_OriginalEntriesForHLBBGiven_ControlValueCalculated() {
        int squaredSum1 = hashingCalculator.calculateSquaredSum(
                "10000224",
                "00550233437",
                "0000010000");
        assertThat(squaredSum1, is(20164));

        int squaredSum2 = hashingCalculator.calculateSquaredSum(
                "10000224",
                "00100889286",
                "0000060000");
        assertThat(squaredSum2, is(49729));

        int squaredSum3 = hashingCalculator.calculateSquaredSum(
                "10000224",
                "4363646001145575",
                "0000090060");
        assertThat(squaredSum3, is(93636));

        int[] listOfSquaredSum = new int[]{squaredSum1, squaredSum2, squaredSum3};
        assertThat(hashingCalculator.calculateControlValue(listOfSquaredSum), is(971));
    }

    @Test
    public void calculateControlValue_ReturnEntriesForHLBBGiven_ControlValueCalculated() {
        int squaredSum1 = hashingCalculator.calculateSquaredSum(
                "10000224",
                "11301000001054",
                "1500");
        assertThat(squaredSum1, is(14161));

        int squaredSum2 = hashingCalculator.calculateSquaredSum(
                "10000224",
                "11301111111111",
                "1600");
        assertThat(squaredSum2, is(13689));

        int squaredSum3 = hashingCalculator.calculateSquaredSum(
                "10000224",
                "20708200024300",
                "1700");
        assertThat(squaredSum3, is(22201));

        int[] listOfSquaredSum = new int[]{squaredSum1, squaredSum2, squaredSum3};
        assertThat(hashingCalculator.calculateControlValue(listOfSquaredSum), is(949));
    }


    @Test
    public void calculateControlValue_OriginalEntriesForRHBGiven_ControlValueCalculated() {
        int squaredSum1 = hashingCalculator.calculateSquaredSum(
                "10000218",
                "11301000001054",
                "1100");
        assertThat(squaredSum1, is(15876));

        int squaredSum2 = hashingCalculator.calculateSquaredSum(
                "10000218",
                "11301111111111",
                "1200");
        assertThat(squaredSum2, is(15376));

        int squaredSum3 = hashingCalculator.calculateSquaredSum(
                "10000218",
                "20708200024300",
                "1300");
        assertThat(squaredSum3, is(24336));

        int[] listOfSquaredSum = new int[]{squaredSum1, squaredSum2, squaredSum3};
        assertThat(hashingCalculator.calculateControlValue(listOfSquaredSum), is(912));
    }

}
