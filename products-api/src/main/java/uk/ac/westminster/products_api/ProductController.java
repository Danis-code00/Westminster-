package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices productServices;

//    @GetMapping("/{id}")
//    public Product getById(@PathVariable Long id){
//        return new Product(id, "Laptop", 999.99);
//    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productServices.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productServices.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product requestProduct(@RequestBody Product product){
        return productServices.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable Long id){
        return productServices.deleteProduct(id);
    }

    //404 experiment when Get /produt/99 was excuted it gave the example value

    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name){
        return productServices.findByName(name);
    }
}
