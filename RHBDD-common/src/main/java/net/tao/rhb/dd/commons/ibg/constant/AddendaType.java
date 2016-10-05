package net.tao.rhb.dd.commons.ibg.constant;

public enum AddendaType {
    DEFAULT("05"),
    
    RETURN("99");

    private final String value;

    AddendaType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    /**
     * Look up AddendaType by value.
     * @param value lookup value
     * @return AddendaType if found; else throw {@link IllegalArgumentException}
     */
    public static AddendaType lookup(String value) {
        AddendaType found = null;

        for (AddendaType addendaType : AddendaType.values()) {
            if (addendaType.value().equals(value)) {
                found = addendaType;
            }
        }

        if (found == null) {
            throw new IllegalArgumentException("Addenda Type not found: " + value);
        }

        return found;
    }
}
