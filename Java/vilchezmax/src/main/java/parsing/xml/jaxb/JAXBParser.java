package parsing.xml.jaxb;

import db.models.Area;
import db.models.Role;
import db.models.Seniority;
import db.models.Worker;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JAXBParser<T> {
    public static void main(String[] args) throws ParseException {

        Worker worker = new Worker();
        worker.setId(1);
        worker.setRole(new Role());
        worker.setSeniority(new Seniority());
        worker.setFirstName("Lionel");
        worker.setLastName("Messi");
        worker.setIdNumber(10);
        worker.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1994-12-10"));
        worker.setEmail("messi10@jaxb.com");
        worker.setWage(1011);
        worker.setPhd(true);
        List<Area> areas = new ArrayList<>();
        Area area = new Area();
        area.setId(1);
        area.setName("max");
        areas.add(area);
        worker.setAreas(areas);

        String toPath = "src/main/resources/xml/worker.xml";
        try {
            createXmlFromWorker(worker, toPath);
            System.out.println(getWorkerFromXml(toPath));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Worker getWorkerFromXml(String xmlPath) throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Worker.class);
        Worker worker = (Worker) context.createUnmarshaller()
                .unmarshal(new FileReader(xmlPath));
        return worker;
    }

    public static void createXmlFromWorker(Worker worker, String toPath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Worker.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(worker, new File(toPath));
    }

    public static <T> T unmarshall(Class<T> clazz, String filePath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller jaxbUnmarshall = jaxbContext.createUnmarshaller();

        return (T) jaxbUnmarshall.unmarshal(new File(filePath));
    }
}
