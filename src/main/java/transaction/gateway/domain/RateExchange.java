package transaction.gateway.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class RateExchange {
    @JsonProperty("data")
    private List<RateExchangeData> data;

    @JsonProperty("meta")
    private RateExchangeMeta meta;

    @JsonProperty("links")
    private RateExchangeLink links;

    public List<RateExchangeData> getData() {
        return data;
    }

    public void setData(List<RateExchangeData> data) {
        this.data = data;
    }

    public RateExchangeMeta getMeta() {
        return meta;
    }

    public void setMeta(RateExchangeMeta meta) {
        this.meta = meta;
    }

    public RateExchangeLink getLinks() {
        return links;
    }

    public void setLinks(RateExchangeLink links) {
        this.links = links;
    }
}
