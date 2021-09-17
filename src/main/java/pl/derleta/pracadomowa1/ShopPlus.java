package pl.derleta.pracadomowa1;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("Plus")
@ConfigurationProperties("shop-plus")
public class ShopPlus extends AbstractShop {

    double discount;
    double vat;

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }


    @Override
    protected double calculatePrice(Product product) {
        double price = product.getPrice();
        price = price * vat * discount;
        return price;
    }
}
