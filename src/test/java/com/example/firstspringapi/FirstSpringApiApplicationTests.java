package com.example.firstspringapi;

import com.example.firstspringapi.models.Category;
import com.example.firstspringapi.models.Product;
import com.example.firstspringapi.projections.ProductWithTimeAndDescription;
import com.example.firstspringapi.repositories.CategoryRepository;
import com.example.firstspringapi.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class FirstSpringApiApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository ProductRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testTC(){
        Optional<Category> optionalCategory = categoryRepository.findById(1L);

        Category category = optionalCategory.get();
        System.out.println("Fetching product related to above category");
//        List<Product> products = category.getProducts();
//        System.out.println(products.get(0).getTitle());

        ProductWithTimeAndDescription product = ProductRepository.someRandomeQuery(3L);
        System.out.println(product.getTitle());
        System.out.println(product.getDescription());

        ProductWithTimeAndDescription product2 = ProductRepository.someOtherRandomeQuery(4L);
        System.out.println(product.getTitle());
        System.out.println(product.getDescription());

        System.out.println("DEBUG");
    }

}
