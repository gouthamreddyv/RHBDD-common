package net.tao.rhb.dd.commons.ibg.field.transmittal;

import net.tao.rhb.dd.commons.ibg.field.AbstractTruncateStringField;

public class OfiNameField extends AbstractTruncateStringField {
    @Override
    public int length() {
        return 4;
    }
}
