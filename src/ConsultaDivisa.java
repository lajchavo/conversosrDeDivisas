import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {
    public Divisa consultaDivisa (String base_code) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/cd5147c081958487fba80c85/latest/" + base_code  );


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontre la divisa de ese pais");

        }
    }

}
