package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.FieldUtils;
import net.tao.rhb.dd.commons.ibg.constant.StandardEntryClassCode;

public class StandardEntryClassCodeField implements Field<StandardEntryClassCode> {
    @Override
    public int length() {
        return 3;
    }

    @Override
    public StandardEntryClassCode parse(String value) throws IllegalArgumentException {
        StandardEntryClassCode code = null;

        for (StandardEntryClassCode t : StandardEntryClassCode.values()) {
            if (t.toString().equals(value)) {
                code = t;
            }
        }

        if (code == null) {
            throw new IllegalArgumentException("Invalid standard entry class code");
        }

        return code;
    }

    @Override
    public String format(StandardEntryClassCode value) throws IllegalArgumentException {
        return FieldUtils.rightPad(value.toString(), ' ', length());
    }
}
