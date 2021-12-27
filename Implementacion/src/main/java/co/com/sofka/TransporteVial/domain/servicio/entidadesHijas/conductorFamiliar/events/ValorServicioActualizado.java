package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.events;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorServicioActualizado extends DomainEvent {

    private final Valor valorServicio;

    public ValorServicioActualizado(Valor valorServicio) {
        super("sofka.conductorFamiliar.valorServicioActualizado");
        this.valorServicio = valorServicio;
    }

    public Valor getValorServicio() {
        return valorServicio;
    }
}
