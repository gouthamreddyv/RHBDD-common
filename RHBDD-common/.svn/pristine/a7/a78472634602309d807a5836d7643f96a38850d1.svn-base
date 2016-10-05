package net.tao.rhb.dd.commons.ibg.format;

import net.tao.rhb.dd.commons.ibg.constant.PriorityCode;
import net.tao.rhb.dd.commons.ibg.constant.RecordType;
import org.springframework.batch.item.file.transform.Range;

public class FileHeaderFormat {
    public static final Range[] COLUMN_RANGES = new Range[]{
        new Range(1, 1), new Range(2, 3), new Range(4, 13), new Range(14, 23),
        new Range(24, 29), new Range(30, 33), new Range(34, 34), new Range(35, 37),
        new Range(38, 39), new Range(40, 40), new Range(41, 63), new Range(64, 86),
        new Range(87, 94)};

    public static final String[] COLUMN_NAMES = new String[]{
        "recordType", "priorityCode", "immediateDestination", "immediateOrigin",
        "fileCreationDate", "fileCreationTime", "fileIdModifier", "recordSize",
        "blockingFactor", "formatCode", "immediateDestinationName", "immediateOriginName",
        "referenceCode"};
    
    public RecordType recordType = RecordType.FILE_HEADER;

    public PriorityCode priorityCode = PriorityCode.DEFAULT;

    public String immediateDestination;

    public String immediateOrigin;

    public SimpleDate fileCreationDate = new SimpleDate();

    public SimpleTime fileCreationTime = new SimpleTime(0, 0);

    public String fileIdModifier;

    public long recordSize = 94;

    public long blockingFactor = 10;

    public long formatCode = 1;

    public String immediateDestinationName;

    public String immediateOriginName;

    public String referenceCode;

    /**
     * Non-IBG properties.
     */

    public String filename;


    @Override
    public String toString() {
        return "FileHeaderFormat{"
               + "recordType=" + recordType
               + ", priorityCode=" + priorityCode
               + ", immediateDestination='" + immediateDestination + '\''
               + ", immediateOrigin='" + immediateOrigin + '\''
               + ", fileCreationDate=" + fileCreationDate
               + ", fileCreationTime=" + fileCreationTime
               + ", fileIdModifier='" + fileIdModifier + '\''
               + ", recordSize=" + recordSize
               + ", blockingFactor=" + blockingFactor
               + ", formatCode=" + formatCode
               + ", immediateDestinationName='" + immediateDestinationName + '\''
               + ", immediateOriginName='" + immediateOriginName + '\''
               + ", referenceCode='" + referenceCode + '\''
               + ", filename='" + filename + '\''
               + '}';
    }
}
