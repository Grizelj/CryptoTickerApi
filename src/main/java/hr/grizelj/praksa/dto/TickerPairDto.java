package hr.grizelj.praksa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class TickerPairDto {

    @JsonProperty("pair")
    private String pair;
    @JsonProperty("timestamp")
    private Instant timestamp;
    @JsonProperty("a")
    private List<String> a;
    @JsonProperty("b")
    private List<String> b;
    @JsonProperty("c")
    private List<String> c;
    @JsonProperty("v")
    private List<String> v;
    @JsonProperty("p")
    private List<String> p;
    @JsonProperty("t")
    private List<Long> t;
    @JsonProperty("l")
    private List<String> l;
    @JsonProperty("h")
    private List<String> h;
    @JsonProperty("o")
    private String o;
}
