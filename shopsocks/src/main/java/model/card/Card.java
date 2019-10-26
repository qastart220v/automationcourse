
package model.card;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "href"
})
public class Card {

    @JsonProperty("href")
    private String href;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Card() {
    }

    /**
     * 
     * @param href
     */
    public Card(String href) {
        super();
        this.href = href;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        return getHref() != null ? getHref().equals(card.getHref()) : card.getHref() == null;
    }

    @Override
    public int hashCode() {
        return getHref() != null ? getHref().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Card{" +
                "href='" + href + '\'' +
                '}';
    }
}
