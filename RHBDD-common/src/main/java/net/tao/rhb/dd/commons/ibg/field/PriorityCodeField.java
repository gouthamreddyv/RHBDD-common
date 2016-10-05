package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.constant.PriorityCode;

public class PriorityCodeField implements Field<PriorityCode> {
    @Override
    public int length() {
        return 2;
    }

    @Override
    public PriorityCode parse(String value) throws IllegalArgumentException {
        return PriorityCode.lookup(value);
    }

    @Override
    public String format(PriorityCode value) throws IllegalArgumentException {
        return value.value();
    }
}
