package net.tao.rhb.dd.commons.constant;

public enum AccountType {

    SAVING_ACCOUNT("1"),

    CURRENT_ACCOUNT("2"),

    CREDIT_ACCOUNT("3"),

    DUMMY1("4"),
    DUMMY2("5"),
    DUMMY3("6");

    private final String value;

    AccountType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    /**
     * Look up the Account Type by value.
     *
     * @param value look up using this value
     * @return the AccountType if found; if not found, throw {@link IllegalArgumentException}
     */
    public static AccountType lookup(String value) {
        AccountType found = null;

        for (AccountType accountType : AccountType.values()) {
            if (accountType.value().equals(value)) {
                found = accountType;
            }
        }

        if (found == null) {
            throw new IllegalArgumentException("Account Type not found: " + value);
        }

        return found;
    }
}
