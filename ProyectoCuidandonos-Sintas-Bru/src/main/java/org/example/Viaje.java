package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Viaje {
    @Setter @Getter public MotivoNotificacion motivoNotificacion;
    @Setter @Getter public String direccionActual;
    @Setter @Getter public String direccionFinal;
    @Setter @Getter public List<String> direccionIntermedia;
    @Getter private List<Cuidador> CuidadoresDesignadosAlViaje = null;
    @Getter private List<Integer> tiempoDemoraAproximado;
    @Getter private Configuracion configuracion = null;

    public List<Cuidador> solicitarCuidadores() {

        //Esto seria una variable global
        List<Cuidador> CuidadoresDisponibles = null;

        for(Cuidador cuidador: CuidadoresDisponibles){
            if(cuidador.solicitarViaje(this)) CuidadoresDesignadosAlViaje.add(cuidador);
        }
        return CuidadoresDesignadosAlViaje;
    }

    public void comenzarViaje(Configuracion configuracion) throws InterruptedException {

        this.configuracion = configuracion;
        //falta el tema de la distancia pero eso es con la API

        //determinar tiempo de todas las paradas
        CalculoEnMapaAPI calculosMapa = new CalculoEnMapaAPI();
        for(String direccion: direccionIntermedia)
        {
            Integer tiempoAproximado = 0;
            tiempoAproximado = calculosMapa.calcularTiempoAproximado();
            this.tiempoDemoraAproximado.add(tiempoAproximado);
        }

        this.viajarSiguienteParada();

        return;
    }

    public void viajarSiguienteParada() throws InterruptedException {

        Incidente incidente = new Incidente();
        CalculoEnMapaAPI calculosAPI = new CalculoEnMapaAPI();

        Integer tiempoEstimadoViaje = calculosAPI.calcularTiempoAproximado();
        incidente.comenzarContador(tiempoDemoraAproximado.get(0), this.configuracion, this);
        if(tiempoDemoraAproximado.isEmpty())
        {
            NotificacionPersona notificacionCuidadores = new NotificacionPersona();
            for(Cuidador cuidador: CuidadoresDesignadosAlViaje)
            {
                notificacionCuidadores.notificar(MotivoNotificacion.FINALIZAR);
            }

        }
        tiempoDemoraAproximado.remove(tiempoDemoraAproximado.get(0));

        return;
    }

}
