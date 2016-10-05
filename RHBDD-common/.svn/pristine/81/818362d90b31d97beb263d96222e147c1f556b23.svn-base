package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.FieldUtils;

public abstract class AbstractStringField implements Field<String> {

    @Override
    public String parse(String value) {
        return value.trim();
    }

    @Override
    public String format(String value) {

        if (value == null) {
            value = "";
        }

        return FieldUtils.rightPad(value, ' ', length());
    }
}
