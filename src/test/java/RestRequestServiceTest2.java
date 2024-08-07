import io.restassured.response.Response;
import org.example.services.RestRequestService;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * RestRequestServiceTest : Cette classe de test montre comment utiliser RestRequestService pour effectuer des requêtes REST telles que  GET et POST.
 * Elle utilise des assertions pour vérifier que les réponses contiennent les données attendues.
 */

public class RestRequestServiceTest2 {

    private RestRequestService restRequestService = new RestRequestService("https://reqres.in/api");



    @Test
    public void testPostRequest() {
        String requestBody = "{\n" +
                "  \"name\": \"fat3\",\n" +
                "  \"job\": \"ing3\",\n" +
                "}";

        System.out.println("requestBody ==" + requestBody);
        Response response = restRequestService.postRequest("/users", requestBody);

        response.then().statusCode(201)
                .body("name", equalTo("fat3"))
                .body("job", equalTo("ing3"));
        System.out.println("response.getBody().asString()  ==" + response.getBody().asString());

    }

    @Test
    public void testGetRequestafter() {
        Response response = restRequestService.getRequest("/users?page=2");
        //Pourquoi on ne voit pas les informations qu on vient de créer
        System.out.println("response.getBody().asString()  ==" + response.getBody().asString());
    }

}
