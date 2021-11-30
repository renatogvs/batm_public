package com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow.dto;

import java.math.BigDecimal;

public class Payload {
    public String orderId;
    public String receiveCurrency;
    public BigDecimal receiveQuantity;
    public String deliverCurrency;
    public BigDecimal deliverQuantity;
    public BigDecimal fee;
}
