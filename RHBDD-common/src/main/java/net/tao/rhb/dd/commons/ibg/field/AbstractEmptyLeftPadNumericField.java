package net.tao.rhb.dd.commons.ibg.field;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractEmptyLeftPadNumericField implements Field<Long> {
    @Override
    public Long parse(String value) throws IllegalArgumentException {
        //TODO 
        return 0L;
    }

    @Override
    public String format(Long value) throws IllegalArgumentException {
        if (value == null) {
            value = 0L;
        }
        
        return StringUtils.leftPad(value.toString(), length(), " ");
    }
}
