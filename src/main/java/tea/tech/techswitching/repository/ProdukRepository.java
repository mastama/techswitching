package tea.tech.techswitching.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tea.tech.techswitching.entity.Product;

@Repository
public interface ProdukRepository extends MongoRepository<Product, String> {
}
