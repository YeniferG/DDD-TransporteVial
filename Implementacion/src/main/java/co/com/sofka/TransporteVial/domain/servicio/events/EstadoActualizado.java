package co.com.sofka.TransporteVial.domain.servicio.events;

import co.com.sofka.TransporteVial.domain.servicio.enums.Estado;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoActualizado extends DomainEvent {

    private final Estado estado;

    public EstadoActualizado(Estado estado) {
        super("sofka.servicio.estadoActualizado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
