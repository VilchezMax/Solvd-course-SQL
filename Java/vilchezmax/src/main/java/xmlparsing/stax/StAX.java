package xmlparsing.stax;

import db.models.*;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Source: https://www.w3schools.blog/java-stax-xmlstreamreader-example

public class StAX {

    public static void main(String[] args) {
        //StAX.readXML("src/main/resources/xmlparsing/classes.xml");
//        WorkerMySQLDAO workerMySQLDAO = new WorkerMySQLDAO();
//        Worker worker = workerMySQLDAO.getById(1); //TODO CONNECTION

        /*MOCK WORKER*/
        String workerPath = "src/main/resources/xmlparsing/classesxml/worker.xml";

        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter outputWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(workerPath));

            Worker worker1 = new Worker();

            Role role1 = new Role();
            role1.setId(1);
            role1.setName("Boss");

            Seniority seniority1 = new Seniority();
            seniority1.setId(2);
            seniority1.setName("Sr");

            Experiment exp1 = new Experiment();
            exp1.setId(1);
            exp1.setName("CoViD-19 vaccine");

            Experiment exp2 = new Experiment();
            exp2.setId(2);
            exp2.setName("Eratosthenes' measurement of the Earth's circumference");

            List<Experiment> experiments = new ArrayList<>();
            experiments.add(exp1);
            experiments.add(exp2);

            Area area1 = new Area();
            area1.setId(10);
            area1.setDescription("blablablah");
            area1.setName("area area");

            Area area2 = new Area();
            area2.setId(11);
            area2.setDescription("blablablahhhhhhh");
            area2.setName("area 2");

            List<Area> areas = new ArrayList<>();
            areas.add(area1);
            areas.add(area2);

            worker1.setId(1);
            worker1.setRole(role1);
            worker1.setSeniority(seniority1);
            worker1.setFirstName("Lionel");
            worker1.setLastName("Messi");
            worker1.setIdNumber(10);
//            worker1.setBirthDate(new GregorianCalendar(1994, Calendar.DECEMBER, 10).getTime());
            worker1.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1994-12-10"));
            worker1.setEmail("messi10@jaxb.com");
            worker1.setWage(1011);
            worker1.setPhd(true);
            worker1.setExperiments(experiments);
            worker1.setAreas(areas);

            StAX.pojoToXML(worker1, outputWriter);
            outputWriter.flush();
            outputWriter.close();

            StAX.readXML(workerPath);
        } catch (XMLStreamException | FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void readXML(String path) {
        try {
            Reader reader = new FileReader(path);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlReader = inputFactory.createXMLStreamReader(reader);

            while (xmlReader.hasNext()) {
                int event = xmlReader.next();

                if (event == XMLStreamConstants.START_ELEMENT) {
                    System.out.println("Start element:" + xmlReader.getLocalName());
                    int attributes = xmlReader.getAttributeCount();
                    for (int i = 0; i < attributes; i++) {
                        QName name = xmlReader.getAttributeName(i);
                        String value = xmlReader.getAttributeValue(i);
                        System.out.println("Attribute name :" + name);
                        System.out.println("Attribute value :" + value);
                    }
                }
                if (event == XMLStreamConstants.END_ELEMENT) {
                    System.out.println("End element: " + xmlReader.getLocalName());
                }

            }
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println(e);
        }
    }

    public synchronized static void writeXML(String path) {
        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter outputWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(path));
            outputWriter.writeStartDocument("UTF-8", "1.0");
            // Create worker
            outputWriter.writeStartElement("Worker");
            outputWriter.writeEndElement();
            outputWriter.flush();
            outputWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public synchronized static void pojoToXML(Worker worker, XMLStreamWriter outputWriter) throws FileNotFoundException, XMLStreamException {
        outputWriter.writeStartElement("Worker");
        outputWriter.writeAttribute("Id", worker.getId().toString());

        pojoToXML(worker.getRole(), outputWriter);

        pojoToXML(worker.getSeniority(), outputWriter);

        outputWriter.writeStartElement("FirstName");
        outputWriter.writeCharacters(worker.getFirstName());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("LastName");
        outputWriter.writeCharacters(worker.getLastName());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("IdNumber");
        outputWriter.writeCharacters(worker.getIdNumber().toString());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("BirthDate");
        outputWriter.writeCharacters(worker.getBirthDate().toString());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("Email");
        outputWriter.writeCharacters(worker.getEmail());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("Wage");
        outputWriter.writeCharacters(worker.getWage().toString());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("PhD");
        outputWriter.writeCharacters(String.valueOf(worker.isPhd()));
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("Experiments");
        for (Experiment experiment : worker.getExperiments()) {
            pojoToXML(experiment, outputWriter);
        }
        outputWriter.writeEndElement();
        outputWriter.writeStartElement("Areas");
        for (Area area : worker.getAreas()) {
            pojoToXML(area, outputWriter);
        }
        outputWriter.writeEndElement();
        outputWriter.writeEndElement();
    }

    public synchronized static void pojoToXML(Area area, XMLStreamWriter outputWriter) throws FileNotFoundException, XMLStreamException {
        outputWriter.writeStartElement("Area");
        outputWriter.writeAttribute("Id", area.getId().toString());

        outputWriter.writeStartElement("Name");
        outputWriter.writeCharacters(area.getName());
        outputWriter.writeEndElement();

        outputWriter.writeStartElement("Description");
        outputWriter.writeCharacters(area.getDescription());
        outputWriter.writeEndElement();

        outputWriter.writeEndElement();
    }

    public synchronized static void pojoToXML(Experiment experiment, XMLStreamWriter outputWriter) throws FileNotFoundException, XMLStreamException {
        outputWriter.writeStartElement("Experiment");
        outputWriter.writeAttribute("Id", experiment.getId().toString());

        outputWriter.writeStartElement("Name");
        outputWriter.writeCharacters(experiment.getName());
        outputWriter.writeEndElement();

        outputWriter.writeEndElement();
    }

    public static void pojoToXML(Role role, XMLStreamWriter outputWriter) throws FileNotFoundException, XMLStreamException {

        outputWriter.writeStartElement("Role");
        outputWriter.writeAttribute("Id", role.getId().toString());

        outputWriter.writeStartElement("Name");
        outputWriter.writeCharacters(role.getName());
        outputWriter.writeEndElement();

        outputWriter.writeEndElement();
    }

    public synchronized static void pojoToXML(Seniority seniority, XMLStreamWriter outputWriter) throws FileNotFoundException, XMLStreamException {
        outputWriter.writeStartElement("Seniority");
        outputWriter.writeAttribute("Id", seniority.getId().toString());

        outputWriter.writeStartElement("Name");
        outputWriter.writeCharacters(seniority.getName());
        outputWriter.writeEndElement();

        outputWriter.writeEndElement();
    }

    public synchronized static void writeXML(String filePath, Map<String, String> attributesValues, String element) {
        //Aca falta definir como usar la fx, porque si hay nested elements no puede estar metiendo startDocument().
        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter outputWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(filePath));
            //if ( el file esta vacio)
            outputWriter.writeStartDocument("UTF-8", "1.0");

            // Create worker
            outputWriter.writeStartElement(element);
            attributesValues.forEach((key, value) -> {
                try {
                    outputWriter.writeAttribute(key, value);
                } catch (XMLStreamException e) {
                    System.out.println(e);
                }
            });

            outputWriter.writeEndElement();
            outputWriter.flush();
            outputWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
