package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.constant.AddendaType;

public class AddendaTypeField implements Field<AddendaType> {
    @Override
    public int length() {
        return 2;
    }

    @Override
    public AddendaType parse(String value) throws IllegalArgumentException {
        return AddendaType.lookup(value);
    }

    @Override
    public String format(AddendaType value) throws IllegalArgumentException {
        return value.value();
    }
}
