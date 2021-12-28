package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.values.ServicioId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDisponibilidadDeConductor extends Command {

    private final ServicioId servicioId;
    private ConductorId conductorId;
    private Disponibilidad disponibilidad;

    public ActualizarDisponibilidadDeConductor(ServicioId servicioId, ConductorId conductorId, Disponibilidad disponibilidad){
        this.servicioId = servicioId;
        this.conductorId = conductorId;
        this.disponibilidad = disponibilidad;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public ConductorId getConductorId() {
        return conductorId;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }
}
