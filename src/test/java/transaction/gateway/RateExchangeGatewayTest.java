package transaction.gateway;

import org.junit.jupiter.api.Test;
import transaction.gateway.domain.RateExchange;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RateExchangeGatewayTest {

    private final RateExchangeGateway rateExchangeGateway = new RateExchangeGateway();

    @Test
    void rateExchange() {
        RateExchange result = rateExchangeGateway.rateExchange("2024-12-31", "Real");
        assertThat(result.getData().size()).isEqualTo(1);
    }
}