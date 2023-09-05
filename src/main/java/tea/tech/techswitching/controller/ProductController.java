package tea.tech.techswitching.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tea.tech.techswitching.dto.ProductRequest;
import tea.tech.techswitching.dto.ProductResponse;
import tea.tech.techswitching.service.ProductService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest request) {
        log.info("START Incoming createProduct");
        productService.createProduct(request);
        log.info("END Outgoing createProduct");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        log.info("Incoming getAllProduct");

        log.info("Outgoing getAllProduct");
        return productService.getAllProduct();
    }
}
