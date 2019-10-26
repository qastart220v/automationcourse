package service;

import com.jayway.restassured.specification.RequestSpecification;
import model.customer.CustomerResponse;

public class CustomerService {

    private CustomerResponse performGetRequest(RequestSpecification requestSpecification) {
        return  requestSpecification.get().as(CustomerResponse.class);
    }
}
