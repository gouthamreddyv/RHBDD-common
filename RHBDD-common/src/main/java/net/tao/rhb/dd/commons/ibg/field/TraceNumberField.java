package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.format.TraceNumber;
import org.apache.commons.lang3.StringUtils;

public class TraceNumberField implements Field<TraceNumber> {
    @Override
    public int length() {
        return 15;
    }

    @Override
    public TraceNumber parse(String value) throws IllegalArgumentException {
        if (StringUtils.isEmpty(value) || value.length() != length()) {
            throw new IllegalArgumentException("Invalid trace number: " + value);
        }

        return new TraceNumber(value);
    }

    @Override
    public String format(TraceNumber value) throws IllegalArgumentException {
        return value.toString();
    }
}
