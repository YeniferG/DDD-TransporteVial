package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.commands;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.Tiempo;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.Valor;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;


public class CrearConductorFamiliar extends Command {

    private final ServicioId entityId;
    private final Valor valorServicio;
    private final Tiempo tiempo;

    public CrearConductorFamiliar(ServicioId entityId, Valor valorServicio, Tiempo tiempo) {
        this.entityId = entityId;
        this.valorServicio = valorServicio;
        this.tiempo = tiempo;
    }

    public ServicioId getEntityId() {
        return entityId;
    }

    public Valor getValorServicio() {
        return valorServicio;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }
}
