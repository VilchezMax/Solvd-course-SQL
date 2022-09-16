package xmlparsing;
//Source https://www.tutorialspoint.com/xsd/xsd_validation.htm

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class XSDValidator {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage : XSDValidator <file-name.xsd> <file-name.xml>");
        } else {
            if (validateXSD(args[0], args[1])) {
                System.out.println(args[1] + " is valid XML.");
            } else {
                System.out.println(args[1] + " is not valid XML.");
            }
        }
    }

    public static boolean validateXSD(String xsdPath, String xmlPath) {
        try {
            SchemaFactory xsdFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
            Schema xsd = xsdFactory.newSchema(new File(xsdPath));

            Validator validator = xsd.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
