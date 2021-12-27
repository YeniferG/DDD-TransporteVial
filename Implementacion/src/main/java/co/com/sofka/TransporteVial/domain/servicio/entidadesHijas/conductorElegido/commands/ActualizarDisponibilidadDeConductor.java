package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.commands;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDisponibilidadDeConductor extends Command {

    private ConductorId conductorId;
    private Disponibilidad disponibilidad;

    public ActualizarDisponibilidadDeConductor(ConductorId conductorId, Disponibilidad disponibilidad){
        this.conductorId = conductorId;
        this.disponibilidad = disponibilidad;
    }

    public ConductorId getConductorId() {
        return conductorId;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }
}
