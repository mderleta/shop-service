package pl.derleta.pracadomowa1;

import java.util.List;

public interface ShopService {

    void addToCart(Product product);
    List<Product> getAllProducts();

}
