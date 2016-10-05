package net.tao.rhb.dd.dao;

import net.tao.rhb.dd.commons.db.SequenceTable;
import net.tao.rhb.dd.commons.ibg.format.BatchHeaderFormat;
import net.tao.rhb.dd.commons.ibg.format.EntryDetailFormat;
import net.tao.rhb.dd.commons.ibg.format.FileHeaderFormat;
import net.tao.rhb.dd.commons.ibg.format.FirstAddendaFormat;
import net.tao.rhb.dd.commons.ibg.format.ReturnAddendaFormat;
import net.tao.rhb.dd.commons.ibg.format.SecondAddendaFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.HashMap;
import java.util.Map;

public class JdbcIbgFileDao
        extends NamedParameterJdbcDaoSupport
        implements IbgFileDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public long addIbgFile(FileHeaderFormat fileHeaderFormat) {
        String sequenceSql = generateSequenceSql(SequenceTable.IBG_FILE);
        //language=SQL
        final String sql =
                "INSERT INTO ibg_file (ibg_file_id"
                + ", filename, rec_type_code"
                + ", priority_code, immediate_destination, immediate_origin"
                + ", file_creation_date, file_creation_time, file_id_modifier"
                + ", record_size, blocking_factor, format_code"
                + ", immediate_destination_name, immediate_origin_name, reference_code)"
                + " VALUES (" + sequenceSql
                + ", :filename, :rec_type_code"
                + ", :priority_code, :immediate_destination, :immediate_origin"
                + ", :file_creation_date, :file_creation_time, :file_id_modifier"
                + ", :record_size, :blocking_factor, :format_code"
                + ", :immediate_destination_name, :immediate_origin_name, :reference_code)";

        Map<String, Object> params = new HashMap<>();
        params.put("filename", fileHeaderFormat.filename);
        params.put("rec_type_code", fileHeaderFormat.recordType.value());

        params.put("priority_code", fileHeaderFormat.priorityCode.value());
        params.put("immediate_destination", fileHeaderFormat.immediateDestination);
        params.put("immediate_origin", fileHeaderFormat.immediateOrigin);

        params.put("file_creation_date", fileHeaderFormat.fileCreationDate.toString());
        params.put("file_creation_time", fileHeaderFormat.fileCreationTime.toString());
        params.put("file_id_modifier", fileHeaderFormat.fileIdModifier);

        params.put("record_size", fileHeaderFormat.recordSize);
        params.put("blocking_factor", fileHeaderFormat.blockingFactor);
        params.put("format_code", fileHeaderFormat.formatCode);

        params.put("immediate_destination_name", fileHeaderFormat.immediateDestinationName);
        params.put("immediate_origin_name", fileHeaderFormat.immediateOriginName);
        params.put("reference_code", fileHeaderFormat.referenceCode);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        insert(sql, new MapSqlParameterSource(params), keyHolder, "ibg_file_id");

        return keyHolder.getKey().longValue();

    }

    @Override
    public long addIbgFileBatch(BatchHeaderFormat batchHeaderFormat) {
        String sequenceSql = generateSequenceSql(SequenceTable.IBG_FILE_BATCH);
        //language=SQL
        final String sql =
                "INSERT INTO ibg_file_batch(ibg_file_batch_id, ibg_file_id"
                + ", rec_type_code, service_class_code, company_name"
                + ", company_discretionary_data, company_identification"
                + ", standard_entry_class_code, company_entry_description"
                + ", company_descriptive_date, effective_entry_date, settlement_date"
                + ", originator_status_code, originating_fi_identification, batch_number)"
                + " VALUES (" + sequenceSql
                + ", :ibg_file_id"
                + ", :rec_type_code, :service_class_code, :company_name"
                + ", :company_discretionary_data, :company_identification"
                + ", :standard_entry_class_code, :company_entry_description"
                + ", :company_descriptive_date, :effective_entry_date, :settlement_date"
                + ", :originator_status_code, :originating_fi_identification, :batch_number)";

        Map<String, Object> params = new HashMap<>();
        params.put("ibg_file_id", batchHeaderFormat.ibgFileId);
        params.put("rec_type_code", batchHeaderFormat.recordType.value());
        params.put("service_class_code", batchHeaderFormat.serviceClassCode.value());
        params.put("company_name", batchHeaderFormat.companyName);
        params.put("company_discretionary_data", batchHeaderFormat.companyDiscretionaryData);
        params.put("company_identification", batchHeaderFormat.companyIdentification);
        params.put("standard_entry_class_code",
                batchHeaderFormat.standardEntryClassCode.toString());
        params.put("company_entry_description", batchHeaderFormat.companyEntryDescription.value());
        params.put("company_descriptive_date", batchHeaderFormat.companyDescriptiveDate.toString());
        params.put("effective_entry_date", batchHeaderFormat.effectiveEntryDate.toString());
        params.put("settlement_date", batchHeaderFormat.settlementDate);
        params.put("originator_status_code", batchHeaderFormat.originatorStatusCode);
        params.put("originating_fi_identification", batchHeaderFormat.originatingDfiIdentification);
        params.put("batch_number", batchHeaderFormat.batchNumber);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        insert(sql, new MapSqlParameterSource(params), keyHolder, "ibg_file_batch_id");

        return keyHolder.getKey().longValue();
    }

    @Override
    public long addIbgFileEntry(EntryDetailFormat entryDetailFormat) {
        String sequenceSql = generateSequenceSql(SequenceTable.IBG_FILE_ENTRY);

        //language=SQL
        final String sql =
                "INSERT INTO IBG_FILE_ENTRY(ibg_file_entry_id"
                + ", ibg_file_batch_id"
                + ", rec_type_code, transaction_code, receiving_fi_identification"
                + ", check_digit, rfi_account_number, amount_in_cent, individual_id_number"
                + ", no_of_addenda_records, individual_name, reserved, discretionary_data"
                + ", addenda_records_indicator, trace_number)"
                + " VALUES (" + sequenceSql
                + ", :ibg_file_batch_id"
                + ", :rec_type_code, :transaction_code, :receiving_fi_identification"
                + ", :check_digit, :rfi_account_number, :amount_in_cent, :individual_id_number"
                + ", :no_of_addenda_records, :individual_name, :reserved, :discretionary_data"
                + ", :addenda_records_indicator, :trace_number)";

        Map<String, Object> params = new HashMap<>();
        params.put("ibg_file_batch_id", entryDetailFormat.ibgFileBatchId);
        params.put("rec_type_code", entryDetailFormat.recordType.value());
        params.put("transaction_code", entryDetailFormat.transactionCode.value());
        params.put("receiving_fi_identification", entryDetailFormat.receivingDfiIdentification);
        params.put("check_digit", entryDetailFormat.checkDigit);
        params.put("rfi_account_number", entryDetailFormat.dfiAccountNumber);
        params.put("amount_in_cent", entryDetailFormat.amount);
        params.put("individual_id_number", entryDetailFormat.individualIdNumber);
        params.put("no_of_addenda_records", entryDetailFormat.noOfAddendaRecords);
        params.put("individual_name", entryDetailFormat.individualName);
        params.put("reserved", entryDetailFormat.reserved);
        params.put("discretionary_data", entryDetailFormat.discretionaryData);
        params.put("addenda_records_indicator", entryDetailFormat.addendaRecordIndicator ? 1 : 0);
        params.put("trace_number", entryDetailFormat.traceNumber.toString());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        insert(sql, new MapSqlParameterSource(params), keyHolder, "ibg_file_entry_id");

        return keyHolder.getKey().longValue();
    }

    @Override
    public long addIbgFirstAddenda(FirstAddendaFormat firstAddendaFormat) {
        String sequenceSql = generateSequenceSql(SequenceTable.IBG_FIRST_ADDENDA);
        //language=SQL
        final String sql =
                "INSERT INTO ibg_first_addenda(ibg_first_addenda_id"
                + ", ibg_file_entry_id"
                + ", rec_type_code, addenda_type_code, biller_name"
                + ", biller_code, mandate_number, debit_retry"
                + ", account_type, fee_amount_in_cent, fee_charge_type"
                + ", reserved, addenda_sequence_number, entry_detail_sequence_number)"
                + " VALUES (" + sequenceSql
                + ", :ibg_file_entry_id"
                + ", :rec_type_code, :addenda_type_code, :biller_name"
                + ", :biller_code, :mandate_number, :debit_retry"
                + ", :account_type, :fee_amount_in_cent, :fee_charge_type"
                + ", :reserved, :addenda_sequence_number, :entry_detail_sequence_number)";

        Map<String, Object> params = new HashMap<>();
        params.put("ibg_file_entry_id", firstAddendaFormat.ibgFileEntryId);
        params.put("rec_type_code", firstAddendaFormat.recordType.value());
        params.put("addenda_type_code", firstAddendaFormat.addendaType.value());
        params.put("biller_name", firstAddendaFormat.billerName);
        params.put("biller_code", firstAddendaFormat.billerCode);
        params.put("mandate_number", firstAddendaFormat.mandateNumber);
        params.put("debit_retry", firstAddendaFormat.debitRetry);
        params.put("account_type", firstAddendaFormat.accountType.value());
        params.put("fee_amount_in_cent", firstAddendaFormat.feeAmount);
        params.put("fee_charge_type", firstAddendaFormat.feeChargeType.value());
        params.put("reserved", firstAddendaFormat.reserved);
        params.put("addenda_sequence_number", firstAddendaFormat.addendaSequenceNumber);
        params.put("entry_detail_sequence_number", firstAddendaFormat.entryDetailSequenceNumber);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        insert(sql, new MapSqlParameterSource(params), keyHolder, "ibg_first_addenda_id");

        return keyHolder.getKey().longValue();

    }

    @Override
    public long addIbgSecondAddenda(SecondAddendaFormat secondAddendaFormat) {
        String sequenceSql = generateSequenceSql(SequenceTable.IBG_SECOND_ADDENDA);

        // language=SQL
        final String sql = "INSERT INTO ibg_second_addenda (ibg_second_addenda_id"
                           + ", ibg_file_entry_id, rec_type_code, addenda_type_code"
                           + ", other_payment_details, recipient_reference, reserved"
                           + ", addenda_sequence_number, entry_detail_sequence_number)"
                           + " VALUES (" + sequenceSql
                           + ", :ibg_file_entry_id, :rec_type_code, :addenda_type_code"
                           + ", :other_payment_details, :recipient_reference, :reserved"
                           + ", :addenda_sequence_number, :entry_detail_sequence_number)";

        Map<String, Object> params = new HashMap<>();
        params.put("ibg_file_entry_id", secondAddendaFormat.ibgFileEntryId);
        params.put("rec_type_code", secondAddendaFormat.recordType.value());
        params.put("addenda_type_code", secondAddendaFormat.addendaType.value());
        params.put("other_payment_details", secondAddendaFormat.otherPaymentDetails);
        params.put("recipient_reference", secondAddendaFormat.recipientReference);
        params.put("reserved", secondAddendaFormat.reserved);
        params.put("addenda_sequence_number", secondAddendaFormat.addendaSequenceNumber);
        params.put("entry_detail_sequence_number", secondAddendaFormat.entryDetailSequenceNumber);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        insert(sql, new MapSqlParameterSource(params), keyHolder, "ibg_second_addenda_id");

        return keyHolder.getKey().longValue();
    }

    @Override
    public long addIbgReturnAddenda(ReturnAddendaFormat returnAddendaFormat) {
        String sequenceSql = generateSequenceSql(SequenceTable.IBG_RETURN_ADDENDA);

        // language=SQL
        final String sql = "INSERT INTO ibg_return_addenda(ibg_return_addenda_id"
                           + ", ibg_file_entry_id, rec_type_code, addenda_type_code"
                           + ", return_reason_code"
                           + ", original_entry_trace_number, date_of_death"
                           + ", original_rfi_identification"
                           + ", biller_code, recipient_reference, debit_retry"
                           + ", account_type, addenda_information, trace_number)"
                           + " VALUES (" + sequenceSql
                           + ", :ibg_file_entry_id, :rec_type_code, :addenda_type_code"
                           + ", :return_reason_code"
                           + ", :original_entry_trace_number, :date_of_death"
                           + ", :original_rfi_identification"
                           + ", :biller_code, :recipient_reference, :debit_retry"
                           + ", :account_type, :addenda_information, :trace_number)";

        Map<String, Object> params = new HashMap<>();
        params.put("ibg_file_entry_id", returnAddendaFormat.ibgFileEntryId);
        params.put("rec_type_code", returnAddendaFormat.recordType.value());
        params.put("addenda_type_code", returnAddendaFormat.addendaType.value());
        params.put("return_reason_code", returnAddendaFormat.returnReasonCode);
        params.put("original_entry_trace_number", returnAddendaFormat.originalEntryTraceNumber);
        params.put("date_of_death", returnAddendaFormat.dateOfDeath);
        params.put("original_rfi_identification",
                returnAddendaFormat.originalReceivingFiIdentification);
        params.put("biller_code", returnAddendaFormat.billerCode);
        params.put("recipient_reference", returnAddendaFormat.recipientReference);
        params.put("debit_retry", returnAddendaFormat.debitRetry);
        params.put("account_type", returnAddendaFormat.accountType.value());
        params.put("addenda_information", returnAddendaFormat.addendaInformation);
        params.put("trace_number", returnAddendaFormat.traceNumber.toString());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        insert(sql, new MapSqlParameterSource(params), keyHolder, "ibg_return_addenda_id");

        return keyHolder.getKey().longValue();
    }

    private String generateSequenceSql(SequenceTable sequenceTable) {
        return sequenceTable.sequenceName() + ".nextval";
    }

    private int insert(String sql, MapSqlParameterSource params,
                       KeyHolder keyHolder, String keyColumnName) {

        int updatedRows = getNamedParameterJdbcTemplate().update(sql,
                params,
                keyHolder,
                new String[]{keyColumnName});

        if (updatedRows != 1) {
            logger.error("Failed to insert records: SQL[{}], Params[{}]", sql, params);
        }

        logger.debug("Total affected row [{}], SQL:[{}], Params:[{}]",
                updatedRows, sql, params.getValues());

        return updatedRows;
    }
}
