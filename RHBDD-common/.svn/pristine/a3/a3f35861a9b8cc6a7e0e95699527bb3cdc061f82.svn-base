package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.ibg.constant.RecordType;
import net.tao.rhb.dd.commons.ibg.constant.TransactionCode;
import org.springframework.batch.item.file.transform.Range;

public class EntryDetailFormat {
    public static final Range[] COLUMN_RANGES = new Range[]{
        new Range(1, 1), new Range(2, 3), new Range(4, 11), new Range(12, 12),
        new Range(13, 29), new Range(30, 39), new Range(40, 54), new Range(55, 58),
        new Range(59, 74), new Range(75, 76), new Range(77, 78), new Range(79, 79),
        new Range(80, 94)};

    public static final String[] COLUMN_NAMES = new String[]{
        "recordType", "transactionCode", "receivingDfiIdentification", "checkDigit",
        "dfiAccountNumber", "amount", "individualIdNumber", "noOfAddendaRecords",
        "individualName", "reserved", "discretionaryData", "addendaRecordIndicator",
        "traceNumber"};

    public RecordType recordType;

    public TransactionCode transactionCode;

    public String receivingDfiIdentification;

    public long checkDigit;

    public String dfiAccountNumber;

    public long amount;

    public String individualIdNumber;

    public long noOfAddendaRecords;

    public String individualName;

    public String reserved;

    public String discretionaryData;

    public boolean addendaRecordIndicator;

    public TraceNumber traceNumber;

    public FirstAddendaFormat firstAddendaFormat;

    public SecondAddendaFormat secondAddendaFormat;

    public ReturnAddendaFormat returnAddendaFormat;

    /**
     * Non-IBG properties.
     */
    public long ibgFileBatchId;


    @Override
    public String toString() {
        return "{\"EntryDetailFormat\":{"
               + "\"recordType\":\"" + recordType + "\""
               + ", \"transactionCode\":\"" + transactionCode + "\""
               + ", \"receivingDfiIdentification\":\"" + receivingDfiIdentification + "\""
               + ", \"checkDigit\":\"" + checkDigit + "\""
               + ", \"dfiAccountNumber\":\"" + dfiAccountNumber + "\""
               + ", \"amount\":\"" + amount + "\""
               + ", \"individualIdNumber\":\"" + individualIdNumber + "\""
               + ", \"noOfAddendaRecords\":\"" + noOfAddendaRecords + "\""
               + ", \"individualName\":\"" + individualName + "\""
               + ", \"reserved\":\"" + reserved + "\""
               + ", \"discretionaryData\":\"" + discretionaryData + "\""
               + ", \"addendaRecordIndicator\":\"" + addendaRecordIndicator + "\""
               + ", \"traceNumber\":" + traceNumber
               + ", \"firstAddendaFormat\":" + firstAddendaFormat
               + ", \"secondAddendaFormat\":" + secondAddendaFormat
               + ", \"returnAddendaFormat\":" + returnAddendaFormat
               + ", \"ibgFileBatchId\":\"" + ibgFileBatchId + "\""
               + "}}";
    }
}
