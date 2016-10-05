package net.tao.rhb.dd.support;

import org.apache.commons.lang3.StringUtils;
import org.jboss.security.vault.SecurityVaultException;
import org.picketbox.plugins.vault.PicketBoxSecurityVault;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;

public class VaultDecoder implements InitializingBean {
    private static final String VAULT_BLOCK = "fpxdb_vb";
    private static final String ATTRIBUTE_NAME = "db_password";

    private String keyStoreUrl;
    private String keyStorePassword;
    private String keyStoreAlias;
    private String keyStoreSalt;
    private String keyStoreIterationCount;
    private String encodedFileDir;

    private Map<String, Object> data = new HashMap<>();

    /**
     * Retrieve the database password from Jboss Vault.
     *
     * @return decrypted password
     */
    public String getDbPassword() {
        data.put("KEYSTORE_URL", keyStoreUrl);
        data.put("KEYSTORE_PASSWORD", keyStorePassword);
        data.put("SALT", keyStoreSalt);
        data.put("ITERATION_COUNT", keyStoreIterationCount);
        data.put("KEYSTORE_ALIAS", keyStoreAlias);
        data.put("ENC_FILE_DIR", encodedFileDir);

        try {
            PicketBoxSecurityVault meuPick = new PicketBoxSecurityVault();
            meuPick.init(data);

            return String.valueOf(meuPick.retrieve(VAULT_BLOCK, ATTRIBUTE_NAME, null));
        } catch (SecurityVaultException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void setKeyStoreUrl(String keyStoreUrl) {
        this.keyStoreUrl = keyStoreUrl;
    }

    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }

    public void setKeyStoreAlias(String keyStoreAlias) {
        this.keyStoreAlias = keyStoreAlias;
    }

    public void setKeyStoreSalt(String keyStoreSalt) {
        this.keyStoreSalt = keyStoreSalt;
    }

    public void setKeyStoreIterationCount(String keyStoreIterationCount) {
        this.keyStoreIterationCount = keyStoreIterationCount;
    }

    public void setEncodedFileDir(String encodedFileDir) {
        this.encodedFileDir = encodedFileDir;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isBlank(keyStoreUrl)) {
            throw new IllegalArgumentException("KeyStoreUrl property is required");
        }
        if (StringUtils.isBlank(keyStorePassword)) {
            throw new IllegalArgumentException("keyStorePassword property is required");
        }
        if (StringUtils.isBlank(keyStoreAlias)) {
            throw new IllegalArgumentException("keyStoreAlias property is required");
        }
        if (StringUtils.isBlank(keyStoreSalt)) {
            throw new IllegalArgumentException("keyStoreSalt property is required");
        }
        if (StringUtils.isBlank(keyStoreIterationCount)) {
            throw new IllegalArgumentException("keyStoreIterationCount property is required");
        }
        if (StringUtils.isBlank(encodedFileDir)) {
            throw new IllegalArgumentException("encodedFileDir property is required");
        }
    }
}
