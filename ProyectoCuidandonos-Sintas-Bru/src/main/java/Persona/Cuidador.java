package Persona;

import Enums.MotivoNotificacion;
import Incidente.Viaje;

public class Cuidador extends Persona {
    private MotivoNotificacion motivoNotificacion;

    //true
    public Boolean ocupado = false;

    public boolean solicitarViaje(Viaje viaje) {

        //Mira todo lo del viaje

        //Acepta/rechaza el viaje

        //vamos a suponer que siempre acepta el viaje
        this.ocupado = true;

        return true;
    }

    public void finalizarViaje(){this.ocupado=false;}
}