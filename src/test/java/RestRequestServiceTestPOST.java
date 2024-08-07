import io.restassured.response.Response;
import org.example.services.RestRequestService;
import org.example.services.RestRequestService2;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * RestRequestServiceTest : Cette classe de test montre comment utiliser RestRequestService pour effectuer des requêtes REST telles que  GET et POST.
 * Elle utilise des assertions pour vérifier que les réponses contiennent les données attendues.
 */


import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class RestRequestServiceTestPOST {

        private RestRequestService2 restRequestService2 = new RestRequestService2("https://reqres.in/api");

        @Test
        public void testPostRequestWithJsonFile() {
//            String jsonFilePath = "src/test/resources/requestPayload.json";
            String jsonFilePath = "src/main/resources/input/payload-post-user-create2.json";


            Response response = restRequestService2.postRequestWithJsonFile("/users", jsonFilePath);

//            response.then().statusCode(201)
//                    .body("name", equalTo("fat3"))
//                    .body("job", equalTo("ing3"));
            System.out.println("response.getBody().asString()  ==" + response.getBody().asString());
        }
    }
