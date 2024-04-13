package org.example;
import com.sun.jmx.remote.security.NotificationAccessController;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Transeunte extends Persona {

    @Getter public MotivoNotificacion motivoNotificacion;
    @Setter @Getter public Configuracion configuracion;

    public Boolean solicitarViaje(MotivoNotificacion motivoNotificacion){
        Viaje viaje = new Viaje();
        viaje.motivoNotificacion = motivoNotificacion;

        return true;
    }

    public void comenzarViaje(List<String> Destino, String UbicacionActual, List<Cuidador> Cuidadores){

        Incidente incidente = new Incidente();
        CalculoDistanciaAproximada calculosAPI = new CalculoDistanciaAproximada();

        Integer tiempoEstimadoViaje = calculosAPI.calcularTiempoAproximado();
        incidente.comenzarContador(tiempoEstimadoViaje);
        return;
    }


    public void cambiarEstadoNotificaciones(){
        //desactivar notificaciones (como pingo hago eso)
        return;
    }

    public void enviarNotificacion(MotivoNotificacion motivo){
        Notificacion notificacion = new Notificacion();
        notificacion.recibirMotivoNotificacion(motivo);
        return;
    }

}
