package com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow;

import com.generalbytes.batm.common.currencies.CryptoCurrency;
import com.generalbytes.batm.common.currencies.FiatCurrency;
import com.generalbytes.batm.server.extensions.IExchangeAdvanced;
import com.generalbytes.batm.server.extensions.IRateSourceAdvanced;
import com.generalbytes.batm.server.extensions.ITask;
import com.google.common.collect.ImmutableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Set;

public class AquanowExchange implements IExchangeAdvanced, IRateSourceAdvanced {

    private static final Logger log = LoggerFactory.getLogger("batm.master.exchange.AquanowExchange");

    private static final Set<String> fiatCurrencies = ImmutableSet.of(
        FiatCurrency.USD.getCode(),
        FiatCurrency.CAD.getCode(),
        FiatCurrency.EUR.getCode(),
        CryptoCurrency.USDT.getCode()
    ); // stable coin as fiat

    private static final Set<String> cryptoCurrencies = ImmutableSet.of(
        CryptoCurrency.BTC.getCode(),
		CryptoCurrency.DOGE.getCode(),
		CryptoCurrency.LTC.getCode(),
		CryptoCurrency.ETH.getCode(),
		CryptoCurrency.SHIB.getCode(),
		CryptoCurrency.XRP.getCode(),
		CryptoCurrency.BCH.getCode(),
		CryptoCurrency.BAT.getCode(),
		CryptoCurrency.MKR.getCode(),
		CryptoCurrency.ADA.getCode(),
		CryptoCurrency.DAI.getCode());

    @Override
    public Set<String> getCryptoCurrencies() {
        return cryptoCurrencies;
    }

    @Override
    public Set<String> getFiatCurrencies() {
        return fiatCurrencies;
    }

    @Override
    public String getPreferredFiatCurrency() {
        return null;
    }

    @Override
    public BigDecimal getCryptoBalance(String cryptoCurrency) {
        return null;
    }

    @Override
    public BigDecimal getFiatBalance(String fiatCurrency) {
        return null;
    }

    @Override
    public String sendCoins(String destinationAddress, BigDecimal amount, String cryptoCurrency, String description) {
        return null;
    }

    @Override
    public String getDepositAddress(String cryptoCurrency) {
        return null;
    }

    @Override
    public ITask createPurchaseCoinsTask(BigDecimal amount, String cryptoCurrency, String fiatCurrencyToUse, String description) {
        return null;
    }

    @Override
    public ITask createSellCoinsTask(BigDecimal amount, String cryptoCurrency, String fiatCurrencyToUse, String description) {
        return null;
    }

    @Override
    public BigDecimal getExchangeRateForBuy(String cryptoCurrency, String fiatCurrency) {
        return null;
    }

    @Override
    public BigDecimal getExchangeRateForSell(String cryptoCurrency, String fiatCurrency) {
        return null;
    }

    @Override
    public BigDecimal calculateBuyPrice(String cryptoCurrency, String fiatCurrency, BigDecimal cryptoAmount) {
        return null;
    }

    @Override
    public BigDecimal calculateSellPrice(String cryptoCurrency, String fiatCurrency, BigDecimal cryptoAmount) {
        return null;
    }
}
