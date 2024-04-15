package Incidente;


import CalculoDistancia.CalculoEnMapaAPI;
import Enums.Configuracion;
import Enums.MotivoNotificacion;
import Notificacion.NotificacionPersona;
import Persona.Cuidador;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Viaje {
    @Setter @Getter public MotivoNotificacion motivoNotificacion;
    @Setter @Getter public String direccionActual;
    @Setter @Getter public String direccionFinal;
    @Setter @Getter public List<String> direccionIntermedia;
    @Getter public List<Cuidador> CuidadoresDesignadosAlViaje = null;
    @Getter public List<Integer> tiempoDemoraAproximadoDeCadaViaje;
    @Getter public Configuracion configuracion = null;

    public List<Cuidador> solicitarCuidadores(List<Cuidador> cuidadoresElegidos) {

        //Esto seria una variable global
        List<Cuidador> ListaGeneralCuidadores = null;

        for(Cuidador cuidador: cuidadoresElegidos){
            if(cuidador.solicitarViaje(this) && !cuidador.ocupado)
                CuidadoresDesignadosAlViaje.add(cuidador);
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
            this.tiempoDemoraAproximadoDeCadaViaje.add(tiempoAproximado);
        }

        this.viajarSiguienteParada();

        return;
    }

    public void viajarSiguienteParada() throws InterruptedException {

        Incidente incidente = new Incidente();
        CalculoEnMapaAPI calculosAPI = new CalculoEnMapaAPI();

        Integer tiempoEstimadoViaje = calculosAPI.calcularTiempoAproximado();
        incidente.comenzarContador(this);
        if(tiempoDemoraAproximadoDeCadaViaje.isEmpty())
        {
            NotificacionPersona notificacionCuidadores = new NotificacionPersona();
            for(Cuidador cuidador: CuidadoresDesignadosAlViaje)
            {
                this.motivoNotificacion = MotivoNotificacion.FINALIZAR;
                notificacionCuidadores.notificar(this);
            }
        }
        tiempoDemoraAproximadoDeCadaViaje.remove(tiempoDemoraAproximadoDeCadaViaje.get(0));

        return;
    }

}
