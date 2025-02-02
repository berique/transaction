package transaction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import transaction.entity.PurchaseEntity;
import transaction.respository.PurchaseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseEntity save(PurchaseEntity purchaseEntity) {
        return purchaseRepository.save(purchaseEntity);
    }

    public List<PurchaseEntity> getPurchase(String id, String transactionDate) {
        return new ArrayList<>();
    }
}
