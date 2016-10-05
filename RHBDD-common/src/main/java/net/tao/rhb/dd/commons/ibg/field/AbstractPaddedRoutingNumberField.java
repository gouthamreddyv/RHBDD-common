package net.tao.rhb.dd.commons.ibg.field;

abstract class AbstractPaddedRoutingNumberField implements Field<String> {

    @Override
    public int length() {
        return 10;
    }

    @Override
    public String parse(String value) {
        return value.substring(1);
    }

    @Override
    public String format(String value) {
        return " " + value;
    }
}
