package net.tao.rhb.dd.commons.eai;

import net.tao.rhb.dd.commons.db.SequenceTable;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CustomSequenceGeneratorTest {

    private DataSource dataSource = dataSource();

    private CustomSequenceGenerator generator;

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    @Before
    public void beforeTest() {
        // Login ID (50): 806300-806349
        // Message Ref (9999): 1-9999
        generator = new CustomSequenceGeneratorBuilder()
                .startLoginId(806300)
                .endLoginId(806349)
                .startMessageRefNo(1)
                .endMessageRefNo(20)
                .dataSource(dataSource)
                .build();

       resetSequenceNumber(SequenceTable.EAI_DD, 1);
    }

    private void resetSequenceNumber(SequenceTable sequenceTable, int startingNo) {
        jdbcTemplate.update(String.format("drop sequence %s", sequenceTable.sequenceName()));

        jdbcTemplate.update(
                String.format("CREATE SEQUENCE %s INCREMENT BY 1 START WITH %s NOCACHE CYCLE",
                        sequenceTable.sequenceName(),
                        startingNo));
    }

    @Test
    public void getNextId_GenerateIdWithinLoginIdRange_CorrectIdGenerated() {
        long loginId = 0;
        long messageRefNo = 0;
        for (int count = 1; count <= 50; count++) {
            CustomSequenceGenerator.IdHolder idHolder = generator.getNextId();
            loginId = idHolder.getLoginId();
            messageRefNo = idHolder.getMessageRefNo();
        }
        assertThat(loginId, is(806349L));
        assertThat(messageRefNo, is(1L));
    }

    @Test
    public void getNextId_GenerateIdExceedLoginIdRange_LoginIdIsRecycledAndMessageRefNoIsIncreased() {
        long loginId = 0;
        long messageRefNo = 0;
        for (int count = 1; count <= 51; count++) {
            CustomSequenceGenerator.IdHolder idHolder = generator.getNextId();
            loginId = idHolder.getLoginId();
            messageRefNo = idHolder.getMessageRefNo();
        }
        assertThat(loginId, is(806300L));
        assertThat(messageRefNo, is(2L));
    }

    @Test
    public void getNextId_GenerateIdExceedLoginIdAndMsgRefNoRange_LoginIdAndMsgRefNumberAreRecycled() {
        long loginId = 0;
        long messageRefNo = 0;

        // Range for Message Ref No is 20; recycle to 1 once reached 21
        // Range for Login Id is 50; recycle to 806300 once reached 51
        final long runCount = (50 * 20) + 1;
        for (int count = 1; count <= runCount; count++) {
            CustomSequenceGenerator.IdHolder idHolder = generator.getNextId();
            loginId = idHolder.getLoginId();
            messageRefNo = idHolder.getMessageRefNo();
        }
        assertThat("<Login ID> should be recycled", loginId, is(806300L));
        assertThat("<Message Reference No> should be recycled", messageRefNo, is(1L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void InvalidLoginIDRangeProvided_ExceptionExpected() {
        generator = new CustomSequenceGeneratorBuilder()
                .startLoginId(100)
                .endLoginId(1)
                .startMessageRefNo(1)
                .endMessageRefNo(9999)
                .dataSource(dataSource)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void InvalidMessageRefNoRangeProvided_ExceptionExpected() {
        generator = new CustomSequenceGeneratorBuilder()
                .startLoginId(1)
                .endLoginId(10)
                .startMessageRefNo(99)
                .endMessageRefNo(9)
                .dataSource(dataSource)
                .build();
    }

    private DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .addScript("classpath:/org/springframework/batch/core/schema-drop-h2.sql")
                .addScript("classpath:/org/springframework/batch/core/schema-h2.sql")
                .addScript("classpath:/test-schema.sql")
                .addScript("classpath:/direct-debit-schema.sql")
                .continueOnError(true)
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }


}
