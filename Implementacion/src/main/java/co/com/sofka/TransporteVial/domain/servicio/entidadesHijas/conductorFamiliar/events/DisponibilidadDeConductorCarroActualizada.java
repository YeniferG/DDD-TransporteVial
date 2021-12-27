package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.events;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.ConductorCarroId;
import co.com.sofka.domain.generic.DomainEvent;

public class DisponibilidadDeConductorCarroActualizada extends DomainEvent {

    private final ConductorCarroId conductorCarroId;
    private final Disponibilidad disponibilidad;

    public DisponibilidadDeConductorCarroActualizada(ConductorCarroId conductorCarroId, Disponibilidad disponibilidad) {
        super("sofka.conductorFamiliar.disponibilidadDeConductorCarroActualizada");
        this.conductorCarroId = conductorCarroId;
        this.disponibilidad = disponibilidad;
    }

    public ConductorCarroId getConductorCarroId() {
        return conductorCarroId;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }
}
