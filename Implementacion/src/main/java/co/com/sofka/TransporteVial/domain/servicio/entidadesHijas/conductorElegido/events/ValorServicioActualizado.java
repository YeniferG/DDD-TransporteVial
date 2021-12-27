package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorServicioActualizado extends DomainEvent {

    private final ValorServicio valorServicio;

    public ValorServicioActualizado(ValorServicio valorServicio) {
        super("sofka.conductorElegido.valorServicioActualizado");
        this.valorServicio = valorServicio;
    }

    public ValorServicio getValorServicio() {
        return valorServicio;
    }
}
