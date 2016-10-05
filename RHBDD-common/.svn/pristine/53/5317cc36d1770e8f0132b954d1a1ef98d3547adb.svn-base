package net.tao.rhb.dd.commons.ibg.field;

import net.tao.rhb.dd.commons.constant.AccountType;

public class AccountTypeField implements Field<AccountType> {
    @Override
    public int length() {
        return 1;
    }

    @Override
    public AccountType parse(String value) throws IllegalArgumentException {
        return AccountType.lookup(value);
    }

    @Override
    public String format(AccountType value) throws IllegalArgumentException {
        return value.value();
    }
}
