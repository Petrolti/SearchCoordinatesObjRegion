package rest.java;
/*код создан программистом Petrolti, e-mail: petrov_ot@mail.ru*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Model {
    private String result;  //string output

    private String getResult() {
        return result;
    }

    Model(String search) {      //constructor
        try {
            SearchRegionByOSM(search);                              //main processing response OSM
            new View(getResult());                                  //processing output view to console
        } catch (IOException e) {
            System.out.println("Ошибка ввода региона поиска");      //error processing for all
        }
    }

    private void SearchRegionByOSM(String r) throws IOException {
        //формируем REST соединение с сервером, запрос GET, тайм-аут 10с до автоматического закрытия соединения
        String urlString = "https://nominatim.openstreetmap.org/search?"+r+"&country=russia&format=json&polygon_geojson=1";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();
        //буфферизация полученного Response во входном потоке и формирование строки в цикле, пока не поступит пустая строка
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder json = new StringBuilder();
        String currentLine;
        do{
            currentLine = br.readLine();
            json.append(currentLine); }
            while (currentLine != null);
        //обрезка первого "[" и последнего "]" символов - без этого не работала JSON обработка (=костыль),т.е. буду дорабатывать
        result = json.substring(1,json.length()-1);
    }
}
