
package model.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "cards",
    "customer",
    "self"
})
public class Links {

    @JsonProperty("addresses")
    private Addresses addresses;
    @JsonProperty("cards")
    private Cards cards;
    @JsonProperty("customer")
    private Customer_ customer;
    @JsonProperty("self")
    private Self self;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links() {
    }

    /**
     * 
     * @param addresses
     * @param cards
     * @param self
     * @param customer
     */
    public Links(Addresses addresses, Cards cards, Customer_ customer, Self self) {
        super();
        this.addresses = addresses;
        this.cards = cards;
        this.customer = customer;
        this.self = self;
    }

    @JsonProperty("addresses")
    public Addresses getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("cards")
    public Cards getCards() {
        return cards;
    }

    @JsonProperty("cards")
    public void setCards(Cards cards) {
        this.cards = cards;
    }

    @JsonProperty("customer")
    public Customer_ getCustomer() {
        return customer;
    }

    @JsonProperty("customer")
    public void setCustomer(Customer_ customer) {
        this.customer = customer;
    }

    @JsonProperty("self")
    public Self getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Self self) {
        this.self = self;
    }

}
