package transaction.gateway;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import transaction.gateway.domain.RateExchange;

@Service
public class RateExchangeGateway {
    private final RestTemplate restTemplate = new RestTemplate();

    public RateExchange rateExchange(String recordDate, String currency) {
        String baseUrl = "https://api.fiscaldata.treasury.gov";
        String path = "/services/api/fiscal_service/v1/accounting/od/rates_of_exchange";
        String url = baseUrl + path + "?filter=record_date:eq:" + recordDate + ",currency:eq:" + currency;
        return restTemplate.getForObject(url, RateExchange.class);
    }

}
