package pl.derleta.pracadomowa1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final ShopService shop;

    @Autowired
    public DataLoader(ShopService shop) {
        this.shop = shop;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void makeNewShop() {
        generateProductsInCart();
    }

    void generateProductsInCart() {
        double tempPrice;
        String tempName; // todo metoda addTOCart powinna przyjmowac Product wraz z podstawowa cene, ktora bedzie regulowana w odpowiednich serwisach
        for (int i = 1; i < 6; i++) {
            tempName = "Product" + i;
            tempPrice = Utils.getRandomNumber(50, 300);
            tempPrice = Utils.round(tempPrice, 2);
            Product product = new Product(tempName, tempPrice);
            System.out.println(product.getName() + "; " + product.getPrice());
            shop.addToCart(product);
        }
        System.out.println();
        shop.getAllProducts()
                .forEach(s -> System.out.println(s.getName() + ": " + s.getPrice()));
        double sumPrice = shop.getAllProducts().stream()
                .map(Product::getPrice)
                .reduce(0.0, (sum, act) -> sum += act);
        System.out.println(Utils.round(sumPrice, 2));
    }




}
