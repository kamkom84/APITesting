package stepdefinitions;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.*;

public class Products {


    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;

    @Given("User hits the url of get product api endpoint")
    public void user_hits_the_url_of_the_get_product_api_endpoint() {

        RestAssured.baseURI = "https://fakestoreapi.com/";

    }

    @When("User passes the url in the request")
    public void user_passes_the_url_in_the_request() {

        httpRequest = RestAssured.given();
        response = httpRequest.get("products");

    }

    @Then("User should receive the response code as {int}")
    public void user_should_receive_the_response_code_as(Integer int1) {

        ResponseCode = response.statusCode();
        assertEquals(ResponseCode, 200);

    }

    @Then("User verifies that the rate of the first product is {}")
    public void user_Verifies_That_The_Rate_Of_The_First_Product_Is_Rate(String rate) {

        body = response.getBody();

        String responseBody = body.asString();

        JsonPath jsnpath = response.jsonPath();

        String s = jsnpath.getJsonObject("rating[0].rate").toString();

        assertEquals(rate, s);
    }

    @Given("User hits the url of post product api endpoint")
    public void userHitsTheUrlOfPostProductApiEndpoint() {

        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest  = RestAssured.given();
        JsonObject requestParams = new JsonObject();
        requestParams.add("title", "Shoes");
        requestParams.add("price", "13.5");
        requestParams.add("description", "Lorem ipsum set");
        requestParams.add("image", "https://i.pravatar.cc");
        requestParams.add("category", "electronics");

        httpRequest.body(requestParams.toString());

    }

    @When("User passes the request body of the product title Shoes")
    public void user_passes_the_request_body_of_the_product_title_shoes() {

        Response response = httpRequest.put("products");
        ResponseBody body = response.getBody();

        System.out.println(response.getStatusCode());
        System.out.println(body.asString());

    }
}

























