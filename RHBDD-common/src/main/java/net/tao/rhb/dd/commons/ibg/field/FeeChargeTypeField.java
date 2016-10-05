package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.constant.FeeChargeType;

public class FeeChargeTypeField implements Field<FeeChargeType> {
    @Override
    public int length() {
        return 1;
    }

    @Override
    public FeeChargeType parse(String value) throws IllegalArgumentException {
        return FeeChargeType.lookup(value);
    }

    @Override
    public String format(FeeChargeType value) throws IllegalArgumentException {
        return value.value();
    }
}
