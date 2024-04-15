package Notificacion;

import Enums.MotivoNotificacion;
import lombok.Getter;
import lombok.Setter;
import Incidente.Viaje;

public abstract class Notificacion {
    @Setter @Getter private MotivoNotificacion notificacion;
    public abstract void notificar(Viaje viaje) throws InterruptedException;

    //aca podemos hacer los distintos tipos de notificacion
    //no si hacer un switch o muchas clases, como es solo un texto

}
