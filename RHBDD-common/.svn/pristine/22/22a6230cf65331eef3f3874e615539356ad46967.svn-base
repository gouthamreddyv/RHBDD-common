package net.tao.rhb.dd.commons.ibg.field;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractTruncateStringField extends AbstractStringField {
    @Override
    public String format(String value) {
        if (value == null) {
            value = "";
        }

        return super.format(StringUtils.left(value, length()));
    }
}
