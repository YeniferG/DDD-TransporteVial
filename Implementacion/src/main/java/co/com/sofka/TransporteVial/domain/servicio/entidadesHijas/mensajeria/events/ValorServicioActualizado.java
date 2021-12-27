package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.events;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorServicioActualizado extends DomainEvent {

    private final Valor valorServicio;

    public ValorServicioActualizado(Valor valorServicio) {
        super("sofka.mensajeria.valorServicioActualizado");
        this.valorServicio = valorServicio;
    }

    public Valor getValorServicio() {
        return valorServicio;
    }
}
