package com.business.user.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitarios {


    public static String formateoFecha() throws ParseException {

        Date fecha = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ssss");
        String fechaActual = format.format(fecha);
        return fechaActual;
    }
}
