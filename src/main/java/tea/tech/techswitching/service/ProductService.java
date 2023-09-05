package tea.tech.techswitching.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tea.tech.techswitching.dto.ProductRequest;
import tea.tech.techswitching.dto.ProductResponse;
import tea.tech.techswitching.entity.Product;
import tea.tech.techswitching.repository.ProdukRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProdukRepository produkRepository;
    public void createProduct(ProductRequest request) {
        log.info("START CreateProduct");
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        produkRepository.save(product);
        log.info("Product is saved: {}", product.getId());
    }

    public List<ProductResponse> getAllProduct() {
        List<Product> products = produkRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product request) {
        return ProductResponse.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }
}