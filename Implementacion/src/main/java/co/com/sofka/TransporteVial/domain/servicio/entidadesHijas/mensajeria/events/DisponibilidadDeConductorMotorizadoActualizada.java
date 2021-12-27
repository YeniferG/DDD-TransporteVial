package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.events;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.ConductorMotorizadoId;
import co.com.sofka.domain.generic.DomainEvent;

public class DisponibilidadDeConductorMotorizadoActualizada extends DomainEvent {

    private final ConductorMotorizadoId conductorMotorizadoId;
    private final Disponibilidad disponibilidad;

    public DisponibilidadDeConductorMotorizadoActualizada(ConductorMotorizadoId conductorMotorizadoId, Disponibilidad disponibilidad) {
        super("sofka.mensajeria.disponibilidadDeConductorMotorizadoActualizada");
        this.conductorMotorizadoId = conductorMotorizadoId;
        this.disponibilidad = disponibilidad;
    }

    public ConductorMotorizadoId getConductorMotorizadoId() {
        return conductorMotorizadoId;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }
}
