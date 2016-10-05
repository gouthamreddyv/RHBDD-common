package net.tao.rhb.dd.commons.db;

public enum SequenceTable {
    TRACE_NUMBER("trace_number_seq"),
    
    IBG_FILE("ibg_file_seq"),
    
    IBG_FILE_BATCH("ibg_file_batch_seq"),
    
    IBG_FILE_ENTRY("ibg_file_entry_seq"),
    
    IBG_FIRST_ADDENDA("ibg_first_addenda_seq"),
    
    IBG_SECOND_ADDENDA("ibg_second_addenda_seq"),
    
    IBG_RETURN_ADDENDA("ibg_return_addenda_seq"),
    
    EAI_DD("eai_dd_seq");

    private final String sequenceName;

    SequenceTable(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public String sequenceName() {
        return sequenceName;
    }
}
