package transaction.api;

import org.springframework.web.bind.annotation.*;
import transaction.converter.PurchaseConverter;
import transaction.dto.PurchaseDTO;
import transaction.service.PurchaseService;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseV1API {
    private final PurchaseService purchaseService;

    public PurchaseV1API(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/{id}/{transactionDate}")
    public PurchaseDTO getPurchase(@PathVariable("id") String id, @PathVariable("transactionDate") String transactionDate) {
        return purchaseService.getPurchase(id, transactionDate);
    }

    @PostMapping
    public PurchaseDTO putPurchase(@RequestBody PurchaseDTO purchaseDTO) {
        if (purchaseDTO.getId() != null) {
            throw new IllegalArgumentException("ID must be null");
        }
        return PurchaseConverter.toDTO(purchaseService.save(PurchaseConverter.toEntity(purchaseDTO)));
    }
}
