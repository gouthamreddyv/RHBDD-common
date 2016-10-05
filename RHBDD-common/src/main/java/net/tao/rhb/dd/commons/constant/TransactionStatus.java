package net.tao.rhb.dd.commons.constant;

public enum TransactionStatus {

    NEW("A90"),
    
    DR_SUBMITTED("A51"),
    
    DR_DECLINED("A54"),
    
    SUCCESS("A00");

    private final String statusCode;

    TransactionStatus(String statusCode) {
        this.statusCode = statusCode;
    }

    public String statusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return statusCode;
    }
}
