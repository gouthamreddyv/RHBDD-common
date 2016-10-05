package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.constant.AccountType;
import net.tao.rhb.dd.commons.ibg.constant.AddendaType;
import net.tao.rhb.dd.commons.ibg.constant.FeeChargeType;
import net.tao.rhb.dd.commons.ibg.constant.RecordType;
import org.springframework.batch.item.file.transform.Range;

public class FirstAddendaFormat {
    public static final Range[] COLUMN_RAGES = new Range[]{
        new Range(1, 1), new Range(2, 3), new Range(4, 33), new Range(34, 43),
        new Range(44, 63), new Range(64, 64), new Range(65, 65), new Range(66, 71),
        new Range(72, 72), new Range(73, 83), new Range(84, 87), new Range(88, 94)};

    public static final String[] COLUMN_NAMES = new String[]{
        "recordType", "addendaType", "billerName", "billerCode",
        "mandateNumber", "debitRetry", "accountType", "feeAmount",
        "feeChargeType", "reserved", "addendaSequenceNumber", "entryDetailSequenceNumber"};

    public RecordType recordType = RecordType.ENTRY_ADDENDA;

    public AddendaType addendaType = AddendaType.DEFAULT;

    public String billerName;

    public String billerCode;

    public String mandateNumber;

    public long debitRetry;

    public AccountType accountType;

    public long feeAmount;

    public FeeChargeType feeChargeType;

    public String reserved;

    public long addendaSequenceNumber = 1;

    public long entryDetailSequenceNumber;

    /**
     * Non-IBG properties.
     */
    public long ibgFileEntryId;

    @Override
    public String toString() {
        return "{\"FirstAddendaFormat\":{"
               + "\"recordType\":\"" + recordType + "\""
               + ", \"addendaType\":\"" + addendaType + "\""
               + ", \"billerName\":\"" + billerName + "\""
               + ", \"billerCode\":\"" + billerCode + "\""
               + ", \"mandateNumber\":\"" + mandateNumber + "\""
               + ", \"debitRetry\":\"" + debitRetry + "\""
               + ", \"accountType\":\"" + accountType + "\""
               + ", \"feeAmount\":\"" + feeAmount + "\""
               + ", \"feeChargeType\":\"" + feeChargeType + "\""
               + ", \"reserved\":\"" + reserved + "\""
               + ", \"addendaSequenceNumber\":\"" + addendaSequenceNumber + "\""
               + ", \"entryDetailSequenceNumber\":\"" + entryDetailSequenceNumber + "\""
               + ", \"ibgFileEntryId\":\"" + ibgFileEntryId + "\""
               + "}}";
    }
}
