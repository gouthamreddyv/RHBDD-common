package net.tao.rhb.dd.commons.config;

import net.tao.rhb.dd.support.VaultDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class InfrastructureConfiguration {

    @Autowired
    private Environment env;

    @Autowired
    private VaultDecoder vaultDecoder;

    /**
     * To be used by batch application.
     *
     * @return the main data source for the application
     */
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
            .driverClassName(env.getRequiredProperty("datasource.driverClassName"))
            .url(env.getRequiredProperty("datasource.url"))
            .username(env.getRequiredProperty("datasource.username"))
            //.password(vaultDecoder.getDbPassword())datasource.password
            .password(env.getRequiredProperty("datasource.password"))
            .build();
    }

    /**
     * A decoder to retrieve database password from vault.
     *
     * @return the VaultDecoder
     */
    @Bean
    public VaultDecoder vaultDecoder() {
        VaultDecoder decoder = new VaultDecoder();
        decoder.setKeyStoreUrl(env.getRequiredProperty("vault.keystore.url"));
        decoder.setKeyStorePassword(env.getRequiredProperty("vault.keystore.password"));
        decoder.setKeyStoreAlias(env.getRequiredProperty("vault.keystore.alias"));
        decoder.setKeyStoreSalt(env.getRequiredProperty("vault.keystore.salt"));
        decoder.setKeyStoreIterationCount(
            env.getRequiredProperty("vault.keystore.iteration.count"));
        decoder.setEncodedFileDir(env.getRequiredProperty("vault.encoded.file.dir"));
        return decoder;
    }
}
