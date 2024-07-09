

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public Moneda convertirMoneda(String baseCode, String targetCode, double amount){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7968b8c50aec95fd506b34d8/pair/"+
                baseCode + "/"+ targetCode + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("No se encontro el código de la moneda");
        }
    }
}
