package Usuario;

import Direccion.Direccion;
import Enums.Configuracion;
import Enums.MotivoNotificacion;
import Notificacion.NotificacionPersona;
import Viaje.Viaje;
import lombok.Getter;
import lombok.Setter;
import Enums.Sexo;

import java.util.List;

public class Usuario {
    @Setter @Getter private String nombre;
    @Setter @Getter private String apellido;
    @Setter @Getter private Direccion direccion;
    @Setter @Getter private String edad;
    @Setter @Getter private Sexo sexo;
    @Getter public Boolean instalada = true;
    @Getter public MotivoNotificacion motivoNotificacion;
    @Setter @Getter public Configuracion configuracion;
    @Setter @Getter Boolean notificacionEncendida = true;
    @Getter public Viaje viajeActual;
    @Getter public Boolean ocupado = false;


    public List<Usuario> solicitarViaje(MotivoNotificacion motivoNotificacion, List<Direccion> direcciones){
        Viaje viaje = new Viaje();
        this.viajeActual = viaje;
        viaje.motivoNotificacion = MotivoNotificacion.SOLICITUD;
        viaje.direcciones = direcciones;

        //elige a los cuidadores
        List<Usuario> CuidadoresElegidos = null;

        List<Usuario> CuidadoresDesignados = viaje.solicitarCuidadores(CuidadoresElegidos);

        this.cambiarEstadoNotificaciones();

        return CuidadoresDesignados;
    }

    public void comenzarViaje() throws InterruptedException {
        this.viajeActual.comenzarViaje(this.configuracion);
    }

    public void finalizarViaje(){
        this.ocupado=false;
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

    public boolean decidirSiAceptaViaje(Viaje viaje) {

        return true;
    }
}
