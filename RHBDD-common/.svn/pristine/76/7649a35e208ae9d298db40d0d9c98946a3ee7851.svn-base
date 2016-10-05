package net.tao.rhb.dd.commons.ibg.field;

abstract class AbstractBooleanField implements Field<Boolean> {

    @Override
    public Boolean parse(String value) {

        if ("0".equals(value)) {
            return false;
        } else if ("1".equals(value)) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid boolean value");
        }
    }

    @Override
    public String format(Boolean value) {
        if (value) {
            return "1";
        } else {
            return "0";
        }
    }
}
