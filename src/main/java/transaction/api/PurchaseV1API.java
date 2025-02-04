package transaction.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import transaction.dto.PurchaseDTO;
import transaction.service.PurchaseService;

@RestController("/v1/purchase")
public class PurchaseV1API {
    private final PurchaseService purchaseService;

    public PurchaseV1API(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/{id}/{transactionDate}")
    public PurchaseDTO getPurchase(@PathVariable("id") String id, @PathVariable("transactionDate") String transactionDate) {
        // TODO: Retrieve
        return null;
    }

    @PostMapping
    public PurchaseDTO putPurchase(@RequestBody PurchaseDTO purchaseDTO) {
        // TODO: Store
        return null;
    }
}
