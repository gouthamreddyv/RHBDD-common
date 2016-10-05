package net.tao.rhb.dd.commons.eai;

import javax.sql.DataSource;

public class CustomSequenceGeneratorBuilder {

    private int startLoginId = 0;
    private int endLoginId = 0;
    private int startMessageRefNo = 0;
    private int endMessageRefNo = 0;
    private DataSource dataSource;

    public CustomSequenceGeneratorBuilder startLoginId(int startLoginId) {
        this.startLoginId = startLoginId;
        return this;
    }

    public CustomSequenceGeneratorBuilder endLoginId(int endLoginId) {
        this.endLoginId = endLoginId;
        return this;
    }

    public CustomSequenceGeneratorBuilder startMessageRefNo(int startMessageRefNo) {
        this.startMessageRefNo = startMessageRefNo;
        return this;
    }

    public CustomSequenceGeneratorBuilder endMessageRefNo(int endMessageRefNo) {
        this.endMessageRefNo = endMessageRefNo;
        return this;
    }

    public CustomSequenceGeneratorBuilder dataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    public CustomSequenceGenerator build() {
        return new CustomSequenceGenerator(
                startLoginId, endLoginId, startMessageRefNo, endMessageRefNo, dataSource);
    }
}