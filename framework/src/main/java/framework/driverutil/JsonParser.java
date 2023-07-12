package framework.driverutil;

import com.fasterxml.jackson.databind.ObjectMapper;
import framework.util.LoggerUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonParser {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static ConfigModel configModel = null;

    public static ConfigModel parsParamFromJson() {
        LoggerUtils.info("Получены парометры браузера с конфига и помещены в модель");
        if(configModel == null) {
            String json;
            try {
                json = Files.readString(Path.of("../config.json"));
                configModel = MAPPER.readValue(json, ConfigModel.class);
                return configModel;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configModel;
    }
}
