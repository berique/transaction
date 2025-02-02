package transaction.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import transaction.respository.PurchaseRepository;

@SpringBootTest
public class PurchaseEntityRepositoryTests {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Test
    public void purchaseRepository_save() {

    }
}
