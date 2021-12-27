package co.com.sofka.TransporteVial.domain.servicio.events;

import co.com.sofka.TransporteVial.domain.servicio.values.FechaConHora;
import co.com.sofka.domain.generic.DomainEvent;

public class FechaConHoraActualizada extends DomainEvent {

    private final FechaConHora fecha;

    public FechaConHoraActualizada(FechaConHora fecha) {
        super("sofka.servicio.fechaConHoraActualizada");
        this.fecha = fecha;
    }

    public FechaConHora getFecha() {
        return fecha;
    }
}
