package pl.brawura.convert;

import pl.brawura.properties.Constans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bartłomiej on 2015-01-11.
 */
public class DateConverter {

    public Date convertDate(String stringDate){

        DateFormat dateFormat = new SimpleDateFormat(Constans.DATE_FORMAT);
        String preparedDate = stringDate.substring(1, stringDate.length() - 1);

        Date date = null;
        try {
            date = dateFormat.parse(preparedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    return date;
    }

}
