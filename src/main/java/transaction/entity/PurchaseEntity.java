package transaction.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "purchases")
@Entity
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 50)
    private String description;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @Column(precision = 10, scale = 2)
    private BigDecimal amount;

    public PurchaseEntity() {

    }

    private PurchaseEntity(Builder builder) {
        setId(builder.id);
        setDescription(builder.description);
        setTransactionDate(builder.transactionDate);
        setAmount(builder.amount);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public static final class Builder {
        private String id;
        private String description;
        private LocalDate transactionDate;
        private BigDecimal amount;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder transactionDate(LocalDate val) {
            transactionDate = val;
            return this;
        }

        public Builder amount(BigDecimal val) {
            amount = val;
            return this;
        }

        public PurchaseEntity build() {
            return new PurchaseEntity(this);
        }
    }
}