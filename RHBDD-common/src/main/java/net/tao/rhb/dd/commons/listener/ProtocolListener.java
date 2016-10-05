package net.tao.rhb.dd.commons.listener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.core.Ordered;

import java.util.Map;

/**
 * This listener adds protocol header and protocol summary to the log.
 */
public class ProtocolListener implements JobExecutionListener, Ordered {

    private static final int DEFAULT_WIDTH = 80;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolListener.class);

    /**
     * Log the job execution details after a job completion.
     *
     * @param jobExecution job execution details
     */
    public void afterJob(JobExecution jobExecution) {
        StringBuilder protocol = new StringBuilder()
                .append("\n")
                .append(createFilledLine('*'))
                .append(createFilledLine('-'))
                .append("Protocol for ")
                .append(jobExecution.getJobInstance().getJobName())
                .append(" \n")
                .append("  Started:      ").append(jobExecution.getStartTime())
                .append("\n")
                .append("  Finished:     ").append(jobExecution.getEndTime())
                .append("\n")
                .append("  Exit-Code:    ").append(jobExecution.getExitStatus().getExitCode())
                .append("\n")
                .append("  Exit-Desc:    ")
                .append(jobExecution.getExitStatus().getExitDescription())
                .append("\n")
                .append("  Status:       ").append(jobExecution.getStatus())
                .append("\n")
                .append("  Job-ExecutionContext:\n");

        for (Map.Entry<String, Object> entry : jobExecution.getExecutionContext().entrySet()) {
            protocol.append(String.format("     %s=%s %n", entry.getKey(), entry.getValue()));
        }

        protocol.append("  Job-Parameter: \n");
        JobParameters jp = jobExecution.getJobParameters();
        for (Map.Entry<String, JobParameter> entry : jp.getParameters().entrySet()) {
            protocol.append(String.format("     %s=%s %n", entry.getKey(), entry.getValue()));
        }

        protocol.append(createFilledLine('-'));
        for (StepExecution stepExecution : jobExecution.getStepExecutions()) {
            protocol.append("Step ").append(stepExecution.getStepName())
                    .append(" \n")
                    .append("  ReadCount:    ").append(stepExecution.getReadCount())
                    .append("\n")
                    .append("  WriteCount:   ").append(stepExecution.getWriteCount())
                    .append("\n")
                    .append("  Commits:      ").append(stepExecution.getCommitCount())
                    .append("\n")
                    .append("  SkipCount:    ").append(stepExecution.getSkipCount())
                    .append("\n")
                    .append("  Rollbacks:    ").append(stepExecution.getRollbackCount())
                    .append("\n")
                    .append("  Filter:       ").append(stepExecution.getFilterCount())
                    .append("\n");

            protocol.append("  Step-ExecutionContext:\n");
            for (Map.Entry<String, Object> entry : stepExecution.getExecutionContext().entrySet()) {
                protocol.append(String.format("     %s=%s %n", entry.getKey(), entry.getValue()));
            }

            protocol.append(createFilledLine('-'));
        }
        protocol.append(createFilledLine('*'));

        LOGGER.info(protocol.toString());
    }

    /**
     * Log the job execution details before start the job.
     *
     * @param jobExecution job execution details
     */
    public void beforeJob(JobExecution jobExecution) {
        StringBuilder protocol = new StringBuilder();
        protocol.append("\n");
        protocol.append(createFilledLine('*'));
        protocol.append(createFilledLine('-'));
        protocol.append(String.format("Job %s started with Job-Execution-Id %s %n",
                jobExecution.getJobInstance().getJobName(),
                jobExecution.getId()));

        protocol.append("Job-Parameter: \n");
        JobParameters jp = jobExecution.getJobParameters();
        for (Map.Entry<String, JobParameter> entry : jp.getParameters().entrySet()) {
            protocol.append(String.format("     %s=%s %n", entry.getKey(), entry.getValue()));
        }

        protocol.append(createFilledLine('-'));
        protocol.append(createFilledLine('*'));
        LOGGER.info(protocol.toString());
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 10;
    }

    /**
     * Create line with defined char.
     *
     * @param filler characters to be filled
     */
    private String createFilledLine(char filler) {
        return StringUtils.leftPad("", DEFAULT_WIDTH, filler) + "\n";
    }

}
