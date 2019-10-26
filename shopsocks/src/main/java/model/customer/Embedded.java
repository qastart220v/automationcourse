
package model.customer;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customer"
})
public class Embedded {

    @JsonProperty("customer")
    private List<Customer> customer = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Embedded() {
    }

    /**
     * 
     * @param customer
     */
    public Embedded(List<Customer> customer) {
        super();
        this.customer = customer;
    }

    @JsonProperty("customer")
    public List<Customer> getCustomer() {
        return customer;
    }

    @JsonProperty("customer")
    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

}
