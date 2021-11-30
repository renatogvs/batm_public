package com.generalbytes.batm.server.extensions.extra.ethereum.erc20.shiba;

import com.generalbytes.batm.common.currencies.CryptoCurrency;
import com.generalbytes.batm.server.extensions.CryptoCurrencyDefinition;
import com.generalbytes.batm.server.extensions.extra.ethereum.erc20.dai.DaiPaymentSupport;
import com.generalbytes.batm.server.extensions.payment.IPaymentSupport;

public class ShibaDefinition  extends CryptoCurrencyDefinition {
    private IPaymentSupport paymentSupport = new DaiPaymentSupport();

    public ShibaDefinition() {
        super(CryptoCurrency.SHIB.getCode(), "Shiba Inu ERC20 Token", "ethereum","https://shibatoken.com/");
    }

    @Override
    public IPaymentSupport getPaymentSupport() {
        return paymentSupport;
    }
}
