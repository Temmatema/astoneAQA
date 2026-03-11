import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anEmptyMap;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;

public class PostmanEchoTest {
    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        given()
        .when()
            .get("/get?foo1=bar1&foo2=bar2")
        .then()
            .statusCode(200)
            .body("args.foo1", equalTo("bar1"))
            .body("args.foo2", equalTo("bar2"))
            .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRawTextRequest() {
        given()
            .contentType("text/plain")
            .body("{\"test\": \"value\"}")
        .when()
            .post("/post")
        .then()
            .statusCode(200)
            .body("args", anEmptyMap())
            .body("data", equalTo("{\"test\": \"value\"}"))
            .body("files", anEmptyMap())
            .body("form", anEmptyMap())
            .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPostFormDataRequest() {
        given()
            .contentType("application/x-www-form-urlencoded; charset=utf-8")
            .formParam("foo1", "bar1")
            .formParam("foo2", "bar2")
        .when()
            .post("/post")
        .then()
            .statusCode(200)
            .body("args", anEmptyMap())
            .body("data", equalTo(""))
            .body("files", anEmptyMap())
            .body("form.foo1", equalTo("bar1"))
            .body("form.foo2", equalTo("bar2"))
            .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPutRequest() {
        given()
            .contentType("text/plain")
            .body("This is expected to be sent back as part of response body.")
        .when()
            .put("/put")
        .then()
            .statusCode(200)
            .body("args", anEmptyMap())
            .body("data", equalTo("This is expected to be sent back as part of response body."))
            .body("files", anEmptyMap())
            .body("form", anEmptyMap())
            .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void testPatchRequest() {
        given()
            .contentType("text/plain")
            .body("This is expected to be sent back as part of response body.")
        .when()
            .patch("/patch")
        .then()
            .statusCode(200)
            .body("args", anEmptyMap())
            .body("data", equalTo("This is expected to be sent back as part of response body."))
            .body("files", anEmptyMap())
            .body("form", anEmptyMap())
            .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void testDeleteRequest() {
        given()
            .contentType("text/plain")
            .body("This is expected to be sent back as part of response body.")
        .when()
            .delete("/delete")
        .then()
            .statusCode(200)
            .body("args", anEmptyMap())
            .body("data", equalTo("This is expected to be sent back as part of response body."))
            .body("files", anEmptyMap())
            .body("form", anEmptyMap()) 
            .body("url", equalTo("https://postman-echo.com/delete"));
    }
}