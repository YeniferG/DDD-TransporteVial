package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.commands;

import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.ConductorCarroId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstadoAsignacionDeConductorCarro extends Command {

    private ServicioId servicioId;
    private ConductorCarroId conductorCarroId;

    public ActualizarEstadoAsignacionDeConductorCarro(ServicioId servicioId, ConductorCarroId conductorCarroId){
        this.servicioId = servicioId;
        this.conductorCarroId = conductorCarroId;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ConductorCarroId getConductorCarroId() {
        return conductorCarroId;
    }
}
