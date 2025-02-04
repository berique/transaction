package transaction.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import transaction.dto.PurchaseDTO;
import transaction.entity.PurchaseEntity;
import transaction.respository.PurchaseRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
class PurchaseServiceTest {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Test
    public void save() {
        LocalDate now = LocalDate.now();
        BigDecimal transactionRecord = new BigDecimal("10.50");
        String description = "Wi-fi router";
        PurchaseEntity entity = purchaseService.save(PurchaseEntity.Builder.builder() //
                .amount(transactionRecord) //
                .description(description) //
                .transactionDate(now) //
                .build());
        assertThat(entity.getId()).isNotNull();
        assertThat(entity.getAmount()).isEqualTo(transactionRecord);
        assertThat(entity.getDescription()).isEqualTo(description);
        assertThat(entity.getTransactionDate()).isEqualTo(now);

    }

    @Test
    public void getProduct() {
        LocalDate now = LocalDate.now();
        BigDecimal transactionRecord = new BigDecimal("10.50");
        String description = "Wi-fi router";
        PurchaseEntity entity = purchaseService.save(PurchaseEntity.Builder.builder() //
                .amount(transactionRecord) //
                .description(description) //
                .transactionDate(LocalDate.of(2025, 2, 4)) //
                .build());
        PurchaseDTO purchase = purchaseService.getPurchase(entity.getId(), "Real");
        assertThat(purchase.getAmount()).isEqualTo("21.45");
    }

    @Test
    public void getProduct2() {
        assertThatThrownBy(() -> purchaseService.getPurchase("Blah", "Real")) //
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getProduct3() {
        save();
        PurchaseEntity result = purchaseRepository.findAll().getFirst();
        assertThatThrownBy(() -> purchaseService.getPurchase(result.getId(), "Real2")) //
                .isInstanceOf(IllegalArgumentException.class);
    }
}