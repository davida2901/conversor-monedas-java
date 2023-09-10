import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConversorMonedas {
    private Map<String, Double> exchangeRates;

    private double monto;
    private String fuente;
    private String objetivo;

    public ConversorMonedas() {
        exchangeRates = new HashMap<>();

        exchangeRates.put("DOP", 1.0);
        exchangeRates.put("USD", 0.018);
        exchangeRates.put("MXN", 0.31);
        exchangeRates.put("EUR", 0.016);
        exchangeRates.put("LIB", 0.014);
        exchangeRates.put("YEN", 2.57);
        exchangeRates.put("WON", 23.48);
        exchangeRates.put("ARG", 4.71);
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }


    public double ConversorMonedas() {
        double sourceRate = exchangeRates.getOrDefault(getFuente(), 0.0);
        double targetRate = exchangeRates.getOrDefault(getObjetivo(), 0.0);
        double convertedAmount = Math.round(((getMonto() / sourceRate) * targetRate) *
                100.0) / 100.0;
        return convertedAmount;
    }

    public ArrayList<String> getCurrencies() {
        ArrayList<String> currencies = new ArrayList<>(exchangeRates.keySet());
        return currencies;
    }

}
