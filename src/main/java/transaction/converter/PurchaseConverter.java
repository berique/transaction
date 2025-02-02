package transaction.converter;

import transaction.dto.PurchaseDTO;
import transaction.entity.PurchaseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PurchaseConverter {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static PurchaseDTO toDto(PurchaseEntity purchaseEntity) {
        return PurchaseDTO.builder() //
                .id(purchaseEntity.getId()) //
                .transactionDate(purchaseEntity.getTransactionDate().format(formatter)) //
                .amount(purchaseEntity.getAmount().toString()) //
                .description(purchaseEntity.getDescription()) //
                .build();
    }

    public static PurchaseEntity toEntity(PurchaseDTO purchaseDTO) {
        return PurchaseEntity.builder() //
                .id(purchaseDTO.getId()) //
                .transactionDate(LocalDate.parse(purchaseDTO.getTransactionDate(), formatter)) //
                .amount(new BigDecimal(purchaseDTO.getAmount())) //
                .description(purchaseDTO.getDescription()) //
                .build();
    }
}
