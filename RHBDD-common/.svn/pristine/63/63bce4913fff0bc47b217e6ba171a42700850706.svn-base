package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.FieldUtils;
import net.tao.rhb.dd.commons.ibg.constant.TransactionCode;

public class TransactionCodeField implements Field<TransactionCode> {
    @Override
    public int length() {
        return 2;
    }

    @Override
    public TransactionCode parse(String value) throws IllegalArgumentException {
        TransactionCode code = null;

        for (TransactionCode tc : TransactionCode.values()) {
            if (tc.value().equals(value)) {
                code = tc;
            }
        }

        if (code == null) {
            throw new IllegalArgumentException("Invalid Transaction Code: " + value);
        }

        return code;
    }

    @Override
    public String format(TransactionCode value) throws IllegalArgumentException {
        return FieldUtils.rightPad(value.value(), ' ', length());
    }
}
