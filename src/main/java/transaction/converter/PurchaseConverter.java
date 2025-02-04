package transaction.converter;

import transaction.dto.PurchaseDTO;
import transaction.entity.PurchaseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PurchaseConverter {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static PurchaseDTO toDTO(PurchaseEntity purchaseEntity) {
        return PurchaseDTO.Builder.builder() //
                .id(purchaseEntity.getId()) //
                .transactionDate(purchaseEntity.getTransactionDate().format(formatter)) //
                .amount(purchaseEntity.getAmount().toString()) //
                .description(purchaseEntity.getDescription()) //
                .build();
    }

    public static PurchaseEntity toEntity(PurchaseDTO purchaseDTO) {
        return PurchaseEntity.Builder.builder() //
                .id(purchaseDTO.getId()) //
                .transactionDate(LocalDate.parse(purchaseDTO.getTransactionDate(), formatter)) //
                .amount( //
                        new BigDecimal( //
                                purchaseDTO.getAmount() //
                        ).setScale(2) //
                ) //
                .description(purchaseDTO.getDescription()) //
                .build();
    }
}
