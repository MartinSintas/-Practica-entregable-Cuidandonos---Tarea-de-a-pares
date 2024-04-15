package Viaje;


import CalculoDistancia.CalculoDistanciaAproximadaAPI;
import Enums.Configuracion;
import Enums.MotivoNotificacion;
import Notificacion.NotificacionPersona;
import Persona.Cuidador;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Viaje {
    @Getter
    @Setter public MotivoNotificacion motivoNotificacion;
    @Setter public List<String> direcciones;
    public List<Cuidador> cuidadoresDesignadosAlViaje = null;
    public List<Integer> tiempoDemoraAproximadoDeCadaViaje;
    public Configuracion configuracion = null;

    public List<Cuidador> solicitarCuidadores(List<Cuidador> cuidadoresElegidos) {
//mondongo
        //Esto seria una variable global
        List<Cuidador> ListaGeneralCuidadores = null;

        for(Cuidador cuidador: cuidadoresElegidos){
            if(cuidador.decidirSiAceptaViaje(this) && !cuidador.ocupado)
                cuidadoresDesignadosAlViaje.add(cuidador);
        }

        return cuidadoresDesignadosAlViaje;
    }

    public void comenzarViaje(Configuracion configuracion) throws InterruptedException {

        this.configuracion = configuracion;
        //falta el tema de la distancia pero eso es con la API

        //determinar tiempo de todas las paradas
        CalculoDistanciaAproximadaAPI calculosMapa = new CalculoDistanciaAproximadaAPI();
        for(String direccion: this.direcciones)
        {
            Integer tiempoAproximado = 0;
            // calcula con direccion actual y siguiente
            tiempoAproximado = calculosMapa.calculoAproximado(direccion, this.direcciones.get(1));
            this.tiempoDemoraAproximadoDeCadaViaje.add(tiempoAproximado);
        }

        this.viajarSiguienteParada();

        return;
    }

    public void viajarSiguienteParada() throws InterruptedException {

        Incidente incidente = new Incidente();
        CalculoDistanciaAproximadaAPI calculosAPI = new CalculoDistanciaAproximadaAPI();

        Integer tiempoEstimadoViaje = calculosAPI.calculoAproximado(this.direcciones.get(0),this.direcciones.get(1));
        incidente.comenzarContador(this);
        if(tiempoDemoraAproximadoDeCadaViaje.isEmpty())
        {
            NotificacionPersona notificacionCuidadores = new NotificacionPersona();
            for(Cuidador cuidador: cuidadoresDesignadosAlViaje)
            {
                this.motivoNotificacion = MotivoNotificacion.FINALIZAR_VIAJE;
                notificacionCuidadores.notificar(this);
            }
        }
        tiempoDemoraAproximadoDeCadaViaje.remove(tiempoDemoraAproximadoDeCadaViaje.get(0));

        return;
    }

}
