package net.tao.rhb.dd.commons.ibg.field;

import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class AbstractUsdWithoutSignField implements Field<Long> {
    
    @Override
    public Long parse(String value) throws IllegalArgumentException {
        // TODO
        return 0L;
    }

    @Override
    public String format(Long cents) throws IllegalArgumentException {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        String dollar = numberFormat.format(cents / 100.0);
        dollar = StringUtils.remove(dollar, "$");
        
        return StringUtils.leftPad(dollar, length(), " ");
    }
}
