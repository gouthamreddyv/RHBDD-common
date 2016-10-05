package net.tao.rhb.dd.commons.ibg.constant;

public enum FeeChargeType {
    CHARGE_BILLER("B");

    private final String value;

    FeeChargeType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    /**
     * Look up FeeChargeType by value.
     * @param value lookup value
     * @return the FeeChargeType if found; else throw {@link IllegalArgumentException}
     */
    public static FeeChargeType lookup(String value) {
        FeeChargeType found = null;
        for (FeeChargeType chargeType : FeeChargeType.values()) {
            if (chargeType.value().equals(value)) {
                found = chargeType;
            }
        }

        if (found == null) {
            throw new IllegalArgumentException("Fee Charge Type not found: " + value);
        }

        return found;
    }
}
