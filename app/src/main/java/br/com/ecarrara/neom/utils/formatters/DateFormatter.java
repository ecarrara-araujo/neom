package br.com.ecarrara.neom.utils.formatters;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

}
