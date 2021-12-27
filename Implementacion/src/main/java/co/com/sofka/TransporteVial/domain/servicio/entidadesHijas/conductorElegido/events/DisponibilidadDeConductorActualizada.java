package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.domain.generic.DomainEvent;

public class DisponibilidadDeConductorActualizada extends DomainEvent {

    private final ConductorId conductorId;
    private final Disponibilidad disponibilidad;

    public DisponibilidadDeConductorActualizada(ConductorId conductorId, Disponibilidad disponibilidad) {
        super("sofka.conductorElegido.disponibilidadDeConductorActualizada");
        this.conductorId = conductorId;
        this.disponibilidad = disponibilidad;
    }

    public ConductorId getConductorId() {
        return conductorId;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }
}
