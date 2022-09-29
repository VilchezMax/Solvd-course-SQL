package parsing.xml.jaxb.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import db.models.Worker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class JacksonParser {
    private static final Logger logger = LogManager.getLogger(JacksonParser.class);

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            JavaType javaType = mapper.getTypeFactory().constructCollectionType(List.class, Worker.class);
            List<Worker> workers = mapper.readValue(new File(" "))
        } catch (JsonProcessingException e) {
            logger.warn(e);
        }
//        URL url = new URL("https://pokeapi.co/api/v2/pokemon/ditto");
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-Type", "application/json");
//        conn.setConnectTimeout(5000);
//        conn.setReadTimeout(5000);
//
//        int status = conn.getResponseCode();
//        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        StringBuilder content = new StringBuilder();
//        String inputLine;
//
//        while ((inputLine = in.readLine()) != null) {
//            content.append(inputLine);
//        }
//        in.close();
//
//        System.out.println(stringToPrettyJson(content.toString()));

    }

    public static String stringToPrettyJson(String str) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            str = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(mapper.readTree(str));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
