package Notificacion;

import Viaje.Viaje;

import java.util.concurrent.TimeUnit;

public class NotificacionFalsaAlarma extends Notificacion{

    @Override
    public void notificar(Viaje viaje) throws InterruptedException {

        // printf Cuanto  tiempo vas a tardar? bla bla
        Integer tiempoEstimadoViaje = 1;

        this.comenzarContador(tiempoEstimadoViaje, viaje);
        return;
    }

    public void comenzarContador(Integer tiempoEstimadoViaje, Viaje viaje) throws InterruptedException {

        //cuenta tiempo estimado (en minutos)
        TimeUnit.SECONDS.sleep(1000L * 60 * tiempoEstimadoViaje);

        //cuando termina

        viaje.viajarSiguienteParada();

        return;
    }

}
