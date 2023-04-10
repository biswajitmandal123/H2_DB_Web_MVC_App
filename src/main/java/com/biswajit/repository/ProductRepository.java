package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
