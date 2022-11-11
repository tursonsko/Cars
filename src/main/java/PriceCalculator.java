import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PriceCalculator {

//    private final DatabaseFacade database = new Database();

    public BigDecimal calculatePrice(LocalDate dateFrom, LocalDate dateTo, Map<DayOfWeek, BigDecimal> carPriceList) {

//        long numOfDaysBetween = ChronoUnit.DAYS.between(dateFrom, dateTo);
//        List<DayOfWeek> daysListToCount = IntStream.iterate(0, i -> i + 1)
//                .limit(numOfDaysBetween)
//                .mapToObj(dateFrom::plusDays)
//                .map(LocalDate::getDayOfWeek)
//                .collect(Collectors.toList());

        final List<DayOfWeek> daysListToCount = dateFrom.datesUntil(dateTo)
                .map(LocalDate::getDayOfWeek)
                .collect(Collectors.toList());
        System.out.println(daysListToCount);

        return daysListToCount.stream()
                .map(carPriceList::get)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

}
