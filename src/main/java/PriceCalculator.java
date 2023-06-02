import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PriceCalculator {

//    private final DatabaseFacade database = new Database();

    public BigDecimal calculatePrice(LocalDate dateFrom, LocalDate dateTo, Map<DayOfWeek, BigDecimal> carPriceList) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(dateFrom, dateTo);

        List<DayOfWeek> daysListToCount2 = IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(dateFrom::plusDays)
                .map(LocalDate::getDayOfWeek)
                .collect(Collectors.toList());

        List<DayOfWeek> daysListToCount3 = IntStream.iterate(0, i -> i + 1)
            .limit(numOfDaysBetween)
            .mapToObj(i -> dateFrom.plusDays(i))
            .map(date -> date.getDayOfWeek())
            .collect(Collectors.toList());

        List<DayOfWeek> daysListToCount = dateFrom.datesUntil(dateTo)
                .map(date -> date.getDayOfWeek())
                .collect(Collectors.toList());
        System.out.println(daysListToCount);
        return daysListToCount.stream()
                .map(dayOfWeek -> carPriceList.get(dayOfWeek))
                .reduce(BigDecimal.ZERO, (subtotal, price) -> subtotal.add(price));

    }

}
