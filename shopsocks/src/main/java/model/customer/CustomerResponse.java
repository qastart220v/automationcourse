
package model.customer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "_embedded"
})
public class CustomerResponse {

    @JsonProperty("_embedded")
    private Embedded embedded;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomerResponse() {
    }

    /**
     * 
     * @param embedded
     */
    public CustomerResponse(Embedded embedded) {
        super();
        this.embedded = embedded;
    }

    @JsonProperty("_embedded")
    public Embedded getEmbedded() {
        return embedded;
    }

    @JsonProperty("_embedded")
    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

}
