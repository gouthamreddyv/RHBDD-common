package net.tao.rhb.dd.commons.ibg;

import net.tao.rhb.dd.commons.ibg.field.Field;

public class FieldUtils {

    /**
     * Get the name of the Field.
     * @param field the target Field
     * @return the name of the provided Field
     */
    public static String getName(Field<?> field) {

        String[] parts = field.getClass().getName().split("\\.");
        String className = parts[parts.length - 1];
        String name = className.substring(0, 1).toLowerCase() + className.substring(1);

        if (name.endsWith("Field")) {
            name = name.substring(0, name.length() - "Field".length());
        }

        return name;
    }

    /**
     * Left pad a String with filler.
     * @param str the String to be padded
     * @param filler the String to pad with
     * @param length the size to pad to
     * @return left padded String or original String if padding is not necessary
     */
    public static String leftPad(String str, char filler, int length) {

        int count = length - str.length();

        if (count < 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(filler);
        }

        sb.append(str);

        return sb.toString();
    }

    /**
     * Right pad a String with filler.
     * @param str the String to be padded
     * @param filler the String to pad with
     * @param length the size to pad to
     * @return right padded String or original String if padding is not necessary
     */
    public static String rightPad(String str, char filler, int length) {

        int count = length - str.length();

        if (count < 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(str);

        for (int i = 0; i < count; i++) {
            sb.append(filler);
        }

        return sb.toString();
    }

    /**
     * Left strip a String with filler.
     * @param str the String to be stripped
     * @param filler the String to strip with
     * @return the stripped String
     */
    public static String leftStrip(String str, char filler) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != filler) {
                break;
            }
            count++;
        }

        return str.substring(count);
    }
}