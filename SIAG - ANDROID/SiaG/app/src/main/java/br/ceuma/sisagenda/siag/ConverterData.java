package br.ceuma.sisagenda.siag;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by INFORMÁT on 29/05/2016.
 */
public class ConverterData {

    public static String retorna(String data){
        Calendar c = Calendar.getInstance();
        Date d = c.getTime();

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

        return String.format(data, sd);
    }
}
