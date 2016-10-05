package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.FieldUtils;

public abstract class AbstractNumericField implements Field<Long> {

    @Override
    public Long parse(String value) {

        value = FieldUtils.leftStrip(value, '0');

        if (("").equals(value)) {
            value = "0";
        }

        try {
            return Long.valueOf(value);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String format(Long value) {

        if (value == null) {
            value = 0L;
        }

        return FieldUtils.leftPad(value.toString(), '0', length());
    }
}
