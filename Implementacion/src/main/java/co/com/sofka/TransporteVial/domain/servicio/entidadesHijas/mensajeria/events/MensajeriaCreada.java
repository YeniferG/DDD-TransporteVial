package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.events;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.Valor;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class MensajeriaCreada extends DomainEvent {

    private final ServicioId servicioId;
    private final Valor valorServicio;

    public MensajeriaCreada(ServicioId servicioId, Valor valorServicio) {
        super("sofka.mensajeria.mensajeriaCreada");
        this.servicioId = servicioId;
        this.valorServicio = valorServicio;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public Valor getValorServicio() {
        return valorServicio;
    }
}
