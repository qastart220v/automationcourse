
package model.card;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "card",
    "self"
})
public class Links {

    @JsonProperty("card")
    private Card card;
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
     * @param self
     * @param card
     */
    public Links(Card card, Self self) {
        super();
        this.card = card;
        this.self = self;
    }

    @JsonProperty("card")
    public Card getCard() {
        return card;
    }

    @JsonProperty("card")
    public void setCard(Card card) {
        this.card = card;
    }

    @JsonProperty("self")
    public Self getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Self self) {
        this.self = self;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Links)) return false;

        Links links = (Links) o;

        if (getCard() != null ? !getCard().equals(links.getCard()) : links.getCard() != null) return false;
        return getSelf() != null ? getSelf().equals(links.getSelf()) : links.getSelf() == null;
    }

    @Override
    public int hashCode() {
        int result = getCard() != null ? getCard().hashCode() : 0;
        result = 31 * result + (getSelf() != null ? getSelf().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Links{" +
                "card=" + card +
                ", self=" + self +
                '}';
    }
}
