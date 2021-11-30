package com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow.dto;

import java.math.BigDecimal;

public class OrderRequest {
    public String ticker;
    public String tradeSide;
    public BigDecimal deliverQuantity;
    public BigDecimal receiveQuantity;
    public String usernameRef;
}
