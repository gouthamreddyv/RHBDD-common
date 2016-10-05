package net.tao.rhb.dd.commons.ibg.field;

import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class AbstractCommaSeparatedNumericField implements Field<Long> {

    @Override
    public Long parse(String value) throws IllegalArgumentException {
        // TODO
        return 0L;
    }

    @Override
    public String format(Long value) {
        return StringUtils.leftPad(NumberFormat.getNumberInstance(Locale.US).format(value),
                length(), " ");
    }
}
