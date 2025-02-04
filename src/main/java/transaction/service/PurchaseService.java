package transaction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transaction.entity.PurchaseEntity;
import transaction.respository.PurchaseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public PurchaseEntity save(PurchaseEntity purchaseEntity) {
        return purchaseRepository.save(purchaseEntity);
    }

    public List<PurchaseEntity> getPurchases(String id, String transactionDate) {
        return new ArrayList<>();
    }
}
