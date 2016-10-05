package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.constant.RecordType;

public class RecordTypeField implements Field<RecordType> {

    public String getFormat() {
        return null;
    }

    public int length() {
        return 1;
    }

    @Override
    public RecordType parse(String value) {
        return RecordType.lookup(value);
    }

    @Override
    public String format(RecordType value) {
        return value.value();
    }
}