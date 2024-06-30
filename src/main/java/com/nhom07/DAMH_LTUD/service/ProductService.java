package com.nhom07.DAMH_LTUD.service;

import com.nhom07.DAMH_LTUD.NotFoundByIdException;
import com.nhom07.DAMH_LTUD.model.Product;
import com.nhom07.DAMH_LTUD.repository.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getById(Long id) throws NotFoundByIdException {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NotFoundByIdException("Không tìm thấy id: " + id);
    }

    public void updateProduct(@NotNull Product product) {
        Product productExists = productRepository.findById(product.getId())
                .orElseThrow(() -> new IllegalStateException("Product with id: " + product.getId() + " does not exist."));
        productExists.setNameProduct(product.getNameProduct());
        productExists.setImageClotheFootball(product.getImageClotheFootball()); // Add this line
        // Cập nhật các thuộc tính khác của Product nếu cần
        productRepository.save(productExists);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalStateException("Không tìm thấy id: " + id);
        }
        productRepository.deleteById(id);
    }
}