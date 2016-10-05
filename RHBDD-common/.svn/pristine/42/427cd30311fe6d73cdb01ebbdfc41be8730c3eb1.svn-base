package net.tao.rhb.dd.commons.ibg;

import net.tao.rhb.dd.commons.ibg.field.AccountTypeField;
import net.tao.rhb.dd.commons.ibg.field.AddendaInformationField;
import net.tao.rhb.dd.commons.ibg.field.AddendaRecordIndicatorField;
import net.tao.rhb.dd.commons.ibg.field.AddendaSequenceNumberField;
import net.tao.rhb.dd.commons.ibg.field.AddendaTypeField;
import net.tao.rhb.dd.commons.ibg.field.AmountField;
import net.tao.rhb.dd.commons.ibg.field.BatchControlEntryAddendaCountField;
import net.tao.rhb.dd.commons.ibg.field.BatchControlReservedField;
import net.tao.rhb.dd.commons.ibg.field.BatchCountField;
import net.tao.rhb.dd.commons.ibg.field.BatchNumberField;
import net.tao.rhb.dd.commons.ibg.field.BillerCodeField;
import net.tao.rhb.dd.commons.ibg.field.BillerNameField;
import net.tao.rhb.dd.commons.ibg.field.BlockCountField;
import net.tao.rhb.dd.commons.ibg.field.BlockingFactorField;
import net.tao.rhb.dd.commons.ibg.field.CheckDigitField;
import net.tao.rhb.dd.commons.ibg.field.CompanyDescriptiveDateField;
import net.tao.rhb.dd.commons.ibg.field.CompanyDiscretionaryDataField;
import net.tao.rhb.dd.commons.ibg.field.CompanyEntryDescriptionField;
import net.tao.rhb.dd.commons.ibg.field.CompanyIdentificationField;
import net.tao.rhb.dd.commons.ibg.field.CompanyNameField;
import net.tao.rhb.dd.commons.ibg.field.DateOfDeathField;
import net.tao.rhb.dd.commons.ibg.field.DebitRetryField;
import net.tao.rhb.dd.commons.ibg.field.DfiAccountNumberField;
import net.tao.rhb.dd.commons.ibg.field.DiscretionaryDataField;
import net.tao.rhb.dd.commons.ibg.field.EffectiveEntryDateField;
import net.tao.rhb.dd.commons.ibg.field.EntryDetailReservedField;
import net.tao.rhb.dd.commons.ibg.field.EntryDetailSequenceNumberField;
import net.tao.rhb.dd.commons.ibg.field.EntryHashField;
import net.tao.rhb.dd.commons.ibg.field.FeeAmountField;
import net.tao.rhb.dd.commons.ibg.field.FeeChargeTypeField;
import net.tao.rhb.dd.commons.ibg.field.Field;
import net.tao.rhb.dd.commons.ibg.field.FileControlEntryAddendaCountField;
import net.tao.rhb.dd.commons.ibg.field.FileControlReservedField;
import net.tao.rhb.dd.commons.ibg.field.FileCreationDateField;
import net.tao.rhb.dd.commons.ibg.field.FileCreationTimeField;
import net.tao.rhb.dd.commons.ibg.field.FileIdModifierField;
import net.tao.rhb.dd.commons.ibg.field.FirstAddendaReservedField;
import net.tao.rhb.dd.commons.ibg.field.FormatCodeField;
import net.tao.rhb.dd.commons.ibg.field.ImmediateDestinationField;
import net.tao.rhb.dd.commons.ibg.field.ImmediateDestinationNameField;
import net.tao.rhb.dd.commons.ibg.field.ImmediateOriginField;
import net.tao.rhb.dd.commons.ibg.field.ImmediateOriginNameField;
import net.tao.rhb.dd.commons.ibg.field.IndividualIdNumberField;
import net.tao.rhb.dd.commons.ibg.field.IndividualNameField;
import net.tao.rhb.dd.commons.ibg.field.MandateNumberField;
import net.tao.rhb.dd.commons.ibg.field.MessageAuthenticationCodeField;
import net.tao.rhb.dd.commons.ibg.field.NoOfAddendaRecordsField;
import net.tao.rhb.dd.commons.ibg.field.OriginalEntryTraceNumberField;
import net.tao.rhb.dd.commons.ibg.field.OriginatingDfiIdentificationField;
import net.tao.rhb.dd.commons.ibg.field.OriginatorStatusCodeField;
import net.tao.rhb.dd.commons.ibg.field.OtherPaymentDetailsField;
import net.tao.rhb.dd.commons.ibg.field.PriorityCodeField;
import net.tao.rhb.dd.commons.ibg.field.ReceivingDfiIdentificationField;
import net.tao.rhb.dd.commons.ibg.field.RecipientReferenceField;
import net.tao.rhb.dd.commons.ibg.field.RecordSizeField;
import net.tao.rhb.dd.commons.ibg.field.RecordTypeField;
import net.tao.rhb.dd.commons.ibg.field.ReferenceCodeField;
import net.tao.rhb.dd.commons.ibg.field.ReturnReasonCodeField;
import net.tao.rhb.dd.commons.ibg.field.SecondAddendaReservedField;
import net.tao.rhb.dd.commons.ibg.field.ServiceClassCodeField;
import net.tao.rhb.dd.commons.ibg.field.SettlementDateField;
import net.tao.rhb.dd.commons.ibg.field.StandardEntryClassCodeField;
import net.tao.rhb.dd.commons.ibg.field.TotalCreditEntryDollarAmountField;
import net.tao.rhb.dd.commons.ibg.field.TotalDebitEntryDollarAmountField;
import net.tao.rhb.dd.commons.ibg.field.TraceNumberField;
import net.tao.rhb.dd.commons.ibg.field.TransactionCodeField;
import net.tao.rhb.dd.commons.ibg.format.BatchControlFormat;
import net.tao.rhb.dd.commons.ibg.format.BatchHeaderFormat;
import net.tao.rhb.dd.commons.ibg.format.EntryDetailFormat;
import net.tao.rhb.dd.commons.ibg.format.FileControlFormat;
import net.tao.rhb.dd.commons.ibg.format.FileHeaderFormat;
import net.tao.rhb.dd.commons.ibg.format.FirstAddendaFormat;
import net.tao.rhb.dd.commons.ibg.format.ReturnAddendaFormat;
import net.tao.rhb.dd.commons.ibg.format.SecondAddendaFormat;
import org.apache.commons.lang3.StringUtils;

