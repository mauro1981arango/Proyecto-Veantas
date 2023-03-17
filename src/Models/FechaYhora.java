package Models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FechaYhora {
    
    Calendar fecha = new GregorianCalendar();
    
    String anio = Integer.toString(fecha.get(Calendar.YEAR));
    String mes = Integer.toString(fecha.get(Calendar.MONTH));
    String dia = Integer.toString(fecha.get(Calendar.DATE));
    String hora = Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
    String minutos = Integer.toString(fecha.get(Calendar.MINUTE));
    String segundos = Integer.toString(fecha.get(Calendar.SECOND));
    
    String fechaCompleta = anio+"-"+mes+"-"+dia+" "+hora+":"+minutos+":"+segundos;
     
}
