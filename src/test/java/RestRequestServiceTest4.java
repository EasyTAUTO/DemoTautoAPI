import io.restassured.response.Response;
import org.example.services.RestRequestService;
import org.example.services.RestRequestService3;
import org.example.utils.JSONFile;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RestRequestServiceTest4 {
    JSONFile jsonFile;

    private RestRequestService3 restRequestService3;

    @Before
    public void setUp() {
        jsonFile = new JSONFile();
        restRequestService3 = new RestRequestService3("https://jsonplaceholder.typicode.com");
    }

    @Test
    public void testPostRequestWithJsonFile2() throws IOException, JSONException {
        String actualJsonFilePath= "src/main/resources/input/actualResponse1.json";
        String expectedJsonFilePath = "src/main/resources/input/expectedResponse1.json";

        String actualResponse = new String(Files.readAllBytes(Paths.get(actualJsonFilePath)));
        String expectedResponse = new String(Files.readAllBytes(Paths.get(expectedJsonFilePath)));
        System.out.println("actualResponse  ==" + actualResponse);
        System.out.println("expectedResponse  ==" + expectedResponse);
        JSONAssert.assertEquals(expectedResponse, actualResponse, jsonFile.getStrictCustomComparator());
    }
}
