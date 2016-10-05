package net.tao.rhb.dd.commons.ibg.constant;

public enum TransactionCode {

    DEBIT_NORMAL("27", 2),
    
    DEBIT_RETURN("26", 1);

    private final String code;

    private final int addendaRecordCount;

    TransactionCode(String code, int noOfAddenda) {
        this.code = code;
        this.addendaRecordCount = noOfAddenda;
    }

    public String value() {
        return code;
    }

    public int addendaRecordCount() {
        return addendaRecordCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TransactionCode{");
        sb.append("code='").append(code).append('\'');
        sb.append(", addendaRecordCount=").append(addendaRecordCount);
        sb.append('}');
        return sb.toString();
    }
}
