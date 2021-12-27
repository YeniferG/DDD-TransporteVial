package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.commands;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.ConductorMotorizadoId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstadoAsignacionDeConductorMotorizado extends Command {

    private final ServicioId servicioId;
    private final ConductorMotorizadoId conductorMotorizadoId;


    public ActualizarEstadoAsignacionDeConductorMotorizado(ServicioId servicioId, ConductorMotorizadoId conductorMotorizadoId) {
        this.servicioId = servicioId;
        this.conductorMotorizadoId = conductorMotorizadoId;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ConductorMotorizadoId getConductorMotorizadoId() {
        return conductorMotorizadoId;
    }
}
