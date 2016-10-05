package net.tao.rhb.dd.commons.ibg.field;

abstract class AbstractNoCheckDigitRoutingNumberField implements Field<String> {

    @Override
    public int length() {
        return 8;
    }

    @Override
    public String parse(String value) {
        return value.trim();
    }

    @Override
    public String format(String value) {
        if (value == null) {
            return "";
        }
        return value.substring(0, value.length() - 1);
    }
}
