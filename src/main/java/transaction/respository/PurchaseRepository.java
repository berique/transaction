package transaction.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transaction.entity.PurchaseEntity;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity, String> {
}
