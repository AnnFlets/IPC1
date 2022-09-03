package Extras;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FechaHora {
    public String devolverFechaHoraActual(){
        //Formato de la fecha y hora ---> día/mes/año hora:minutos
        String fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());   
        return fechaHora;
    }
}