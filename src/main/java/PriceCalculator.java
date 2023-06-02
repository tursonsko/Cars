import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PriceCalculator {

    public BigDecimal calculatePrice(LocalDate dateFrom, LocalDate dateTo, Map<DayOfWeek, BigDecimal> carPriceList) {

        final List<DayOfWeek> daysListToCount = dateFrom.datesUntil(dateTo)
                .map(LocalDate::getDayOfWeek)
                .collect(Collectors.toList());
        System.out.println(daysListToCount);

        return daysListToCount.stream()
                .map(carPriceList::get)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

}
