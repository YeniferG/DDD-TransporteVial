package co.com.sofka.TransporteVial.domain.servicio;

import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Servicio extends AggregateEvent<ServicioId> {

    public Servicio(ServicioId entityId) {
        super(entityId);
    }
}
