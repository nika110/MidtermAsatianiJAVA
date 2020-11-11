package ge.edu.btu.currency;
import ge.edu.btu.currency.service.impl.CurrencyServiceImpl;
import org.apache.log4j.Logger;

public class Main {
    final static Logger Logger=org.apache.log4j.Logger.getLogger(Main.class);

    public static void main(String[] args) {
        CurrencyServiceImpl currencyService = new CurrencyServiceImpl();

        currencyService.setExchangeRate(3);
        currencyService.convert(12);
        currencyService.convert(122.3);

    }
}
