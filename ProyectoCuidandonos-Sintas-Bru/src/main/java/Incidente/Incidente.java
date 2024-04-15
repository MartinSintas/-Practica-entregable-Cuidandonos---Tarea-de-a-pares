package Incidente;

import Enums.Configuracion;
import Notificacion.NotificacionFalsaAlarma;
import Notificacion.NotificacionOrdinaria;

import java.util.concurrent.TimeUnit;

public class Incidente {

    private String contador;

    public void comenzarContador(Viaje viaje) throws InterruptedException {

        //cuenta tiempo estimado (en minutos)
        TimeUnit.SECONDS.sleep(1000L * 60 * viaje.tiempoDemoraAproximadoDeCadaViaje.get(0));

        //cuando termina
        this.notificarIncidente(viaje);

        viaje.viajarSiguienteParada();

        return;
    }

    public void notificarIncidente(Viaje viaje) throws InterruptedException {

        // La notificacion distinta es falsa alarma, esa hacemos override
        if(viaje.configuracion== Configuracion.FALSA_ALARMA)
        {
            NotificacionFalsaAlarma notificacion = new NotificacionFalsaAlarma();
            notificacion.notificar(viaje);
        }
        else
        {
            NotificacionOrdinaria notificacion = new NotificacionOrdinaria();
            notificacion.notificar(viaje);

        }

        return;
    }

}
