package net.tao.rhb.dd.commons.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class CustomBatchConfigurer extends DefaultBatchConfigurer {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private Environment env;

    @Override
    protected JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(transactionManager);

        String isolationLevelForCreate =
                env.getProperty("batch.repository.isolation_level_for_create");
        if (isolationLevelForCreate != null) {
            factory.setIsolationLevelForCreate(isolationLevelForCreate);
        }

        String tablePrefix = env.getProperty("batch.repository.table_prefix");
        if (tablePrefix != null) {
            factory.setTablePrefix(tablePrefix);
        }

        factory.afterPropertiesSet();

        return factory.getObject();
    }
}
