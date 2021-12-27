package co.com.sofka.TransporteVial.domain.servicio.events;

import co.com.sofka.TransporteVial.domain.servicio.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionActualizada extends DomainEvent {

    private final Descripcion descripcion;

    public DescripcionActualizada(Descripcion descripcion) {
        super("sofka.servicio.descripcionActualizada");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
