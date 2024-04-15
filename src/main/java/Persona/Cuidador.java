package Persona;

import Viaje.Viaje;

public class Cuidador extends Persona {
    //true
    public Boolean ocupado = false;

    public boolean decidirSiAceptaViaje(Viaje viaje) {

        //Mira todo lo del viaje

        //Acepta/rechaza el viaje

        //vamos a suponer que siempre acepta el viaje
        this.ocupado = true;

        return true;
    }

    public void finalizarViaje(){this.ocupado=false;}
}
