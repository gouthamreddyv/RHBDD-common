package net.tao.rhb.dd.model;

import net.tao.rhb.dd.commons.constant.AccountType;

import java.math.BigDecimal;

public class PaymentInstruction {

    private String transactionStatusCode;

    private boolean isInterbank;

    private String sellerOrderNo;

    private String payerAccountNo;

    private String payerName;

    private String payerIdNo;

    private BigDecimal transactionAmount;

    private Long transactionAmountInCent;

    private String paymentReferenceNo;

    private String mandateNo;

    private Integer debitRetry;

    private String rfiRoutingNumber;

    private String segmentCode;

    private String elementCode;

    private Long sequenceNumber;

    private String billerName;

    private String billerCode;

    private AccountType payerAccountType;

    private String originalTraceNumber;

    private Long id;

    private String ibgReturnCode;

    /**
     * Payment Instruction which initialized with some default values.
     */
    public PaymentInstruction() {
        transactionAmount = new BigDecimal("0.00");
        transactionAmountInCent = 0L;
        debitRetry = 0;
        segmentCode = "1";
        elementCode = "0";
    }

    public String getIbgReturnCode() {
        return ibgReturnCode;
    }

    public void setIbgReturnCode(String ibgReturnCode) {
        this.ibgReturnCode = ibgReturnCode;
    }

    public String getRfiRoutingNumber() {
        return rfiRoutingNumber;
    }

    public void setRfiRoutingNumber(String rfiRoutingNumber) {
        this.rfiRoutingNumber = rfiRoutingNumber;
    }

    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerIdNo() {
        return payerIdNo;
    }

    public void setPayerIdNo(String payerIdNo) {
        this.payerIdNo = payerIdNo;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * If null, set it to 0.00.
     *
     * @param transactionAmount transaction amount in dollar
     */
    public void setTransactionAmount(BigDecimal transactionAmount) {
        if (transactionAmount == null) {
            this.transactionAmount = new BigDecimal("0.00");
        } else {
            this.transactionAmount = transactionAmount;
        }

        this.transactionAmountInCent = dollarToCent(transactionAmount);
    }

    public String getPaymentReferenceNo() {
        return paymentReferenceNo;
    }

    public void setPaymentReferenceNo(String paymentReferenceNo) {
        this.paymentReferenceNo = paymentReferenceNo;
    }

    public String getMandateNo() {
        return mandateNo;
    }

    public void setMandateNo(String mandateNo) {
        this.mandateNo = mandateNo;
    }

    public Integer getDebitRetry() {
        return debitRetry;
    }

    /**
     * If provided value is null, it is default to zero.
     *
     * @param debitRetry debit retry attempt
     */
    public void setDebitRetry(Integer debitRetry) {
        if (debitRetry != null) {
            this.debitRetry = debitRetry;
        } else {
            this.debitRetry = 0;
        }
    }

    public String getSellerOrderNo() {
        return sellerOrderNo;
    }

    public void setSellerOrderNo(String sellerOrderNo) {
        this.sellerOrderNo = sellerOrderNo;
    }

    public boolean getIsInterbank() {
        return isInterbank;
    }

    public void setIsInterbank(boolean isInterbank) {
        this.isInterbank = isInterbank;
    }

    public String getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public void setTransactionStatusCode(String transactionStatusCode) {
        this.transactionStatusCode = transactionStatusCode;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public String getElementCode() {
        return elementCode;
    }

    public void setElementCode(String elementCode) {
        this.elementCode = elementCode;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getBillerName() {
        return billerName;
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }

    public AccountType getPayerAccountType() {
        return payerAccountType;
    }

    public void setPayerAccountType(String payerAccountType) {
        this.payerAccountType = AccountType.lookup(payerAccountType);
    }

    public String getBillerCode() {
        return billerCode;
    }

    public void setBillerCode(String billerCode) {
        this.billerCode = billerCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransactionAmountInCent() {
        return transactionAmountInCent;
    }

    /**
     * Note: This setter will set the transaction amount in dollar format as well.
     *
     * @param transactionAmountInCent amount in cents; if null, default to zero
     */
    public void setTransactionAmountInCent(Long transactionAmountInCent) {
        if (transactionAmountInCent == null) {
            transactionAmountInCent = 0L;
        } else {
            this.transactionAmountInCent = transactionAmountInCent;
        }

        this.transactionAmount = centToDollar(transactionAmountInCent);
    }

    private BigDecimal centToDollar(Long amountInCent) {
        if (amountInCent != null) {
            return new BigDecimal(amountInCent).movePointLeft(2);

        } else {
            return new BigDecimal("0.00");
        }
    }

    private Long dollarToCent(BigDecimal dollar) {
        if (dollar == null) {
            throw new IllegalArgumentException("Dollar cannot be null");
        }

        //more than 2 decimal point
        if (dollar.scale() > 2) {
            throw new IllegalArgumentException("Not a billable amount: " + dollar);
        }

        BigDecimal bigDecimalInCents = dollar.movePointRight(2);

        return bigDecimalInCents.longValueExact();
    }

    public String getOriginalTraceNumber() {
        return originalTraceNumber;
    }

    public void setOriginalTraceNumber(String originalTraceNumber) {
        this.originalTraceNumber = originalTraceNumber;
    }

    @Override
    public String toString() {
        return "{\"PaymentInstruction\":{"
               + "\"transactionStatusCode\":\"" + transactionStatusCode + "\""
               + ", \"isInterbank\":\"" + isInterbank + "\""
               + ", \"sellerOrderNo\":\"" + sellerOrderNo + "\""
               + ", \"payerAccountNo\":\"" + payerAccountNo + "\""
               + ", \"payerName\":\"" + payerName + "\""
               + ", \"payerIdNo\":\"" + payerIdNo + "\""
               + ", \"transactionAmount\":\"" + transactionAmount + "\""
               + ", \"transactionAmountInCent\":\"" + transactionAmountInCent + "\""
               + ", \"paymentReferenceNo\":\"" + paymentReferenceNo + "\""
               + ", \"mandateNo\":\"" + mandateNo + "\""
               + ", \"debitRetry\":\"" + debitRetry + "\""
               + ", \"rfiRoutingNumber\":\"" + rfiRoutingNumber + "\""
               + ", \"segmentCode\":\"" + segmentCode + "\""
               + ", \"elementCode\":\"" + elementCode + "\""
               + ", \"sequenceNumber\":\"" + sequenceNumber + "\""
               + ", \"billerName\":\"" + billerName + "\""
               + ", \"billerCode\":\"" + billerCode + "\""
               + ", \"payerAccountType\":\"" + payerAccountType + "\""
               + ", \"originalTraceNumber\":\"" + originalTraceNumber + "\""
               + ", \"id\":\"" + id + "\""
               + ", \"ibgReturnCode\":\"" + ibgReturnCode + "\""
               + "}}";
    }
}
