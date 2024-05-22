package com.example.firstspringapi.services;

import com.example.firstspringapi.Dtos.FakeStoreProductDto;
import com.example.firstspringapi.models.Category;
import com.example.firstspringapi.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product getProductById(Long id) {
        // Call FakeStore API to get product by id
        FakeStoreProductDto fakeStoreProductDto =
        restTemplate.getForObject("https://fakestoreapi.com/products" + id, FakeStoreProductDto.class);

        if(fakeStoreProductDto == null){
            return null;
        }
        // Convert FakeStoreProductDto to Product
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
