import java.util.ArrayList;
import java.util.HashMap;

public record Moneda(
        String result,
        String time_last_update_utc,
        String base_code,
        String target_code,
        double conversion_rate,
        double conversion_result){

    @Override
    public String toString() {
        return "$" + conversion_result + " " + target_code;
    }
}
