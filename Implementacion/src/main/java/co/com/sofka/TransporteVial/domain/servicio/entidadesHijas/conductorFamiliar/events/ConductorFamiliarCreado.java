package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.events;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.Tiempo;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.Valor;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public class ConductorFamiliarCreado extends DomainEvent {

    private final ServicioId servicioId;
    private final Valor valorServicio;
    private final Tiempo tiempo;

    public ConductorFamiliarCreado(ServicioId servicioId, Valor valorServicio, Tiempo tiempo) {
        super("sofka.conductorFamiliar.conductorFamiliarCreado");
        this.servicioId = servicioId;
        this.valorServicio = valorServicio;
        this.tiempo = tiempo;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public Valor getValorServicio() {
        return valorServicio;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }
}
