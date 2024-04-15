package Notificacion;

import Enums.MotivoNotificacion;
import lombok.Getter;
import lombok.Setter;
import Viaje.Viaje;

public abstract class Notificacion {

    public abstract void notificar(Viaje viaje) throws InterruptedException;

    //aca podemos hacer los distintos tipos de notificacion
    //no si hacer un switch o muchas clases, como es solo un texto

}
