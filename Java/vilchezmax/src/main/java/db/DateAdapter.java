package db;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    /* Unmarshal: XML to Object */
    @Override
    public Date unmarshal(String dateStr) throws Exception {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
    }

    /* Marshal: Object to XML */
    @Override
    public String marshal(Date date) {
        return date.toString();
    }
}
