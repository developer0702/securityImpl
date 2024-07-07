package com.sanjay_impl.serviceimpl;

import com.sanjay_impl.entity.Product;
import com.sanjay_impl.exceptions.ResourceNotFoundException;
import com.sanjay_impl.repository.ProductRepository;
import com.sanjay_impl.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Product> productList = null;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void loadProductFromDb() {
        productList = IntStream.rangeClosed(1, 100)
                .mapToObj(product -> Product.builder()
                        .productId((long) product)
                        .productName("product" + product)
                        .quantity(new Random().nextInt(6))
                        .price(new Random().nextInt(5000))
                        .build()).collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProduct(Long id){
        Product product = productList.stream().filter(s -> s.getProductId() == id).findAny().orElseThrow(() -> new ResourceNotFoundException("product", "productId",  id));
        return product;
    }

    public List<Product> getProductsByUserId(Long userId) {
        return productRepository.findByUserUserId(userId);
    }

}
