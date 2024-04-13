package org.example;

import lombok.Getter;
import lombok.Setter;

public class Notificacion {
    @Setter @Getter private MotivoNotificacion notificacion;

    public void recibirMotivoNotificacion(MotivoNotificacion motivo){
        this.notificacion = motivo;
    }

    //aca podemos hacer los distintos tipos de notificacion
    //no si hacer un switch o muchas clases, como es solo un texto

}
