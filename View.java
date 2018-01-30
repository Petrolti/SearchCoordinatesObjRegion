package rest.java;
/*код создан программистом Petrolti, e-mail: petrov_ot@mail.ru*/
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

class View {
    View(String json) throws IOException {
        //здесь реализована обработка JSON файла - можно переделать необходимые задачи
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(json);

        System.out.println(actualObj.get("display_name"));
        System.out.println("latitude: " + actualObj.get("lat"));
        System.out.println("longitude: " + actualObj.get("lon"));

        JsonNode geoJson = actualObj.get("geojson");
        System.out.println(geoJson.get("type") + " coordinates:");
        String coordinatesOut = geoJson.get("coordinates").toString();
        System.out.println(coordinatesOut);
    }
}
