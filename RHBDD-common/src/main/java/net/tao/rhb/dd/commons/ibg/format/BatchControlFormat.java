package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.ibg.constant.RecordType;
import net.tao.rhb.dd.commons.ibg.constant.ServiceClassCode;
import org.springframework.batch.item.file.transform.Range;

public class BatchControlFormat {
    public static final Range[] COLUMN_RANGES = new Range[] {
        new Range(1, 1), new Range(2, 4), new Range(5, 10),
        new Range(11, 20) , new Range(21, 32) , new Range(33, 44),
        new Range(45, 54) , new Range(55, 73) , new Range(74, 79),
        new Range(80, 87) , new Range(88, 94)};
    
    public static final String[] COLUMN_NAMES = new String[] {
        "recordType", "serviceClassCode", "entryAddendaCount", 
        "entryHash", "totalDebitEntryDollarAmount", "totalCreditEntryDollarAmount", 
        "companyIdentification", "messageAuthenticationCode", "reserved",
        "originatingDfiIdentification", "batchNumber"};
    
    public RecordType recordType;

    public ServiceClassCode serviceClassCode;

    public long entryAddendaCount;

    public long entryHash;

    public long totalDebitEntryDollarAmount;

    public long totalCreditEntryDollarAmount;

    public String companyIdentification;

    public String messageAuthenticationCode;

    public String reserved;

    public String originatingDfiIdentification;

    public long batchNumber;


    @Override
    public String toString() {
        return "BatchControlFormat{" 
               + "recordType=" + recordType 
               + ", serviceClassCode=" + serviceClassCode 
               + ", entryAddendaCount=" + entryAddendaCount 
               + ", entryHash=" + entryHash 
               + ", totalDebitEntryDollarAmount=" + totalDebitEntryDollarAmount 
               + ", totalCreditEntryDollarAmount=" + totalCreditEntryDollarAmount 
               + ", companyIdentification='" + companyIdentification + '\'' 
               + ", messageAuthenticationCode='" + messageAuthenticationCode + '\'' 
               + ", reserved='" + reserved + '\'' 
               + ", originatingDfiIdentification='" + originatingDfiIdentification + '\'' 
               + ", batchNumber=" + batchNumber 
               + '}';
    }
}
