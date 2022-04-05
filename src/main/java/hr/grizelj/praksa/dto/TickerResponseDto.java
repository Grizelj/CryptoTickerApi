package hr.grizelj.praksa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TickerResponseDto {

    @JsonProperty("error")
    private List<String> error;

    @JsonProperty("result")
    private Map<String, TickerPairDto> result;
}
