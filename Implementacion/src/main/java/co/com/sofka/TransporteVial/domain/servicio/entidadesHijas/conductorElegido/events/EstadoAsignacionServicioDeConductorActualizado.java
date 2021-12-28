package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events;

import co.com.sofka.TransporteVial.domain.generico.enums.EstadoAsignacionServicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoAsignacionServicioDeConductorActualizado extends DomainEvent {

    private final ServicioId servicioId;
    private final ConductorId conductorId;

    public EstadoAsignacionServicioDeConductorActualizado(ServicioId servicioId, ConductorId conductorId){
        super("sofka.conductorElegido.asignacionConductorActualizado");
        this.servicioId =servicioId;
        this.conductorId = conductorId;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ConductorId getConductorId() {
        return conductorId;
    }

}
