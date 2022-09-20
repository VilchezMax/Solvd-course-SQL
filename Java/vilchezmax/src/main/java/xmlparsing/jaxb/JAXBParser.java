package xmlparsing.jaxb;

import db.models.Area;
import db.models.Role;
import db.models.Seniority;
import db.models.Worker;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JAXBParser {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        Worker worker = new Worker();
        worker.setId(1);
        worker.setRole(new Role());
        worker.setSeniority(new Seniority());
        worker.setFirstName("Lionel");
        worker.setLastName("Messi");
        worker.setIdNumber(10);
        worker.setEmail("messi10@jaxb.com");
        worker.setWage(1011);
        worker.setPhd(true);
        List<Area> areas = new ArrayList<>();
        Area area = new Area();
        area.setId(1);
        area.setName("max");
        areas.add(area);
        worker.setAreas(areas);

        String toPath = "src/main/resources/xmlparsing/worker.xml";

        createXmlFromWorker(worker, toPath);
        System.out.println(getWorkerFromXml(toPath));
    }

    public static Worker getWorkerFromXml(String xmlPath) throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Worker.class);
        System.out.println(context);
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
}
