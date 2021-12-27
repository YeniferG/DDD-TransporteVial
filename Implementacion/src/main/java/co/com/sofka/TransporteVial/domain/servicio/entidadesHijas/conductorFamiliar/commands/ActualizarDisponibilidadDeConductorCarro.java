package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.commands;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorFamiliar.values.ConductorCarroId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDisponibilidadDeConductorCarro extends Command {

    private ConductorCarroId conductorCarroId;
    private Disponibilidad disponibilidad;

    public ActualizarDisponibilidadDeConductorCarro(ConductorCarroId conductorCarroId, Disponibilidad disponibilidad){
        this.conductorCarroId = conductorCarroId;
        this.disponibilidad = disponibilidad;
    }

    public ConductorCarroId getConductorCarroId() {
        return conductorCarroId;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }
}
