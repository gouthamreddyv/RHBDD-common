package net.tao.rhb.dd.commons.ibg.constant;

public enum RecordType {
    FILE_HEADER("1"),
    BATCH_HEADER("5"),
    ENTRY_DETAIL("6"),
    ENTRY_ADDENDA("7"),
    BATCH_CONTROL("8"),
    FILE_CONTROL("9");

    private final String value;

    RecordType(String value) {
        this.value = value;
    }

    /**
     * Lookup RecordType using value.
     *
     * @param value lookup value
     * @return the RecordType if found; else throw {@link IllegalArgumentException}
     */
    public static RecordType lookup(String value) {
        RecordType found = null;

        for (RecordType t : RecordType.values()) {
            if (t.value().equals(value)) {
                found = t;
            }
        }

        if (found == null) {
            throw new IllegalArgumentException("Invalid record type: " + value);
        }

        return found;
    }

    public String value() {
        return value;
    }
}
