package seedu.address.storage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XmlDateAdapter extends XmlAdapter<String, Date> {

    DateFormat f = new SimpleDateFormat("yyy-MM-dd HH:mm:ss.SSS");

    @Override
    public Date unmarshal(String v) throws Exception {
        return f.parse(v);
    }
    
    @Override
    public String marshal(Date v) throws Exception {
        return f.format(v);
    }
}