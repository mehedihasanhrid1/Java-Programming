import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class JoddHttpExample {
    public static void main(String[] args) {
        HttpResponse response = HttpRequest
                .get("api_url")
                .send();

        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.bodyText());
    }
}
