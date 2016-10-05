package net.tao.rhb.dd.commons.eai;

import net.tao.rhb.dd.commons.db.SequenceTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * This is utility to generate <code>Login ID</code>
 * and <code>Message Reference Number</code> for RHB EAI.
 */
public class CustomSequenceGenerator {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final long startLoginId;
    private final long startMessageRefNo;
    private final JdbcTemplate jdbcTemplate;

    private final long totalLoginIdRange;
    private final long totalMessageRefNoRange;

    /**
     * Default constructor with all required parameters.
     *
     * @param startLoginId      starting number for Login ID
     * @param endLoginId        ending number for Login ID
     * @param startMessageRefNo starting number for Message Reference No
     * @param endMessageRefNo   ending number for Message Reference No
     * @param dataSource        the data source (database)
     */
    public CustomSequenceGenerator(long startLoginId, long endLoginId, long startMessageRefNo,
                                   long endMessageRefNo, DataSource dataSource) {
        if (startLoginId >= endLoginId) {
            throw new IllegalArgumentException(String.format(
                    "startLoginId is larger or equal to endLoginId: %s >= %s",
                    startLoginId, endLoginId));
        }

        if (startMessageRefNo >= endMessageRefNo) {
            throw new IllegalArgumentException(String.format(
                    "startMessageRefNo is larger or equal to endMessageRefNo: %s >= %s",
                    startMessageRefNo, endMessageRefNo));
        }

        this.startLoginId = startLoginId;
        this.startMessageRefNo = startMessageRefNo;
        this.jdbcTemplate = new JdbcTemplate(dataSource);

        totalLoginIdRange = (endLoginId - this.startLoginId) + 1;
        totalMessageRefNoRange = (endMessageRefNo - this.startMessageRefNo) + 1;
    }

    /**
     * To retrieve the next Login ID and Messsage Reference Number.
     *
     * <p>The formula to generate Login ID:<br/>
     * <code>(MOD(RunningNumber-1, TotalLoginIdRange) + StartLoginId)</code>
     *
     * <p>The formula to generate Message Reference Number:<br/>
     * <code>(TRUNC(StartMessageRefNo + (RunningNumber-1)/TotalLoginIdRange)</code>
     *
     * @return the holder that contains Login ID and Message Reference Number
     */
    public IdHolder getNextId() {
        long currentRunningNumber = getCurrentRunningNo();

        long nextLoginId = ((currentRunningNumber - 1) % totalLoginIdRange) + startLoginId;
        long nextMessageRefNo = startMessageRefNo
                                + ((currentRunningNumber - 1) / totalLoginIdRange);

        // recycle to starting number if reached max
        nextMessageRefNo = ((nextMessageRefNo - 1) % totalMessageRefNoRange)
                           + startMessageRefNo;

        IdHolder idHolder = new IdHolder(nextLoginId, nextMessageRefNo);

        logger.debug("Generated EAI sequence ({}): {}", currentRunningNumber, idHolder);

        return idHolder;
    }

    private long getCurrentRunningNo() {
        String sql = String.format("select %s.nextval from dual",
                SequenceTable.EAI_DD.sequenceName());
        
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    public static class IdHolder {
        private final long loginId;
        private final long messageRefNo;

        IdHolder(long loginId, long messageRefNo) {
            this.loginId = loginId;
            this.messageRefNo = messageRefNo;
        }

        public long getLoginId() {
            return loginId;
        }

        public long getMessageRefNo() {
            return messageRefNo;
        }

        @Override
        public String toString() {
            return "IdHolder{"
                   + "loginId=" + loginId
                   + ", messageRefNo=" + messageRefNo
                   + '}';
        }
    }

}
