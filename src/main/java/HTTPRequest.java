import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HTTPRequest {
    public String path;

    public HTTPRequest(BufferedReader inFromClient) {
        processRequest(inFromClient);
//        Map<String, String> params = queryParams();
//        System.out.println("q:" + params.get("q"));
    }

    public void processRequest(BufferedReader inFromClient) {
        try {
            // peel off the first GET/POST PATH line
            // "GET /home.html HTTP/1.1"
            // ["GET", "/home.html", "HTTP/1.1"][1]
            String requestLine = inFromClient.readLine();
            this.path = requestLine.split(" ")[1];

            if (this.path.equals("/")) {
                this.path = "/index.html";
            }
        } catch (IOException e) {
            System.out.println("Error parsing HTTP request: " + this.path);
        }
    }

    public static Map<String, String> queryParams() {
        Map<String, String> params = new HashMap<>();
        String example = "https://www.discogs.com/search/?q=thrice+vheissu&type=all";

        // urls are not required to have query params
        if (!example.contains("?")) {
            return params;
        }

        String querystring = example.split("\\?")[1];
        String[] pairs = querystring.split("&");
        for (String pair : pairs) {
            System.out.println(pair);

            String[] cells = pair.split("=");
            String key = cells[0];
            String value = "";

            // params aren't required to have a value
            // keys can be present by themselves
            // google.com/q=hotdog&animated&size=400
            if (cells.length >= 2) {
                value = cells[1];
            }

            params.put(key, value);
        }

        return params;
    }
}