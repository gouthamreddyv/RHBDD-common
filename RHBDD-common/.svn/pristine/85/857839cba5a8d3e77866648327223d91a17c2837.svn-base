package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.FieldUtils;
import net.tao.rhb.dd.commons.ibg.format.SimpleTime;

public class AbstractSimpleTimeField implements Field<SimpleTime> {
    @Override
    public int length() {
        return 4;
    }

    @Override
    public SimpleTime parse(String value) throws IllegalArgumentException {
        int hours = Integer.parseInt(value.substring(0, 2));
        int minutes = Integer.parseInt(value.substring(2, 4));

        return new SimpleTime(hours, minutes);
    }

    @Override
    public String format(SimpleTime value) throws IllegalArgumentException {
        return FieldUtils.leftPad(Integer.toString(value.getHours()), '0', 2)
               + FieldUtils.leftPad(Integer.toString(value.getMinutes()), '0', 2);

    }
}
