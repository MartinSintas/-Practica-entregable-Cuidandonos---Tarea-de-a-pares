package org.example;

public class Cuidador extends Persona {
    private MotivoNotificacion motivoNotificacion;


    public Boolean aceptarViaje(Viaje viaje){
        return true;
    }

    public Boolean rechazarViaje(Viaje viaje){
        return false;
    }
}
