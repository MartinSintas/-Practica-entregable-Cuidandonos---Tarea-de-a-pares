package Persona;

import lombok.Getter;
import lombok.Setter;
import Enums.Configuracion;
import Enums.MotivoNotificacion;
import Incidente.Viaje;

import java.util.List;

public class Transeunte extends Persona {

    @Getter public MotivoNotificacion motivoNotificacion;
    @Setter @Getter public Configuracion configuracion;
    @Setter @Getter Boolean notificacionEncendida = true;
    @Getter public Viaje viajeActual;


    public List<Cuidador> solicitarViaje(MotivoNotificacion motivoNotificacion){
        Viaje viaje = new Viaje();
        this.viajeActual = viaje;
        viaje.motivoNotificacion = MotivoNotificacion.SOLICITUD;

        //elige a los cuidadores
        List<Cuidador> CuidadoresElegidos = null;

        List<Cuidador> CuidadoresDesignados = viaje.solicitarCuidadores(CuidadoresElegidos);
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
            this.viajeActual.viajarSiguienteParada();
    }
}
