package transaction.converter;

import transaction.dto.PurchaseDTO;
import transaction.entity.PurchaseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PurchaseConverter {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static PurchaseDTO toDTO(PurchaseEntity purchaseEntity) {
        return PurchaseDTO.Builder.builder() //
                .id(purchaseEntity.getId()) //
                .transactionDate(purchaseEntity.getTransactionDate().format(DATE_TIME_FORMATTER)) //
                .amount(purchaseEntity.getAmount().toString()) //
                .description(purchaseEntity.getDescription()) //
                .build();
    }

    public static PurchaseEntity toEntity(PurchaseDTO purchaseDTO) {
        return PurchaseEntity.Builder.builder() //
                .id(purchaseDTO.getId()) //
                .transactionDate(LocalDate.parse(purchaseDTO.getTransactionDate(), DATE_TIME_FORMATTER)) //
                .amount( //
                        new BigDecimal( //
                                purchaseDTO.getAmount() //
                        ).setScale(2) //
                ) //
                .description(purchaseDTO.getDescription()) //
                .build();
    }
}
