package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.ibg.constant.RecordType;
import org.springframework.batch.item.file.transform.Range;

public class FileControlFormat {
    public static final Range[] COLUMN_RANGES = new Range[] {
        new Range(1, 1), new Range(2, 7), new Range(8, 13), new Range(14, 21),
        new Range(22, 31), new Range(32, 43),
        new Range(44, 55), new Range(56, 94)};
    
    public static final String[] COLUMN_NAME = new String[] {
        "recordType", "batchCount", "blockCount", "entryAddendaCount",
        "entryHash", "totalDebitEntryDollarAmountInFile",
        "totalCreditEntryDollarAmountInFile", "reserved"};
    
    public RecordType recordType;

    public long batchCount;

    public long blockCount;

    public long entryAddendaCount;

    public long entryHash;

    public long totalDebitEntryDollarAmountInFile;

    public long totalCreditEntryDollarAmountInFile;

    public String reserved;


    @Override
    public String toString() {
        return "FileControlFormat{" 
               + "recordType=" + recordType 
               + ", batchCount=" + batchCount 
               + ", blockCount=" + blockCount 
               + ", entryAddendaCount=" + entryAddendaCount
               + ", entryHash=" + entryHash 
               + ", totalDebitEntryDollarAmountInFile=" + totalDebitEntryDollarAmountInFile 
               + ", totalCreditEntryDollarAmountInFile=" + totalCreditEntryDollarAmountInFile 
               + ", reserved='" + reserved + '\'' 
               + '}';
    }
}
