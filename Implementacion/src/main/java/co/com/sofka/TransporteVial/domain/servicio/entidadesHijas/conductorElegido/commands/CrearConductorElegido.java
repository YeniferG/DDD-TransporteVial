package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;


public class CrearConductorElegido extends Command {

    private final ServicioId entityId;
    private final ValorServicio valorServicio;

    public CrearConductorElegido(ServicioId entityId, ValorServicio valorServicio) {
        this.entityId = entityId;
        this.valorServicio = valorServicio;
    }

    public ServicioId getEntityId() {
        return entityId;
    }

    public ValorServicio getValorServicio() {
        return valorServicio;
    }
}
