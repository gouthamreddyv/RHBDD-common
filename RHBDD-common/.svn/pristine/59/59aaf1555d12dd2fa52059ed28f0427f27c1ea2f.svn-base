package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.ibg.constant.CompanyEntryDescription;
import net.tao.rhb.dd.commons.ibg.constant.RecordType;
import net.tao.rhb.dd.commons.ibg.constant.ServiceClassCode;
import net.tao.rhb.dd.commons.ibg.constant.StandardEntryClassCode;
import org.springframework.batch.item.file.transform.Range;

public class BatchHeaderFormat {
    public static final Range[] COLUMN_RANGES = new Range[] {
        new Range(1, 1), new Range(2, 4), new Range(5, 20),
        new Range(21, 40), new Range(41, 50), new Range(51, 53),
        new Range(54, 63), new Range(64, 69), new Range(70, 75),
        new Range(76, 78), new Range(79, 79), new Range(80, 87),
        new Range(88, 94)};

    public static final String[] COLUMN_NAMES = new String[]{
        "recordType", "serviceClassCode", "companyName",
        "companyDiscretionaryData", "companyIdentification", "standardEntryClassCode",
        "companyEntryDescription", "companyDescriptiveDate", "effectiveEntryDate",
        "settlementDate", "originatorStatusCode", "originatingDfiIdentification",
        "batchNumber"};
    
    
    public RecordType recordType = RecordType.BATCH_HEADER;

    public ServiceClassCode serviceClassCode = ServiceClassCode.DEBIT_ONLY;

    public String companyName;

    public String companyDiscretionaryData;

    public String companyIdentification;

    public StandardEntryClassCode standardEntryClassCode = StandardEntryClassCode.CTX;

    public CompanyEntryDescription companyEntryDescription = CompanyEntryDescription.IBG_DD;

    public SimpleDate companyDescriptiveDate = new SimpleDate();

    public SimpleDate effectiveEntryDate = new SimpleDate();

    public String settlementDate; // Julian

    public String originatorStatusCode;

    public String originatingDfiIdentification;

    /**
     * This number is assigned in ascending sequence to each batch by the ODFI
     * or its Sending Point in a given file of entries. Since the batch number
     * in the Batch Header Record and the Batch Control Record is the same,
     * the ascending sequence number should be assigned by batch and not by
     * record.
     */
    public long batchNumber;

    /**
     * Non IBG properties.
     */
    public long ibgFileId;


    @Override
    public String toString() {
        return "BatchHeaderFormat{" 
               + "recordType=" + recordType 
               + ", serviceClassCode=" + serviceClassCode 
               + ", companyName='" + companyName + '\'' 
               + ", companyDiscretionaryData='" + companyDiscretionaryData + '\'' 
               + ", companyIdentification='" + companyIdentification + '\'' 
               + ", standardEntryClassCode=" + standardEntryClassCode 
               + ", companyEntryDescription=" + companyEntryDescription 
               + ", companyDescriptiveDate=" + companyDescriptiveDate 
               + ", effectiveEntryDate=" + effectiveEntryDate 
               + ", settlementDate='" + settlementDate + '\'' 
               + ", originatorStatusCode='" + originatorStatusCode + '\'' 
               + ", originatingDfiIdentification='" + originatingDfiIdentification + '\'' 
               + ", batchNumber=" + batchNumber 
               + ", ibgFileId=" + ibgFileId 
               + '}';
    }
}
