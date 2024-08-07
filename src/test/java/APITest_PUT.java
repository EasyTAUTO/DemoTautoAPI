import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITest_PUT {
    @Test
    public void testPutRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{\n" +
                "  \"id\": 1,\n" +
//                    "  \"title\": \"updated title\",\n" +
//                    "  \"body\": \"updated body\",\n" +
                "  \"title\": \"updated titleFat\",\n" +
                "  \"body\": \"updated bodyFat\",\n" +
                "  \"userId\": 1\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .log().all()
//                    .body("title", equalTo("updated title"))
//                    .body("body", equalTo("updated body"))
                .body("title", equalTo("updated titleFat"))
                .body("body", equalTo("updated bodyFat"))
                .body("userId", equalTo(1));


    }
}
