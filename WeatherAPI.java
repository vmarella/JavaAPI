

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherAPI {

    public static void main(String[] args) throws Exception {


        try {
            //Public API:

            URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=60.17&longitude=24.94&hourly=temperature_2m");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder(1024);
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                System.out.println(informationString);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}