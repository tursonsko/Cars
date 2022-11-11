import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        DatabaseFacade database = new Database();

        Map<DayOfWeek, BigDecimal> carPriceList = database.getPriceListForCar("Ford");

        if (carPriceList.isEmpty()) {
            System.err.println("404 Not found - Database dont have car");
            return;
        }

        BigDecimal result = new PriceCalculator().calculatePrice(
                LocalDate.of(2022, 10, 25),
                LocalDate.of(2022, 11, 2),
                carPriceList
        );

        System.out.println(result);

    }
}
