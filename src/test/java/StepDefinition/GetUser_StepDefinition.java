package StepDefinition;

import SpecBuilders.specBuilders;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import java.io.File;

public class GetUser_StepDefinition extends specBuilders {
    Response resp;
    RequestSpecification reqParam;
    @Given("Enter baseURI and Content-Type as JSON")
    public void enter_base_uri_and_content_type_as_json() {
        reqParam = given().
                spec(GetSpecBuilder()).
                basePath("api/users").
                pathParam("ID", 3);
    }

    @When("Use GET Request with path parameter")
    public void use_get_request_with_path_parameter() {
        resp = reqParam.when().
                get("/{ID}");
    }

    @Then("Verify response")
    public void verify_response() {
        File jsonSchema = new File("src/test/resources/JsonSchema/Get_User.json");

        resp.then().
                assertThat().
                spec(RespSpecBuilder(jsonSchema)).
                body("data.id",equalTo(4)).
                log().
                body().
                extract().
                response();
    }

}
