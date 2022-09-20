package xmlparsing.jaxb;

import db.models.Role;
import db.models.Seniority;
import db.models.Worker;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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

        String toPath = "../../resources/xmlparsing/worker.xml";

        createXmlFromWorker(worker, toPath);

        /* ERROR:
         The reason of this error is, Sun people have remove directly access to JAXB package in java 11.
         These packages are availble in Java 8.
         To resolve this issue, you need to add below dependencies in your code manually....BLAHBLAH POM.XML

         Interesting answers:
         https://stackoverflow.com/a/60286701/18997525
         https://stackoverflow.com/a/10002848/18997525 (jaxb team)
         https://stackoverflow.com/a/64862997/18997525 (About dependency combinations, but didn't work)
         */

    }

    public static Worker getWorkerFromXml(String xmlPath) throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Worker.class);
        System.out.println(context);
        Worker worker = (Worker) context.createUnmarshaller()
                .unmarshal(new FileReader(xmlPath));
        return worker;
    }

    public static void createXmlFromWorker(Worker worker, String toPath) throws JAXBException {
//        JAXBContext context = JAXBContext.newInstance(JAXBContext.JAXB_CONTEXT_FACTORY);
        JAXBContext context = JAXBContext.newInstance(Worker.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(worker, new File(toPath));
    }
}
