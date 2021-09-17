package pl.derleta.pracadomowa1.services;

import pl.derleta.pracadomowa1.model.Product;

import java.util.List;

public interface ShopService {

    void addToCart(Product product);
    List<Product> getAllProducts();

}
