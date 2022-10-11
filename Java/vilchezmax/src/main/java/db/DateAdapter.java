package db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    private static final Logger logger = LogManager.getLogger(DateAdapter.class);

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /* Unmarshal: XML to Object */
    @Override
    public Date unmarshal(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
            logger.warn("unmarshal error: " + e.getMessage());
            return null;
        }
    }

    /* Marshal: Object to XML */
    @Override
    public String marshal(Date date) {
        return dateFormat.format(date);
    }
}
