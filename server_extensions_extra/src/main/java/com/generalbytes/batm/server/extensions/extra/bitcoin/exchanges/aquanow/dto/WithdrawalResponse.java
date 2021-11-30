package com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow.dto;

import java.math.BigDecimal;

public class WithdrawalResponse {
    public long itemDateTime;
    public String address;
    public BigDecimal networkFeeAqua;
    public BigDecimal quantity;
    public String txId;
    public String symbol;
    public String tag;
    public String username;
    public Boolean fullNodeEnabled;
    public BigDecimal networkFee;
    public Boolean freeOrNot;
    public String transactionType;
    public Boolean isAutopilotAddress;
    public String adminApproval;
    public Long createdAt;
    public Long updatedAt;
}
