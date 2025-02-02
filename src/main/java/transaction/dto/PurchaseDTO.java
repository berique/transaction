package transaction.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Builder
@Data
public class PurchaseDTO {
    private String id;

    @Length(max = 50)
    private String description;

    @Pattern(regexp = "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])")
    private String transactionDate;

    @Pattern(regexp = "[0-9]{1,10}?(,[0-9]{1,2})")
    private String amount;
}
