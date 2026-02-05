package com.ludamhuy.tuan4.repository;

import com.ludamhuy.tuan4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
