package ru.cursach.internetstorebackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.cursach.internetstorebackend.dao.ProductDao;
import ru.cursach.internetstorebackend.model.Product;

import java.util.UUID;

@Controller
@RequestMapping("/api")
public class ProductController {
    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/{code_product}")
    public void getProduct(@PathVariable UUID code_product) {
        productDao.getProductById(code_product);
    }
}
