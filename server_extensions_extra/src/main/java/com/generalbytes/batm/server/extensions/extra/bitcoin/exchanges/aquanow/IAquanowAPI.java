package com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow;

import com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow.dto.Balance;
import com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow.dto.OrderResponse;
import com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow.dto.WithdrawalRequest;
import com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.aquanow.dto.WithdrawalResponse;
import com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.bitbuy.dto.OrderRequest;
import com.generalbytes.batm.server.extensions.extra.bitcoin.exchanges.bitbuy.dto.WithdrawResult;
import com.generalbytes.batm.server.extensions.util.net.RateLimitingInterceptor;
import org.knowm.xchange.utils.nonce.CurrentTimeIncrementalNonceFactory;
import si.mazi.rescu.ClientConfig;
import si.mazi.rescu.Interceptor;
import si.mazi.rescu.RestProxyFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;

@Produces(MediaType.APPLICATION_JSON)
public interface IAquanowAPI {

    static IAquanowAPI create(String apiKey, String apiSecret) throws GeneralSecurityException {
        final ClientConfig config = new ClientConfig();
        config.addDefaultParam(QueryParam.class, "apikey", apiKey);
        config.addDefaultParam(QueryParam.class, "stamp", new CurrentTimeIncrementalNonceFactory(TimeUnit.MILLISECONDS));
        config.addDefaultParam(HeaderParam.class, "signature", AquanowDigest.createInstance(apiSecret, (new CurrentTimeIncrementalNonceFactory(TimeUnit.MILLISECONDS)).toString()));
        Interceptor interceptor = new RateLimitingInterceptor(IAquanowAPI.class, 25, 30_000);
        return RestProxyFactory.createProxy(IAquanowAPI.class, "https://api.aquanow.io", config, interceptor);
    }

    @GET
    @Path("/users/v1/userbalance")
    Balance getBalance(@QueryParam("symbol") String cryptoSymbol) throws IOException;

    @POST
    @Path("accounts/v1/transaction")
    WithdrawalResponse withdraw(WithdrawalRequest request) throws IOException;

    @POST
    @Path("trades/v1/executeQuote")
    OrderResponse createOrder(OrderRequest request) throws IOException;

}
