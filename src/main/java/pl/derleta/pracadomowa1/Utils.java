package pl.derleta.pracadomowa1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Utils {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    protected static double getRandomNumber(int start, int bound) {
        double doubleValue;
        Random random = new Random();
        doubleValue = random.nextDouble(50, 300);
        return doubleValue;
    }
}
