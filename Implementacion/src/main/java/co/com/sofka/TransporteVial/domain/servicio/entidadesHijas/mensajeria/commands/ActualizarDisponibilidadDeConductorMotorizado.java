package co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.commands;

import co.com.sofka.TransporteVial.domain.generico.enums.Disponibilidad;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.conductorElegido.values.ConductorId;
import co.com.sofka.TransporteVial.domain.servicio.entidadesHijas.mensajeria.values.ConductorMotorizadoId;
import co.com.sofka.domain.generic.Command;

public class ActualizarDisponibilidadDeConductorMotorizado extends Command {

    private final ConductorMotorizadoId conductorMotorizadoId;
    private final Disponibilidad disponibilidad;

    public ActualizarDisponibilidadDeConductorMotorizado(ConductorMotorizadoId conductorMotorizadoId, Disponibilidad disponibilidad) {
        this.conductorMotorizadoId = conductorMotorizadoId;
        this.disponibilidad = disponibilidad;
    }

    public ConductorMotorizadoId getConductorMotorizadoId() {
        return conductorMotorizadoId;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }
}
