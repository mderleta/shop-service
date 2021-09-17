package pl.derleta.pracadomowa1;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShop implements ShopService {

    private static final List<Product> listOfProductsBasicPrice = new ArrayList<>();


    @Override
    public List<Product> getAllProducts() {
        return listOfProductsBasicPrice;
    }


    @Override
    public void addToCart(Product product) {
        product.setPrice(Utils.round(calculatePrice(product), 2));
        listOfProductsBasicPrice.add(product);
    }

    protected abstract double calculatePrice(Product product);

}