public class FieldFormatter {

    /**
     * Format the value based on the given field format.
     *
     * @param fieldClass the field class
     * @param value      the field value to be formatted
     * @param <T>        the type of the field
     */
    public <T> String format(Class<? extends Field<T>> fieldClass, T value) {
        Field<T> field;

        try {
            field = fieldClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String fieldName = FieldUtils.getName(field);

        String formattedValue = field.format(value);
        if (formattedValue.length() != field.length()) {
            throw new RuntimeException(String.format(
                    "Field(%s) '%s' has a formatted output of an invalid length: %s",
                    field.length(),
                    fieldName,
                    formattedValue));
        }

        return formattedValue;
    }

    /**
     * Format the Batch Header in fixed length format.
     *
     * @param batchHeader format of Batch Header
     * @return Batch Header in fixed length format
     */
    public String formatBatchHeader(final BatchHeaderFormat batchHeader) {
        return format(RecordTypeField.class, batchHeader.recordType)
               + format(ServiceClassCodeField.class, batchHeader.serviceClassCode)
               + format(CompanyNameField.class, batchHeader.companyName)
               + format(CompanyDiscretionaryDataField.class, batchHeader.companyDiscretionaryData)
               + format(CompanyIdentificationField.class, batchHeader.companyIdentification)
               + format(StandardEntryClassCodeField.class, batchHeader.standardEntryClassCode)
               + format(CompanyEntryDescriptionField.class, batchHeader.companyEntryDescription)
               + format(CompanyDescriptiveDateField.class, batchHeader.companyDescriptiveDate)
               + format(EffectiveEntryDateField.class, batchHeader.effectiveEntryDate)
               + format(SettlementDateField.class, batchHeader.settlementDate)
               + format(OriginatorStatusCodeField.class, batchHeader.originatorStatusCode)
               + format(OriginatingDfiIdentificationField.class,
                batchHeader.originatingDfiIdentification)
               + format(BatchNumberField.class, batchHeader.batchNumber);
    }

    /**
     * Format the Entry Detail in fixed length format.
     *
     * @param entry the Entry Detail to be formatted
     * @return Entry Detail in fixed length format
     */
    public String formatEntryDetail(final EntryDetailFormat entry) {
        return format(RecordTypeField.class, entry.recordType)
               + format(TransactionCodeField.class, entry.transactionCode)
               + format(ReceivingDfiIdentificationField.class, entry.receivingDfiIdentification)
               + format(CheckDigitField.class, entry.checkDigit)
               + format(DfiAccountNumberField.class, entry.dfiAccountNumber)
               + format(AmountField.class, entry.amount)
               + format(IndividualIdNumberField.class, entry.individualIdNumber)
               + format(NoOfAddendaRecordsField.class, entry.noOfAddendaRecords)
               + format(IndividualNameField.class, entry.individualName)
               + format(EntryDetailReservedField.class, entry.reserved)
               + format(DiscretionaryDataField.class, entry.discretionaryData)
               + format(AddendaRecordIndicatorField.class, entry.addendaRecordIndicator)
               + format(TraceNumberField.class, entry.traceNumber);
    }

    /**
     * Format the First Addenda in fixed length format.
     *
     * @param firstAddenda the First Addenda to be formatted
     * @return First Addenda in fixed length format
     */
    public String formatFirstAddenda(final FirstAddendaFormat firstAddenda) {
        return format(RecordTypeField.class, firstAddenda.recordType)
               + format(AddendaTypeField.class, firstAddenda.addendaType)
               + format(BillerNameField.class, firstAddenda.billerName)
               + format(BillerCodeField.class, firstAddenda.billerCode)
               + format(MandateNumberField.class, firstAddenda.mandateNumber)
               + format(DebitRetryField.class, firstAddenda.debitRetry)
               + format(AccountTypeField.class, firstAddenda.accountType)
               + format(FeeAmountField.class, firstAddenda.feeAmount)
               + format(FeeChargeTypeField.class, firstAddenda.feeChargeType)
               + format(FirstAddendaReservedField.class, firstAddenda.reserved)
               + format(AddendaSequenceNumberField.class, firstAddenda.addendaSequenceNumber)
               + format(EntryDetailSequenceNumberField.class,
                firstAddenda.entryDetailSequenceNumber);
    }

    /**
     * Format the Second Addenda in fixed length format.
     *
     * @param secondAddenda the Second Addenda to be formatted
     * @return First Addenda in fixed length format
     */
    public String formatSecondAddenda(final SecondAddendaFormat secondAddenda) {
        return format(RecordTypeField.class, secondAddenda.recordType)
               + format(AddendaTypeField.class, secondAddenda.addendaType)
               + format(OtherPaymentDetailsField.class, secondAddenda.otherPaymentDetails)
               + format(RecipientReferenceField.class, secondAddenda.recipientReference)
               + format(SecondAddendaReservedField.class, secondAddenda.reserved)
               + format(AddendaSequenceNumberField.class, secondAddenda.addendaSequenceNumber)
               + format(EntryDetailSequenceNumberField.class,
                secondAddenda.entryDetailSequenceNumber);
    }

    /**
     * Format the Return Addenda in fixed length format.
     *
     * @param returnAddenda the Return Added to be formatted
     * @return Return Addenda in fixed length format
     */
    public String formatReturnAddenda(final ReturnAddendaFormat returnAddenda) {
        return format(RecordTypeField.class, returnAddenda.recordType)
               + format(AddendaTypeField.class, returnAddenda.addendaType)
               + format(ReturnReasonCodeField.class, returnAddenda.returnReasonCode)
               + format(OriginalEntryTraceNumberField.class, returnAddenda.originalEntryTraceNumber)
               + format(DateOfDeathField.class, returnAddenda.dateOfDeath)
               + format(OriginatingDfiIdentificationField.class,
                returnAddenda.originalReceivingFiIdentification)
               + format(BillerCodeField.class, returnAddenda.billerCode)
               + format(RecipientReferenceField.class, returnAddenda.recipientReference)
               + format(DebitRetryField.class, returnAddenda.debitRetry)
               + format(AccountTypeField.class, returnAddenda.accountType)
               + format(AddendaInformationField.class, returnAddenda.addendaInformation)
               + format(TraceNumberField.class, returnAddenda.traceNumber);

    }

    /**
     * Format the Batch Control in fixed length format.
     *
     * @param controlFormat the Batch Control to be formatted
     * @return Batch Control in fixed length format
     */
    public String formatBatchControl(BatchControlFormat controlFormat) {
        return format(RecordTypeField.class, controlFormat.recordType)
               + format(ServiceClassCodeField.class, controlFormat.serviceClassCode)
               + format(BatchControlEntryAddendaCountField.class, controlFormat.entryAddendaCount)
               + format(EntryHashField.class, controlFormat.entryHash)
               + format(TotalDebitEntryDollarAmountField.class,
                controlFormat.totalDebitEntryDollarAmount)
               + format(TotalCreditEntryDollarAmountField.class,
                controlFormat.totalCreditEntryDollarAmount)
               + format(CompanyIdentificationField.class, controlFormat.companyIdentification)
               + format(MessageAuthenticationCodeField.class,
                controlFormat.messageAuthenticationCode)
               + format(BatchControlReservedField.class, controlFormat.reserved)
               + format(OriginatingDfiIdentificationField.class,
                controlFormat.originatingDfiIdentification)
               + format(BatchNumberField.class, controlFormat.batchNumber);
    }

    /**
     * Format the File Header in fixed length format.
     *
     * @param fileHeader the File Header to be formatted
     * @return File Header in fixed length format
     */
    public String formatFileHeader(FileHeaderFormat fileHeader) {
        return format(RecordTypeField.class, fileHeader.recordType)
               + format(PriorityCodeField.class, fileHeader.priorityCode)
               + format(ImmediateDestinationField.class, fileHeader.immediateDestination)
               + format(ImmediateOriginField.class, fileHeader.immediateOrigin)
               + format(FileCreationDateField.class, fileHeader.fileCreationDate)
               + format(FileCreationTimeField.class, fileHeader.fileCreationTime)
               + format(FileIdModifierField.class, fileHeader.fileIdModifier)
               + format(RecordSizeField.class, fileHeader.recordSize)
               + format(BlockingFactorField.class, fileHeader.blockingFactor)
               + format(FormatCodeField.class, fileHeader.formatCode)
               + format(ImmediateDestinationNameField.class, fileHeader.immediateDestinationName)
               + format(ImmediateOriginNameField.class, fileHeader.immediateOriginName)
               + format(ReferenceCodeField.class, fileHeader.referenceCode);
    }

    /**
     * Format the File Control in fixed length format.
     *
     * @param fileControl the File Control to be formatted
     * @return File Control in fixed length format
     */
    public String formatFileControl(FileControlFormat fileControl) {
        return format(RecordTypeField.class, fileControl.recordType)
               + format(BatchCountField.class, fileControl.batchCount)
               + format(BlockCountField.class, fileControl.blockCount)
               + format(FileControlEntryAddendaCountField.class, fileControl.entryAddendaCount)
               + format(EntryHashField.class, fileControl.entryHash)
               + format(TotalDebitEntryDollarAmountField.class,
                fileControl.totalDebitEntryDollarAmountInFile)
               + format(TotalCreditEntryDollarAmountField.class,
                fileControl.totalCreditEntryDollarAmountInFile)
               + format(FileControlReservedField.class, fileControl.reserved);
    }

    /**
     * Any unused portions of the remaining block must be padded with '9' characters.
     *
     * @param totalLinesWritten total lines written
     * @return one or more lines that padded with '9' characters
     */
    public String paddingWith9Characters(long totalLinesWritten,
                                         int blockingFactor,
                                         int recordSize,
                                         String lineSeparator) {
        if (totalLinesWritten % blockingFactor != 0) {
            StringBuilder lines = new StringBuilder(lineSeparator);

            long neededRows = blockingFactor - (totalLinesWritten % blockingFactor);
            String line = StringUtils.leftPad("", recordSize, "9") + lineSeparator;

            for (int count = 0; count < neededRows; ++count) {
                lines.append(line);
            }
            return lines.toString();
        } else {
            return "";
        }

    }
}
