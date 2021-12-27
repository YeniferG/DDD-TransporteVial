package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.events;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.Tiempo;
import co.com.sofka.domain.generic.DomainEvent;

public class TiempoServicioActualizado extends DomainEvent {

    private final Tiempo tiempo;

    public TiempoServicioActualizado(Tiempo tiempo) {
        super("sofka.conductorFamiliar.tiempoServicioActualizado");
        this.tiempo = tiempo;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }
}
