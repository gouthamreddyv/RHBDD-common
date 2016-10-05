package net.tao.rhb.dd.commons.ibg;


import net.tao.rhb.dd.commons.ibg.field.Field;
import org.apache.commons.lang3.StringUtils;

public class FieldParser {

    /**
     * Parse the value according to the Field Type.
     *
     * @param fieldClass he class of Field
     * @param value      the value to be parsed
     * @param <T>        the return type
     * @return the parsed value
     */
    public <T> T parse(Class<? extends Field<T>> fieldClass, String value) {
        Field<T> field;

        try {
            field = fieldClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int expectedFieldLength = field.length();
        int actualLength = StringUtils.length(value);

        if (expectedFieldLength != actualLength) {
            throw new RuntimeException(
                    String.format("[%s] Expected length is [%s] but it was [%s]",
                            fieldClass, expectedFieldLength, actualLength));
        }

        return field.parse(value);
    }
}
