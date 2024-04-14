package org.example;

import java.util.concurrent.TimeUnit;

public class Incidente {

    private String contador;

    public void comenzarContador(Integer tiempoEstimadoViaje, Configuracion configuracion, Viaje viaje) throws InterruptedException {

        //cuenta tiempo estimado (en minutos)
        TimeUnit.SECONDS.sleep(1000L * 60 * tiempoEstimadoViaje);

        //cuando termina
        this.notificarIncidente(configuracion);

        viaje.viajarSiguienteParada();

        return;
    }

    public void notificarIncidente(Configuracion configuracion){

        // La notificacion distinta es falsa alarma, esa hacemos override
        if(configuracion==Configuracion.FALSA_ALARMA)
        {
            NotificacionFalsaAlarma notificacion = new NotificacionFalsaAlarma();
            notificacion.notificar(configuracion);
        }
        else
        {
            NotificacionOrdinaria notificacion = new NotificacionOrdinaria();
            notificacion.notificar(configuracion);

        }

        return;
    }

}
