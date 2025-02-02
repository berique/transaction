package transaction.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import transaction.dto.PurchaseDTO;
import transaction.service.PurchaseService;

@RestController("/v1/purchase")
@RequiredArgsConstructor
public class PurchaseV1Api {
    private final PurchaseService purchaseService;

    @GetMapping("/{id}/{transactionDate}")
    public PurchaseDTO getPurchase(@PathVariable("id") String id, @PathVariable("transactionDate") String transactionDate) {
        return PurchaseDTO.builder().build();
    }

    @PutMapping
    public PurchaseDTO putPurchase(PurchaseDTO purchaseDTO) {
        // TODO: Store
        return PurchaseDTO.builder().build();
    }
}
