package transaction.service;

import org.springframework.stereotype.Service;
import transaction.converter.PurchaseConverter;
import transaction.dto.PurchaseDTO;
import transaction.entity.PurchaseEntity;
import transaction.gateway.RateExchangeGateway;
import transaction.gateway.domain.RateExchangeData;
import transaction.respository.PurchaseRepository;

import java.math.RoundingMode;
import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final RateExchangeGateway rateExchangeGateway = new RateExchangeGateway();

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public PurchaseEntity save(PurchaseEntity purchaseEntity) {
        return purchaseRepository.save(purchaseEntity);
    }

    public PurchaseDTO getPurchase(String id, String currency) {
        PurchaseEntity entity = purchaseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        String recordDate = entity.getTransactionDate().format(PurchaseConverter.DATE_TIME_FORMATTER);
        List<RateExchangeData> data = rateExchangeGateway.rateExchange(recordDate, currency).getData();
        if (data == null || data.isEmpty()) {
            data = rateExchangeGateway.rateExchangeLess(recordDate, currency).getData();
            if (data == null || data.isEmpty()) {
                throw new IllegalArgumentException("Invalid currency");
            }
        }
        RateExchangeData rate = data.getFirst();

        return PurchaseDTO.Builder.builder() //
                .id(id) //
                .amount(String.valueOf(rate.getExchangeRate().multiply(entity.getAmount()).setScale(2, RoundingMode.HALF_EVEN))) //
                .description(entity.getDescription()) //
                .transactionDate(rate.getRecordDate().formatted(PurchaseConverter.DATE_TIME_FORMATTER)) //
                .build();
    }
}
