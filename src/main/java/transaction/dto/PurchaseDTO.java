package transaction.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PurchaseDTO {
    private String id;

    @Length(max = 50)
    private String description;

    @Pattern(regexp = "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])")
    private String transactionDate;

    @Pattern(regexp = "[0-9]{1,10}?(\\.[0-9]{1,2})")
    private String amount;

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

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    private PurchaseDTO(Builder builder) {
        setId(builder.id);
        setDescription(builder.description);
        setTransactionDate(builder.transactionDate);
        setAmount(builder.amount);
    }


    public static final class Builder {
        private String id;
        private @Length(max = 50) String description;
        private @Pattern(regexp = "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])") String transactionDate;
        private @Pattern(regexp = "[0-9]{1,10}?(\\.[0-9]{1,2})") String amount;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder description(@Length(max = 50) String val) {
            description = val;
            return this;
        }

        public Builder transactionDate(@Pattern(regexp = "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])") String val) {
            transactionDate = val;
            return this;
        }

        public Builder amount(@Pattern(regexp = "[0-9]{1,10}?(\\.[0-9]{1,2})") String val) {
            amount = val;
            return this;
        }

        public PurchaseDTO build() {
            return new PurchaseDTO(this);
        }
    }
}
