import java.util.Map;

public record Divisa(
        double monto,
        String base_code,
        String code,
        Map<String,
        Double> conversion_rates) {
}
