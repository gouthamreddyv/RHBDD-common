package net.tao.rhb.dd.support;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class VaultDecoderTest {

    private VaultDecoder decoder;

    @Before
    public void before() {
        decoder = new VaultDecoder();
        decoder.setKeyStoreUrl("target/test-classes/vault/FPX-DB-VAULT.keystore");
        decoder.setKeyStorePassword("MASK-1N7QtYN4DrwbwA.LuNjx3f");
        decoder.setKeyStoreAlias("fpxdb");
        decoder.setKeyStoreSalt("2018efpx");
        decoder.setKeyStoreIterationCount("150");
        decoder.setEncodedFileDir("target/test-classes/vault");
    }

    @Test
    public void getDbPassword_RequiredVaultConfigurationGiven_PasswordDecrypted() {
        String expectedDbPassword = "fpxuatuser";

        String actualDbPassword = decoder.getDbPassword();

        assertThat(actualDbPassword, is(expectedDbPassword));
    }
}
