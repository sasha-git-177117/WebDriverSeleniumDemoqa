package framework.driverutil;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConfigModel {
    @JsonProperty("headless")
    private Boolean headless;
    @JsonProperty("baseUrl")
    private String baseUrl;
    @JsonProperty("explicitWait")
    private int explicitWait;
    @JsonProperty("language")
    private String language;
    @JsonProperty("browser")
    private String browser;
}