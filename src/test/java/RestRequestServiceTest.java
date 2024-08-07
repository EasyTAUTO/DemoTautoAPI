import org.junit.Test;
import io.restassured.response.Response;
import org.example.services.RestRequestService;

import static org.hamcrest.Matchers.equalTo;

/**
 * RestRequestServiceTest : Cette classe de test montre comment utiliser RestRequestService pour effectuer des requêtes REST telles que  GET et POST.
 * Elle utilise des assertions pour vérifier que les réponses contiennent les données attendues.
 */

public class RestRequestServiceTest {

    private RestRequestService restRequestService = new RestRequestService("https://jsonplaceholder.typicode.com");

//    @Test
//    public void testGetRequest() {
//        Response response = restRequestService.getRequest("/posts/1");
//
//        response.then().statusCode(200)
//                .body("id", equalTo(1))
//                .body("userId", equalTo(1));
//    }

    @Test
    public void testPostRequest() {
        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": 1\n" +
                "}";
        System.out.println("requestBody ==" + requestBody);

        Response response = restRequestService.postRequest("/posts", requestBody);

        response.then().statusCode(201)
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1));
        System.out.println("response.getBody().asString()  ==" + response.getBody().asString());
    }
}
