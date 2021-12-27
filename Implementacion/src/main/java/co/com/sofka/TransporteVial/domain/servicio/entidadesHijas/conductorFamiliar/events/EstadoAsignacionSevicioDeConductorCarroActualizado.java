package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.events;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.ConductorCarroId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoAsignacionSevicioDeConductorCarroActualizado extends DomainEvent {

    private final ServicioId servicioId;
    private final ConductorCarroId conductorCarroId;

    public EstadoAsignacionSevicioDeConductorCarroActualizado(ServicioId servicioId, ConductorCarroId conductorCarroId){
        super("sofka.conductorFamiliar.asignacionConductorCarroActualizado");
        this.servicioId =servicioId;
        this.conductorCarroId = conductorCarroId;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ConductorCarroId getConductorCarroId() {
        return conductorCarroId;
    }
}
