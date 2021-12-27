package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.commands;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ValorServicio;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.Valor;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;


public class CrearMendsajeria extends Command {

    private final ServicioId entityId;
    private final Valor valorServicio;

    public CrearMendsajeria(ServicioId entityId, Valor valorServicio) {
        this.entityId = entityId;
        this.valorServicio = valorServicio;
    }

    public ServicioId getEntityId() {
        return entityId;
    }

    public Valor getValorServicio() {
        return valorServicio;
    }
}
