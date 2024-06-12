package com.example.firstspringapi.repositories;

import com.example.firstspringapi.models.Product;
import com.example.firstspringapi.projections.ProductWithTimeAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findById(Long id);

    Product save(Product product);

    @Query("select p.title as title, p.description as description from Product p where p.id = :id")
    ProductWithTimeAndDescription someRandomeQuery(@Param("id") Long id);

    @Query(value = "select title, description from Product p where p.id = :id", nativeQuery = true)
    ProductWithTimeAndDescription someOtherRandomeQuery(@Param("id") Long id);
}
