package co.com.sofka.TransporteVial.domain.servicio.commands;

import co.com.sofka.TransporteVial.domain.servicio.enums.Estado;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstado extends Command {

    private final Estado estado;

    public ActualizarEstado(Estado estado){
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
