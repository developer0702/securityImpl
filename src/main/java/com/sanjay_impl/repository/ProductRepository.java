package com.sanjay_impl.repository;

import com.sanjay_impl.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUserUserId(Long userId);

}
