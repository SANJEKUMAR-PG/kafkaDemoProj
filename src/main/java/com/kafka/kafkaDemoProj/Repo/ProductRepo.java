package com.kafka.kafkaDemoProj.Repo;

import com.kafka.kafkaDemoProj.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
