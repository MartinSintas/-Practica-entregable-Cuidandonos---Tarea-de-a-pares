package org.example;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Transeunte extends Persona {

    @Getter public MotivoNotificacion motivoNotificacion;
    @Setter @Getter public Configuracion configuracion;
    @Setter @Getter Boolean notificacionEncendida = true;

    public List<Cuidador> solicitarViaje(MotivoNotificacion motivoNotificacion){
        Viaje viaje = new Viaje();
        viaje.motivoNotificacion = MotivoNotificacion.SOLICITUD;
        List<Cuidador> CuidadoresDesignados = viaje.solicitarCuidadores();
        return CuidadoresDesignados;
    }

    public void cambiarEstadoNotificaciones(){

        if(this.notificacionEncendida) this.notificacionEncendida = false;
        else this.notificacionEncendida = true;

        return;
    }
}
