package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.domain.generic.Entity;

public class Conductor extends Entity<ConductorId> {

    public Conductor(ConductorId entityId) {
        super(entityId);
    }
}
