package net.tao.rhb.dd.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import net.tao.rhb.dd.commons.config.TestDataSourceConfiguration;
import net.tao.rhb.dd.commons.constant.AccountType;
import net.tao.rhb.dd.commons.ibg.constant.AddendaType;
import net.tao.rhb.dd.commons.ibg.constant.CompanyEntryDescription;
import net.tao.rhb.dd.commons.ibg.constant.FeeChargeType;
import net.tao.rhb.dd.commons.ibg.constant.PriorityCode;
import net.tao.rhb.dd.commons.ibg.constant.RecordType;
import net.tao.rhb.dd.commons.ibg.constant.ServiceClassCode;
import net.tao.rhb.dd.commons.ibg.constant.StandardEntryClassCode;
import net.tao.rhb.dd.commons.ibg.constant.TransactionCode;
import net.tao.rhb.dd.commons.ibg.format.BatchHeaderFormat;
import net.tao.rhb.dd.commons.ibg.format.EntryDetailFormat;
import net.tao.rhb.dd.commons.ibg.format.FileHeaderFormat;
import net.tao.rhb.dd.commons.ibg.format.FirstAddendaFormat;
import net.tao.rhb.dd.commons.ibg.format.ReturnAddendaFormat;
import net.tao.rhb.dd.commons.ibg.format.SecondAddendaFormat;
import net.tao.rhb.dd.commons.ibg.format.SimpleDate;
import net.tao.rhb.dd.commons.ibg.format.SimpleTime;
import net.tao.rhb.dd.commons.ibg.format.TraceNumber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.sql.DataSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration({
        TestDataSourceConfiguration.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("/data/reset-dataSet.xml")
public class JdbcIbgFileDaoTest {
    @Autowired
    private DataSource dataSource;

    private JdbcIbgFileDao dao;

    @Before
    public void beforeTest() {
        dao = new JdbcIbgFileDao();
        dao.setDataSource(dataSource);
    }

    @Test
    @ExpectedDatabase(value = "/data/JdbcIbgFileDaoTest-expectedDataSet1.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void addIbgFile_IbgFileRecordPersisted() {
        long ibgFileId = dao.addIbgFile(createFileHeaderFormat());
        assertThat("IBG File ID is not generated", ibgFileId, is(greaterThan(0L)));
    }

    @Test
    @ExpectedDatabase(value = "/data/JdbcIbgFileDaoTest-expectedDataSet2.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void addIbgFileBatch_IbgFileBatchRecordPersisted() {
        long ibgFileId = dao.addIbgFile(createFileHeaderFormat());

        long ibgFileBatchId = dao.addIbgFileBatch(createBatchHeaderFormat(ibgFileId));
        assertThat("IBG Batch ID is not generated", ibgFileBatchId, is(greaterThan(0L)));
    }

    @Test
    @ExpectedDatabase(value = "/data/JdbcIbgFileDaoTest-expectedDataSet3.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void addIbgFileEntry_IbgFileEntryRecordPersisted() {
        long ibgFileId = dao.addIbgFile(createFileHeaderFormat());
        long ibgFileBatchId = dao.addIbgFileBatch(createBatchHeaderFormat(ibgFileId));

        // first entry
        long ibgFileEntryId = dao.addIbgFileEntry(createEntryDetailFormat(ibgFileBatchId));
        assertThat("IBG File Entry ID is not generated", ibgFileEntryId, is(greaterThan(0L)));

        // second entry
        ibgFileEntryId = dao.addIbgFileEntry(createEntryDetailFormat(ibgFileBatchId));
        assertThat("IBG File Entry ID is not generated", ibgFileEntryId, is(greaterThan(0L)));
    }

    @Test
    @ExpectedDatabase(value = "/data/JdbcIbgFileDaoTest-expectedDataSet4.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void addIbgFirstAddenda_IbgFirstAddendaRecordPersisted() {
        long ibgFileId = dao.addIbgFile(createFileHeaderFormat());
        long ibgFileBatchId = dao.addIbgFileBatch(createBatchHeaderFormat(ibgFileId));
        long ibgFileEntryId = dao.addIbgFileEntry(createEntryDetailFormat(ibgFileBatchId));

        long ibgFirstAddendaId = dao.addIbgFirstAddenda(createFirstAddendaFormat(ibgFileEntryId));
        assertThat("IBG First Addenda ID is not generated", ibgFirstAddendaId, is(greaterThan(0L)));
    }

    @Test
    @ExpectedDatabase(value = "/data/JdbcIbgFileDaoTest-expectedDataSet5.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void addIbgSecondAddenda_IbgSecondAddendaRecordPersisted() {
        long ibgFileId = dao.addIbgFile(createFileHeaderFormat());
        long ibgFileBatchId = dao.addIbgFileBatch(createBatchHeaderFormat(ibgFileId));
        long ibgFileEntryId = dao.addIbgFileEntry(createEntryDetailFormat(ibgFileBatchId));
        dao.addIbgFirstAddenda(createFirstAddendaFormat(ibgFileEntryId));

        long ibgSecondAddendaId = dao.addIbgSecondAddenda(createSecondAddendaFormat(ibgFileEntryId));
        assertThat("IBG Second Addenda ID is not generated", ibgSecondAddendaId, is(greaterThan(0L)));
    }

    @Test
    @ExpectedDatabase(value = "/data/JdbcIbgFileDaoTest-expectedDataSet6.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void addIbgReturnAddenda_ReturnAddendaPersisted() {
        long ibgFileId = dao.addIbgFile(createFileHeaderFormat());
        long ibgFileBatchId = dao.addIbgFileBatch(createBatchHeaderFormat(ibgFileId));
        long ibgFileEntryId = dao.addIbgFileEntry(createEntryDetailFormat(ibgFileBatchId));

        long ibgReturnAddendaId = dao.addIbgReturnAddenda(createReturnAddendaFormat(ibgFileEntryId));
        assertThat("Return Addenda ID is not generated", ibgReturnAddendaId, is(greaterThan(0L)));
    }

    private ReturnAddendaFormat createReturnAddendaFormat(long ibgFileEntryId) {
        ReturnAddendaFormat returnAddenda = new ReturnAddendaFormat();
        returnAddenda.recordType = RecordType.ENTRY_ADDENDA;
        returnAddenda.addendaType = AddendaType.RETURN;
        returnAddenda.returnReasonCode = "R00";
        returnAddenda.originalEntryTraceNumber = "10000123456";
        returnAddenda.dateOfDeath = "";
        returnAddenda.originalReceivingFiIdentification = "100000123";
        returnAddenda.billerCode = "SE123455";
        returnAddenda.recipientReference = "PRN-123455";
        returnAddenda.debitRetry = 4;
        returnAddenda.accountType = AccountType.SAVING_ACCOUNT;
        returnAddenda.addendaInformation = "";
        returnAddenda.traceNumber = new TraceNumber("123456781234567");
        returnAddenda.ibgFileEntryId = ibgFileEntryId;
        return returnAddenda;
    }

    private SecondAddendaFormat createSecondAddendaFormat(long ibgFileEntryId) {
        SecondAddendaFormat secondAddenda = new SecondAddendaFormat();
        secondAddenda.recordType = RecordType.ENTRY_ADDENDA;
        secondAddenda.addendaType = AddendaType.DEFAULT;
        secondAddenda.otherPaymentDetails = "Order-01";
        secondAddenda.recipientReference = "PRN-01";
        secondAddenda.reserved = "";
        secondAddenda.addendaSequenceNumber = 2;
        secondAddenda.entryDetailSequenceNumber = 2;
        secondAddenda.ibgFileEntryId = ibgFileEntryId;
        return secondAddenda;
    }

    private FirstAddendaFormat createFirstAddendaFormat(long ibgFileEntryId) {
        FirstAddendaFormat firstAddenda = new FirstAddendaFormat();
        firstAddenda.ibgFileEntryId = ibgFileEntryId;
        firstAddenda.recordType = RecordType.ENTRY_ADDENDA;
        firstAddenda.addendaType = AddendaType.DEFAULT;
        firstAddenda.billerName = "Test Biller A";
        firstAddenda.billerCode = "SE009";
        firstAddenda.mandateNumber = "MN-RHB-TEST-0001";
        firstAddenda.debitRetry = 4;
        firstAddenda.accountType = AccountType.CREDIT_ACCOUNT;
        firstAddenda.feeAmount = 0;
        firstAddenda.feeChargeType = FeeChargeType.CHARGE_BILLER;
        firstAddenda.reserved = "";
        firstAddenda.addendaSequenceNumber = 1;
        firstAddenda.entryDetailSequenceNumber = 2;
        return firstAddenda;
    }

    private EntryDetailFormat createEntryDetailFormat(long ibgFileBatchId) {
        EntryDetailFormat entryDetail = new EntryDetailFormat();
        entryDetail.recordType = RecordType.ENTRY_DETAIL;
        entryDetail.transactionCode = TransactionCode.DEBIT_NORMAL;
        entryDetail.receivingDfiIdentification = "12345678";
        entryDetail.checkDigit = 9;
        entryDetail.dfiAccountNumber = "20001345667";
        entryDetail.amount = 21050;
        entryDetail.individualIdNumber = "810908084567";
        entryDetail.noOfAddendaRecords = 2;
        entryDetail.individualName = "Tester 1";
        entryDetail.reserved = "";
        entryDetail.discretionaryData = "01";
        entryDetail.addendaRecordIndicator = true;
        entryDetail.traceNumber = new TraceNumber("123456780123456");
        entryDetail.ibgFileBatchId = ibgFileBatchId;

        return entryDetail;
    }


    private BatchHeaderFormat createBatchHeaderFormat(long ibgFileId) {
        BatchHeaderFormat batchHeader = new BatchHeaderFormat();
        batchHeader.recordType = RecordType.BATCH_HEADER;
        batchHeader.serviceClassCode = ServiceClassCode.DEBIT_ONLY;
        batchHeader.companyName = "HLBB";
        batchHeader.companyDiscretionaryData = "00";
        batchHeader.companyIdentification = "10000344";
        batchHeader.standardEntryClassCode = StandardEntryClassCode.CTX;
        batchHeader.companyEntryDescription = CompanyEntryDescription.IBG_DD;
        batchHeader.companyDescriptiveDate = new SimpleDate(16, 3, 21);
        batchHeader.effectiveEntryDate = new SimpleDate(16, 3, 21);
        batchHeader.settlementDate = "000";
        batchHeader.originatorStatusCode = "1";
        batchHeader.originatingDfiIdentification = "100000211";
        batchHeader.batchNumber = 1L;
        batchHeader.ibgFileId = ibgFileId;

        return batchHeader;
    }

    private FileHeaderFormat createFileHeaderFormat() {
        FileHeaderFormat fileHeader = new FileHeaderFormat();
        fileHeader.recordType = RecordType.FILE_HEADER;
        fileHeader.priorityCode = PriorityCode.DEFAULT;
        fileHeader.immediateDestination = "1000211";
        fileHeader.immediateOrigin = "1000411";
        fileHeader.fileCreationDate = new SimpleDate(16, 3, 21);
        fileHeader.fileCreationTime = new SimpleTime(7, 0);
        fileHeader.fileIdModifier = "C";
        fileHeader.recordSize = 94;
        fileHeader.blockingFactor = 10;
        fileHeader.formatCode = 1;
        fileHeader.immediateDestinationName = "MyClear";
        fileHeader.immediateOriginName = "RHB";
        fileHeader.referenceCode = "123";
        fileHeader.filename = "dnc0321070001.txt";

        return fileHeader;
    }
}
