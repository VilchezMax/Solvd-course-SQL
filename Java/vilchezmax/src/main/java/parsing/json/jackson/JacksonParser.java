package parsing.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.models.Area;
import db.models.Role;
import db.models.Seniority;
import db.models.Worker;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JacksonParser {


    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/parsing/json/worker.json";
        Worker worker = new Worker();
        worker.setId(1);
        worker.setRole(new Role());
        worker.setSeniority(new Seniority());
        worker.setFirstName("Lionel");
        worker.setLastName("Messi");
        worker.setBirthDate(new GregorianCalendar(1994, Calendar.DECEMBER, 10).getTime());
        worker.setIdNumber(10);
        worker.setEmail("messi10@jaxb.com");
        worker.setWage(1011);
        worker.setPhd(true);
        List<Area> areas = new ArrayList<>();
        Area area1 = new Area();
        area1.setId(1);
        area1.setName("max");
        areas.add(area1);
        Area area2 = new Area();
        area2.setId(2);
        area2.setName("min");
        areas.add(area2);
        worker.setAreas(areas);
        try {
            JacksonParser.marshall(path, worker);
            JacksonParser.readJSONcontent(path);
            Worker unmarshalledWorker = JacksonParser.unmarshall(path, Worker.class);
            System.out.println(unmarshalledWorker.toString());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
//        try {
//            JavaType javaType = mapper.getTypeFactory().constructCollectionType(List.class, Area.class);
//            List<Area> areass = mapper.readValue(worker.getAreas().toString(), javaType); //PATH: DATA SOURCE
//            mapper.writeValue(new File(path), areass); //PATH: DESTINATION OF PARSING
//        } catch (IOException e) {
//            logger.warn(e);
//        }
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

    public static <T> void marshall(String path, T object) {
        ObjectMapper mapper = new ObjectMapper();
        File file;
        try {
            file = new File(path);
            mapper.writeValue(file, object);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static <T> T unmarshall(String path, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        File file;
        try {
            file = new File(path);
            return mapper.readValue(file, clazz);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String prettyJson(String str) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            str = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(mapper.readTree(str));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void readJSONcontent(String path) {
        String str = null;
        try {
            str = JacksonParser.prettyJson(Files.readString(Path.of(path), StandardCharsets.UTF_8));
            Files.write(Path.of(path), Collections.singleton(str), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path + "\n" + str);
    }
}
