package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.ibg.FieldUtils;
import org.apache.commons.lang3.StringUtils;

public class TraceNumber {

    private final String routingNumber;
    private final long sequenceNumber;

    /**
     * Trace Number which is combined of routing number (without check digit) and trace number.
     *
     * @param routingNumber  routing number without check digit
     * @param sequenceNumber sequence number of the trace number
     */
    public TraceNumber(String routingNumber, long sequenceNumber) {

        if (routingNumber == null) {
            throw new IllegalArgumentException("routing number is null");
        }

        if (sequenceNumber < 0) {
            throw new IllegalArgumentException(
                    "The sequence number must be a number greater than or equal to zero");
        }

        String value = Long.toString(sequenceNumber);
        if (value.length() > 7) {
            throw new IllegalArgumentException(
                    "The sequence number must be less than or equal to seven digits.");
        }

        this.sequenceNumber = sequenceNumber;
        this.routingNumber = routingNumber;
    }

    /**
     * Trace Number which is combined of routing number (without check digit) and trace number.
     *
     * @param numberMinusCheckDigit 15 character long trace number
     */
    public TraceNumber(String numberMinusCheckDigit) {

        if (StringUtils.isEmpty(numberMinusCheckDigit) || numberMinusCheckDigit.length() != 15) {
            throw new IllegalArgumentException("Invalid trace number: " + numberMinusCheckDigit);
        }
        // append zero to form a 9-digit routing number
        this.routingNumber = numberMinusCheckDigit.substring(0, 8) + 0;

        String sequenceNumberString = numberMinusCheckDigit.substring(8);
        sequenceNumberString = FieldUtils.leftStrip(sequenceNumberString, '0');

        this.sequenceNumber = Long.parseLong(sequenceNumberString);

    }

    @Override
    public String toString() {
        String routingNumberString = this.routingNumber;
        routingNumberString = routingNumberString.substring(0, routingNumberString.length() - 1);

        String sequenceNumberString = Long.toString(this.sequenceNumber);
        sequenceNumberString = FieldUtils.leftPad(sequenceNumberString, '0', 7);

        return routingNumberString + sequenceNumberString;
    }
}