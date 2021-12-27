package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstadoAsignacionDeConductor extends Command {

    private ServicioId servicioId;
    private ConductorId conductorId;

    public ActualizarEstadoAsignacionDeConductor(ServicioId servicioId, ConductorId conductorId){
        this.servicioId = servicioId;
        this.conductorId = conductorId;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ConductorId getConductorId() {
        return conductorId;
    }
}
