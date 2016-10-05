package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.FieldUtils;
import net.tao.rhb.dd.commons.ibg.format.SimpleDate;
import org.apache.commons.lang3.StringUtils;

abstract class AbstractSimpleDateField implements Field<SimpleDate> {

    @Override
    public int length() {
        return 6;
    }

    @Override
    public SimpleDate parse(String value) throws IllegalArgumentException {
        if (StringUtils.isBlank(value)) {
            return null;
        }

        try {
            int year = Integer.parseInt(value.substring(0, 2));
            int month = Integer.parseInt(value.substring(2, 4));
            int day = Integer.parseInt(value.substring(4, 6));

            return new SimpleDate(year, month, day);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public String format(SimpleDate value) {
        if (value == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        return FieldUtils.leftPad(Integer.toString(value.getYear()), '0', 2)
               + FieldUtils.leftPad(Integer.toString(value.getMonth()), '0', 2)
               + FieldUtils.leftPad(Integer.toString(value.getDay()), '0', 2);
    }
}
