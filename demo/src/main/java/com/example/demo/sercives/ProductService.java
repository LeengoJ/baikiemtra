package com.example.demo.sercives;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> GetALl (){return productRepository.findAll();}

    public void add(Product product) { productRepository.save(product);}
    public void delete (Long id)
    {
        productRepository.deleteById(id);
    }
    public  Product getProductById (Long id)
    {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if(optional.isPresent())
        {
            product =optional.get();
        }
        else
        {
            throw  new RuntimeException();
        }
        return product;
    }
    public Product updateProduct (Product product , Long id)
    {
        Product currentproduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("ko co"+id));
        currentproduct.setName(product.getName());
        currentproduct.setImage(product.getImage());
        currentproduct.setPrice(product.getPrice());
        productRepository.save(currentproduct);
        return currentproduct;
    }
}
