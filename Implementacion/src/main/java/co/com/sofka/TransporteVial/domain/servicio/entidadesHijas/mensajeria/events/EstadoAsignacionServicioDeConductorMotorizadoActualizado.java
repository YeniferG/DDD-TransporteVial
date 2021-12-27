package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.events;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.ConductorMotorizadoId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoAsignacionServicioDeConductorMotorizadoActualizado extends DomainEvent {

    private final ServicioId servicioId;
    private final ConductorMotorizadoId conductorMotorizadoId;

    public EstadoAsignacionServicioDeConductorMotorizadoActualizado(ServicioId servicioId, ConductorMotorizadoId conductorMotorizadoId){
        super("sofka.mensajeria.asignacionConductorMotorizadoActualizado");
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
