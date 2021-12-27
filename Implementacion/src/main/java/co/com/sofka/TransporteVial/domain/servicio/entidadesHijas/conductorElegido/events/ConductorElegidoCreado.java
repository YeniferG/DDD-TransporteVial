package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.events;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class ConductorElegidoCreado extends DomainEvent {

    private final ServicioId servicioId;
    private final ValorServicio valorServicio;

    public ConductorElegidoCreado(ServicioId servicioId, ValorServicio valorServicio) {
        super("sofka.conductorElegido.conductorElegidoCreado");
        this.servicioId = servicioId;
        this.valorServicio = valorServicio;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ValorServicio getValorServicio() {
        return valorServicio;
    }
}
