package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Viaje {
    @Setter @Getter public MotivoNotificacion motivoNotificacion;
    @Setter @Getter private String direccionActual;
    @Setter @Getter private List<String> direccionFinal;
    @Setter @Getter private List<Cuidador> Cuidadores;
    @Setter @Getter private List<CalculoDistanciaAproximada> tiempoDemoraAproximado;

    public void solicitarNotificacion(MotivoNotificacion motivo){
        
    }
}
