package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class GetPinData {

    @Test
    public void registerWithValidDataRest() {
        given()
                .header("X-RapidAPI-Key", "a434e4627cmsh172034b91e5db51p171ea9jsn0b950058f624")
                .header("X-RapidAPI-Host", "pinterest-video-and-image-downloader.p.rapidapi.com")
                .queryParam("url", "https://in.pinterest.com/pin/805370345878350660/")
                .when()
                .get("https://pinterest-video-and-image-downloader.p.rapidapi.com/pinterest")
                .then()
                .assertThat()
                .statusCode(200)
                .body("success", is(true));
    }
}
