package parsing.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONValidator {

    public boolean isValid(String json) {
        ObjectMapper mapper = new ObjectMapper();
        boolean valid = true;
        try {
            mapper.readTree(json);
        } catch (IOException e) {
            valid = false;
        }
        return valid;
    }
}
