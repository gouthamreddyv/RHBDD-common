package net.tao.rhb.dd.commons.ibg.constant;

public enum PriorityCode {
    DEFAULT("01");

    private final String value;

    PriorityCode(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    /**
     * Lookup PriorityCode using value.
     * @param value lookup value
     * @return the PriorityCode if found; else throw {@link IllegalArgumentException}
     */
    public static PriorityCode lookup(String value) {
        PriorityCode found = null;

        for (PriorityCode priorityCode : PriorityCode.values()) {
            if (priorityCode.value().equals(value)) {
                found = priorityCode;
            }
        }

        if (found == null) {
            throw new IllegalArgumentException("PriorityCode is not found: " + value);
        }

        return found;
    }
}
