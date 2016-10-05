package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.ibg.FieldUtils;
import net.tao.rhb.dd.commons.ibg.constant.ServiceClassCode;

public class ServiceClassCodeField implements Field<ServiceClassCode> {
    @Override
    public int length() {
        return 3;
    }

    @Override
    public ServiceClassCode parse(String value) throws IllegalArgumentException {

        ServiceClassCode code = null;

        for (ServiceClassCode t : ServiceClassCode.values()) {
            if (t.value().equals(value)) {
                code = t;
            }
        }

        if (code == null) {
            throw new IllegalArgumentException("Invalid service class code: " + value);
        }

        return code;
    }

    @Override
    public String format(ServiceClassCode value) throws IllegalArgumentException {
        return FieldUtils.rightPad(value.value(), ' ', length());
    }
}
