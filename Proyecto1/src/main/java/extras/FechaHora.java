package extras;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FechaHora {
    //Método que devuelve la fecha y hora en formato ---> día/mes/año hora:minutos
    public String devolverFechaHoraActual() {
        String fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
        return fechaHora;
    }
}