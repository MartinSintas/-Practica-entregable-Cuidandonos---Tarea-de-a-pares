package org.example;

import lombok.Getter;
import lombok.Setter;

public abstract class Notificacion {
    @Setter @Getter private MotivoNotificacion notificacion;
    public abstract void notificar(Enum configuracion);

    //aca podemos hacer los distintos tipos de notificacion
    //no si hacer un switch o muchas clases, como es solo un texto

}
