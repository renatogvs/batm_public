package com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow.dto;

import java.math.BigDecimal;

public class WithdrawalRequest {
    public String symbol;
    public String address;
    public BigDecimal quantity;
    public String transactionType;

    @Override
    public String toString() {
        return "WithdrawalRequest{" +
            "symbol='" + symbol + '\'' +
            ", address='" + address + '\'' +
            ", quantity=" + quantity +
            ", transactionType='" + transactionType + '\'' +
            '}';
    }
}
