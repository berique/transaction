package transaction.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Entity
public class Purchase {
    @Id
    private String id;
    @Column(length = 50)
    private String description;
    private LocalDate transactionDate;
    @Column(precision = 10, scale = 2)
    private BigDecimal amount;
}