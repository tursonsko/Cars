import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class Database implements DatabaseFacade {

    private final Map<String, Map<DayOfWeek, BigDecimal>> database;

    public Database() {
        database = fillUpDatabase();
    }

    public Map<DayOfWeek, BigDecimal> getPriceListForCar(String car) {
        if (database.get(car) == null) {
            return new HashMap<>();
        }
        return database.get(car);
    }

    private Map<String, Map<DayOfWeek, BigDecimal>> fillUpDatabase() {
        Map<String, Map<DayOfWeek, BigDecimal>> database = new HashMap<>();
        Map<DayOfWeek, BigDecimal> priceMapFord = new HashMap<>();
        Map<DayOfWeek, BigDecimal> priceMapToyota = new HashMap<>();

        priceMapFord.put(DayOfWeek.MONDAY, new BigDecimal("10"));
        priceMapFord.put(DayOfWeek.TUESDAY, new BigDecimal("10"));
        priceMapFord.put(DayOfWeek.WEDNESDAY, new BigDecimal("20"));
        priceMapFord.put(DayOfWeek.THURSDAY, new BigDecimal("20"));
        priceMapFord.put(DayOfWeek.FRIDAY, new BigDecimal("20"));
        priceMapFord.put(DayOfWeek.SATURDAY, new BigDecimal("20"));
        priceMapFord.put(DayOfWeek.SUNDAY, new BigDecimal("20"));

        priceMapToyota.put(DayOfWeek.MONDAY, new BigDecimal("15"));
        priceMapToyota.put(DayOfWeek.TUESDAY, new BigDecimal("15"));
        priceMapToyota.put(DayOfWeek.WEDNESDAY, new BigDecimal("15"));
        priceMapToyota.put(DayOfWeek.THURSDAY, new BigDecimal("20"));
        priceMapToyota.put(DayOfWeek.FRIDAY, new BigDecimal("20"));
        priceMapToyota.put(DayOfWeek.SATURDAY, new BigDecimal("20"));
        priceMapToyota.put(DayOfWeek.SUNDAY, new BigDecimal("20"));

        database.put("Ford", priceMapFord);
        database.put("Toyota", priceMapToyota);
        return database;
    }

}
