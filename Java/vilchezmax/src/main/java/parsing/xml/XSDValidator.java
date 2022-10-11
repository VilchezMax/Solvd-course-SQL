package parsing.xml;
//Source https://www.tutorialspoint.com/xsd/xsd_validation.htm

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class XSDValidator {
    private static final Logger logger = LogManager.getLogger(XSDValidator.class);

    public static void main(String[] args) {
        String xsdPath = "src/main/resources/xml/classesxsd/worker.xsd";
        String xmlPath = "src/main/resources/xml/mock.xml";

        logger.info("XSD file: " + xsdPath);
        logger.info("XML file: " + xmlPath);

        if (staxValidator(xsdPath, xmlPath)) {
            logger.log(Level.getLevel("SUCCESS"), (xmlPath + " is valid XML."));
        } else {
            logger.warn(xmlPath + " is not valid XML.");
        }
    }

    public static boolean staxValidator(String xsdPath, String xmlPath) {
        try {
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(xmlPath));
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema xsd = factory.newSchema(new File(xsdPath));

            javax.xml.validation.Validator validator = xsd.newValidator();
            validator.validate(new StAXSource(reader));
        } catch (IOException | SAXException | XMLStreamException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
/*
    public static boolean saxValidator(String xsdPath, String xmlPath) {
        try {
            SchemaFactory xsdFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
            Schema xsd = xsdFactory.newSchema(new File(xsdPath));

            Validator validator = xsd.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }*/
}
