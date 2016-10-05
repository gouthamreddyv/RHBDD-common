package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.constant.AccountType;
import net.tao.rhb.dd.commons.ibg.constant.AddendaType;
import net.tao.rhb.dd.commons.ibg.constant.RecordType;
import org.springframework.batch.item.file.transform.Range;

public class ReturnAddendaFormat {
    public static final Range[] COLUMN_RANGES = new Range[]{
        new Range(1, 1), new Range(2, 3), new Range(4, 6), new Range(7, 21),
        new Range(22, 27), new Range(28, 35), new Range(36, 45), new Range(46, 65),
        new Range(66, 66), new Range(67, 67), new Range(68, 79), new Range(80, 94)};

    public static final String[] COLUMN_NAMES = new String[]{
        "recordType", "addendaType", "returnReasonCode", "originalEntryTraceNumber",
        "dateOfDeath", "originalReceivingFiIdentification", "billerCode", "recipientReference",
        "debitRetry", "accountType", "addendaInformation", "traceNumber"};


    public RecordType recordType = RecordType.ENTRY_ADDENDA;

    public AddendaType addendaType = AddendaType.RETURN;

    public String returnReasonCode;

    public String originalEntryTraceNumber;

    public String dateOfDeath;

    public String originalReceivingFiIdentification;

    public String billerCode;

    public String recipientReference;

    public long debitRetry;

    public AccountType accountType;

    public String addendaInformation;

    public TraceNumber traceNumber;

    /**
     * Non-IBG properties.
     */
    public long ibgFileEntryId;

    @Override
    public String toString() {
        return "{\"ReturnAddendaFormat\":{"
               + "\"recordType\":\"" + recordType + "\""
               + ", \"addendaType\":\"" + addendaType + "\""
               + ", \"returnReasonCode\":\"" + returnReasonCode + "\""
               + ", \"originalEntryTraceNumber\":\"" + originalEntryTraceNumber + "\""
               + ", \"dateOfDeath\":\"" + dateOfDeath + "\""
               + ", \"originalReceivingFiIdentification\":\""
               + originalReceivingFiIdentification + "\""
               + ", \"billerCode\":\"" + billerCode + "\""
               + ", \"recipientReference\":\"" + recipientReference + "\""
               + ", \"debitRetry\":\"" + debitRetry + "\""
               + ", \"accountType\":\"" + accountType + "\""
               + ", \"addendaInformation\":\"" + addendaInformation + "\""
               + ", \"traceNumber\":" + traceNumber
               + ", \"ibgFileEntryId\":\"" + ibgFileEntryId + "\""
               + "}}";
    }
}
