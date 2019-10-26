import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.response.Response;

import com.jayway.restassured.specification.RequestSpecification;
import model.card.Card;
import model.card.CardResponse;
import model.card.Links;
import model.card.Self;
import model.customer.CustomerResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.CardService;

import static com.jayway.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class BaseTest {

    public static final String BASE_URL = "http://localhost/";
    public static final String cardsEndpoint = "/cards/%s";
    private String customerId = "57a98d98e4b00679b4a830b1";
    private String credirCardNumber = "5544154011345918";
    private String expires = "08/19";
    private String cvvCode = "958";
    Card card = new Card("http://user/cards/57a98d98e4b00679b4a830b1");
    Self self = new Self("http://user/cards/57a98d98e4b00679b4a830b1");

    @Test
    public void verifyCards() {
        //Bad practice
        RestAssured.port = 80;
        RestAssured.registerParser("text/plain", Parser.JSON);
        Response response = given().contentType(ContentType.JSON).
                log().all().
                get("http://localhost/cards/57a98d98e4b00679b4a830b1");

        response.then().assertThat().
                statusCode(200).
                body("ccv", equalTo("958"));

        response.then().assertThat().
                statusCode(200).
                body("longNum", equalTo("5544154011345918"));

        response.then().assertThat().
                statusCode(200).
                body("id", equalTo("57a98d98e4b00679b4a830b1"));

    }

    @Test
    public void verifyCustomers() {

        //Bad practice
        RestAssured.port = 80;
        RestAssured.registerParser("text/plain", Parser.JSON);
        Response response = given().contentType(ContentType.JSON).
                log().all().
                get("http://localhost/customers");
        response.body().prettyPrint();

        response.then().
                statusCode(200);

        response.then().assertThat().
                body("_embedded.customer.username", hasItems("Eve", "User", "User1", "testA"));

        response.then().assertThat().
                body("_embedded.customer.firstName", hasItems("Eve", "User", "", "alexandr220v1"));
        response.then().assertThat().
                body("_embedded.customer.firstName", hasItems("Eve", "User", "", "alexandr220v1"));


    }

    @Test

    public void verifyCardsObjectApproach() {
        RestAssured.registerParser("text/plain", Parser.JSON);
        CardResponse cardResponseExpected = new CardResponse.CardResponseBuilder().longNum("5544154011345918").expires("08/19").ccv("958").id("57a98d98e4b00679b4a830b1").links(new Links(new Card("http://user/cards/57a98d98e4b00679b4a830b1"), new Self("http://user/cards/57a98d98e4b00679b4a830b1"))).build();

        String customerId = "57a98d98e4b00679b4a830b1";
        RequestSpecification requestSpecification = RestAssured.given().
                baseUri("http://localhost/").
                basePath(format("cards/%s", customerId)).
                port(80).log().all();
        CardService cardService = new CardService();
        CardResponse cardResponseActual = cardService.performGetRequest(requestSpecification);

        Assert.assertEquals(cardResponseActual, cardResponseExpected);

    }

    @Test

    public void verifyCardsObjectApproachBuilder() {
//Object oriented approach
        Links links = new Links(card, self);
        RestAssured.registerParser("text/plain", Parser.JSON);
        CardResponse cardResponseExpected = new CardResponse.CardResponseBuilder().
                longNum(credirCardNumber).
                expires(expires).
                ccv(cvvCode).
                id(customerId).
                links(links).
                build();
        RequestSpecification requestSpecification = RestAssured.given().
                baseUri(BASE_URL).
                basePath(format(cardsEndpoint, customerId)).
                port(80).log().all();
        CardService cardService = new CardService();
        CardResponse cardResponseActual = cardService.performGetRequest(requestSpecification);
        Assert.assertEquals(cardResponseActual, cardResponseExpected);

    }

}

