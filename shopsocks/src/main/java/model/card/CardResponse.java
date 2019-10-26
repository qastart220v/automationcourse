
package model.card;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "longNum",
    "expires",
    "ccv",
    "id",
    "_links"
})
public class CardResponse {

    @JsonProperty("longNum")
    private String longNum;
    @JsonProperty("expires")
    private String expires;
    @JsonProperty("ccv")
    private String ccv;
    @JsonProperty("id")
    private String id;
    @JsonProperty("_links")
    private Links _links;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CardResponse() {
    }

    public CardResponse(CardResponseBuilder cardResponseBuilder) {
        super();
        this.longNum = cardResponseBuilder.longNum;
        this.expires = cardResponseBuilder.expires;
        this.ccv = cardResponseBuilder.ccv;
        this.id = cardResponseBuilder.id;
        this._links = cardResponseBuilder.links;
    }

    @JsonProperty("longNum")
    public String getLongNum() {
        return longNum;
    }

    @JsonProperty("longNum")
    public void setLongNum(String longNum) {
        this.longNum = longNum;
    }

    @JsonProperty("expires")
    public String getExpires() {
        return expires;
    }

    @JsonProperty("expires")
    public void setExpires(String expires) {
        this.expires = expires;
    }

    @JsonProperty("ccv")
    public String getCcv() {
        return ccv;
    }

    @JsonProperty("ccv")
    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("_links")
    public Links get_links() {
        return _links;
    }

    @JsonProperty("_links")
    public void set_links(Links _links) {
        this._links = _links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardResponse)) return false;

        CardResponse that = (CardResponse) o;

        if (getLongNum() != null ? !getLongNum().equals(that.getLongNum()) : that.getLongNum() != null) return false;
        if (getExpires() != null ? !getExpires().equals(that.getExpires()) : that.getExpires() != null) return false;
        if (getCcv() != null ? !getCcv().equals(that.getCcv()) : that.getCcv() != null) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return get_links() != null ? get_links().equals(that.get_links()) : that.get_links() == null;
    }

    @Override
    public int hashCode() {
        int result = getLongNum() != null ? getLongNum().hashCode() : 0;
        result = 31 * result + (getExpires() != null ? getExpires().hashCode() : 0);
        result = 31 * result + (getCcv() != null ? getCcv().hashCode() : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (get_links() != null ? get_links().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CardResponse{" +
                "longNum='" + longNum + '\'' +
                ", expires='" + expires + '\'' +
                ", ccv='" + ccv + '\'' +
                ", id='" + id + '\'' +
                ", _links=" + _links +
                '}';
    }


    public static class CardResponseBuilder {
        private String longNum;
        private String expires;
        private String ccv;
        private String id;
        private Links links;

        public CardResponseBuilder longNum(String longNum) {
            this.longNum = longNum;
            return this;
        }

        public CardResponseBuilder expires(String expires) {
            this.expires = expires;
            return this;
        }

        public CardResponseBuilder ccv(String ccv) {
            this.ccv = ccv;
            return this;
        }

        public CardResponseBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CardResponseBuilder links(Links links) {
            this.links = links;
            return this;
        }

        public CardResponse build() {
            return new CardResponse(this);
        }
    }
}
