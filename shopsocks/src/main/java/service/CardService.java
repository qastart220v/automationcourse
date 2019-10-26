package service;

import com.jayway.restassured.specification.RequestSpecification;
import model.card.CardResponse;

public class CardService {

    public CardResponse performGetRequest(RequestSpecification requestSpecification) {
        return  requestSpecification.get().as(CardResponse.class);
    }
}
