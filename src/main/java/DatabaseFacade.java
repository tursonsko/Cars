import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.util.Map;

public interface DatabaseFacade {

    Map<DayOfWeek, BigDecimal> getPriceListForCar(String car);
}
