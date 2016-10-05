package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.ibg.constant.AddendaType;
import net.tao.rhb.dd.commons.ibg.constant.RecordType;
import org.springframework.batch.item.file.transform.Range;

public class SecondAddendaFormat {
    public static final Range[] COLUMN_RANGES = new Range[]{
        new Range(1, 1), new Range(2, 3), new Range(4, 23), new Range(24, 43),
        new Range(44, 83), new Range(84, 87), new Range(88, 94)};

    public static final String[] COLUMN_NAMES = new String[]{
        "recordType", "addendaType", "otherPaymentDetails", "recipientReference",
        "reserved", "addendaSequenceNumber", "entryDetailSequenceNumber"};


    public RecordType recordType = RecordType.ENTRY_ADDENDA;

    public AddendaType addendaType = AddendaType.DEFAULT;

    public String otherPaymentDetails;

    public String recipientReference;

    public String reserved;

    public long addendaSequenceNumber = 2;

    public long entryDetailSequenceNumber;

    /**
     * Non-IBG properties.
     */
    public long ibgFileEntryId;

    @Override
    public String toString() {
        return "{\"SecondAddendaFormat\":{"
               + "\"recordType\":\"" + recordType + "\""
               + ", \"addendaType\":\"" + addendaType + "\""
               + ", \"otherPaymentDetails\":\"" + otherPaymentDetails + "\""
               + ", \"recipientReference\":\"" + recipientReference + "\""
               + ", \"reserved\":\"" + reserved + "\""
               + ", \"addendaSequenceNumber\":\"" + addendaSequenceNumber + "\""
               + ", \"entryDetailSequenceNumber\":\"" + entryDetailSequenceNumber + "\""
               + ", \"ibgFileEntryId\":\"" + ibgFileEntryId + "\""
               + "}}";
    }
}
