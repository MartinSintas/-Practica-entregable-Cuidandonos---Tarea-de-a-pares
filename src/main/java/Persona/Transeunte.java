package Persona;

import Notificacion.NotificacionPersona;
import lombok.Getter;
import lombok.Setter;
import Enums.Configuracion;
import Enums.MotivoNotificacion;
import Viaje.Viaje;

import java.util.List;

public class Transeunte extends Persona {

    @Getter public MotivoNotificacion motivoNotificacion;
    @Setter @Getter public Configuracion configuracion;
    @Setter @Getter Boolean notificacionEncendida = true;
    @Getter public Viaje viajeActual;


    public List<Cuidador> solicitarViaje(MotivoNotificacion motivoNotificacion, List<String> direcciones){
        Viaje viaje = new Viaje();
        this.viajeActual = viaje;
        viaje.motivoNotificacion = MotivoNotificacion.SOLICITUD;
        viaje.direcciones = direcciones;

        //elige a los cuidadores
        List<Cuidador> CuidadoresElegidos = null;

        List<Cuidador> CuidadoresDesignados = viaje.solicitarCuidadores(CuidadoresElegidos);

        this.cambiarEstadoNotificaciones();

        return CuidadoresDesignados;
    }

    public void comenzarViaje() throws InterruptedException {
        this.viajeActual.comenzarViaje(this.configuracion);
    }

    public void cambiarEstadoNotificaciones(){
        this.notificacionEncendida = !this.notificacionEncendida;
        return;
    }

    public void llegueParadaIntermedia() throws InterruptedException {

        if(!this.notificacionEncendida) this.cambiarEstadoNotificaciones();

        this.viajeActual.viajarSiguienteParada();

        return;
    }

    public void enviarNotificacion(){
        NotificacionPersona notificacionPersona = new NotificacionPersona();
        notificacionPersona.notificar(this.viajeActual);
    }
}
